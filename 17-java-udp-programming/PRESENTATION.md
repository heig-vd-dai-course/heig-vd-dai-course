---
marp: true
---

<!--
theme: gaia
size: 16:9
paginate: true
author: L. Delafontaine and H. Louis, with the help of ChatGPT
title: HEIG-VD DAI Course - Java UDP programming
description: Java UDP programming for the DAI course at HEIG-VD, Switzerland
url: https://heig-vd-dai-course.github.io/heig-vd-dai-course/17-java-udp-programming/
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
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/17-java-udp-programming/
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/17-java-udp-programming/17-java-udp-programming-presentation.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/120
[illustration]:
  https://images.unsplash.com/photo-1578054041218-5ee0003926dd?fit=crop&h=720
[course-material]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/17-java-udp-programming/COURSE_MATERIAL.md
[course-material-qr-code]:
  https://quickchart.io/qr?format=png&ecLevel=Q&size=400&margin=1&text=https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/17-java-udp-programming/COURSE_MATERIAL.md

# Java UDP programming

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

- Learn the differences between TCP and UDP
- Learn what an UDP datagram is
- Learn the different ways to send a UDP datagram to one or multiple clients
- How UDP can be used for service discovery

![bg right:40%](https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720)

## UDP

<!-- _class: lead -->

More details for this section in the
[course material](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/17-java-udp-programming/COURSE_MATERIAL.md#udp).
You can find other resources and alternatives as well.

### UDP

TODO

## Differences between TCP and UDP

<!-- _class: lead -->

More details for this section in the
[course material](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/17-java-udp-programming/COURSE_MATERIAL.md#differences-between-tcp-and-udp).
You can find other resources and alternatives as well.

### Differences between TCP and UDP

TODO

## UDP datagrams

<!-- _class: lead -->

More details for this section in the
[course material](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/17-java-udp-programming/COURSE_MATERIAL.md#udp-datagrams).
You can find other resources and alternatives as well.

### UDP datagrams

## Reliability

<!-- _class: lead -->

More details for this section in the
[course material](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/17-java-udp-programming/COURSE_MATERIAL.md#reliability).
You can find other resources and alternatives as well.

### Reliability

TODO

## UDP in the Socket API

<!-- _class: lead -->

More details for this section in the
[course material](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/17-java-udp-programming/COURSE_MATERIAL.md#udp-in-the-socket-api).
You can find other resources and alternatives as well.

### UDP in the Socket API

TODO

## Unicast, multicast and broadcast

<!-- _class: lead -->

More details for this section in the
[course material](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/17-java-udp-programming/COURSE_MATERIAL.md#unicast-multicast-and-broadcast).
You can find other resources and alternatives as well.

### Unicast, multicast and broadcast

TODO

### Unicast

TODO

### Multicast

TODO

### Broadcast

TODO

## Messaging patterns

<!-- _class: lead -->

More details for this section in the
[course material](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/17-java-udp-programming/COURSE_MATERIAL.md#messaging-patterns).
You can find other resources and alternatives as well.

### Messaging patterns

TODO

### Fire-and-forget

TODO

### Request-response

TODO

## Service discovery protocols

<!-- _class: lead -->

More details for this section in the
[course material](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/17-java-udp-programming/COURSE_MATERIAL.md#service-discovery-protocols).
You can find other resources and alternatives as well.

### Service discovery protocols

TODO

## Practical content

<!-- _class: lead -->

### What will you do?

- Run a complete emitter/receiver UDP example in Java
- Dockerize the emitter/receiver UDP example
- Isolate some containers in a dedicated Docker network

![bg right contain](./images/what-will-you-do-server.png)

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

- Main illustration by
  [Possessed Photography](https://unsplash.com/@possessedphotography) on
  [Unsplash](https://unsplash.com/photos/tiNCpHudGrw)
- Illustration by [Aline de Nadai](https://unsplash.com/@alinedenadai) on
  [Unsplash](https://unsplash.com/photos/j6brni7fpvs)
