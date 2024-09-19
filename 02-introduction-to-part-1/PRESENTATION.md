---
marp: true
---

<!--
theme: gaia
size: 16:9
paginate: true
author: L. Delafontaine and H. Louis, with the help of GitHub Copilot
title: 'HEIG-VD DAI Course - Introduction to part 1: Input/output processing'
description: 'Introduction to part 1: Input/output processing for the DAI course at HEIG-VD, Switzerland'
url: https://heig-vd-dai-course.github.io/heig-vd-dai-course/02-introduction-to-part-1/
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
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/02-introduction-to-part-1/
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/02-introduction-to-part-1/02-introduction-to-part-1-presentation.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[illustration]: ./images/main-illustration.jpg

# Introduction to part 1: Input/output processing

<!--
_class: lead
_paginate: false
-->

<https://github.com/heig-vd-dai-course>

[Web][web] · [PDF][pdf]

<small>L. Delafontaine and H. Louis, with the help of GitHub Copilot.</small>

<small>This work is licensed under the [CC BY-SA 4.0][license] license.</small>

![bg opacity:0.1][illustration]

## Do you know what happens when you browse the Web? How do you think it works?

<!-- _class: lead -->

## What happens when you browse the Web

1. You request a resource (e.g. a file) from a web server
2. The web server opens the file
3. The web server reads the file
4. The web server sends the file to you
5. Your web browser receives the file
6. Your web browser displays the file

The whole process uses **input/output** (IO) operations!

---

<!-- _class: lead -->

For network programming, you need to know how to do IOs.

But for this, you will need some tools and some knowledge.

## What will you learn?

- How to use Git, GitHub and Markdown (professionally)
- How to create a Java project with Maven and external dependencies
- How to use the Java IO API to read/write files with different formats and
  encodings
- How to run your Java application in a Docker container

![bg right:40%](https://images.unsplash.com/photo-1434030216411-0b793f4b4173?fit=crop&h=720)

## What will you accomplish?

- Have a presence on GitHub
- Use a professional Git workflow
- Collaborate with your team on GitHub
- Create a CLI to process files
- Display your work and skills on GitHub

![bg right:40%](https://images.unsplash.com/photo-1433878455169-4698e60005b1?fit=crop&h=720)

## Sources

- Main illustration by [Martin Adams](https://unsplash.com/@martinadams) on
  [Unsplash](https://unsplash.com/photos/a_PDPUPuNZ8)
- Illustration by [Unseen Studio](https://unsplash.com/@craftedbygc) on
  [Unsplash](https://unsplash.com/photos/s9CC2SKySJM)
- Illustration by [Jared Erondu](https://unsplash.com/@erondu) on
  [Unsplash](https://unsplash.com/photos/j4PaE7E2_Ws)
