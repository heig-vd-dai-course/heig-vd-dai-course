[markdown]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/18-practical-work-3/COURSE_MATERIAL.md
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/18-practical-work-3/18-practical-work-3-course-material.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/118

# Practical work 3

<https://github.com/heig-vd-dai-course>

[Markdown][markdown] · [PDF][pdf]

L. Delafontaine and H. Louis, with the help of Copilot.

This work is licensed under the [CC BY-SA 4.0][license] license.

## Table of contents

- [Table of contents](#table-of-contents)
- [Introduction](#introduction)
- [Objectives](#objectives)
- [Group composition](#group-composition)
- [Grading criteria](#grading-criteria)
  - [Category 1 - Git, GitHub and Markdown](#category-1---git-github-and-markdown)
  - [Category 2 - Java, IntelliJ IDEA and Maven](#category-2---java-intellij-idea-and-maven)
  - [Category 3 - Define an application protocol](#category-3---define-an-application-protocol)
  - [Category 4 - Docker and Docker Compose](#category-4---docker-and-docker-compose)
  - [Category 5 - Java UDP programming](#category-5---java-udp-programming)
  - [Category 6 - Presentation and questions](#category-6---presentation-and-questions)
- [Constraints](#constraints)
- [Remarks](#remarks)
- [Submission](#submission)
- [Grades and feedback](#grades-and-feedback)
- [Finished? Was it easy? Was it hard?](#finished-was-it-easy-was-it-hard)

## Introduction

Network applications are everywhere. They are used to communicate, to play
games, to watch videos, to listen to music, to browse the web, to send emails,
etc.

In this practical work, you will create a network application that uses the UDP
protocol.

The network application will be defined by an application protocol, a client and
a server. The client will send a request to the server and the server will send
a response to the client.

The application protocol will be defined by you. You can decide to create your
own little application protocol or you can implement an existing protocol.

Your application must be built around UDP. You can use TCP but it should not be
the core of your application. The main difference between TCP and UDP is that
TCP is reliable and UDP is not, having more challenges. UDP is faster than TCP
because it does not have to wait for acknowledgments. It can be used in
real-time communication applications and discovery protocols.

Feel free to be creative! For example, you can choose to create a chat
application, a game, a file transfer application, etc. If you do not have any
idea, come to see us and we can give you.

## Objectives

- Define a network application protocol
- Make usage of the UDP protocol
- Use Java UDP programming to implement a client and a server application
- Use Docker and Docker Compose to deploy the client and the server

## Group composition

You will work in groups of two students. You can choose your partner. If you do
not have a partner, we will assign you one.

To announce your group, create a new GitHub Discussion at
<https://github.com/orgs/heig-vd-dai-course/discussions> with the following
information:

- **Title**: DAI 2023-2024 - Practical work 3 - First name Last name member 1
  and First name Last name member 2
- **Category**: Show and tell
- **Description**: A quick description of what you will achieve during this
  practical work

The teaching staff might ask you to change the scope of your practical work if
it is too complex or too simple.

## Grading criteria

- 0 point - The work is not done
- 0.1 point - The work is insufficient
- 0.2 point - The work is done

Maximum grade: 25 points \* 0.2 + 1 = 6

### Category 1 - Git, GitHub and Markdown

If your repository is private, you must add us as collaborators to your
repository!

| #   | Criterion                                                                                                               | Points |
| --- | ----------------------------------------------------------------------------------------------------------------------- | -----: |
| 1   | The whole team contributes to the project and can explain it in details                                                 |    0.2 |
| 2   | The README is well structured and explains what the network application is for with its documented application protocol |    0.2 |
| 3   | The README explains how to build and publish the network application with Docker                                        |    0.2 |
| 4   | The README explains how to run the network application with examples and outputs                                        |    0.2 |

### Category 2 - Java, IntelliJ IDEA and Maven

| #   | Criterion                                                  | Points |
| --- | ---------------------------------------------------------- | -----: |
| 5   | The codebase has all required files and is well structured |    0.2 |
| 6   | The codebase is well documented                            |    0.2 |

### Category 3 - Define an application protocol

| #   | Criterion                                                                             | Points |
| --- | ------------------------------------------------------------------------------------- | -----: |
| 7   | The application protocol defines the port and protocol to use                         |    0.2 |
| 8   | The application protocol defines who initiates the connection and how                 |    0.2 |
| 9   | The application protocol defines the available messages with their input(s)/output(s) |    0.2 |
| 10  | The application protocol defines the success/errors codes and their explanations      |    0.2 |
| 11  | The application protocol is described using a sequence diagram                        |    0.2 |

### Category 4 - Docker and Docker Compose

| #   | Criterion                                                              | Points |
| --- | ---------------------------------------------------------------------- | -----: |
| 12  | The server and the client are built and published to a Docker registry |    0.2 |
| 13  | A Docker Compose file allows to run the network application            |    0.2 |
| 14  | A health check allows to wait for the application to be ready          |    0.2 |

### Category 5 - Java UDP programming

| #   | Criterion                                                                    | Points |
| --- | ---------------------------------------------------------------------------- | -----: |
| 15  | The client discovers the server(s) and can connect to them                   |    0.2 |
| 16  | The server starts on the defined port and advertises who it is               |    0.2 |
| 17  | The client and server correctly process the input/output commands            |    0.2 |
| 18  | All clients/servers are informed if the servers/clients close the connection |    0.2 |
| 19  | The application makes usage of the UDP protocol                              |    0.2 |
| 20  | The application uses all the best practices regarding network programming    |    0.2 |

### Category 6 - Presentation and questions

| #   | Criterion                                                                            | Points |
| --- | ------------------------------------------------------------------------------------ | -----: |
| 21  | The presentation is clear and well prepared                                          |    0.2 |
| 22  | Everyone speaks during the presentation, and the presentation lasts the time allowed |    0.2 |
| 23  | The presentation presents the network application                                    |    0.2 |
| 24  | A demo of the network application is made                                            |    0.2 |
| 25  | The answers to the questions are correct                                             |    0.2 |

## Constraints

- The network application must be written in Java, compatible with Java 17
- The network application must be built using Maven
- You must use one or more of the Java classes seen in the course
- Your application must be slightly more complex and different than the ones
  presented during the course
- The network application can only use the UDP protocol
- You must build and release the application using Docker and Docker Compose

## Remarks

Remember the KISS principle: Keep It Simple, Silly! Sometimes it is better to
use a simple solution than a complex one.

If your implementation is too complex, we might penalize you.

If elements that are supposed to be acquired through the course or previous
practical works are omitted, forgotten or poorly implemented, we might penalize
you.

You can use [PlantUML](https://plantuml.com/), [Draw.io](https://draw.io/) or
any other tools you want to create your sequence diagrams.

You can use any other dependencies you want in your Maven project. You must
however explain why and how you use it in your README.

You can protect the `main` branch of your repository to prevent any push on it
and force signed commits from team members. This will force all team members to
use signed pull requests to merge your work.

## Submission

The planning of the course is available at
<https://github.com/orgs/heig-vd-dai-course/projects>. The **deadline** is just
**before the Practical work review and feedback session**.

Any commit after the deadline will not be taken into account. Each day of delay
will result in a penalty of -1 point on the final grade.

You must update the GitHub Discussion you created previously with the following
information:

- **Description**: The link to your repository as well as the latest commit hash
  of your work before submission

## Grades and feedback

Grades will be entered into GAPS, followed by an email with the feedback.

The evaluation will use exactly the same grading grid as shown in the course
material.

Each criterion will be accompanied by a comment explaining the points obtained,
a general comment on your work and the final grade.

If you have any questions about the evaluation, you can contact us!

<details>
<summary>Grading grid for the teaching staff with comments</summary>

```markdown
# Practical work 3 - Grading grid for First name Last name member 1 and First name Last name member 2

Here are the grades and comments for each criterion for the practical work.

## Grading criteria

- 0 point - The work is not done
- 0.1 point - The work is insufficient
- 0.2 point - The work is done

Maximum grade: 25 points \* 0.2 + 1 = 6

TODO

## General feedback

- ...

## Final grade

Your final grade is:

Feel free to contact us if you have any questions about the evaluation!
```

</details>

## Finished? Was it easy? Was it hard?

Can you let us know what was easy and what was difficult for you during this
practical work?

This will help us to improve the course and adapt the content to your needs. If
we notice some difficulties, we will come back to you to help you.

➡️ [GitHub Discussions][discussions]

You can use reactions to express your opinion on a comment!
