package ch.heigvd.users;

import io.javalin.http.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class UsersController {
  private final ConcurrentMap<Integer, User> users;

  private final AtomicInteger uniqueId = new AtomicInteger(1);

  private final ConcurrentMap<Integer, LocalDateTime> usersCache;

  // This is a magic number used to store the users' list last modification date
  // As the ID for users starts from 1, it is safe to reserve the value -1 for all users
  private final Integer RESERVED_ID_TO_IDENTIFY_ALL_USERS = -1;

  public UsersController(
      ConcurrentMap<Integer, User> users, ConcurrentMap<Integer, LocalDateTime> usersCache) {
    this.users = users;
    this.usersCache = usersCache;
  }

  public void create(Context ctx) {
    User newUser =
        ctx.bodyValidator(User.class)
            .check(obj -> obj.firstName() != null, "Missing first name")
            .check(obj -> obj.lastName() != null, "Missing last name")
            .check(obj -> obj.email() != null, "Missing email")
            .check(obj -> obj.password() != null, "Missing password")
            .get();

    for (User user : users.values()) {
      if (newUser.email().equalsIgnoreCase(user.email())) {
        throw new ConflictResponse();
      }
    }

    newUser =
        new User(
            uniqueId.getAndIncrement(),
            newUser.firstName(),
            newUser.lastName(),
            newUser.email(),
            newUser.password());

    users.put(newUser.id(), newUser);

    // Store the last modification date of the user
    LocalDateTime now = LocalDateTime.now();
    usersCache.put(newUser.id(), now);

    // Invalidate the cache for all users
    usersCache.remove(RESERVED_ID_TO_IDENTIFY_ALL_USERS);

    ctx.status(HttpStatus.CREATED);

    // Add the last modification date to the response
    ctx.header("Last-Modified", String.valueOf(now));

    ctx.json(newUser);
  }

  public void getOne(Context ctx) {
    Integer id = ctx.pathParamAsClass("id", Integer.class).get();

    // Get the last known modification date of the user
    LocalDateTime lastKnownModification =
        ctx.headerAsClass("If-Modified-Since", LocalDateTime.class).getOrDefault(null);

    // Check if the user has been modified since the last known modification date
    if (lastKnownModification != null && usersCache.get(id).equals(lastKnownModification)) {
      throw new NotModifiedResponse();
    }

    User user = users.get(id);

    if (user == null) {
      throw new NotFoundResponse();
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

  public void getMany(Context ctx) {
    // Get the last known modification date of all users
    LocalDateTime lastKnownModification =
        ctx.headerAsClass("If-Modified-Since", LocalDateTime.class).getOrDefault(null);

    // Check if all users have been modified since the last known modification date
    if (lastKnownModification != null
        && usersCache.containsKey(RESERVED_ID_TO_IDENTIFY_ALL_USERS)
        && usersCache.get(RESERVED_ID_TO_IDENTIFY_ALL_USERS).equals(lastKnownModification)) {
      throw new NotModifiedResponse();
    }

    String firstName = ctx.queryParam("firstName");
    String lastName = ctx.queryParam("lastName");

    List<User> users = new ArrayList<>();

    for (User user : this.users.values()) {
      if (firstName != null && !user.firstName().equalsIgnoreCase(firstName)) {
        continue;
      }

      if (lastName != null && !user.lastName().equalsIgnoreCase(lastName)) {
        continue;
      }

      users.add(user);
    }

    LocalDateTime now;
    if (usersCache.containsKey(RESERVED_ID_TO_IDENTIFY_ALL_USERS)) {
      // If it is already in the cache, get the last modification date
      now = usersCache.get(RESERVED_ID_TO_IDENTIFY_ALL_USERS);
    } else {
      // Otherwise, set to the current date
      now = LocalDateTime.now();
      usersCache.put(RESERVED_ID_TO_IDENTIFY_ALL_USERS, now);
    }

    // Add the last modification date to the response
    ctx.header("Last-Modified", String.valueOf(now));
    ctx.json(users);
  }

  public void update(Context ctx) {
    Integer id = ctx.pathParamAsClass("id", Integer.class).get();

    // Get the last known modification date of the user
    LocalDateTime lastKnownModification =
        ctx.headerAsClass("If-Unmodified-Since", LocalDateTime.class).getOrDefault(null);

    // Check if the user has been modified since the last known modification date
    if (lastKnownModification != null && !usersCache.get(id).equals(lastKnownModification)) {
      throw new PreconditionFailedResponse();
    }

    if (!users.containsKey(id)) {
      throw new NotFoundResponse();
    }

    User updateUser =
        ctx.bodyValidator(User.class)
            .check(obj -> obj.firstName() != null, "Missing first name")
            .check(obj -> obj.lastName() != null, "Missing last name")
            .check(obj -> obj.email() != null, "Missing email")
            .check(obj -> obj.password() != null, "Missing password")
            .get();

    for (User user : users.values()) {
      if (updateUser.email().equalsIgnoreCase(user.email())) {
        throw new ConflictResponse();
      }
    }

    users.put(id, updateUser);

    // Store the last modification date of the user
    LocalDateTime now = LocalDateTime.now();
    usersCache.put(updateUser.id(), now);

    // Invalidate the cache for all users
    usersCache.remove(RESERVED_ID_TO_IDENTIFY_ALL_USERS);

    // Add the last modification date to the response
    ctx.header("Last-Modified", String.valueOf(now));
    ctx.json(updateUser);
  }

  public void delete(Context ctx) {
    Integer id = ctx.pathParamAsClass("id", Integer.class).get();

    // Get the last known modification date of the user
    LocalDateTime lastKnownModification =
        ctx.headerAsClass("If-Unmodified-Since", LocalDateTime.class).getOrDefault(null);

    // Check if the user has been modified since the last known modification date
    if (lastKnownModification != null && !usersCache.get(id).equals(lastKnownModification)) {
      throw new PreconditionFailedResponse();
    }

    if (!users.containsKey(id)) {
      throw new NotFoundResponse();
    }

    users.remove(id);

    // Invalidate the cache for the user
    usersCache.remove(id);

    // Invalidate the cache for all users
    usersCache.remove(RESERVED_ID_TO_IDENTIFY_ALL_USERS);

    ctx.status(HttpStatus.NO_CONTENT);
  }
}
