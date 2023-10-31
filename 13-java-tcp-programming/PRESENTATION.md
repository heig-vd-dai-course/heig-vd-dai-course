---
marp: true
---

<!--
theme: gaia
size: 16:9
paginate: true
author: L. Delafontaine and H. Louis, with the help of ChatGPT
title: HEIG-VD DAI Course - Java TCP programming
description: Java TCP programming for the DAI course at HEIG-VD, Switzerland
url: https://heig-vd-dai-course.github.io/heig-vd-dai-course/13-java-tcp-programming/
footer: '**HEIG-VD** - DAI Course 2023-2024 - CC BY-SA 4.0'
style: |
    :root {
        --color-background: #fff;
        --color-foreground: #333;
        --color-highlight: #f96;
        --color-dimmed: #888;
        --color-headings: #7d8ca3;
    }
    blockquote {
        font-style: italic;
    }
    table {
        width: 100%;
    }
    th:first-child {
        width: 15%;
    }
    h1, h2, h3, h4, h5, h6 {
        color: var(--color-headings);
    }
    h2, h3, h4, h5, h6 {
        font-size: 1.5rem;
    }
    h1 a:link, h2 a:link, h3 a:link, h4 a:link, h5 a:link, h6 a:link {
        text-decoration: none;
    }
    section:not([class=lead]) > p, blockquote {
        text-align: justify;
    }
headingDivider: 4
-->

[web]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/13-java-tcp-programming/
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/13-java-tcp-programming/13-java-tcp-programming-presentation.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/116
[illustration]:
  https://images.unsplash.com/photo-1554960750-9468c5d9e239?fit=crop&h=720
[course-material]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/13-java-tcp-programming/COURSE_MATERIAL.md
[course-material-qr-code]:
  https://quickchart.io/qr?format=png&ecLevel=Q&size=400&margin=1&text=https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/13-java-tcp-programming/COURSE_MATERIAL.md

# Java TCP programming

<!--
_class: lead
_paginate: false
-->

<https://github.com/heig-vd-dai-course>

[Web][web] · [PDF][pdf]

<small>L. Delafontaine and H. Louis, with the help of ChatGPT.</small>

<small>Based on the original course by O. Liechti and J. Ehrensberger.</small>

<small>This work is licensed under the [CC BY-SA 4.0][license] license.</small>

![bg opacity:0.1][illustration]

## Objectives

- TODO

![bg right:40%](https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720)

## TCP

<!-- _class: lead -->

More details for this section in the
[course material](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/13-java-tcp-programming/COURSE_MATERIAL.md#tcp).
You can find other resources and alternatives as well.

### TCP

TCP is a transport protocol that is similar to a phone call.

- A connection is established between two parties
- Data sent is guaranteed to arrive in the same order
- Data can be sent again

![bg right contain](https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720)

## The Socket API

<!-- _class: lead -->

More details for this section in the
[course material](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/13-java-tcp-programming/COURSE_MATERIAL.md#the-socket-api).
You can find other resources and alternatives as well.

### The Socket API

- Originally developed by Berkeley University
- Ported to Java and many other languages
- Provides a simple API to use TCP and UDP
- A socket is a connection between two parties using a protocol and a port

![bg right contain](https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720)

### Client/server common functions

| Operation           | Description                        |
| ------------------- | ---------------------------------- |
| `socket()`          | Creates a new socket               |
| `getInputStream()`  | Gets the input stream of a socket  |
| `getOutputStream()` | Gets the output stream of a socket |
| `close()`           | Closes a socket                    |

### Client structure and functions

1. Create a `Socket`
2. Connect the socket to an IP address and a port number
3. Read and write data from/to the socket
4. Flush and close the socket

| Operation   | Description                                          |
| ----------- | ---------------------------------------------------- |
| `connect()` | Connects a socket to an IP address and a port number |

### Server structure and functions

1. Create a `ServerSocket`
2. Bind the socket to an IP address and a port number
3. Listen for incoming connections
4. Loop
   1. Accept an incoming connection - creates a new `Socket`
   2. Read and write data from/to the socket
   3. Flush and close the socket
5. Close the `ServerSocket`

---

| Operation  | Description                                       |
| ---------- | ------------------------------------------------- |
| `bind()`   | Binds a socket to an IP address and a port number |
| `listen()` | Listens for incoming connections                  |
| `accept()` | Accepts an incoming connection                    |

To make it simple, a socket is just like a file that you can open, read from,
write to and close. To exchange data, sockets on both sides must be connected.

## Processing data from streams

<!-- _class: lead -->

More details for this section in the
[course material](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/13-java-tcp-programming/COURSE_MATERIAL.md#processing-data-from-streams).
You can find other resources and alternatives as well.

### Processing data from streams

- Sockets use data streams to send and receive data, just like files
- Get an input stream to read data from a socket
- Get an output stream to write data to a socket

![bg right contain](https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720)

### Variable length data

Data sent can have a variable length. Manage this using one of the two methods:

- Use a delimiter
- Communicate a fixed length

This must be defined by your application protocol!

![bg right contain](https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720)

---

Using a delimiter:

```java
// End of transmission character
String EOT = "\u0004";

// Read data until the delimiter is found
String line;
while ((line = in.readLine()) != null && !line.equals(EOT)) {
  System.out.println(
    "[Client " + CLIENT_ID + "] response from server: " + line
  );
}
```

---

Communicating a fixed length:

```java
// Send the length of the data
out.write("DATA_LENGTH " + data.length() + "\n");

// Send the data
out.write(data);
```

## Handling one client at a time

<!-- _class: lead -->

More details for this section in the
[course material](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/13-java-tcp-programming/COURSE_MATERIAL.md#handling-one-client-at-a-tim).
You can find other resources and alternatives as well.

### Handling one client at a time

![bg right contain](https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720)

## Handling multiple clients at the same time

<!-- _class: lead -->

More details for this section in the
[course material](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/13-java-tcp-programming/COURSE_MATERIAL.md#handling-multiple-clients-at-the-same-time).
You can find other resources and alternatives as well.

### Handling multiple clients at the same time

![bg right contain](https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720)

### Multi-processing

![bg right contain](https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720)

### Multi-threading

![bg right contain](https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720)

### Asynchronous programming

![bg right contain](https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720)

## Practical content

<!-- _class: lead -->

### What will you do?

- Send an email using a SMTP client written in Java with the Socket API
- Run full client/server examples and understand how concurrent clients are
  handled

![bg right contain](./images/what-will-you-do-server.png)
![bg right vertical contain](./images/what-will-you-do-client.png)

### Find the practical content

<!-- _class: lead -->

You can find the practical content for this chapter on
[GitHub][course-material].

[![bg right w:75%][course-material-qr-code]][course-material]

## Finished? Was it easy? Was it hard?

Can you let us know what was easy and what was difficult for you during this
chapter?

This will help us to improve the course and adapt the content to your needs. If
we notice some difficulties, we will come back to you to help you.

➡️ [GitHub Discussions][discussions]

You can use reactions to express your opinion on a comment!

## What will you do next?

<!-- _class: lead -->

You will start the practical work!

## Sources

- Main illustration by [Carl Nenzen Loven](https://unsplash.com/@archduk3) on
  [Unsplash](https://unsplash.com/photos/N8GdKC4Rcvs)
- Illustration by [Aline de Nadai](https://unsplash.com/@alinedenadai) on
  [Unsplash](https://unsplash.com/photos/j6brni7fpvs)
