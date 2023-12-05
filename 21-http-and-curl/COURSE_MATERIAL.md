[markdown]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/21-http-and-curl/COURSE_MATERIAL.md
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/21-http-and-curl/21-http-and-curl-course-material.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/121
[illustration]:
  https://images.unsplash.com/photo-1446770145316-10a05382c470?fit=crop&h=720

# HTTP and curl - Course material

<https://github.com/heig-vd-dai-course>

[Markdown][markdown] · [PDF][pdf]

L. Delafontaine and H. Louis, with the help of Copilot.

Based on the original course by O. Liechti and J. Ehrensberger.

This work is licensed under the [CC BY-SA 4.0][license] license.

![Main illustration][illustration]

## Table of contents

- [Table of contents](#table-of-contents)
- [Objectives](#objectives)
- [Disclaimer](#disclaimer)
- [Prepare and setup your environment](#prepare-and-setup-your-environment)
  - [Start and configure curl](#start-and-configure-curl)
  - [Create and configure a new IntelliJ IDEA project](#create-and-configure-a-new-intellij-idea-project)
  - [Add Javalin to the project](#add-javalin-to-the-project)
  - [Update the `Main.java` file](#update-the-mainjava-file)
  - [Explore and understand the code](#explore-and-understand-the-code)
- [HTTP](#http)
  - [HTTP resources](#http-resources)
  - [HTTP request methods](#http-request-methods)
  - [HTTP response status codes](#http-response-status-codes)
  - [HTTP query parameters, path parameters, body and URL encoding](#http-query-parameters-path-parameters-body-and-url-encoding)
  - [HTTP status codes](#http-status-codes)
  - [HTTP headers](#http-headers)
  - [Content negotiation](#content-negotiation)
  - [HTTP caching](#http-caching)
  - [HTTP sessions (stateful vs. stateless)](#http-sessions-stateful-vs-stateless)
  - [HTTP cookies](#http-cookies)
- [Interact with HTTP](#interact-with-http)
  - [The browser](#the-browser)
  - [Specialized tools (Postman, Insomnia, etc)](#specialized-tools-postman-insomnia-etc)
  - [Command line tools (curl, etc)](#command-line-tools-curl-etc)
- [HTTP in Java](#http-in-java)
- [Practical content](#practical-content)
  - [Install and configure curl](#install-and-configure-curl)
  - [Interact with an API](#interact-with-an-api)
  - [Use HTTP with Java](#use-http-with-java)
  - [Go further](#go-further)
- [Conclusion](#conclusion)
  - [What did you do and learn?](#what-did-you-do-and-learn)
  - [Test your knowledge](#test-your-knowledge)
- [Finished? Was it easy? Was it hard?](#finished-was-it-easy-was-it-hard)
- [What will you do next?](#what-will-you-do-next)
- [Additional resources](#additional-resources)
- [Sources](#sources)
- [HTTP versions](#http-versions)
  - [HTTP/0.9](#http09)
  - [HTTP/1.0](#http10)
  - [HTTP/1.1](#http11)
  - [HTTP/2](#http2)
  - [HTTP/3](#http3)

## Objectives

So far in the course, you have built network applications using the TCP and UDP
protocols.

You have mastered these protocols and you are now able to build network
applications using them.

TCP and UDP are low-level protocols. They are used to transfer data between
computers. They do not define how the data should be structured.

It is up to the developers to define how the data should be structured, using an
application protocol, for example.

This is where the HTTP protocol comes into play.

In this final part, you will learn how to use the HTTP protocol to build network
applications using all the features offered by this protocol.

This will allow you to build more complex network applications, built on top of
a solid foundation: HTTP.

As HTTP offers many features and is a very complex protocol, this chapter will
be a mixed between theory and practice to introduce you to the most important
concepts.

## Disclaimer

In this chapter, you will learn and experiment with the HTTP protocol. We will
focus on the version 1.1 of the protocol as it is the most used version today
and is supported by all browsers. Other versions of the protocol will be
mentioned but will not be covered in details.

You will also experiment with HTTP with the help of
[Javalin](https://javalin.io/).

Javalin is a lightweight web framework for Java and Kotlin. It is built on top
of [Jetty](https://eclipse.dev/jetty/).

Even though you will have a good understanding of HTTP at the end of this
chapter, **this is not a web course**.

The web is a complex ecosystem with many different technologies. HTTP is only
one of them. You will see other technologies in future courses.

Javalin is the perfect tool to learn and experiment with HTTP. However, it is
not a production-ready library. It is only meant to be used for learning
purposes and for prototyping.

If you want to develop a network application using HTTP that you want to use in
production, you will have to use a third-party library such as
[Quarkus](https://quarkus.io/) or
[Spring Boot](https://spring.io/projects/spring-boot).

As these libraries are out of the scope of this course (and mostly because you
will see them details in future courses), we will not use them.

## Prepare and setup your environment

### Start and configure curl

In this section, you will start [curl](https://curl.se/) using its official
Docker image available on Docker Hub: <https://github.com/curl/curl-container>.

To start curl, run the following command:

```sh
# Pull the Docker image
docker pull curlimages/curl:latest

# Start the Docker image
docker run --rm curlimages/curl:latest
```

The output should be similar to the following:

```text
Unable to find image 'curlimages/curl:latest' locally
latest: Pulling from curlimages/curl
96526aa774ef: Already exists
b3ed3d59459c: Pull complete
4f4fb700ef54: Pull complete
Digest: sha256:4a3396ae573c44932d06ba33f8696db4429c419da87cbdc82965ee96a37dd0af
Status: Downloaded newer image for curlimages/curl:latest
curl: try 'curl --help' or 'curl --manual' for more information
```

Now start the container overwriting the default entrypoint to access the
container:

```sh
# Start the Docker image
docker run --rm -it --entrypoint /bin/sh curlimages/curl:latest
```

The output should be similar to the following:

```text
~ $
```

You are now in the container. You should be able to use `curl` inside the
container for the following sections. To exit the container, type `exit` and
press `Enter`.

### Create and configure a new IntelliJ IDEA project

In this section, you will create a new IntelliJ IDEA project to experiment with
HTTP in the next sections.

Create a new IntelliJ IDEA project as seen in previous chapters with Maven.

### Add Javalin to the project

In this section, you will add [Javalin](https://javalin.io/) to the project.

Javalin is a lightweight web framework for Java and Kotlin. It is built on top
of [Jetty](https://eclipse.dev/jetty/).

Add the latest **stable** version of Javalin available in the Maven repository:
<https://mvnrepository.com/artifact/io.javalin/javalin> to the `pom.xml` file as
seen in previous chapters:

```xml
<!-- https://mvnrepository.com/artifact/io.javalin/javalin -->
<dependency>
    <groupId>io.javalin</groupId>
    <artifactId>javalin</artifactId>
    <version>5.6.3</version>
</dependency>
```

> **Note**  
> You might also need the SLF4J Simple Provider dependency for logging support
> (based on the official documentation
> [here](https://javalin.io/documentation#logging)). Add the latest **stable**
> version of SLF4J Simple Provider available in the Maven repository:
> <https://mvnrepository.com/artifact/org.slf4j/slf4j-simple> to the `pom.xml`
> file as seen in previous chapters:
>
> ```xml
> <dependency>
>     <groupId>org.slf4j</groupId>
>     <artifactId>slf4j-simple</artifactId>
>     <version>2.0.9</version>
> </dependency>
> ```

### Update the `Main.java` file

Update the `Main.java` file with the following code:

```java
package ch.heigvd;

import io.javalin.Javalin;

public class Main {
    public static final int PORT = 8080;

    public static void main(String[] args) {
        Javalin app = Javalin.create();

        app.get("/", ctx -> ctx.result("Hello, world!"));

        app.start(PORT);
    }
}
```

Run the application and open your browser at <http://localhost:8080>. You should
see the following:

```text
Hello, world!
```

Using curl, you can also access the server:

```sh
# Send a GET request to the server
curl "http://host.docker.internal:8080"
```

The host `host.docker.internal` is a special host that allows you to access the
host from inside the container. If you do not use curl inside a container, you
can use `localhost` instead.

The output should be the same as in the browser.

This file will be our starting point for the next sections. In future sections,
we will refer to this file as `Main.java`.

### Explore and understand the code

Let's take a look at the code.

```java
Javalin app = Javalin.create();
```

This line creates a new Javalin instance.

```java
app.get("/", ctx -> ctx.result("Hello, World!"));
```

This line creates a new context for the server. A context is a path on the
server. In this case, the context is `/`. This means that the server will
respond to requests to the path `/` using the `GET` method (more on this later).

The second parameter is a HTTP handler. It is a functional interface that
defines a method to handle HTTP requests. In this case, the method is a
[lambda expression](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)
that sends a response to the client.

```java
app.start(PORT);
```

This line will start the server on the port `8080`. You might have noticed that
no concurrency is specified. This is because Javalin uses good defaults that
they describe in their
[documentation](https://javalin.io/documentation#concurrency). You will not have
to worry about concurrency in this chapter as Javalin will handle it for you.

You now have a basic HTTP server running on your computer. It is time to learn
more about HTTP!

## HTTP

Hyper Text Transfer Protocol (HTTP) is a protocol used to transfer data over the
Web based. It is a client-server protocol based on the request-response pattern:
a client (called **user agent** in the HTTP specification) sends a request to a
server, the server processes the request and sends a response to the client.

A client can be a web browser, a command line tool, a mobile application, etc.

The client requests a resource from the server. A resource can be a web page, an
image, a video, etc.

HTTP was initiated by Tim Berners-Lee at CERN in 1989. It was first used in 1990
to transfer Hypertext Markup Language (HTML) documents.

HTML is a markup language used to create web pages that interconnect with each
other. It is the primary language used to create web pages.

Over the years, HTTP and HTML have evolved. HTTP is now used to transfer
different types of data (HTML, CSS, JavaScript, images, videos, etc.).

Built on top of TCP (until HTTP/2.0) and UDP (since HTTP/3.0), HTTP offers
numerous features that make it a very powerful protocol.

Servers typically listen on the TCP port 80 for HTTP and 443 for HTTPS.

### HTTP resources

A resource is identified by a URL. A resource can be a web page, an image, a
video, etc.

Let's take a look at the following URL (the "Fiche d'unité" of the current
course in GAPS):

<https://gaps.heig-vd.ch/consultation/fiches/uv/uv.php?id=6573>

The URL is composed of the following parts:

- The protocol (`http` or `https`)
- The host (e.g. `gaps.heig-vd.ch`)
- The port number (optional, e.g. `:80` for HTTP or `:443` for HTTPS)
- The path to the resource (e.g. `/consultation/fiches/uv/uv.php`)
- The query parameters (optional, e.g. `?id=6573`)

The URL can also contain the following parts:

- The path parameters (optional, e.g. `/users/{user-id}/view`, where `{user-id}`
  is a path parameter)
- A subdomain (optional, e.g. `gaps` in `gaps.heig-vd.ch`)

The **host** is sometimes called the **domain name** or the **fully qualified
domain name** (FQDN). It is composed of the following parts:

- The subdomain (optional, e.g. `gaps` in `gaps.heig-vd.ch`)
- The domain name (e.g. `heig-vd`)
- The top-level domain (e.g. `ch`)

### HTTP request methods

In order to get a resource from a server, the client must send a request to the
server.

The request is defined by a method. The most used methods are:

- `GET` - Get a resource (default method - a browser always requests a resource
  using the HTTP method `GET` by default)
- `POST` - Create a new resource
- `PATCH` - Partially update a resource
- `PUT` - Update a resource
- `DELETE` - Delete a resource

Other methods exist but are out of the scope of this course.

Let's update the `Main.java` file to demonstrate this:

```java
package ch.heigvd;

import io.javalin.Javalin;

public class Main {

  public static final int PORT = 8080;

  public static void main(String[] args) {
    Javalin app = Javalin.create();

    app.get("/", ctx ->
        ctx.result("Hello, World from a GET request method!")
    );
    app.post("/", ctx ->
        ctx.result("Hello, World from a POST request method!")
    );
    app.patch("/", ctx ->
        ctx.result("Hello, World from a PATCH request method!")
    );
    app.delete("/", ctx ->
        ctx.result("Hello, World from a DELETE request method!")
    );

    app.start(PORT);
  }
}

```

We have added a new context for each HTTP method. Each context will respond to
the corresponding HTTP method. You might have noticed that we have used the same
context for each method. This is because the HTTP method is part of the request.

Run the application and open your browser at <http://localhost:8080>. You should
see the following:

```text
Hello, World from a GET request method!
```

Now, let's try to send a `POST` request to the server using curl:

```sh
curl -X POST "http://host.docker.internal:8080"
```

The `-X` option tells curl to use to set the HTTP method.

You should see the following:

```text
Hello, World from a POST request method!
```

Try the other methods using curl:

```sh
# Send a PATCH request to the server
curl -X PATCH "http://host.docker.internal:8080"

# Send a DELETE request to the server
curl -X DELETE "http://host.docker.internal:8080"
```

You should see the different responses.

These methods are used to interact with resources on the server. For example, if
you want to create a new user, you will send a `POST` request to the server. If
you want to update a user, you will send a `PATCH` or `PUT` request to the
server. If you want to delete a user, you will send a `DELETE` request to the
server.

### HTTP response status codes

When a client sends a request to a server, the server processes the request and
sends a response to the client.

The response is defined by a status code. Status codes are grouped into five
categories:

- `1xx` - Informational responses

  The most common informational response are:

  - `101` - Switching Protocols (the server switches to a different protocol)
  - `102` - Processing (the server is processing the request)
- `2xx` - Successful responses

  The most common successful responses are:

  - `200` - OK (the request was successful)
  - `201` - Created (the request was successful and a new resource was created)
  - `202` - Accepted (the request was accepted but not yet processed)
  - `204` - No Content (the request was successful but the server does not send
    any content)

- `3xx` - Redirection messages

  The most common redirection messages are:

  - `301` - Moved Permanently (the resource has been moved permanently to a new
    URL)
  - `302` - Found (the resource has been moved temporarily to a new URL)
  - `304` - Not Modified (the resource has not been modified since the last
    request)

- `4xx` - Client error responses
  The most common client error responses are:

  - `400` - Bad Request (the request is malformed)
  - `401` - Unauthorized (the request requires authentication)
  - `403` - Forbidden (the request is forbidden)
  - `404` - Not Found (the resource does not exist)
  - `405` - Method Not Allowed (the HTTP method is not allowed for this resource)
  - `409` - Conflict (the request could not be processed because of a conflict)
  - `410` - Gone (the resource is no longer available and has been removed)
  - `429` - Too Many Requests (the client has sent too many requests in a given
    amount of time)

- `5xx` - Server error responses

  The most common server error responses are:

  - `500` - Internal Server Error (the server encountered an unexpected condition
    that prevented it from fulfilling the request)
  - `501` - Not Implemented (the server does not support the functionality
    required to fulfill the request)
  - `502` - Bad Gateway (the server received an invalid response from an upstream
    server)
  - `503` - Service Unavailable (the server is currently unable to handle the
    request due to a temporary overload or scheduled maintenance)
  - `504` - Gateway Timeout (the server did not receive a timely response from an
    upstream server)

The default status code is `200` (OK). This means that you can omit the status
code.

Let's update the `Main.java` file to demonstrate this:

```java
package ch.heigvd;

import io.javalin.Javalin;
import io.javalin.http.HttpStatus;

public class Main {

  public static final int PORT = 8080;

  public static void main(String[] args) {
    Javalin app = Javalin.create();

    app.get("/", ctx ->
        ctx
          .result("Hello, World from a GET request method with a `HttpStatus.OK` response status!")
    );
    app.post("/", ctx ->
        ctx
          .result("Hello, World from a POST request method with a `HttpStatus.CREATED` response status!")
          .status(HttpStatus.CREATED)
    );
    app.patch("/", ctx ->
        ctx
          .result("Hello, World from a PATCH request method with a `HttpStatus.OK` response status!")
          .status(HttpStatus.OK)
    );
    app.delete("/", ctx ->
        ctx
          .result("Hello, World from a DELETE request method with a `HttpStatus.NO_CONTENT` response status!")
          .status(HttpStatus.NO_CONTENT)
    );

    app.start(PORT);
  }
}
```

Now, let's try to send a `GET` request to the server using curl:

```sh
curl -v http://host.docker.internal:8080
```

The `-v` option tells curl to print the request headers.

The output should be similar to the following:

```text
*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET / HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/8.1.2
> Accept: */*
> 
< HTTP/1.1 200 OK
< Date: Mon, 04 Dec 2023 14:44:01 GMT
< Content-Type: text/plain
< Content-Length: 78
< 
* Connection #0 to host localhost left intact
Hello, World from a GET request method with a `HttpStatus.OK` response status!
```

The `>` symbol indicates the request headers sent by the client.

The `<` symbol indicates the response headers sent by the server.

You will notice that the response status code is `200` (OK), as expected as no
status code was specified.

You will go into more details about HTTP headers in the next sections.

Try the other methods using curl:

```sh
# Send a POST request to the server
curl -v -X POST http://host.docker.internal:8080

# Send a PATCH request to the server
curl -v -X PATCH http://host.docker.internal:8080

# Send a DELETE request to the server
curl -v -X DELETE http://host.docker.internal:8080
```

The status codes should be the same as in the code. They are defined by the
`HttpStatus` class and allow to better understand the responses made by the
server and how to handle them.

### HTTP query parameters, path parameters, body and URL encoding

In the previous sections, you have seen how to send a request to a server and
how to get a response from the server.

In this section, you will learn how to send data to the server and how to get
data from the server.

#### HTTP query parameters

A HTTP request can contain query parameters. Query parameters are used to send
data to the server such as filters, search terms, etc.

Let's update the `Main.java` file to demonstrate this by adding a new context
with some query parameters:

```java
    app.get("/query-parameters-demo", ctx -> {
      String firstName = ctx.queryParam("firstName");
      String lastName = ctx.queryParam("lastName");
      
      if (firstName == null || lastName == null) {
        ctx.status(HttpStatus.BAD_REQUEST);
        return;
      }

      ctx.result("Hello, " + firstName + " " + lastName + "!");
    });
```

In this example, we have added a new context with the path
`/query-parameters-demo`. This context will respond to `GET` requests.

The context will get the query parameters `firstName` and `lastName` from the
request. If one of the query parameters is missing, the server will respond with
a `400` (Bad Request) status code.

If the query parameters are present, the server will respond with a `200` (OK)
status code and a message.

Run the application and open your browser at <http://localhost:8080>

Let's try to send a `GET` request to the server using curl:

```sh
curl http://host.docker.internal:8080/query-parameters-demo?firstName=John&lastName=Doe
```


#### HTTP body

A HTTP request can contain a body. The body is used to send data to the server.

A HTTP response can also contain a body. The body is used to send data to the
client.

The body is optional. It is not mandatory to send a body with a request or a
response. The body is not limited to text. It can contain any type of data (text, images,
videos, etc.) and can be of any size, encoded in any format.

Let's update the `Main.java` file to demonstrate this:

```java














### HTTP request and response format

In order to get a resource from a server, the client must send a request to the
server. The request contains the following information:

- The HTTP method
- The URL of the resource
- The supported HTTP version
- Some HTTP headers
- The HTTP body (optional)
- The query parameters (optional)
- The cookies (optional)
- The content type (optional)

The server processes the request and sends a response to the client. The
response contains the following information:

- The HTTP version
- The HTTP status code
- The HTTP headers
- The HTTP body (optional)
- The cookies (optional)
- The content type (optional)
- The content length (in HTTP/1.1)
- The content encoding (optional)

#### Structure of a HTTP request

A HTTP request is structured as follows:

```text
<HTTP method> <URL> HTTP/<HTTP version>
<HTTP headers>
<Empty line if there is a body>
<HTTP body (optional)>
```

An example of a HTTP request:

```text
GET / HTTP/1
Host: gaps.heig-vd.ch
User-Agent: curl/8.1.2
Accept: */*
```

In this example, we request the resource `/` from the server `gaps.heig-vd.ch`
using the HTTP method `GET` using the curl command line tool.

You can reproduce this request using curl:

```sh
# Send a GET request to GAPS
curl -v "http://gaps.heig-vd.ch"
```

The `-v` option tells curl to print the request headers.

The default HTTP method is `GET`. This means that you can omit the HTTP method.
A browser always requests a resource using the HTTP method `GET` by default.

The output should be similar to the following:

```text
*   Trying 193.134.218.91:80...
* Connected to gaps.heig-vd.ch (193.134.218.91) port 80 (#0)
> GET / HTTP/1.1
> Host: gaps.heig-vd.ch
> User-Agent: curl/8.1.2
> Accept: */*
>
< HTTP/1.1 200 OK
HTTP/1.1 200 OK
< Date: Mon, 27 Nov 2023 17:27:06 GMT
Date: Mon, 27 Nov 2023 17:27:06 GMT
< Server: Apache
Server: Apache
< Last-Modified: Thu, 23 Feb 2023 15:00:12 GMT
Last-Modified: Thu, 23 Feb 2023 15:00:12 GMT
< ETag: "17df-5f55f450264dd"
ETag: "17df-5f55f450264dd"
< Accept-Ranges: bytes
Accept-Ranges: bytes
< Content-Length: 6111
Content-Length: 6111
< Vary: Accept-Encoding
Vary: Accept-Encoding
< X-Content-Type-Options: nosniff
X-Content-Type-Options: nosniff
< X-Frame-Options: sameorigin
X-Frame-Options: sameorigin
< Content-Type: text/html; charset=ISO-8859-1
Content-Type: text/html; charset=ISO-8859-1

<
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <title>GAPS/SACHEM</title>
  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
  <LINK rel="stylesheet" href="style.css" type="text/css">
  <link rel="shortcut icon" href="/img/favicon.ico" />
</head>

<body>
  [...]
</body>

* Connection #0 to host gaps.heig-vd.ch left intact
</html>
```

The `>` symbol indicates the request headers sent by the client.

The `<` symbol indicates the response headers sent by the server.

The first lines of the request is:

```text
> GET / HTTP/1.1
> Host: gaps.heig-vd.ch
> User-Agent: curl/8.1.2
> Accept: */*
```

The `Accept` header tells the server that the user agent accepts any type of
content in return.

#### Structure of a HTTP response

A HTTP response is structured as follows:

```text
HTTP/<HTTP version> <HTTP status code> <HTTP status message>
<HTTP headers>
<Empty line if there is a body>
<HTTP body>
```

An example of a HTTP response from <http://gaps.heig-vd>:

```text
HTTP/1.1 200 OK
Date: Mon, 27 Nov 2023 17:42:47 GMT
Server: Apache
Last-Modified: Thu, 23 Feb 2023 15:00:12 GMT
ETag: "17df-5f55f450264dd"
Accept-Ranges: bytes
Content-Length: 6111
Vary: Accept-Encoding
X-Content-Type-Options: nosniff
X-Frame-Options: sameorigin
Content-Type: text/html; charset=ISO-8859-1

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <title>GAPS/SACHEM</title>
  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
  <LINK rel="stylesheet" href="style.css" type="text/css">
  <link rel="shortcut icon" href="/img/favicon.ico" />
</head>

<body>
  [...]
</body>

</html>
```

In this example, the server responds with the resource `/` using the HTTP status
code `200` (OK). The server also sends the content of the resource (the HTML).
The `Content-Type` header tells the client that the content is HTML with the
charset `ISO-8859-1`. The `Content-Length` header tells the client that the
content is `6111` bytes long (in HTTP/1.1).

Many other headers are sent by the server. They are not mandatory and some are
out of the scope of this course.

You can reproduce this request using curl:

```sh
# Send a GET request to GAPS
curl -i "http://gaps.heig-vd.ch"
```

The `-i` option tells curl to print the response headers.

### HTTP status codes

### HTTP headers

### Content negotiation

### HTTP caching

### HTTP sessions (stateful vs. stateless)

### HTTP cookies

## Interact with HTTP

### The browser

### Specialized tools (Postman, Insomnia, etc)

### Command line tools (curl, etc)

## HTTP in Java

## Practical content

### Install and configure curl

### Interact with an API

#### Create a new entity

#### Get a entity

#### Update a entity

#### Delete a entity

### Use HTTP with Java

Talk about the different version of the HTTP client

### Go further

This is an optional section. Feel free to skip it if you do not have time.

- Try to use Insomnia instead of curl to interact with the API!
- Try to find another API and interact with it!

## Conclusion

### What did you do and learn?

TODO

### Test your knowledge

At this point, you should be able to answer the following questions:

- TODO

## Finished? Was it easy? Was it hard?

Can you let us know what was easy and what was difficult for you during this
chapter?

This will help us to improve the course and adapt the content to your needs. If
we notice some difficulties, we will come back to you to help you.

➡️ [GitHub Discussions][discussions]

You can use reactions to express your opinion on a comment!

## What will you do next?

In the next chapter, you will learn the following topics:

- Web infrastructures
  - How to deploy and maintain web applications on the Internet?
  - How to scale web applications?
  - How to secure web applications?

## Additional resources

_Resources are here to help you. They are not mandatory to read._

- [Evolution of HTTP](https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/Evolution_of_HTTP)

_Missing item in the list? Feel free to open a pull request to add it! ✨_

## Sources

- Main illustration by [Ashley Knedler](https://unsplash.com/@ashkned) on
  [Unsplash](https://unsplash.com/photos/KvD36NRFjl4)

## HTTP versions

There are several versions of HTTP. The most used are HTTP/1.1, HTTP/2 and
HTTP/3.

Each version of HTTP saw the introduction of many features over the years.

The different versions are:

- HTTP/0.9 (1989)
- HTTP/1.0 (1996)
- HTTP/1.1 (1997)
- HTTP/2 (2015)
- HTTP/3 (2022)

Most features are retro-compatible. This means that a client using HTTP/1.1 can
communicate with a server using HTTP/2.

As of today, HTTP/1.1 and HTTP/2 are still the most used versions of HTTP.

### HTTP/0.9

The first version of HTTP was HTTP/0.9 in 1989. It was a very simple protocol
only meant to transfer HTML documents.

### HTTP/1.0

HTTP/1.0 was released in 1996. It introduced many features that are still used
today (among others):

- HTTP headers
- HTTP status codes
- HTTP methods
- Documents other than HTML (images, videos, etc.) are supported

### HTTP/1.1

HTTP/1.1 was released in 1997, an improved and faster version of HTTP/1.0. It
introduced many features that are still used today (among others):

- Persistent connections - The connection between the client and the server is
  kept alive after the response is sent. This allows the client to send multiple
  requests over the same connection. Which is more efficient.
- Additional cache control features
- Content negotiation - The client can ask for a specific version of a resource
  (HTML, CSS, etc.)
- Thanks to the `Host` header, it is possible to host multiple websites on the
  same server

### HTTP/2

HTTP/2 was released in 2015. The biggest change is the use of a binary protocol
instead of a text protocol. This makes it more efficient.

As no much new features were introduced, HTTP/2 was quickly adopted by the
industry.

### HTTP/3

HTTP/3 is the latest version of HTTP. It was released in 2022. It is based on
the QUIC protocol instead of TCP. QUIC is based on the UDP protocol, making it
more efficient.

The main point of HTTP/3 is to make the Web faster and more secure, using a more
efficient protocol based on UDP.
