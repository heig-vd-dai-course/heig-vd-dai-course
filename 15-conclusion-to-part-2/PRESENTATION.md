---
marp: true
---

<!--
theme: gaia
size: 16:9
paginate: true
author: L. Delafontaine and H. Louis, with the help of ChatGPT
title: 'HEIG-VD DAI Course - Conclusion to part 2: Network programming with TCP'
description: 'Conclusion to part 2: Network programming with TCP for the DAI course at HEIG-VD, Switzerland'
url: https://heig-vd-dai-course.github.io/heig-vd-dai-course/15-conclusion-to-part-2/
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
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/15-conclusion-to-part-2/
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/15-conclusion-to-part-2/15-conclusion-to-part-2-presentation.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[feedback]:
  https://quickchart.io/qr?format=png&ecLevel=Q&size=400&margin=1&text=https://github.com/heig-vd-dai-course
[illustration]:
  https://images.unsplash.com/photo-1545987796-200677ee1011?fit=crop&h=720

# Conclusion to part 2: Network programming with TCP

<!--
_class: lead
_paginate: false
-->

<https://github.com/heig-vd-dai-course>

[Web][web] · [PDF][pdf]

<small>L. Delafontaine and H. Louis, with the help of ChatGPT.</small>

<small>This work is licensed under the [CC BY-SA 4.0][license] license.</small>

![bg opacity:0.1][illustration]

## What have you learned?

- How to read and define a protocol
- The basics of Docker and Docker Compose
- Network utilities to debug and test network programs (Telnet, dig, nslookup,
  SSH, SCP, etc.)
- The basics of network programming with TCP
- How close the sockets and files are

![bg right:40%](https://images.unsplash.com/photo-1549228581-cdbdb7430548?fit=crop&h=720)

## What have you accomplished?

- You have defined your own application protocol
- You have packaged and shared your own Docker image
- You have implemented a client/server TCP application in Java; an application
  that can communicate over the network!

![bg right:40%](https://images.unsplash.com/photo-1608613304810-2d4dd52511a2?fit=crop&h=720)

## Evaluation

In order to validate this part of the course, you will have to pass an
evaluation. The questions will be in French and you can answer them in French or
English as you wish.

The evaluation will be in two parts:

1. A theoretical part (35 minutes)
2. A practical part (25 minutes)

A break of 5 minutes will be given between the two parts.

---

For both parts, no communication between students is allowed and external help
from a human is not allowed. You must do the work yourself.

Cheating is not allowed. If you are caught cheating, you will get a 1 for the
evaluation.

All previous evaluations are available in the
[`00-evaluation-and-exam-archives`](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/00-evaluation-and-exam-archives)
folder of the course repository.

### Theoretical part

The evaluation will be done on paper. You might be asked questions about the
theoretical content, the practical content and elements seen in the practical
work.

You can only have access to your own notes in paper format. Your notes must fit
on one sheet of paper (recto). They can contain anything useful to you:
definitions, schemas, code snippets, etc. You will be able to use them during
the exam at the end of the semester.

All typical questions are at the end of each chapter you studied.

### Practical part

The evaluation will be done on the computer. You will be asked to create a
repository from one of our templates on GitHub, clone the repository locally,
implement a small program, push and share the results with us.

You can use all the tools you want: your own IDE, ChatGPT, Copilot, the official
Java documentation, your old practical works, etc.

The statement will be on paper. You are not allowed to copy it in electronic
format to feed it to ChatGPT or Copilot.

## Questions

<!-- _class: lead -->

Do you have any questions?

## Practical work review

The practical work review will start at the end of this presentation.

We only have **5 minutes per group**. Please be prepared to present your work.

The order of presentation is random and is stated in the next slides.

Do not worry, it is not an exam, it is just a way for us to see how you
understood the practical work. 🙂

---

| #   | Group |
| --- | ----- |
| 1   | TODO  |

## Feedback

Your feedback helps us know **what what you liked and what you disliked** in
your learning experience. **The feedback is anonymous**.

We would be very grateful if you could [take a few minutes to fill
it][feedback]. **Thank you!**

[![bg right w:75%][feedback]][feedback]

## Sources

- Main illustration by [Alina Grubnyak](https://unsplash.com/@alinnnaaaa) on
  [Unsplash](https://unsplash.com/photos/ZiQkhI7417A)
- Illustration by [Nils Stahl](https://unsplash.com/@nilsjakob) on
  [Unsplash](https://unsplash.com/photos/neUbjUnjXNk)
- Illustration by [Samantha Fortney](https://unsplash.com/@goldencoastgrams) on
  [Unsplash](https://unsplash.com/photos/OGDyzpsTjyA)
