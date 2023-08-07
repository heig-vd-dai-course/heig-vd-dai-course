---
marp: true
---

<!--
theme: gaia
size: 16:9
paginate: true
author: L. Delafontaine, J. Ehrensberger and H. Louis with the help of Copilot
title: HEIG-VD DAI Course - Introduction and course organization
description: Introduction and course organization for the DAI course at HEIG-VD, Switzerland
url: https://heig-vd-dai-course.github.io/heig-vd-dai-course/01-introduction-and-course-organization/
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

[readme]: https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/01-introduction-and-course-organization/README.md
[web]: https://heig-vd-dai-course.github.io/heig-vd-dai-course/01-introduction-and-course-organization/
[pdf]: https://heig-vd-dai-course.github.io/heig-vd-dai-course/01-introduction-and-course-organization/01-introduction-and-course-organization.pdf
[video]: #

# Introduction and course organization

<!--
_class: lead
_paginate: false
-->

<https://github.com/heig-vd-dai-course>

[README][readme] | [Slides (web)][web] | [Slides (pdf)][pdf] | [Video (in French)][video]

<small>L. Delafontaine, J. Ehrensberger and H. Louis with the help of Copilot</small>

![bg opacity:0.1](https://images.unsplash.com/photo-1451187580459-43490279c0fa?fit=crop&w=720&q=80)

## Agenda

- **Background**
    - [Who are we?](#who-are-we)
    - [What do we do at the HEIG-VD and why](#what-do-we-do-at-the-heig-vd-and-why)
- **Course objectives and organization**
    - [What to expect to learn from this course](#what-to-expect-to-learn-from-this-course)
    - [Where to find the course material](#where-to-find-the-course-material)
    - [Communication channels](#communication-channels)
    - [Evaluation](#evaluation)

## Who are we?

<!-- _class: lead -->

### Ludovic Delafontaine

I work at HEIG-VD as an applied research and development engineer since 2020. Here is my background:

- 2006: Worms 4 Mayhem (modding)
- 2011-2015: ETML (CFC + MPTi)
- 2015-2019: HEIG-VD (BSc)
- 2020-now: HEIG-VD (aR&D)
- 2022-now: Artios (own company)

![bg right:40%](./images/worms-4-mayhem-pc-boxart.jpg)

#### Expertise

- Software engineering
- System administration
- Cloud computing
- DevOps/MLOps
- Best/proven practices (reviewing, testing, CI/CD, workflows, etc.)
- Startup projects (idea, business model, MVP, etc.)

GitLab: [@ludelafo](https://gitlab.com/ludelafo)  
GitHub: [@ludelafo](https://github.com/ludelafo)

### Juergen Ehrensberger

TODO

### Hadrien Louis

TODO

![bg right:40%](https://picsum.photos/720?image=3)

## What do we do at the HEIG-VD and why

TODO

## What to expect to learn from this course

<!-- _class: lead -->

### What does GAPS say

Taken from the "[Fiche d'unité d'enseignement](https://gaps.heig-vd.ch/consultation/fiches/uv/uv.php?id=6573)" of the course :

> **Programmation réseau**
>
>   - être capable de concevoir une application client-serveur ;
>   - être capable d'implémenter un client et un serveur en utilisant la Socket API dans différents langages ;

---

> **Protocole HTTP**
>
>   - connaître les concepts principaux du protocole ;
>   - être capable de concevoir et réaliser une infrastructure HTTP avec un reverse proxy et plusieurs serveurs ;
>   - être capable d'implémenter le protocole en utilisant la Socket API ;

---

> **Protocoles de messagerie**
>
>   - connaître les principaux protocoles relatifs à la messagerie électronique ;
>   - être capable d'implémenter un client de messagerie simple ;

> **Protocoles de transfert de fichiers et d'accès à distance**
>
>   - connaître les protocoles de transfert de fichiers et d'accès à distance, ainsi que leurs principales utilisations (y compris tunneling/forwarding).

### Topics

You will learn the following topics during this course:

- Inputs/outputs and encoding
- Network programming (TCP and UDP)
- Application-level protocols (SMTP, HTTP and SSH)
- Web infrastructures (reverse proxy, load balancer, sticky sessions)
- How to read and write technical documentation
- An introduction to unit testing and dependencies management

### Technologies

You will learn the following technologies during this course:

- Git and GitHub
- Markdown
- Java for network programming
- Docker & Docker Compose
- Network utilities (`curl`, `dig`, `nslookup`, etc.)
- The terminal :heart:

## Our wishes for this course

<!-- _class: lead -->

### What we want this course to be

- A place to learn
- A place to experiment
- A place to share
- A place to have fun
- A place where you help each other
- A place where you do not loose your time (efficient and useful)

### What we don't want this course to be

- A place you don't want to come
- A place you don't feel comfortable/safe
- A place where you can't ask questions
- A place where you can't take anything away
- If you have a problem with the course, we will do my best to fix it.

We will not take presences during this course. If you are done, you are free to go but we would appreciate if you try to help your classmates instead!

## Where to find the course material

**Everything** will be on the GitHub organization created for this course: <https://github.com/heig-vd-dai-course>.

More specifically, the course material is available in the [`heig-vd-dai-course`](https://github.com/heig-vd-dai-course/heig-vd-dai-course) Git repository.

We will not use Microsoft Teams nor CyberLearn. We want to keep it simple and efficient for you, and for us. One place to find it all.

_PS: We accept issues and pull requests if you spot anything weird! :slightly_smiling_face:_

## Communication channels

Feel free to use any of these communication channels for any kind of questions related to the course:

- GitHub Discussions (you will experiment these very soon)
- In person
- Email
    - [ludovic.delafontaine@heig-vd.ch](mailto:ludovic.delafontaine@heig-vd.ch)
    - [juergen.ehrensberger@heig-vd.ch](mailto:juergen.ehrensberger@heig-vd.ch)
    - [hadrien.louis@heig-vd.ch](mailto:hadrien.louis@heig-vd.ch)

## Course planning - [Calendrier académique](https://heig-vd.ch/formation/bachelor/calendrier-academique/)

64 periods are planned for this course, divided in 4 main chapters:

- Chapter 1 - A CLI to process files (15 periods)
- Chapter 2 - First network application (18 periods)
- Chapter 3 - Second network application (16 periods)
- Chapter 4 - Web infrastructures (12 periods)

The entire course planning for the semester is available at <https://github.com/orgs/heig-vd-dai-course/projects>.

## Course sequence

1. Theoretical content you acquire on your own, at your own pace
    - A set of slides/READMEs or videos for you to read/watch
2. Practical content where you do stuff (:exploding_head:)
    - You will be able to experiment the theoretical content
3. Practical work
    - Bigger work to get deeper into the subject
4. Feedback and discussions (few minutes - very important to us)
    - You will be able to give feedback and share your experience

## Evaluation

- 4 practical works (20%) - done in groups of 2 students
- 2 evaluations (30%) - done individually
- 1 exam (50%) - done individually

`final grade = average of evaluation grades * 0.3 + average of practical work grades * 0.2 + average of exam * 0.5`

You can change groups between practical works. You will have access to the grading criteria. You will have to present each practical work to the teaching staff for a total of 5-10 minutes. 

---

You can be asked to answer questions regarding the theoretical content as well as the practical content of the slides/READMEs/videos during the practical work review or the evaluations. Both aspects are complementary and important.

We will try my best to give you your grades and feedback as quickly as possible so you can improve for the next work.

We can be flexible on the deadlines if you have a good reason. Please let us know as soon as possible if you have any difficulties.

If you have trouble with your group, please let us know as soon as possible. we will do my best to help you.

## Responsibilities and expectations

- The teaching staff responsibilities:
    - You have acquired the necessary knowledge of this course
    - You are prepared for the professional world
    - You are able to work in a team
    - You are able to work on your own
- Your responsibilities: you are responsible for your own learning. If you have any questions, ask them. If you have any difficulties, let us know. If you have any suggestions, share them.

## _"A course in English..? Why This Fantasy?"_

All the written material will be in English. The teaching staff will speak in French.

This is meant to prepare you for the future. Our field is mostly made in English so this is a great opportunity to practice your English skills.

Evaluations will be in English as well but you can answer the questions in French if you prefer.

If you have any difficulties with English, please let us know.

## _"What about ChatGPT, Copilot, etc.?"_

You can use all the tools you want (personal notes, Internet, ChatGPT, Copilot, etc.), even during evaluations. My statement is that you will be able to use these in the real world, so better learn how to use them now. However, they are here to help you, not to do the work for you:

- You must be able to explain what you did and why you did it
- You must state it when you used external help (tools and sources)
- You must be able to do the work on your own. These tools come and go ($$$, end of life, etc.), you should not entirely rely on them. 

## _"Linux, macOS or Windows?"_

The HEIG-VD recommends Windows for your studies. This is mostly because other departments heavily rely on Windows-only products. From my experience, developing on Windows can be more difficult than Linux or macOS.

Linux and macOS are much more supported in the software development world. If you can, we recommend you to try a Linux distribution (Ubuntu or Debian) for this course, either baremetal or in Windows Subsystem for Linux (WSL). It will be useful in your future to have a bit of experience with it as well.

## _"I'm a embedded/network/security/data science engineer, why do I have this course?"_

Network communication is everywhere. You will need to communicate with other devices, servers, etc. and they communicate between them as well.

This course sets the basis for the rest of your studies. You will need to know how to communicate with other devices, how to send and receive data, how to encode it, etc. This course will give you the necessary knowledge to understand how it works and how to do it.

## Questions

<!-- _class: lead -->

Do you have any questions?

## Resources

- [Windows Subsystem for Linux Documentation](https://learn.microsoft.com/en-us/windows/wsl/) - Use version 2 of WSL.

## Sources

- Illustration by [NASA](https://unsplash.com/@nasa) on [Unsplash](https://unsplash.com/photos/Q1p7bh3SHj8)