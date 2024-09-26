---
marp: true
---

<!--
theme: gaia
size: 16:9
paginate: true
author: L. Delafontaine and H. Louis, with the help of GitHub Copilot
title: 'HEIG-VD DAI Course - Introduction to part 2: Network programming with TCP and UDP'
description: 'Introduction to part 2: Network programming with TCP and UDP for the DAI course at HEIG-VD, Switzerland'
url: https://heig-vd-dai-course.github.io/heig-vd-dai-course/10-introduction-to-part-2/
footer: '**HEIG-VD** - DAI Course 2024-2025 - CC BY-SA 4.0'
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
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/10-introduction-to-part-2/
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/10-introduction-to-part-2/10-introduction-to-part-2-presentation.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[illustration]:
  https://images.unsplash.com/photo-1545987796-200677ee1011?fit=crop&h=720

# Introduction to part 2: Network programming with TCP and UDP

<!--
_class: lead
_paginate: false
-->

<https://github.com/heig-vd-dai-course>

[Web][web] · [PDF][pdf]

<small>L. Delafontaine and H. Louis, with the help of GitHub Copilot.</small>

<small>This work is licensed under the [CC BY-SA 4.0][license] license.</small>

![bg opacity:0.1][illustration]

## _Do you know what happens when you browse the Web? How do you think it works?_

<!-- _class: lead -->

Do you remember this question from part 1?

---

The answer was:

> **What happens when you browse the Web**
>
> 1. You request a resource (e.g. a file) from a web server
> 2. The web server opens the file
> 3. The web server reads the file
> 4. The web server sends the file to you
> 5. Your web browser receives the file
> 6. Your web browser displays the file
>
> The whole process uses **input/output** (IO) operations!

## Do you know how does a web server work? How do you think it works?

<!-- _class: lead -->

## How does a web server work

1. A process is started on the server
2. This process opens a socket on a specific port
3. The process waits for a connection
4. A client (another process) connects to the server
5. The server and the client exchange data
6. The client or server closes the connection

The server and the client communicate over the network using a **network
protocol**, exchanging data the same way as **IOs** operations.

## What will you learn?

- What is an **application protocol**
- What is the **TCP** protocol
- What is the **UDP** protocol
- Learn the differences between **TCP** and **UDP**
- Manage multiple connections with **Java network concurrency**
- Learn about the **electronic messaging protocols**

![bg right:40%](https://images.unsplash.com/photo-1434030216411-0b793f4b4173?fit=crop&h=720)

## What will you accomplish?

- Define and implement a game called _"Guess the number"_ with **TCP**
- Define and implement an application called _"Temperature monitoring"_ with
  **UDP**
- Define, implement and share your own a network application

![bg right:40%](https://images.unsplash.com/photo-1433878455169-4698e60005b1?fit=crop&h=720)

## Sources

- Main illustration by [Alina Grubnyak](https://unsplash.com/@alinnnaaaa) on
  [Unsplash](https://unsplash.com/photos/ZiQkhI7417A)
- Illustration by [Unseen Studio](https://unsplash.com/@craftedbygc) on
  [Unsplash](https://unsplash.com/photos/s9CC2SKySJM)
- Illustration by [Jared Erondu](https://unsplash.com/@erondu) on
  [Unsplash](https://unsplash.com/photos/j4PaE7E2_Ws)
