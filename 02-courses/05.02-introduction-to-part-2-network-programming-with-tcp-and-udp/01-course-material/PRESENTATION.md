---
marp: true
---

<!--
theme: custom-marp-theme
size: 16:9
paginate: true
author: L. Delafontaine and H. Louis, with the help of GitHub Copilot
title: 'HEIG-VD DAI - Introduction to part 2: Network programming with TCP and UDP'
description: 'Introduction to part 2: Network programming with TCP and UDP for the DAI course at HEIG-VD, Switzerland'
header: '[**Introduction to part 2: Network programming with TCP and UDP**](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/05.02-introduction-to-part-2-network-programming-with-tcp-and-udp)'
footer: '[**HEIG-VD**](https://heig-vd.ch) - [DAI 2025-2026](https://github.com/heig-vd-dai-course/heig-vd-dai-course) - [CC BY-SA 4.0](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md)'
headingDivider: 6
-->

# Introduction to part 2: Network programming with TCP and UDP

<!--
_class: lead
_paginate: false
-->

[Link to the course][course]

<small>L. Delafontaine and H. Louis, with the help of
[GitHub Copilot](https://github.com/features/copilot).</small>

<small>This work is licensed under the [CC BY-SA 4.0][license] license.</small>

![bg opacity:0.1][illustration]

## _Do you know what happens when you browse the Web? How do you think it works?_

<!-- _class: lead -->

Do you remember this question from part 1?

---

The answer was:

> **What happens when you browse the Web**
>
> 1. You request a resource (e.g. a file) from a web server.
> 2. The web server opens the file.
> 3. The web server reads the file.
> 4. The web server sends the file to you.
> 5. Your web browser receives the file.
> 6. Your web browser displays the file.
>
> **The whole process uses input/output (IO) operations!**

## Do you know how does a web server work? How do you think it works?

<!-- _class: lead -->

## How does a web server work

1. A process is started on the server.
2. This process opens a socket on a specific port.
3. The process waits for a connection.
4. A client (another process) connects to the server.
5. The server and the client exchange data.
6. The client or server closes the connection.

The server and the client communicate over the network using a **network
protocol**, exchanging data the same way as **IOs** operations.

## What will you learn?

- Learn about the **electronic messaging protocols**.
- What is an **application protocol**.
- What is the **TCP** protocol.
- What is the **UDP** protocol.
- Learn the differences between **TCP** and **UDP**.
- Manage multiple connections with **Java network concurrency**.

![bg right:40%](https://images.unsplash.com/photo-1434030216411-0b793f4b4173?fit=crop&h=720)

## What will you accomplish?

- Define and implement a game called _"Guess the number"_ with **TCP**.
- Define and implement an application called _"Temperature monitoring"_ with
  **UDP**.
- Define, implement and share your own network application.

![bg right:40%](https://images.unsplash.com/photo-1433878455169-4698e60005b1?fit=crop&h=720)

## Sources

- Main illustration by [Alina Grubnyak](https://unsplash.com/@alinnnaaaa) on
  [Unsplash](https://unsplash.com/photos/ZiQkhI7417A)
- Illustration by [Unseen Studio](https://unsplash.com/@craftedbygc) on
  [Unsplash](https://unsplash.com/photos/s9CC2SKySJM)
- Illustration by [Jared Erondu](https://unsplash.com/@erondu) on
  [Unsplash](https://unsplash.com/photos/j4PaE7E2_Ws)

[course]:
	https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/05.02-introduction-to-part-2-network-programming-with-tcp-and-udp
[license]:
	https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[illustration]: ./images/main-illustration.jpg
