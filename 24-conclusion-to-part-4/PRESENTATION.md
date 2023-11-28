---
marp: true
---

<!--
theme: gaia
size: 16:9
paginate: true
author: L. Delafontaine and H. Louis, with the help of ChatGPT
title: 'HEIG-VD DAI Course - Conclusion to part 4: Network programming with HTTP'
description: 'Conclusion to part 4: Network programming with HTTP for the DAI course at HEIG-VD, Switzerland'
url: https://heig-vd-dai-course.github.io/heig-vd-dai-course/24-conclusion-to-part-4/
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
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/24-conclusion-to-part-4/
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/24-conclusion-to-part-4/24-conclusion-to-part-4-presentation.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[feedback]: https://framaforms.org/dai-2023-2024-feedback-4-1700494751
[feedback-qr-code]:
  https://quickchart.io/qr?format=png&ecLevel=Q&size=400&margin=1&text=https://framaforms.org/dai-2023-2024-feedback-4-1700494751
[illustration]:
  https://images.unsplash.com/photo-1519043916581-33ecfdba3b1c?fit=crop&h=720

# Conclusion to part 4: Network programming with HTTP

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

- How and why HTTP can be used to build web applications
  - Methods, status codes, headers, etc.
- How HTTP features can be used to build web infrastructures
  - Reverse proxies, load balancers, etc.

![bg right:40%](https://images.unsplash.com/photo-1549228581-cdbdb7430548?fit=crop&h=720)

## What have you accomplished?

- You have acquired and set up a server on the HEIG-VD network
- You have created a simple (REST) API to deploy on your server
- You have acquired and configured a domain name to use for yourself
- You have deployed your API on your server

![bg right:40%](https://images.unsplash.com/photo-1608613304810-2d4dd52511a2?fit=crop&h=720)

## You have closed the loop

<!-- _class: lead -->

With this final part, you have closed the loop of the course. You can be proud of
yourself!

## Evaluation

In order to validate this part of the course, you will have to pass an
evaluation. The questions will be in French and you can answer them in French or
English.

The evaluation will be in two parts:

1. A theoretical part (35 minutes)
2. A practical part (25 minutes)

A break of 10 minutes will be given between the two parts.

---

The following chapters will be evaluated:

- [HTTP and curl](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/21-http-and-curl)
- [Web infrastructure](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/22-web-infrastructures)

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
simple program using vanilla Java (`java` and `javac`). You will then send us
your code by email (old-school but it the easiest way).

You can use all the tools you want: your own IDE, ChatGPT, Copilot, the official
Java documentation, your old practical works, etc.

The statement will be on paper. You are not allowed to copy it in electronic
format to feed it to ChatGPT or Copilot.

### Resources

For both parts, no communication between students is allowed and external help
from a human is not allowed. You must do the work yourself.

Cheating is not allowed. If you are caught cheating, you will get a 1 for the
evaluation.

All previous evaluations are available in the
[`evaluation-and-exam-archives`](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/00-evaluation-and-exam-archives)
folder of the course repository.

## Questions

<!-- _class: lead -->

Do you have any questions?

## Feedback

Your feedback helps us know **what what you liked and what you disliked** in
your learning experience. **The feedback is anonymous**.

We would be very grateful if you could [take a few minutes to fill
it][feedback]. **Thank you!**

[![bg right w:75%][feedback-qr-code]][feedback]

## Sources

- Main illustration by [shawnanggg](https://unsplash.com/@shawnanggg) on
  [Unsplash](https://unsplash.com/photos/vdBE638sszE)
- Illustration by [Nils Stahl](https://unsplash.com/@nilsjakob) on
  [Unsplash](https://unsplash.com/photos/neUbjUnjXNk)
- Illustration by [Samantha Fortney](https://unsplash.com/@goldencoastgrams) on
  [Unsplash](https://unsplash.com/photos/OGDyzpsTjyA)
