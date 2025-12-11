package ch.heigvd.auth;

import ch.heigvd.users.User;
import io.javalin.http.*;
import java.util.concurrent.ConcurrentMap;

public class AuthController {
  private final ConcurrentMap<Integer, User> users;

  public AuthController(ConcurrentMap<Integer, User> users) {
    this.users = users;
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

    User user = users.get(userId);

    if (user == null) {
      throw new UnauthorizedResponse();
    }

    ctx.json(user);
  }
}
