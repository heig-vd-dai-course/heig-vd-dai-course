---
marp: true
---

<!--
theme: custom-marp-theme
size: 16:9
paginate: true
author: L. Delafontaine and H. Louis, with the help of GitHub Copilot
title: HEIG-VD DAI - Java UDP programming
description: Java UDP programming for the DAI course at HEIG-VD, Switzerland
footer: '[**HEIG-VD**](https://heig-vd.ch) - [DAI 2025-2026](https://github.com/heig-vd-dai-course/heig-vd-dai-course) - [CC BY-SA 4.0](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md)'
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
        width: 50%;
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
headingDivider: 6
-->

[web]:
	https://heig-vd-dai-course.github.io/heig-vd-dai-course/13-java-udp-programming/
[pdf]:
	https://heig-vd-dai-course.github.io/heig-vd-dai-course/13-java-udp-programming/13-java-udp-programming-presentation.pdf
[license]:
	https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/120
[illustration]: ./images/main-illustration.jpg
[course-material]:
	https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/13-java-udp-programming/COURSE_MATERIAL.md
[course-material-qr-code]:
	https://quickchart.io/qr?format=png&ecLevel=Q&size=400&margin=1&text=https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/13-java-udp-programming/COURSE_MATERIAL.md

# Java UDP programming

<!--
_class: lead
_paginate: false
-->

<https://github.com/heig-vd-dai-course>

[Web][web] · [PDF][pdf]

