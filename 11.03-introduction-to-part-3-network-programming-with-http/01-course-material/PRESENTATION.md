---
marp: true
---

<!--
theme: custom-marp-theme
size: 16:9
paginate: true
author: L. Delafontaine and H. Louis, with the help of GitHub Copilot
title: 'HEIG-VD DAI Course - Introduction to part 3: Network programming with HTTP'
description: 'Introduction to part 3: Network programming with HTTP for the DAI course at HEIG-VD, Switzerland'
footer: '[**HEIG-VD**](https://heig-vd.ch) - [DAI Course 2025-2026](https://github.com/heig-vd-dai-course) - [CC BY-SA 4.0](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md)'
headingDivider: 6
-->

[web]:
	https://heig-vd-dai-course.github.io/heig-vd-dai-course/19-introduction-to-part-3/
[pdf]:
	https://heig-vd-dai-course.github.io/heig-vd-dai-course/19-introduction-to-part-3/19-introduction-to-part-3-presentation.pdf
[license]:
	https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[illustration]: ./images/main-illustration.jpg

# Introduction to part 3: Network programming with HTTP

<!--
_class: lead
_paginate: false
-->

<https://github.com/heig-vd-dai-course>

[Web][web] · [PDF][pdf]

<small>L. Delafontaine and H. Louis, with the help of GitHub Copilot.</small>

<small>This work is licensed under the [CC BY-SA 4.0][license] license.</small>

![bg opacity:0.1][illustration]

## Up until now, you have mostly worked with low-level protocols such as TCP and UDP

<!-- _class: lead -->

These protocols are the foundation of the Internet and network communications.

Today, you will learn about a higher-level protocol: HTTP.

## What will you learn?

- Learn **how** and **why HTTP is used widely** to **build web applications**
- Learn how to use **HTTP in Java** to build simple (CRUD) **APIs**
- Learn how to **set up a web infrastructure** to host web applications:
  - **Reverse proxy**
  - **Load balancer**

![bg right:40%](https://images.unsplash.com/photo-1434030216411-0b793f4b4173?fit=crop&h=720)

## What will you accomplish?

- Build **a simple web API** in Java
- **Acquire**, **configure** and **set up a server**
- **Acquire** a (free) **domain name**
- **Deploy** a web application on the server with a **reverse proxy**
- **Access** the web application from the **Internet**

![bg right:40%](https://images.unsplash.com/photo-1433878455169-4698e60005b1?fit=crop&h=720)

## Closing the loop

<!-- _class: lead -->

This part will be the last one of the course. This is the last step to close the
loop (from code to production).

## Sources

- Main illustration by [shawnanggg](https://unsplash.com/@shawnanggg) on
  [Unsplash](https://unsplash.com/photos/vdBE638sszE)
- Illustration by [Unseen Studio](https://unsplash.com/@craftedbygc) on
  [Unsplash](https://unsplash.com/photos/s9CC2SKySJM)
- Illustration by [Jared Erondu](https://unsplash.com/@erondu) on
  [Unsplash](https://unsplash.com/photos/j4PaE7E2_Ws)
