package ch.heigvd.auth;

import ch.heigvd.users.User;
import io.javalin.http.*;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentMap;

public class AuthController {
  private final ConcurrentMap<Integer, User> users;

  private final ConcurrentMap<Integer, LocalDateTime> usersCache;

  public AuthController(
      ConcurrentMap<Integer, User> users, ConcurrentMap<Integer, LocalDateTime> usersCache) {
    this.users = users;
    this.usersCache = usersCache;
  }

  public void login(Context ctx) {
    User loginUser =
        ctx.bodyValidator(User.class)
            .check(obj -> obj.email() != null, "Missing email")
            .check(obj -> obj.password() != null, "Missing password")
            .get();

    for (User user : users.values()) {
      if (user.email().equalsIgnoreCase(loginUser.email())
          && user.password().equals(loginUser.password())) {
        ctx.cookie("user", String.valueOf(user.id()));
        ctx.status(HttpStatus.NO_CONTENT);
        return;
      }
    }

    throw new UnauthorizedResponse();
  }

  public void logout(Context ctx) {
    ctx.removeCookie("user");
    ctx.status(HttpStatus.NO_CONTENT);
  }

  public void profile(Context ctx) {
    String userIdCookie = ctx.cookie("user");

    if (userIdCookie == null) {
      throw new UnauthorizedResponse();
    }

    Integer userId = Integer.parseInt(userIdCookie);

    // Get the last known modification date of the user
    LocalDateTime lastKnownModification =
        ctx.headerAsClass("If-Modified-Since", LocalDateTime.class).getOrDefault(null);

    // Check if the user has been modified since the last known modification date
    if (lastKnownModification != null && usersCache.get(userId).equals(lastKnownModification)) {
      throw new NotModifiedResponse();
    }

    User user = users.get(userId);

    if (user == null) {
      throw new UnauthorizedResponse();
    }

    LocalDateTime now;
    if (usersCache.containsKey(user.id())) {
      // If it is already in the cache, get the last modification date
      now = usersCache.get(user.id());
    } else {
      // Otherwise, set to the current date
      now = LocalDateTime.now();
      usersCache.put(user.id(), now);
    }

    // Add the last modification date to the response
    ctx.header("Last-Modified", String.valueOf(now));

    ctx.json(user);
  }
}
