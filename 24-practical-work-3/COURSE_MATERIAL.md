[markdown]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/24-practical-work-3/COURSE_MATERIAL.md
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/24-practical-work-3/24-practical-work-3-course-material.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/119
[illustration]: ./images/main-illustration.jpg

# Practical work 3

<https://github.com/heig-vd-dai-course>

[Markdown][markdown] · [PDF][pdf]

L. Delafontaine and H. Louis, with the help of GitHub Copilot.

This work is licensed under the [CC BY-SA 4.0][license] license.

![Main illustration][illustration]

## Table of contents

- [Table of contents](#table-of-contents)
- [Introduction](#introduction)
- [Objectives](#objectives)
- [Group composition](#group-composition)
- [Idea validation](#idea-validation)
- [Grading criteria](#grading-criteria)
  - [Category 1 - Git, GitHub and Markdown](#category-1---git-github-and-markdown)
  - [Category 2 - Java, IntelliJ IDEA and Maven](#category-2---java-intellij-idea-and-maven)
  - [Category 3 - Docker and Docker Compose](#category-3---docker-and-docker-compose)
  - [Category 4 - Java network concurrency](#category-4---java-network-concurrency)
  - [Category 5 - SSH and SCP](#category-5---ssh-and-scp)
  - [Category 6 - HTTP and curl](#category-6---http-and-curl)
  - [Category 7 - Web infrastructures](#category-7---web-infrastructures)
  - [Category 8 - Caching and performance](#category-8---caching-and-performance)
  - [Category 9 - Presentation and questions](#category-9---presentation-and-questions)
- [Constraints](#constraints)
- [Tips](#tips)
- [Submission](#submission)
- [Presentations](#presentations)
  - [DAI-TIC-B (Monday mornings)](#dai-tic-b-monday-mornings)
  - [DAI-TIC-C (Friday mornings)](#dai-tic-c-friday-mornings)
- [Grades and feedback](#grades-and-feedback)
- [Finished? Was it easy? Was it hard?](#finished-was-it-easy-was-it-hard)
- [Sources](#sources)

## Introduction

Web applications are accessible from anywhere in the world. You can access them
from your computer, your smartphone, your tablet, etc. using a web browser,
mobile application or even a command line tool.

In this practical work, you will create a web application that uses the HTTP
protocol.

The web application will be defined by an application protocol interface (API)
and will be deployed on a virtual machine (a server). The application will be
accessible from the Internet using a domain name.

You will be able to interact with the web application using your web browser
and/or a command line tool such as curl.

The API will be defined by you.

Feel free to be creative and to create a web application that you would like to
use. It can be a web application that you would like to use in your daily life
or a web application that you would like to use for your studies. For example,
you can choose to create a web application that allows you to manage your
shopping list, a web application that allows you to manage your tasks, a web
application that allows you to manage your notes, etc. If you do not have any
idea, come to see us and we can give you.

Multiple groups can choose the same idea and you can share your methodology and
take inspiration from/help each other. However, you are not allowed to
plagiarize the code of another group. You will be penalized if you do so with 1
as the final grade.

## Objectives

- Obtain a virtual machine on a cloud provider
- Access the virtual machine with SSH
- Install Docker and Docker Compose on the virtual machine
- Define some Docker Compose files to run the web application with a reverse
  proxy (Traefik)
- Deploy the simple CRUD API on the virtual machine
- Access the CRUD API from a domain name with HTTPS (Let's encrypt)

## Group composition

You will work in groups of two or three students. You can choose your
partner(s). If you do not have a partner, we will assign you one.

To announce your group, create a new GitHub Discussion at
<https://github.com/orgs/heig-vd-dai-course/discussions> with the following
information:

- **Title**: [DAI 2024-2025] Practical work 3 - First name Last name member 1,
  First name Last name member 2 and First name Last name member 3 (if
  applicable)
- **Category**: Show and tell
- **Description**: A quick description of what you will achieve during this
  practical work

> [!CAUTION]
>
> **Please do it a before the next week**, even if you do not have a clear idea
> yet as it will help us to plan the practical work presentations.
>
> **If you do not open the discussion before next week, you will be penalized
> (-0.2 point on the final grade).**

## Idea validation

The teaching staff might ask you to change the scope of your practical work if
it is too complex or too simple.

This will ensure that you have a good balance between the complexity of the
practical work and the time you have to complete it.

If you do not have any idea, come to see us and we can help you finding some
ideas.

## Grading criteria

- 0 point - The work is insufficient
- 0.1 point - The work is done
- 0.2 point - The work is well done (without the need of being perfect)

Maximum grade: 25 points \* 0.2 + 1 = 6

> [!IMPORTANT]
>
> While the grading criteria might not be as detailed as in the previous
> practical works for each section, you **must** continue to apply all the good
> practices you have learned so far.
>
> If elements that are supposed to be acquired through the course or previous
> practical works are omitted, forgotten or poorly implemented, we might
> penalize you.
>
> Remember the UNIX philosophy and the KISS principle: _Keep it simple, silly!_

### Category 1 - Git, GitHub and Markdown

If your repository is private, you must add us as collaborators to your
repository!

| #   | Criterion                                                                                                                                                        | Points |
| --- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- | -----: |
| 1   | The README is well structured and explains the purpose of your web with the authors' names so new users can understand it and know who is behind the application |    0.2 |

### Category 2 - Java, IntelliJ IDEA and Maven

| #   | Criterion                                                                                                                                                                            | Points |
| --- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | -----: |
| 2   | The README describes **explicit commands** to clone and build your network application with Git and Maven so new developers can start and develop your project on their own computer |    0.2 |
| 3   | The codebase is well structured, easy to access, easy to understand and is documented so it is easier for new comers to understand the codebase                                      |    0.2 |

### Category 3 - Docker and Docker Compose

| #   | Criterion                                                                                                                                               | Points |
| --- | ------------------------------------------------------------------------------------------------------------------------------------------------------- | -----: |
| 4   | The network application is packaged and published to GitHub Container Registry with Docker so other people can use your network application with Docker |    0.2 |
| 5   | The README describes **explicit commands** to build and publish your network application with Docker                                                    |    0.2 |
| 6   | The README describes **explicit commands** to use your network application with Docker Compose so other people can easily use it                        |    0.2 |
| 7   | The Docker applications (Traefik and your web application) are split into multiple directories and make usage of networks to communicate together       |    0.2 |

### Category 4 - Java network concurrency

| #   | Criterion                                                                                | Points |
| --- | ---------------------------------------------------------------------------------------- | -----: |
| 8   | The data structures used in the network application are resilient to concurrent accesses |    0.2 |

### Category 5 - SSH and SCP

| #   | Criterion                                                                                    | Points |
| --- | -------------------------------------------------------------------------------------------- | -----: |
| 9   | You and the teaching staff can access the virtual machine without a password using a SSH key |    0.2 |

### Category 6 - HTTP and curl

| #   | Criterion                                                                                                                                                                                    | Points |
| --- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -----: |
| 10  | The README (or repository) contains the application protocol interface (API) that describes the web application                                                                              |    0.2 |
| 11  | The web application makes usage of at least the following HTTP methods: `GET`, `POST`, `PATCH`/`PUT` and `DELETE`                                                                            |    0.2 |
| 12  | The web application return status codes must be consistent and reflect the HTTP methods                                                                                                      |    0.2 |
| 13  | The web application offers at least two resources (= domains) on which to operate CRUD operations                                                                                            |    0.2 |
| 14  | The README explains how to use your web application with **explicit examples using curl** with outputs to demonstrate how to interact with your web application **deployed on the Internet** |    0.2 |

### Category 7 - Web infrastructures

| #   | Criterion                                                                                                                                | Points |
| --- | ---------------------------------------------------------------------------------------------------------------------------------------- | -----: |
| 15  | The README (or repository) contains instructions how to install and configure the virtual machine with each step                         |    0.2 |
| 16  | The README (or repository) contains explains how to configure the DNS zone to access your web application                                |    0.2 |
| 17  | The README (or repository) contains instructions how to deploy, run and access the web applications with Docker Compose                  |    0.2 |
| 18  | At least Traefik and your web application are deployed on the virtual machine                                                            |    0.2 |
| 19  | The README displays the domain names configuration in the DNS zone to validate everything is set up right                                |    0.2 |
| 20  | The web applications (the Traefik dashboard and your own application) are accessible using a domain name and/or subdomain names          |    0.2 |
| 21  | The web applications (the Traefik dashboard and your own application) use automatic HTTPS/TLS certificate generations with Let's Encrypt |    0.2 |

### Category 8 - Caching and performance

| #   | Criterion                                                             | Points |
| --- | --------------------------------------------------------------------- | -----: |
| 22  | The requests are cached to improve performance until the data changes |    0.2 |

### Category 9 - Presentation and questions

| #   | Criterion                                                                                                                                                                    | Points |
| --- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -----: |
| 23  | The web application is presented and a demo is made as you would do it to a colleague/another team/boss/client/investor so they can understand what you created, why and how |    0.2 |
| 24  | The presentation is clear and well prepared - everyone speaks during the presentation                                                                                        |    0.2 |
| 25  | The answers to the questions are correct                                                                                                                                     |    0.2 |

## Constraints

- The application must be written in Java, compatible with Java 21
- The application must be built using Maven with the `maven-shade-plugin` plugin
- The application must use the Javalin dependency
- You can only use the Java classes seen in the course to implement the network
  application (you can use any other libraries for other aspects of the
  application, such as UI, etc.)
- Your application must be slightly more complex and slightly different than the
  examples presented during the course (we emphasize the word **slightly**, no
  need to shoot for the moon!)
- The web application can only use the HTTP/HTTPS protocols

## Tips

You are allowed to reuse your Bases de données relationnelles (BDR) project for
this practical work.

You can decide to merge the two projects into one if you want or keep the idea
and implement it in a different way (in memory as you will see in the course
materials).

## Submission

Your work is due as follow:

- DAI-TIC-B (Monday mornings): **19.01.2025 23:59**
- DAI-TIC-C (Friday mornings): **23.01.2025 23:59**

> [!CAUTION]
>
> Each day of delay will result in a penalty of -1 point on the final grade.

You must update the GitHub Discussion you created previously with the following
information:

- **Description**: The link to your repository as well as the commit hash you
  want to submit

> [!CAUTION]
>
> If you do not update the GitHub Discussion with the link to your repository
> and the commit hash before the deadline, it is considered as a late submission
> and you will be penalized.

## Presentations

The practical work presentations will take place in **room B51a** (the same room
as the first presentation) on:

- DAI-TIC-B (Monday mornings): **20.01.2025**
- DAI-TIC-C (Friday mornings): **24.01.2025**

We only have **7 minutes per group**. You decide what you want to show us and
how you want to present it.

**Come 5 minutes before your time slot** with your computer. You will have
access to a video projector.

The order of presentation is random and is stated in the next tables:

- [DAI-TIC-B (Monday mornings)](#dai-tic-b-monday-mornings)
- [DAI-TIC-C (Friday mornings)](#dai-tic-c-friday-mornings)

### DAI-TIC-B (Monday mornings)

| #   | Group                                                | Passage       |
| --- | ---------------------------------------------------- | ------------- |
| 1   | Tristan Baud, Mario Ferreira and Mathieu Emery       | 08:19 - 08:26 |
| 2   | Lestiboudois Maxime, Parisod Nathan and Surbeck Léon | 08:28 - 08:35 |
| 3   | Gruber Adam - Pittet Axel                            | 08:37 - 08:44 |
| 4   | Nathan Wulliamoz - Benjamin Kocher                   | 08:46 - 08:53 |
| 5   | Rothen Evan, Thiébaud Jonathan                       | 08:55 - 09:02 |
| 6   | Florian Chollet - Alexandre Delétraz                 | 09:04 - 09:11 |
| 7   | Leonard Cseres, Aude Laydu                           | 09:13 - 09:20 |
| 8   | Drin Racaj, Nils Donatantonio, Esteban Giorgis       | 09:22 - 09:29 |
| 9   | David Schildböck, Kénan Augsburger and Arno Tribolet | 09:31 - 09:38 |
| 10  | Alex Berberat, Lisa Gorgerat et Pierric Ripoll       | 09:40 - 09:47 |
| 11  | Antoine Leresche & Robin Forestier                   | 09:49 - 09:56 |
| 12  | Basile Buxtorf, Dorian Kury and Nicolas Carbonara    | 09:58 - 10:05 |
| 13  | Mathéo Lopez, Emily Baquerizo, Kimberly Beyeler      | 10:07 - 10:14 |
| 14  | Victor Nicolet, Colin Moschard                       | 10:16 - 10:23 |

### DAI-TIC-C (Friday mornings)

| #   | Group                                                   | Passage       |
| --- | ------------------------------------------------------- | ------------- |
| 1   | Florian Duruz, Yoann Changanaqui                        | 08:30 - 08:37 |
| 2   | Thomas Stäheli, Léonard Jouve and Ali Zoubir            | 08:39 - 08:46 |
| 3   | Aladin Iseni, Arthur Jacobs                             | 08:48 - 08:55 |
| 4   | Thirusan Rajadurai, Raphaël Perret                      | 08:57 - 09:04 |
| 5   | Mathieu Rabot, Camille Theubet and Antoine Aubry        | 09:06 - 09:13 |
| 6   | Bovard Nicolas - Froidevaux Kilian                      | 09:15 - 09:22 |
| 7   | Urs Behrmann, Rodrigo Lopes dos santos                  | 09:24 - 09:31 |
| 8   | Pedro Alves da Silva & Gonçalo Carvalheiro Heleno       | 09:33 - 09:40 |
| 9   | David Berger, Sara Camassa                              | 09:42 - 09:49 |
| 10  | Gianni Cecchetto, Nathan Tschantz and Zaïd Schouwey     | 09:51 - 09:58 |
| 11  | Dani Tiago Faria dos Santos and Nicolas Duprat          | 10:00 - 10:07 |
| 12  | Guillaume Fragnière, Dylan Langumier & Killian Viquerat | 10:09 - 10:16 |

## Grades and feedback

Grades will be entered into GAPS, followed by an email with the feedback.

The evaluation will use exactly the same grading grid as shown in the course
material.

Each criterion will be accompanied by a comment explaining the points obtained,
a general comment on your work and the final grade.

If you have any questions about the evaluation, you can contact us!

<details>
<summary>Grading grid template for the teaching staff</summary>

```text
[DAI 202X-202Y] Retours sur le travail pratique Z

Bonjour,

Vous trouverez en pièce jointe les retours que nous vous avons faits pour le
travail pratique.

La note a été saisie dans GAPS également.

Nous restons à votre disposition pour toute question.

Cordialement,
[Le personnel enseignant]
```

</details>

## Finished? Was it easy? Was it hard?

Can you let us know what was easy and what was difficult for you during this
practical work?

This will help us to improve the course and adapt the content to your needs. If
we notice some difficulties, we will come back to you to help you.

> [!NOTE]
>
> Vous pouvez évidemment poser toutes vos questions et/ou vos propositions
> d'améliorations en français ou en anglais.
>
> N'hésitez pas à nous dire si vous avez des difficultés à comprendre un concept
> ou si vous avez des difficultés à réaliser les éléments demandés dans le
> cours. Nous sommes là pour vous aider !

➡️ [GitHub Discussions][discussions]

You can use reactions to express your opinion on a comment!

## Sources

- Main illustration by [Lāsma Artmane](https://unsplash.com/@lasmaa) on
  [Unsplash](https://unsplash.com/photos/lighted-christmas-tree-surrounded-by-houses-5X8N9A2ruHM)