<small>L. Delafontaine and H. Louis, with the help of
[GitHub Copilot](https://github.com/features/copilot).</small>

<small>Based on the original course by O. Liechti and J. Ehrensberger.</small>

<small>This work is licensed under the [CC BY-SA 4.0][license] license.</small>

![bg opacity:0.1][illustration]

## Objectives

- Learn the differences between TCP and UDP and reliability
- Learn what an UDP datagram is
- Learn the different ways to send a UDP datagram to one or multiple clients
- Learn UDP in the Socket API
- How UDP can be used for service discovery

![bg right:40%](https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720)

## Explore the code examples

<!-- _class: lead -->

More details for this section in the [course material][course-material]. You can
find other resources and alternatives as well.

### Explore the code examples

Individually, or in pair/group, **take 10 minutes to explore and discuss the
[code examples](https://github.com/heig-vd-dai-course/heig-vd-dai-course-code-examples)**.

Answer the questions available in the course material:

- How do the code examples work?
- What are the main takeaways of the code examples?
- What are the main differences between the code examples?

If needed, use the theoretical content to help you.

## UDP

<!-- _class: lead -->

More details for this section in the [course material][course-material]. You can
find other resources and alternatives as well.

### UDP

- A transport layer protocol just like TCP
- Connectionless protocol - does not require to establish a connection before
  sending data
- Unreliable protocol - does not guarantee delivery but is fast
- Analogy: sending postcards through the postal service

![bg right:40%](https://images.unsplash.com/photo-1607057937337-e1a1c4e869d9?fit=crop&h=720)

## Differences between TCP and UDP

<!-- _class: lead -->

More details for this section in the [course material][course-material]. You can
find other resources and alternatives as well.

### Differences between TCP and UDP

- TCP
  - Connection-oriented
  - Reliable
  - Stream protocol
  - Unicast
  - Request-response
  - Used for FTP, HTTP, SMTP, SSH, etc.

---

- UDP
  - Connectionless
  - Unreliable
  - Datagram protocol
  - Unicast, broadcast and multicast
  - Fire-and-forget, request-response (manual)
  - Service discovery protocols
  - Used for DNS, streaming, gaming, etc.

## UDP datagrams

<!-- _class: lead -->

More details for this section in the [course material][course-material]. You can
find other resources and alternatives as well.

### UDP datagrams

- Datagrams = discrete chunks of data (packets) sent over the network
- Sent individually and independently
- Contain a header (source and destination ports, length, checksum, etc.) and a
  payload (data)

![bg right contain](./images/udp-datagrams.png)

## Reliability

<!-- _class: lead -->

More details for this section in the [course material][course-material]. You can
find other resources and alternatives as well.

### Reliability

- UDP is unreliable (no guarantee of delivery, no guarantee of order)
- The application must implement its own reliability mechanism
- In some cases, reliability is not needed (e.g. streaming)
- Handling reliability is complex - not covered in this course

![bg right:40%](https://images.unsplash.com/photo-1582782657732-e7d7c08dcadd?fit=crop&h=720)

## UDP in the Socket API

<!-- _class: lead -->

More details for this section in the [course material][course-material]. You can
find other resources and alternatives as well.

### UDP in the Socket API

- `DatagramSocket` is used to send and receive datagrams
- A datagram is created with the `DatagramPacket` class
- A multicast socket is created with the `MulticastSocket` class.

![bg right contain](./images/datagram-socket.png)

## Unicast, broadcast and multicast

<!-- _class: lead -->

More details for this section in the [course material][course-material]. You can
find other resources and alternatives as well.

### Unicast, broadcast and multicast

- Unicast, broadcast and multicast are ways to send data over the network
- TCP is unicast only
- UDP can be unicast, broadcast or multicast

![bg right:40%](https://images.unsplash.com/photo-1542783863-dbe5c9693402?fit=crop&h=720)

### Unicast

- One-to-one communication
- One sender and one receiver
- To send a datagram, the sender must know:
  - The IP address of the receiver
  - The port of the receiver

Think of it as a private conversation between two people

![bg right:40% contain](https://upload.wikimedia.org/wikipedia/commons/7/75/Unicast.svg)

### Broadcast

- One-to-all communication
- One sender and multiple receivers
- To send a datagram, the sender must know:
  - The subnet
  - The port
- `255.255.255.255` for all hosts

Think of it as a public announcement.

![bg right:40% contain](https://upload.wikimedia.org/wikipedia/commons/d/dc/Broadcast.svg)

### Multicast

- One-to-many communication
- One sender and some receivers
- To send a datagram, the sender must know:
  - The multicast address (between `239.0.0.0` and `239.255.255.255`)
  - The port

Think of it as a group conversation.

![bg right:40% contain](https://upload.wikimedia.org/wikipedia/commons/3/30/Multicast.svg)

---

- Just as with broadcast, it can be blocked by routers
- Multicast is quite guaranteed **not** to work on the public Internet
- Made for the local network
- Multicast is a complex topic
- Not covered in depth in this course
- The course material contains some resources

![bg right w:90%](./images/multicast-meme.jpg)

## Messaging patterns

<!-- _class: lead -->

More details for this section in the [course material][course-material]. You can
find other resources and alternatives as well.

### Messaging patterns

- Fire-and-forget
  - One-way communication
  - No response
  - No guarantee of delivery
- Request-response
  - Two-way communication
  - Response
  - Guarantee of delivery (manual)

![bg right:40%](https://images.unsplash.com/photo-1533219057257-4bb9ed5d2cc6?fit=crop&h=720)

## Service discovery protocols

<!-- _class: lead -->

More details for this section in the [course material][course-material]. You can
find other resources and alternatives as well.

### Service discovery protocols

- Discover services on the network
- Two types of protocols
- Service discovery protocol patterns:
  - Advertisement (passive)
  - Query (active)

![bg right:40%](https://images.unsplash.com/photo-1531306728370-e2ebd9d7bb99?fit=crop&h=720)

---

![bg h:80%](./images/service-discovery-protocols-advertisement.png)

---

![bg h:80%](./images/service-discovery-protocols-query.png)

## Questions

<!-- _class: lead -->

Do you have any questions?

## Practical content

<!-- _class: lead -->

### What will you do?

- Update your application protocol with the new knowledge you gained
- Learn to use the debugger
- Execute the code examples and run multiple emitters at the same time
- Explore the Java UDP programming template
- Implement the _"Temperature monitoring"_ application (optional)

![bg right:40% contain](./images/TODO.png)

### Now it's your turn!

- Read the course material.
- Do the practical content.
- Ask questions if you have any.

➡️ [Find the course on GitHub][course].

**Do not hesitate to help each other! There's no need to rush!**

![bg right w:75%][course-qr-code]

## Finished? Was it easy? Was it hard?

Can you let us know what was easy and what was difficult for you during this
chapter?

This will help us to improve the course and adapt the content to your needs. If
we notice some difficulties, we will come back to you to help you.

➡️ [GitHub Discussions][discussions]

You can use reactions to express your opinion on a comment!

## Sources

- Main illustration by
  [Possessed Photography](https://unsplash.com/@possessedphotography) on
  [Unsplash](https://unsplash.com/photos/tiNCpHudGrw)
- Illustration by [Aline de Nadai](https://unsplash.com/@alinedenadai) on
  [Unsplash](https://unsplash.com/photos/j6brni7fpvs)
- Illustration by [Becky Phan](https://unsplash.com/@beckyphan) on
  [Unsplash](https://unsplash.com/photos/white-and-brown-wooden-photo-frame-qWsVgxgo1-E)
- Illustration by [Jackson Simmer](https://unsplash.com/@simmerdownjpg) on
  [Unsplash](https://unsplash.com/photos/blue-green-and-red-plastic-clothes-pin-Vqg809B-SrE)
- Illustration by [Sam Dan Truong](https://unsplash.com/@sam_truong) on
  [Unsplash](https://unsplash.com/photos/grey-metal-tower-during-daytime-ctngce7sr_Y)
- Illustration by [Zuza Gałczyńska](https://unsplash.com/@zgalczynska) on
  [Unsplash](https://unsplash.com/photos/group-of-people-watching-fireworks-display-c5_eQi4rrjA)
- Illustration by [Andy Holmes](https://unsplash.com/@andyjh07) on
  [Unsplash](https://unsplash.com/photos/milky-way-during-night-time-LUpDjlJv4_c)
- Illustration by [Brent Olson](https://unsplash.com/@helixgames) on
  [Unsplash](https://unsplash.com/photos/person-in-green-and-black-shorts-riding-on-black-and-red-bicycle-_aV5y0nLNew)
