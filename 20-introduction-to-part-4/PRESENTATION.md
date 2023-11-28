---
marp: true
---

<!--
theme: gaia
size: 16:9
paginate: true
author: L. Delafontaine and H. Louis, with the help of ChatGPT
title: 'HEIG-VD DAI Course - Introduction to part 4: Network programming with HTTP'
description: 'Introduction to part 4: Network programming with HTTP for the DAI course at HEIG-VD, Switzerland'
url: https://heig-vd-dai-course.github.io/heig-vd-dai-course/20-introduction-to-part-4/
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
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/20-introduction-to-part-4/
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/20-introduction-to-part-4/20-introduction-to-part-4-presentation.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[illustration]:
  https://images.unsplash.com/photo-1519043916581-33ecfdba3b1c?fit=crop&h=720

# Introduction to part 4: Network programming with HTTP

<!--
_class: lead
_paginate: false
-->

<https://github.com/heig-vd-dai-course>

[Web][web] · [PDF][pdf]

<small>L. Delafontaine and H. Louis, with the help of ChatGPT.</small>

<small>This work is licensed under the [CC BY-SA 4.0][license] license.</small>

![bg opacity:0.1][illustration]

## _Do you know how does streaming work?_

<!-- _class: lead -->

Do you remember this question from part 3?

## How does streaming work (simplified)?

The answer was:

> 1. A web browser connects to a service (YouTube, Twitch, etc.)
> 2. The service (a server) sends data to the client continuously
> 3. The client displays the data as it comes
> 4. If the bandwidth is bad, the client adapts the quality of the stream

## Up until now, you have mostly worked with low-level protocols such as TCP and UDP

<!-- _class: lead -->

These protocols are the foundation of the Internet and network communications.

Today, you will learn about a higher-level protocol: HTTP.

## What will you learn?

- Learn **how** and **why HTTP is used widely** to **build web applications**
- Learn how to use **HTTP in Java to build simple (REST) APIs**
- Learn how to **set up web infrastructure** to host web applications:
  - **Reverse proxy**
  - **Load balancer**

![bg right:40%](https://images.unsplash.com/photo-1434030216411-0b793f4b4173?fit=crop&h=720)

## What will you accomplish?

- Build a **simple (REST) API** in Java
- **Acquire**, **install** and **set up a server**
- **Acquire** a (free) **domain name**
- **Deploy** a web application on the server with a **reverse proxy**
- **Access** the web application from the **Internet**

![bg right:40%](https://images.unsplash.com/photo-1433878455169-4698e60005b1?fit=crop&h=720)

## Closing the loop

<!-- _class: lead -->

This part will be the last one of the course. This is the last step to close
the loop (from code to production).

## Sources

- Main illustration by [shawnanggg](https://unsplash.com/@shawnanggg) on
  [Unsplash](https://unsplash.com/photos/vdBE638sszE)
- Illustration by [Unseen Studio](https://unsplash.com/@craftedbygc) on
  [Unsplash](https://unsplash.com/photos/s9CC2SKySJM)
- Illustration by [Jared Erondu](https://unsplash.com/@erondu) on
  [Unsplash](https://unsplash.com/photos/j4PaE7E2_Ws)
