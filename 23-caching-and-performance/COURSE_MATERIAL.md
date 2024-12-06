[markdown]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/23-caching-and-performance/COURSE_MATERIAL.md
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/23-caching-and-performance/23-caching-and-performance-practical-work.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/511
[illustration]:
  https://images.unsplash.com/photo-1529922331924-26e6a694629d?fit=crop&h=720

# Caching and performance - Course material

<https://github.com/heig-vd-dai-course>

[Markdown][markdown] · [PDF][pdf]

L. Delafontaine and H. Louis, with the help of GitHub Copilot.

Based on the original course by O. Liechti and J. Ehrensberger.

This work is licensed under the [CC BY-SA 4.0][license] license.

![Main illustration][illustration]

## Table of contents

- [Table of contents](#table-of-contents)
- [Objectives](#objectives)
- [Caching](#caching)
  - [Types of caching](#types-of-caching)
  - [CDN](#cdn)
  - [Where to cache?](#where-to-cache)
- [Managing cache with HTTP](#managing-cache-with-http)
  - [Expiration model](#expiration-model)
  - [Validation model](#validation-model)
- [Managing cache with proxies](#managing-cache-with-proxies)
- [Managing cache with key-value stores](#managing-cache-with-key-value-stores)
- [Practical content](#practical-content)
  - [Add a `Map` to cache results to your application](#add-a-map-to-cache-results-to-your-application)
  - [Store results in the cache and return the `Last-Modified` header](#store-results-in-the-cache-and-return-the-last-modified-header)
  - [Validate the cache with the `If-Modified-Since` header](#validate-the-cache-with-the-if-modified-since-header)
  - [Validate the cache with the `If-Unmodified-Since` header](#validate-the-cache-with-the-if-unmodified-since-header)
  - [Test the caching system with curl](#test-the-caching-system-with-curl)
  - [Test the caching system with a browser](#test-the-caching-system-with-a-browser)
  - [Go further](#go-further)
- [Conclusion](#conclusion)
  - [What did you do and learn?](#what-did-you-do-and-learn)
  - [Test your knowledge](#test-your-knowledge)
- [Finished? Was it easy? Was it hard?](#finished-was-it-easy-was-it-hard)
- [What will you do next?](#what-will-you-do-next)
- [Additional resources](#additional-resources)
- [Sources](#sources)

## Objectives

In this last and final chapter of this course, you will learn about caching and
performance.

You will learn about caching, how it can be used to improve the performance of a
system, and how you can manage cache with HTTP and how to implement it in your
application.

## Caching

Caching is the process of storing data in a cache. A cache is a temporary
storage component area where data is stored so that future requests for that
data can be served faster.

Caching can be used to improve the performance of a system by serving cached
data instead of processing a request again. Caching significantly improves the
performance of a system because it avoids processing the same request multiple
times.

This has several advantages:

- The client will receive the response faster, especially when the client itself
  (browser) has cached the response.
- The server does not have to process the request (parse the request, query the
  database, compose the response, etc).
- The network does not have to carry the messages along the entire path between
  client and server.

It however introduces some complexity because it is difficult to know when to
invalidate a cache. If a cache is not invalidated, it can serve stale data (=
old data).

### Types of caching

Caching can be done on the client-side or on the server-side:

- **Client-side caching** (private caches): once a client has received a
  response from a server, it can store the response in a cache. The next time
  the client needs the same resource, it can use the cached response instead of
  sending a new request to the server.
- **Server-side caching** (shared caches): the server stores data in a cache
  with the help of a reverse proxy or by the web application. The next time the
  server needs the same resource, it can use the cached response instead of
  processing the request again.

### CDN

Content delivery networks (CDNs) are a type of cache that can be used to serve
static content (e.g. images, videos, etc.) to clients.

A CDN is a geographically distributed network of proxy servers and their data
centers.

A CDN can be used to improve the performance of a system by serving static
content to clients from the closest server for clients all around the world.

### Where to cache?

Caching can be done on the client-side, on the server-side, or on a CDN.

Private caches are caches that are only used by one client. Public caches are
caches that are used by multiple clients.

![Where to cache](./images/where-to-cache.png)

The best would be to cache at each level of the system to ensure the best
performance. But it is not always possible or faisable.

In the context of this course, we will focus on server-side caching.

## Managing cache with HTTP

Managing cache is challenging because it is difficult to know when to invalidate
a cache. If a cache is not invalidated, it can serve stale data.

There are two main caching models:

- **Expiration model**: the cache is valid for a certain amount of time.
- **Validation model**: the cache is valid until the data is modified.

Expiration and validation are two mechanisms that can be used to control
caching.

Expiration is the process of specifying how long a response can be cached.

Validation is the process of checking if a cached response is still valid.

Both can be used at the same time to improve the performance of the system.

Much more details about caching with HTTP can be found on MDN Web Docs:
<https://developer.mozilla.org/en-US/docs/Web/HTTP/Caching>.

> [!TIP]
>
> MDN Web Docs is a great resource to learn about web technologies. It is
> maintained by the Mozilla Foundation and is considered a reliable source of
> information.
>
> If you ever have a question about a web technology, you can check MDN Web Docs
> to find the answer.

### Expiration model

The expiration model is the simplest caching model. It is described in
[RFC 2616](https://datatracker.ietf.org/doc/html/rfc2616#section-13.2).

The cache is invalidated after a certain amount of time. The cache can be
invalidated after a certain amount of time because the data is not expected to
change.

The expiration model can be used to cache static content (e.g. images, videos,
etc.) or to cache responses from servers to improve the performance of the
system.

The expiration model can be implemented with the following header:

- `Cache-Control: max-age=<number of seconds>`: specifies the maximum amount of
  seconds a resource will be considered fresh. and responses.

![Expiration model](./images/expiration-model.png)

### Validation model

The validation model is more complex than the expiration model. It is described
in [RFC 2616](https://datatracker.ietf.org/doc/html/rfc2616#section-13.3).

The cache is invalidated when the data is modified. The cache can be invalidated
when the data is modified because the data is expected to change.

The validation model can be used to cache responses from servers to improve the
performance of the system.

The main idea of the validation model is:

1. Send a request to the server to check if the data has changed.
2. If the data has not changed, the server can return a `304 Not Modified`
   response to the client.
3. If the data has changed, the server can return a `200 OK` response to the
   client with the new data.

The request to check if the data has changed is called a **conditional
request**.

When clients want to update a resource, they can send a conditional request to
the server to check if the data has changed since the last time it was modified.

If not, the server can update the resource. If the data has changed, the server
can return a `412 Precondition Failed` response to the client.

There are two types of conditional requests:

- **Based on the `Last-Modified` header**: allows a `304 Not Modified` to be
  returned if content is unchanged since the last time it was modified.
- **Based on the `ETag` header**: allows a `304 Not Modified` to be returned if
  content is unchanged for the version/hash of the given entity.

#### Based on the `Last-Modified` header

With HTTP, the validation model can be implemented with the following headers:

- `Last-Modified`: indicates the date and time at which the origin server
  believes the selected representation was last modified.
- `If-Modified-Since`: returns a `304 Not Modified` if content is unchanged
  since the time specified in this field (= the value of the `Last-Modified`
  header).
- `If-Unmodified-Since`: returns a `412 Precondition Failed` if content has
  changed since the time specified in this field (= the value of the
  `Last-Modified` header) **when you try to update/delete the resource**.

The `Last-Modified` header is used to check if the data has changed since the
last time it was modified.

![Validation based on the Last-Modified header](./images/validation-model-based-on-the-last-modified-header.png)

#### Based on the `ETag` header

With HTTP, the validation model can be implemented with the following headers:

- `ETag`: provides the current entity tag for the selected representation. Think
  of it like a version number or a hash for the given resource.
- `If-None-Match`: returns a `304 Not Modified` if content is unchanged for the
  entity specified (`ETag`) by this field (= the value of the `ETag` header).
- `If-Match`: returns a `412 Precondition Failed` if content is changed for the
  entity specified (`ETag`) by this field (= the value of the `ETag` header)
  **when you try to update/delete the resource**.

The `ETag` header is used to check if the data has changed since the last time
it was modified.

![Validation based on the ETag header](./images/validation-model-based-on-the-etag-header.png)

## Managing cache with proxies

A forward/reverse proxy can be used to manage cache with HTTP as well. A
forward/reverse proxy can cache responses from clients/servers to improve the
performance of the system.

Traefik, for example, can be used to cache responses from servers. It is
available as a middleware in their Enterprise version. You can learn more about
it in their documentation at
<https://doc.traefik.io/traefik-enterprise/middlewares/http-cache/>.

As it is out of the scope/reach for this course, we will not go into details
about how to configure Traefik to cache responses from servers. We will,
however, implement it on the server side with Javalin.

## Managing cache with key-value stores

A key-value store is a type of database that stores data as a collection of key
value pairs.

A key-value store can be used to manage cache with HTTP. A key-value store can
cache responses from clients/servers to improve the performance of the system.

Redis, for example, can be used as a key-value store to cache responses from
servers. You can learn more about it in their documentation at
<https://redis.io/documentation>.

As it is out of the scope/reach for this course, we will not go into details
about how to configure Redis to cache responses from servers. We will, however,
implement it on the server side with Javalin.

## Practical content

In this practical content, you will implement the validation model based on the
`Last-Modified` header in your application.

You will need the results of the practical content from chapter
[HTTP and curl](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/21-http-and-curl).

If you do not have the results of the practical content from chapter HTTP and
curl, you can use the solution mentioned in the HTTP and curl chapter. Clone the
solution to have the project ready for this practical content.

### Add a `Map` to cache results to your application

Update your `Main.java` class to add a `Map` to cache results to your
application:

```diff
diff --git a/21-http-and-curl/src/main/java/ch/heigvd/dai/Main.java b/21-http-and-curl/src/main/java/ch/heigvd/dai/Main.java
index d4aae20..cc64e48 100644
--- a/21-http-and-curl/src/main/java/ch/heigvd/dai/Main.java
+++ b/21-http-and-curl/src/main/java/ch/heigvd/dai/Main.java
@@ -4,20 +4,33 @@ import ch.heigvd.dai.auth.AuthController;
 import ch.heigvd.dai.users.User;
 import ch.heigvd.dai.users.UsersController;
 import io.javalin.Javalin;
+import java.time.LocalDateTime;
 import java.util.concurrent.ConcurrentHashMap;

 public class Main {
   public static final int PORT = 8080;

   public static void main(String[] args) {
-    Javalin app = Javalin.create();
+    Javalin app =
+            Javalin.create(
+                    // Add custom configuration to Javalin
+                    config -> {
+                      // This will allow us to parse LocalDateTime
+                      config.validation.register(LocalDateTime.class, LocalDateTime::parse);
+                    });

     // This will serve as our database
     ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<>();

+    // This will serve as our cache
+    //
+    // The key is to identify the user(s)
+    // The value is the last modification time of the user(s)
+    ConcurrentHashMap<Integer, LocalDateTime> usersCache = new ConcurrentHashMap<>();
+
     // Controllers
-    AuthController authController = new AuthController(users);
-    UsersController usersController = new UsersController(users);
+    AuthController authController = new AuthController(users, usersCache);
+    UsersController usersController = new UsersController(users, usersCache);

     // Auth routes
     app.post("/login", authController::login);
```

In this code snippet, we have added a `Map` to cache results to your
application.

The key is to identify the user(s) and the value is the last modification time
of the user(s).

Javalin does not support `LocalDateTime` (the class representing a date) by
default. We have added a custom configuration to Javalin to parse
`LocalDateTime`.

Update the `AuthController.java` and `UsersController.java` classes to use the
`Map` to cache results to your application:

```diff
diff --git a/21-http-and-curl/src/main/java/ch/heigvd/dai/auth/AuthController.java b/21-http-and-curl/src/main/java/ch/heigvd/dai/auth/AuthController.java
index 08c8670..4ebbf93 100644
--- a/21-http-and-curl/src/main/java/ch/heigvd/dai/auth/AuthController.java
+++ b/21-http-and-curl/src/main/java/ch/heigvd/dai/auth/AuthController.java
@@ -2,13 +2,19 @@ package ch.heigvd.dai.auth;

 import ch.heigvd.dai.users.User;
 import io.javalin.http.*;
+import java.time.LocalDateTime;
 import java.util.concurrent.ConcurrentHashMap;

 public class AuthController {
   private final ConcurrentHashMap<Integer, User> users;

-  public AuthController(ConcurrentHashMap<Integer, User> users) {
+  private final ConcurrentHashMap<Integer, LocalDateTime> usersCache;
+
+  public AuthController(
+          ConcurrentHashMap<Integer, User> users,
+          ConcurrentHashMap<Integer, LocalDateTime> usersCache) {
     this.users = users;
+    this.usersCache = usersCache;
   }

   public void login(Context ctx) {
```

```diff
diff --git a/21-http-and-curl/src/main/java/ch/heigvd/dai/users/UsersController.java b/21-http-and-curl/src/main/java/ch/heigvd/dai/users/UsersController.java
index 76bca68..ac9f527 100644
--- a/21-http-and-curl/src/main/java/ch/heigvd/dai/users/UsersController.java
+++ b/21-http-and-curl/src/main/java/ch/heigvd/dai/users/UsersController.java
@@ -1,6 +1,7 @@
 package ch.heigvd.dai.users;

 import io.javalin.http.*;
+import java.time.LocalDateTime;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.concurrent.ConcurrentHashMap;
@@ -10,8 +11,13 @@ public class UsersController {
   private final ConcurrentHashMap<Integer, User> users;
   private final AtomicInteger userId = new AtomicInteger(1);

-  public UsersController(ConcurrentHashMap<Integer, User> users) {
+  private final ConcurrentHashMap<Integer, LocalDateTime> usersCache;
+
+  public UsersController(
+          ConcurrentHashMap<Integer, User> users,
+          ConcurrentHashMap<Integer, LocalDateTime> usersCache) {
     this.users = users;
+    this.usersCache = usersCache;
   }

   public void create(Context ctx) {
```

In these code snippets, we have updated the `AuthController.java` and
`UsersController.java` classes to use the `Map` to cache results to your
application.

### Store results in the cache and return the `Last-Modified` header

Update the `AuthController.java` and `UsersController.java` classes to store
results in the cache and return the `Last-Modified` header:

```diff
diff --git a/src/main/java/ch/heigvd/dai/auth/AuthController.java b/src/main/java/ch/heigvd/dai/auth/AuthController.java
index 4ebbf93..dba1f86 100644
--- a/src/main/java/ch/heigvd/dai/auth/AuthController.java
+++ b/src/main/java/ch/heigvd/dai/auth/AuthController.java
@@ -56,6 +56,18 @@ public class AuthController {
       throw new UnauthorizedResponse();
     }

+    LocalDateTime now;
+    if (usersCache.containsKey(user.id)) {
+      // If it is already in the cache, get the last modification date
+      now = usersCache.get(user.id);
+    } else {
+      // Otherwise, set to the current date
+      now = LocalDateTime.now();
+      usersCache.put(user.id, now);
+    }
+
+    // Add the last modification date to the response
+    ctx.header("Last-Modified", String.valueOf(now));
     ctx.json(user);
   }
 }
```

```diff
diff --git a/src/main/java/ch/heigvd/dai/users/UsersController.java b/src/main/java/ch/heigvd/dai/users/UsersController.java
index 2948a46..05c5e88 100644
--- a/src/main/java/ch/heigvd/dai/users/UsersController.java
+++ b/src/main/java/ch/heigvd/dai/users/UsersController.java
@@ -14,6 +14,10 @@ public class UsersController {

   private final ConcurrentHashMap<Integer, LocalDateTime> usersCache;

+  // This is a magic number used to store the users' list last modification date
+  // As the ID for users starts from 1, it is safe to reserve the value -1 for all users
+  private final Integer RESERVED_ID_TO_IDENTIFY_ALL_USERS = -1;
+
   public UsersController(
           ConcurrentHashMap<Integer, User> users,
           ConcurrentHashMap<Integer, LocalDateTime> usersCache) {
@@ -46,7 +50,18 @@ public class UsersController {

     users.put(user.id, user);

+    // Store the last modification date of the user
+    LocalDateTime now = LocalDateTime.now();
+    usersCache.put(user.id, now);
+
+    // Invalidate the cache for all users
+    usersCache.remove(RESERVED_ID_TO_IDENTIFY_ALL_USERS);
+
     ctx.status(HttpStatus.CREATED);
+
+    // Add the last modification date to the response
+    ctx.header("Last-Modified", String.valueOf(now));
+
     ctx.json(user);
   }

@@ -59,6 +74,18 @@ public class UsersController {
       throw new NotFoundResponse();
     }

+    LocalDateTime now;
+    if (usersCache.containsKey(user.id)) {
+      // If it is already in the cache, get the last modification date
+      now = usersCache.get(user.id);
+    } else {
+      // Otherwise, set to the current date
+      now = LocalDateTime.now();
+      usersCache.put(user.id, now);
+    }
+
+    // Add the last modification date to the response
+    ctx.header("Last-Modified", String.valueOf(now));
     ctx.json(user);
   }

@@ -80,6 +107,18 @@ public class UsersController {
       users.add(user);
     }

+    LocalDateTime now;
+    if (usersCache.containsKey(RESERVED_ID_TO_IDENTIFY_ALL_USERS)) {
+      // If it is already in the cache, get the last modification date
+      now = usersCache.get(RESERVED_ID_TO_IDENTIFY_ALL_USERS);
+    } else {
+      // Otherwise, set to the current date
+      now = LocalDateTime.now();
+      usersCache.put(RESERVED_ID_TO_IDENTIFY_ALL_USERS, now);
+    }
+
+    // Add the last modification date to the response
+    ctx.header("Last-Modified", String.valueOf(now));
     ctx.json(users);
   }

@@ -107,6 +146,21 @@ public class UsersController {

     users.put(id, user);

+    LocalDateTime now;
+    if (usersCache.containsKey(user.id)) {
+      // If it is already in the cache, get the last modification date
+      now = usersCache.get(user.id);
+    } else {
+      // Otherwise, set to the current date
+      now = LocalDateTime.now();
+      usersCache.put(user.id, now);
+
+      // Invalidate the cache for all users
+      usersCache.remove(RESERVED_ID_TO_IDENTIFY_ALL_USERS);
+    }
+
+    // Add the last modification date to the response
+    ctx.header("Last-Modified", String.valueOf(now));
     ctx.json(user);
   }

@@ -119,6 +173,12 @@ public class UsersController {

     users.remove(id);

+    // Invalidate the cache for the user
+    usersCache.remove(id);
+
+    // Invalidate the cache for all users
+    usersCache.remove(RESERVED_ID_TO_IDENTIFY_ALL_USERS);
+
     ctx.status(HttpStatus.NO_CONTENT);
   }
 }
```

In these code snippets, we have updated the `AuthController.java` and
`UsersController.java` classes to store results in the cache and return the
`Last-Modified` header.

If you run your application and create a new user, you will see that the
`Last-Modified` header is returned in the response.

The same applies when you get a user or all users.

However, at the moment, each time you create, get, update, or delete a user, the
full object(s) are returned as the caching system is not yet fully implemented.

### Validate the cache with the `If-Modified-Since` header

Update the `AuthController.java` and `UsersController.java` classes to validate
the cache with the `If-Modified-Since` header:

```diff
diff --git a/src/main/java/ch/heigvd/dai/auth/AuthController.java b/src/main/java/ch/heigvd/dai/auth/AuthController.java
index dba1f86..bbd93ca 100644
--- a/src/main/java/ch/heigvd/dai/auth/AuthController.java
+++ b/src/main/java/ch/heigvd/dai/auth/AuthController.java
@@ -50,6 +50,15 @@ public class AuthController {

     Integer userId = Integer.parseInt(userIdCookie);

+    // Get the last known modification date of the user
+    LocalDateTime lastKnownModification =
+            ctx.headerAsClass("If-Modified-Since", LocalDateTime.class).getOrDefault(null);
+
+    // Check if the user has been modified since the last known modification date
+    if (lastKnownModification != null && usersCache.get(userId).equals(lastKnownModification)) {
+      throw new NotModifiedResponse();
+    }
+
     User user = users.get(userId);

     if (user == null) {
```

```diff
diff --git a/src/main/java/ch/heigvd/dai/users/UsersController.java b/src/main/java/ch/heigvd/dai/users/UsersController.java
index 05c5e88..b69cb4a 100644
--- a/src/main/java/ch/heigvd/dai/users/UsersController.java
+++ b/src/main/java/ch/heigvd/dai/users/UsersController.java
@@ -68,6 +68,15 @@ public class UsersController {
   public void getOne(Context ctx) {
     Integer id = ctx.pathParamAsClass("id", Integer.class).get();

+    // Get the last known modification date of the user
+    LocalDateTime lastKnownModification =
+            ctx.headerAsClass("If-Modified-Since", LocalDateTime.class).getOrDefault(null);
+
+    // Check if the user has been modified since the last known modification date
+    if (lastKnownModification != null && usersCache.get(id).equals(lastKnownModification)) {
+      throw new NotModifiedResponse();
+    }
+
     User user = users.get(id);

     if (user == null) {
@@ -90,6 +99,17 @@ public class UsersController {
   }

   public void getMany(Context ctx) {
+    // Get the last known modification date of all users
+    LocalDateTime lastKnownModification =
+            ctx.headerAsClass("If-Modified-Since", LocalDateTime.class).getOrDefault(null);
+
+    // Check if all users have been modified since the last known modification date
+    if (lastKnownModification != null
+            && usersCache.containsKey(RESERVED_ID_TO_IDENTIFY_ALL_USERS)
+            && usersCache.get(RESERVED_ID_TO_IDENTIFY_ALL_USERS).equals(lastKnownModification)) {
+      throw new NotModifiedResponse();
+    }
+
     String firstName = ctx.queryParam("firstName");
     String lastName = ctx.queryParam("lastName");
```

In these code snippets, we have updated the `AuthController.java` and
`UsersController.java` classes to validate the cache with the
`If-Modified-Since` header.

If you run your application and get a user or all users with the
`If-Modified-Since` header, you will see that the response is cached with a
`304 Not Modified` response. Not even the database is queried, more performance!

### Validate the cache with the `If-Unmodified-Since` header

Upddate the `UsersController.java` classe to validate the cache with the
`If-Unmodified-Since` header:

```diff
diff --git a/src/main/java/ch/heigvd/dai/users/UsersController.java b/src/main/java/ch/heigvd/dai/users/UsersController.java
index b69cb4a..a5a3aee 100644
--- a/src/main/java/ch/heigvd/dai/users/UsersController.java
+++ b/src/main/java/ch/heigvd/dai/users/UsersController.java
@@ -145,6 +145,15 @@ public class UsersController {
   public void update(Context ctx) {
     Integer id = ctx.pathParamAsClass("id", Integer.class).get();

+    // Get the last known modification date of the user
+    LocalDateTime lastKnownModification =
+            ctx.headerAsClass("If-Unmodified-Since", LocalDateTime.class).getOrDefault(null);
+
+    // Check if the user has been modified since the last known modification date
+    if (lastKnownModification != null && !usersCache.get(id).equals(lastKnownModification)) {
+      throw new PreconditionFailedResponse();
+    }
+
     User updateUser =
         ctx.bodyValidator(User.class)
             .check(obj -> obj.firstName != null, "Missing first name")
@@ -187,6 +196,15 @@ public class UsersController {
   public void delete(Context ctx) {
     Integer id = ctx.pathParamAsClass("id", Integer.class).get();

+    // Get the last known modification date of the user
+    LocalDateTime lastKnownModification =
+            ctx.headerAsClass("If-Unmodified-Since", LocalDateTime.class).getOrDefault(null);
+
+    // Check if the user has been modified since the last known modification date
+    if (lastKnownModification != null && !usersCache.get(id).equals(lastKnownModification)) {
+      throw new PreconditionFailedResponse();
+    }
+
     if (!users.containsKey(id)) {
       throw new NotFoundResponse();
     }
```

In this code snippet, we have updated the `UsersController.java` class to
validate the cache with the `If-Unmodified-Since` header.

If you run your application and update or delete a user with an old
`If-Unmodified-Since` header, you will see that the response is a
`412 Precondition Failed` response. The client cannot update or delete the
resource because the resource has been modified since the last time the client
modified it.

### Test the caching system with curl

Now that you have implemented the validation model based on the `Last-Modified`
header in your application, you can test the caching system.

To test the caching system, you can use the following steps:

1. Create a new user as client 1.
2. Get the user as client 1.
3. Get the user as client 2.
4. Update the user as client 1.
5. Update the user as client 2 using the old `Last-Modified` header.
6. Get all users as client 1.
7. Create a new user as client 2.
8. Get all users as client 1 using the old `Last-Modified` header.

Use the following commands to test the caching system with curl to simulate
multiple clients and see if the cache is working as expected.

#### Create a new user as client 1

```sh
# Create a new user as client 1
curl -i \
  -X POST \
  -H "Content-Type: application/json" \
  -d '{"firstName":"John","lastName":"Doe","email":"john.doe@example.com","password":"secret"}' \
  http://localhost:8080/users
```

The output should be similar to the following:

```text
HTTP/1.1 201 Created
Date: Fri, 06 Dec 2024 20:28:19 GMT
Content-Type: application/json
Last-Modified: 2024-12-06T21:28:19.140804844
Content-Length: 95

{"id":1,"firstName":"John","lastName":"Doe","email":"john.doe@example.com","password":"secret"}
```

The `Last-Modified` header indicates the date and time at which the resource was
last modified.

#### Get the user as client 1

Now that you have created a user as client 1, you can get the user as client 1,
using the `If-Modified-Since` header:

```sh
# Get the user as client 1
curl -i \
  -X GET \
  -H "If-Modified-Since: 2024-12-06T21:28:19.140804844" \
  http://localhost:8080/users/1
```

The output should be similar to the following:

```text
HTTP/1.1 304 Not Modified
Date: Fri, 06 Dec 2024 20:50:17 GMT
Content-Type: text/plain
```

The `304 Not Modified` response indicates that the resource has not been
modified since the time specified in the `If-Modified-Since` header.

#### Get the user as client 2

Now that you have gotten the user as client 1, you can get the user as client 2:

```sh
# Get the user as client 2
curl -i \
  -X GET \
  http://localhost:8080/users/1
```

The output should be similar to the following:

```text
HTTP/1.1 200 OK
Date: Fri, 06 Dec 2024 20:50:43 GMT
Content-Type: application/json
Last-Modified: 2024-12-06T21:28:19.140804844
Content-Length: 95

{"id":1,"firstName":"John","lastName":"Doe","email":"john.doe@example.com","password":"secret"}
```

As this is the first time client 2 has requested the user, the server has
returned a `200 OK` response with the user and the `Last-Modified` header
corresponding to the date and time at which the resource was last modified.

#### Update the user as client 1

Now that you have gotten the user as client 2, you can update the user as client
1:

```sh
# Update the user with ID 1 as client 1
curl -i \
  -X PUT \
  -H "Content-Type: application/json" \
  -H "If-Unmodified-Since: 2024-12-06T21:28:19.140804844" \
  -d '{"firstName":"Jane","lastName":"Doe","email":"jane.doe@example.com","password":"secret"}' \
  http://localhost:8080/users/1
```

The output should be similar to the following:

```text
HTTP/1.1 200 OK
Date: Fri, 06 Dec 2024 20:52:30 GMT
Content-Type: application/json
Last-Modified: 2024-12-06T21:52:30.542486768
Content-Length: 95

{"id":1,"firstName":"Jane","lastName":"Doe","email":"jane.doe@example.com","password":"secret"}
```

The user has been updated successfully. The `Last-Modified` header indicates the
date and time at which the resource was last modified, updated since the last
time it was modified.

#### Update the user as client 2 using the old `Last-Modified` header

Now that you have updated the user as client 1, you can try to update the user
as client 2:

```sh
# Update the user with ID 1 as client 2 using the old Last-Modified header
curl -i \
  -X PUT \
  -H "Content-Type: application/json" \
  -H "If-Unmodified-Since: 2024-12-06T21:28:19.140804844" \
  -d '{"firstName":"Jeanne","lastName":"Doe","email":"jeanne.doe@example.com","password":"secret"}' \
  http://localhost:8080/users/1
```

The output should be similar to the following:

```text
HTTP/1.1 412 Precondition Failed
Date: Fri, 06 Dec 2024 20:55:04 GMT
Content-Type: text/plain
Content-Length: 19

Precondition Failed
```

The `412 Precondition Failed` response indicates that the resource has been
modified since the time specified in the `If-Unmodified-Since` header. The
client cannot update the resource because the resource has been modified since
the last time the client requested it. The client has to get the resource again
to update it.

#### Get all users as client 1

Get all users as client 1:

```sh
# Get all users as client 1
curl -i \
  -X GET \
  http://localhost:8080/users
```

The output should be similar to the following:

```text
HTTP/1.1 200 OK
Date: Fri, 06 Dec 2024 21:05:23 GMT
Content-Type: application/json
Last-Modified: 2024-12-06T22:02:24.421558585
Content-Length: 97

[{"id":1,"firstName":"Jane","lastName":"Doe","email":"jane.doe@example.com","password":"secret"}]
```

The list of users has been returned successfully. The `Last-Modified` header
indicates the date and time at which the resource was last modified.

If you try to get all users again, you will see that the response is cached with
a `304 Not Modified` response:

```sh
# Get all users as client 1 using the Last-Modified header
curl -i \
  -X GET \
  -H "If-Modified-Since: 2024-12-06T22:02:24.421558585" \
  http://localhost:8080/users
```

#### Create a new user as client 2

Create a new user as client 2:

```sh
# Create a new user as client 2
curl -i \
  -X POST \
  -H "Content-Type: application/json" \
  -d '{"firstName":"Alice","lastName":"Doe","email":"alice.doe@example.com","password":"secret"}' \
  http://localhost:8080/users
```

The output should be similar to the previous one you have seen when you created
a new user as client 1.

#### Get all users as client 1 using the old `Last-Modified` header

Get all users as client 1 using the old `Last-Modified` header:

```sh
# Get all users as client 1 using the old If-Modified-Since header
curl -i \
  -X GET \
  -H "If-Modified-Since: 2024-12-06T22:02:24.421558585" \
  http://localhost:8080/users
```

The output should be similar to the following:

```text
HTTP/1.1 200 OK
Date: Fri, 06 Dec 2024 21:08:11 GMT
Content-Type: application/json
Last-Modified: 2024-12-06T22:08:11.793635324
Content-Length: 195

[{"id":1,"firstName":"Jane","lastName":"Doe","email":"jane.doe@example.com","password":"secret"},{"id":2,"firstName":"Alice","lastName":"Doe","email":"alice.doe@example.com","password":"secret"}]
```

As the cache for the list of users has been invalidated (using the
`RESERVED_ID_TO_IDENTIFY_ALL_USERS` magic ID), the server has returned a
`200 OK` response with the list of users and the `Last-Modified` header
corresponding to the date and time at which the resource was last modified.

### Test the caching system with a browser

You can also test the caching system with a browser to see if the cache is
working as expected.

We recommend creating the users with curl as it is easier than with a browser.
Then, you can use the browser to test the caching system of the `GET` requests.

To check if the cache is working as expected, open the developer tools of your
browser and check the `Network` tab as seen in the chapter
[HTTP and curl](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/21-http-and-curl).

You can use the same steps as with curl to test the caching system with a
browser.

![Network tab in the developer tools of the browser](./images/what-will-you-do.png)

### Go further

This is an optional section. Feel free to skip it if you do not have time.

- Are you able to add the expiration model to the validation model to use both
  models at the same time?
- Are you able to replace the `Last-Modified` validation model with the `ETag`
  validation model in your application?

## Conclusion

### What did you do and learn?

In this chapter, you have learned about caching mechanisms that are offered by
HTTP. You have discovered the expiration and validation caching models. You have
implemented the validation model based on the `Last-Modified` header in your
application to improve the performance of the system: if the data has not
changed, the server can return a `304 Not Modified` response to the client
without even querying the database and processing the request.

You have tested the caching system with curl to simulate multiple clients and
see if the cache is working as expected. You have also tested the caching system
with a browser to see if the cache is working as expected.

### Test your knowledge

At this point, you should be able to answer the following questions:

- What is a cache?
- What is the expiration model?
- What is the validation model?
- What are the two types of conditional requests?
- What are the headers used to implement the validation model based on the
  `Last-Modified` header?
- What are the headers used to implement the validation model based on the
  `ETag` header?

## Finished? Was it easy? Was it hard?

Can you let us know what was easy and what was difficult for you during this
chapter?

This will help us to improve the course and adapt the content to your needs. If
we notice some difficulties, we will come back to you to help you.

> [!NOTE]
>
> Vous pouvez évidemment poser toutes vos questions et/ou vos propositions
> d'améliorations en français ou en anglais.
>
> N'hésitez pas à nous dire si vous avez des difficultés à comprendre un concept
> ou si vous avez des difficultés à réaliser les éléments demandés dans le
> cours. Nous sommes là pour vous aider !

➡️ [GitHub Discussions][discussions]

You can use reactions to express your opinion on a comment!

## What will you do next?

We are arriving at the end of the third part of the course. An evaluation will
be done to check your understanding of all the content seen in this third part.

## Additional resources

_Resources are here to help you. They are not mandatory to read._

- _None yet_

_Missing item in the list? Feel free to open a pull request to add it! ✨_

## Sources

- Main illustration by [Richard Horne](https://unsplash.com/@richardhorne) on
  [Unsplash](https://unsplash.com/photos/black-and-blue-train-running-near-the-tunnel-2PKKbKEkmQE)
