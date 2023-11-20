[markdown]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/21-http-and-curl/COURSE_MATERIAL.md
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/21-http-and-curl/21-http-and-curl-course-material.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/121
[illustration]:
  https://images.unsplash.com/photo-1446770145316-10a05382c470?fit=crop&h=720

# HTTP and cURL - Course material

<https://github.com/heig-vd-dai-course>

[Markdown][markdown] · [PDF][pdf]

L. Delafontaine and H. Louis, with the help of Copilot.

Based on the original course by O. Liechti and J. Ehrensberger.

This work is licensed under the [CC BY-SA 4.0][license] license.

![Main illustration][illustration]

## Table of contents

- [Table of contents](#table-of-contents)
- [Objectives](#objectives)
- [HTTP](#http)
- [HTTP versions](#http-versions)
  - [HTTP/0.9](#http09)
  - [HTTP/1.0](#http10)
  - [HTTP/1.1](#http11)
  - [HTTP/2](#http2)
  - [HTTP/3](#http3)
- [The HTTP protocol](#the-http-protocol)
  - [Structure of a HTTP request](#structure-of-a-http-request)
  - [Structure of a HTTP response](#structure-of-a-http-response)
  - [HTTP methods](#http-methods)
  - [HTTP status codes](#http-status-codes)
  - [HTTP headers](#http-headers)
  - [HTTP Body, Query parameters, URL encoding](#http-body-query-parameters-url-encoding)
  - [HTTP caching](#http-caching)
  - [HTTP sessions (stateful vs. stateless)](#http-sessions-stateful-vs-stateless)
  - [HTTP cookies](#http-cookies)
- [Interact with HTTP](#interact-with-http)
  - [The browser](#the-browser)
  - [Specialized tools (Postman, Insomnia, etc)](#specialized-tools-postman-insomnia-etc)
  - [Command line tools (cURL, etc)](#command-line-tools-curl-etc)
- [HTTP in Java](#http-in-java)
- [Practical content](#practical-content)
  - [Install and configure cURL](#install-and-configure-curl)
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
a solid foundation (HTTP).

## HTTP

Hyper Text Transfer Protocol (HTTP) is a protocol used to transfer data over the
Web. It is a client-server protocol. It is based on the request-response
paradigm.

HTTP was initiated by Tim Berners-Lee at CERN in 1989. It was first used in 1990
to transfer Hypertext Markup Language (HTML) documents.

HTML is a markup language used to create web pages that interconnect with each
other. It is the primary language used to create web pages.

Over the years, HTTP and HTML have evolved. HTTP is now used to transfer
different types of data (HTML, CSS, JavaScript, images, videos, etc.).

Built on top of TCP, HTTP offers numerous features that make it a very powerful
protocol.

HTTP uses the TCP port 80 by default.

HTTPS is a secure version of HTTP. It uses the TCP port 443 by default.

## HTTP versions

There are several versions of HTTP. The most used are HTTP/1.1, HTTP/2 and
HTTP/3.

Each version of HTTP saw the introduction of many features over the years.

The most important versions are:

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
the QUIC protocol instead of TCP. This makes it more efficient.

The main point of HTTP/3 is to make the Web faster and more secure, using a more
efficient protocol based on UDP.

## The HTTP protocol

HTTP is a client-server protocol. It is based on the request-response paradigm:
a client (called user agent in the HTTP specification) sends a request to a
server, the server processes the request and sends a response to the client.

A client can be a web browser, a command line tool, a mobile application, etc.

The client requests a resource from the server. A resource can be a web page, an
image, a video, etc.

A resource is identified by a URL. The URL is composed of the following parts:

- The protocol (`http` or `https`)
- The domain name (or IP address) of the server (e.g. `gaps.heig-vd.ch`)
- The port number (optional, e.g. `:80` for HTTP or `:443` for HTTPS)

The URL can also contain the following parts:

- The path to the resource (e.g. `/`)
- The path parameters (optional, e.g. `/users/{user-id}`, where `{user-id}` is a
  path parameter)
- The query parameters (optional, e.g. `?q=hello`)
- The fragment (optional, e.g. `#section-1`)
- The subdomain (optional, e.g. `www.`)

In order to get a resource from a server, the client must send a request to the
server. The request contains the following information:

- The HTTP method
- The URL of the resource
- The HTTP version
- The HTTP headers
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
- The content length (optional)
- The content encoding (optional)

The details will be explained in the following sections.

### Structure of a HTTP request

A HTTP request is structured as follows:

```text
<HTTP method> <URL> HTTP/<HTTP version>
<HTTP headers>
<HTTP body>
```

An example of a HTTP request:

```text
GET / HTTP/1.1
Host: gaps.heig-vd.ch
User-Agent: curl/8.1.2
Accept: */*
```

In this example, we request the resource `/` from the server `gaps.heig-vd.ch`
using the HTTP method `GET`.

The user agent is `curl/8.1.2`, a command line tool used to interact with HTTP
servers that you will use later in this chapter.

The `Accept` header tells the server that the user agent accepts any type of
content in return.

### Structure of a HTTP response

A HTTP response is structured as follows:

```text
HTTP/<HTTP version> <HTTP status code> <HTTP status message>
<HTTP headers>
<HTTP body>
```

An example of a HTTP response:

```text
HTTP/1.1 200 OK
Date: Mon, 20 Nov 2023 15:00:11 GMT
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
code `200` (OK).

The `Content-Type` header tells the client that the content is HTML with the
charset `ISO-8859-1`.

The `Content-Length` header tells the client that the content is 6111 bytes
long.

Other headers are used to tell the client how to interpret the content but are
not mandatory and some are out of the scope of this course.

### HTTP methods

The HTTP method defines the action to be performed on a resource. The most used
methods are:

- `GET` - Get a resource
- `POST` - Create a new resource
- `PATCH` - Partially update a resource
- `PUT` - Update a resource
- `DELETE` - Delete a resource

A server exposes a set of resources. Each resources can have a different set of
HTTP methods associated with it.

For example, the resource `/api/users` on the server `gaps.heig-vd.ch` could be
accessed using the HTTP methods `GET`, `POST`, `PATCH` and `DELETE`:

- `GET /api/users` - Get all users
- `POST /api/users` - Create a new user
- `PATCH /api/users/{user-id}` - Partially update user with id `{user-id}`
- `DELETE /api/users/{user-id}` - Delete user with id `{user-id}`

### HTTP status codes

### HTTP headers

#### Content negotiation

### HTTP Body, Query parameters, URL encoding

### HTTP caching

### HTTP sessions (stateful vs. stateless)

### HTTP cookies

## Interact with HTTP

### The browser

### Specialized tools (Postman, Insomnia, etc)

### Command line tools (cURL, etc)

## HTTP in Java

## Practical content

### Install and configure cURL

### Interact with an API

#### Create a new entity

#### Get a entity

#### Update a entity

#### Delete a entity

### Use HTTP with Java

Talk about the different version of the HTTP client

### Go further

This is an optional section. Feel free to skip it if you do not have time.

- Try to use Insomnia instead of cURL to interact with the API!
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
