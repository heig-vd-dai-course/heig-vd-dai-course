package ch.heigvd;

import ch.heigvd.auth.AuthController;
import ch.heigvd.users.User;
import ch.heigvd.users.UsersController;
import io.javalin.Javalin;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Main {
  public static final int PORT = 8080;

  public static void main(String[] args) {
    Javalin app =
        Javalin.create(
            // Add custom configuration to Javalin
            config -> {
              // This will allow us to parse LocalDateTime
              config.validation.register(LocalDateTime.class, LocalDateTime::parse);
            });

    // This will serve as our database
    ConcurrentMap<Integer, User> users = new ConcurrentHashMap<>();

    // This will serve as our cache
    //
    // The key is to identify the user(s)
    // The value is the last modification time of the user(s)
    ConcurrentHashMap<Integer, LocalDateTime> usersCache = new ConcurrentHashMap<>();

    // Controllers
    AuthController authController = new AuthController(users, usersCache);
    UsersController usersController = new UsersController(users, usersCache);

    // Auth routes
    app.post("/login", authController::login);
    app.post("/logout", authController::logout);
    app.get("/profile", authController::profile);

    // Users routes
    app.post("/users", usersController::create);
    app.get("/users", usersController::getMany);
    app.get("/users/{id}", usersController::getOne);
    app.put("/users/{id}", usersController::update);
    app.delete("/users/{id}", usersController::delete);

    app.start(PORT);
  }
}
