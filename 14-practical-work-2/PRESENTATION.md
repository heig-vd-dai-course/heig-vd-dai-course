---
marp: true
---

<!--
theme: gaia
size: 16:9
paginate: true
author: L. Delafontaine and H. Louis, with the help of ChatGPT
title: HEIG-VD DAI Course - Practical work 2
description: Practical work 2 for the DAI course at HEIG-VD, Switzerland
url: https://heig-vd-dai-course.github.io/heig-vd-dai-course/14-practical-work-2/
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
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/14-practical-work-2/
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/14-practical-work-2/14-practical-work-2-presentation.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/117
[illustration]:
  https://images.unsplash.com/photo-1610633389918-7d5b62977dc3?fit=crop&h=720
[practical-work]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/14-practical-work-2/COURSE_MATERIAL.md
[practical-work-qr-code]:
  https://quickchart.io/qr?format=png&ecLevel=Q&size=400&margin=1&text=https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/14-practical-work-2/COURSE_MATERIAL.md

# Practical work 2

<!--
_class: lead
_paginate: false
-->

<https://github.com/heig-vd-dai-course>

[Web][web] · [PDF][pdf]

<small>L. Delafontaine and H. Louis, with the help of ChatGPT.</small>

<small>This work is licensed under the [CC BY-SA 4.0][license] license.</small>

![bg opacity:0.1][illustration]

## Practical work 2

- A TCP network application with its own application protocol
- You can choose what the network application will do (you can be creative!)
  - a chat application, a chess game, a shopping list application, ...
- Groups of two students

![bg right:40%][illustration]

## Demo

Compile the project:

```sh
./mvnw clean package
```

Run the CLI without any arguments:

```sh
java -jar target/practical-work-2-demo-1.0-SNAPSHOT.jar
```

---

```text
Missing required subcommand
Usage: DaiFileTransfer [COMMAND]
A simple file transfer application
Commands:
  server  Start a TCP server to serve files
  client  Start a client to download files from a server
```

Start the server:

```sh
java -jar target/practical-work-2-demo-1.0-SNAPSHOT.jar server -p 12345 -t 4
```

Start the client:

```sh
java -jar target/practical-work-2-demo-1.0-SNAPSHOT.jar client -p 12345
```

---

Output:

```text
  _____          _____   _____           _                  _ 
 |  __ \   /\   |_   _| |  __ \         | |                | |
 | |  | | /  \    | |   | |__) | __ ___ | |_ ___   ___ ___ | |
 | |  | |/ /\ \   | |   |  ___/ '__/ _ \| __/ _ \ / __/ _ \| |
 | |__| / ____ \ _| |_  | |   | | | (_) | || (_) | (_| (_) | |
 |_____/_/    \_\_____| |_|   |_|  \___/ \__\___/ \___\___/|_|

You are connected to server on port 12345 with IP address localhost.

Available commands:
LS - list available files on server
GET <file> - get file from server
QUIT - quit the client

> 
```

---

List available files:

```text
> ls
Available files on server:
demo.txt
my-passwords-in-clear.txt
rzr-sc2.exe
```

Get one of the available files:

```text
> GET my-passwords-in-clear.txt
Downloading file from server...
File saved to my-passwords-in-clear.txt
```

---

Get a file that does not exist:

```text
> GET not-found.txt
The specified file was not found on the server.
```

Quit:

```text
> QUIT
Bye.
```

If a client tries to connect to the server when no thread is available, the
client has to wait to be served.

## Find the practical work

<!-- _class: lead -->

You can find the practical work for this part on [GitHub][practical-work].

[![bg right w:75%][practical-work-qr-code]][practical-work]

## Grades and feedback

Grades will be entered into GAPS, followed by an email with the feedback.

The evaluation will use exactly the same grading grid as shown in the course
material.

Each criterion will be accompanied by a comment explaining the points obtained,
a general comment on your work and the final grade.

If you have any questions about the evaluation, you can contact us!

## Finished? Was it easy? Was it hard?

Can you let us know what was easy and what was difficult for you during this
practical work?

This will help us to improve the course and adapt the content to your needs. If
we notice some difficulties, we will come back to you to help you.

➡️ [GitHub Discussions][discussions]

You can use reactions to express your opinion on a comment!

## Sources

- Main illustration by
  [Rafael Rex Felisilda](https://unsplash.com/@rafaelrex) on
  [Unsplash](https://unsplash.com/photos/chess-pieces-on-chess-board-rCxTJlaU5Yc)
