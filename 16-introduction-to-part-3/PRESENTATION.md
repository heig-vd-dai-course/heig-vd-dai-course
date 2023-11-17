---
marp: true
---

<!--
theme: gaia
size: 16:9
paginate: true
author: L. Delafontaine and H. Louis, with the help of ChatGPT
title: 'HEIG-VD DAI Course - Introduction to part 3: Network programming with UDP'
description: 'Introduction to part 3: Network programming with UDP for the DAI course at HEIG-VD, Switzerland'
url: https://heig-vd-dai-course.github.io/heig-vd-dai-course/16-introduction-to-part-3/
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
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/16-introduction-to-part-3/
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/16-introduction-to-part-3/16-introduction-to-part-3-presentation.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[illustration]:
  https://images.unsplash.com/photo-1631220706319-657942774d02?fit=crop&h=720

# Introduction to part 3: Network programming with UDP

<!--
_class: lead
_paginate: false
-->

<https://github.com/heig-vd-dai-course>

[Web][web] · [PDF][pdf]

<small>L. Delafontaine and H. Louis, with the help of ChatGPT.</small>

<small>This work is licensed under the [CC BY-SA 4.0][license] license.</small>

![bg opacity:0.1][illustration]

## _Do you know how does a web server work?_

<!-- _class: lead -->

Do you remember this question from part 2?

## What happens when you browse the Web?

The answer was:

> 1. A process is started on the server
> 2. This process opens a socket on a specific port
> 3. The process waits for a connection
> 4. A client (another process) connects to the server
> 5. The server and the client exchange data
> 6. The client or server closes the connection

## Do you know how does streaming work?

<!-- _class: lead -->

## How does streaming work (simplified)

1. A web browser connects to a service (YouTube, Twitch, etc.)
2. The service (a server) sends data to the client continuously
3. The client displays the data as it comes
4. If the bandwidth is bad, the client adapts the quality of the stream

To optimize the bandwidth, the server certainly uses UDP instead of TCP as it is
more efficient.

UDP is a protocol used in streaming, gaming, VoIP, etc. It is more efficient
than TCP but less reliable as you will see in this part.

## What will you learn?

- Learn how to use of the **UDP protocol** to:
  - **Send** and **receive** data
  - **Broadcast** messages to **multiple clients**
  - Find services on the network with **service discovery patterns**
- How to **Dockerize** a Java application

![bg right:40%](https://images.unsplash.com/photo-1434030216411-0b793f4b4173?fit=crop&h=720)

## What will you accomplish?

- Create a network application using the **UDP** protocol (with its own
  **application protocol**)
- **Build** and **share** your application **with Docker and Docker Compose**
- Again, sharing your work on GitHub (it's becoming a habit!)

![bg right:40%](https://images.unsplash.com/photo-1433878455169-4698e60005b1?fit=crop&h=720)

## Sources

- Main illustration by [Allie Reefer](https://unsplash.com/@thepghtraveler) on
  [Unsplash](https://unsplash.com/photos/rAoQn6kwv64)
- Illustration by [Unseen Studio](https://unsplash.com/@craftedbygc) on
  [Unsplash](https://unsplash.com/photos/s9CC2SKySJM)
- Illustration by [Jared Erondu](https://unsplash.com/@erondu) on
  [Unsplash](https://unsplash.com/photos/j4PaE7E2_Ws)
