# Practical work 3

![Main illustration](./images/main-illustration.jpg)

L. Delafontaine and H. Louis, with the help of
[GitHub Copilot](https://github.com/features/copilot).

This work is licensed under the [CC BY-SA 4.0][license] license.

## Resources

- Objectives, teaching and learning methods, and evaluation methods:
  [Link to content](..)
- Course material: [Link to content](../01-course-material/README.md) ·
  [Presentation (web)](<https://heig-vd-dai-course.github.io/heig-vd-dai-course/12.02-practical-work-3-(1-of-5)/01-course-material/index.html>)
  ·
  [Presentation (PDF)](<https://heig-vd-dai-course.github.io/heig-vd-dai-course/12.02-practical-work-3-(1-of-5)/01-course-material/12.02-practical-work-3-(1-of-5)-presentation.pdf>)

## Table of contents

- [Resources](#resources)
- [Table of contents](#table-of-contents)
- [Introduction](#introduction)
- [Objectives](#objectives)
- [Demo](#demo)
- [Group composition](#group-composition)
- [Idea validation](#idea-validation)
- [Grading criteria](#grading-criteria)
  - [Category 1 - SSH and SCP](#category-1---ssh-and-scp)
  - [Category 2 - Docker and Docker Compose](#category-2---docker-and-docker-compose)
  - [Category 3 - HTTP and curl](#category-3---http-and-curl)
  - [Category 4 - Java network concurrency](#category-4---java-network-concurrency)
  - [Category 5 - Web infrastructures](#category-5---web-infrastructures)
  - [Category 6 - Caching and performance](#category-6---caching-and-performance)
  - [Category 7 - Presentation and questions](#category-7---presentation-and-questions)
- [Constraints](#constraints)
- [Submission](#submission)
- [Presentations](#presentations)
- [Grades and feedback](#grades-and-feedback)
- [Tips](#tips)
- [Finished? Was it easy? Was it hard?](#finished-was-it-easy-was-it-hard)
- [Sources](#sources)

## Introduction

Web applications are accessible from anywhere in the world. You can access them
from your computer, your smartphone, your tablet, etc. using a web browser,
mobile application or even a command line tool.

In this practical work, you will create a web application that uses the HTTP
protocol.

The web application will be defined by an application programming interface
(API) and will be deployed on a virtual machine (a server). The application will
be accessible from the Internet using a domain name.

You will be able to interact with the web application using your web browser
and/or a command line tool such as curl.

The API will be defined by you.

Feel free to be creative! For example, you can choose to create a web
application that allows you to manage your shopping list, a web application that
allows you to manage your tasks, a web application that allows you to manage
your notes, etc. If you do not have any idea, come to see us and we can give
you.

Multiple groups can choose the same processing and you can share your
methodology and take inspiration from/help each other. However, you are not
allowed to plagiarize the code of another group. You will be penalized if you do
so.

## Objectives

- Obtain a virtual machine on a cloud provider.
- Access the virtual machine with SSH.
- Install Docker and Docker Compose on the virtual machine.
- Define some Docker Compose files to run the web application with a reverse
  proxy (Traefik).
- Deploy the simple CRUD API on the virtual machine.
- Access the CRUD API from a domain name with HTTPS (Let's encrypt).

## Demo

The API for the demonstration is accessible at  
<https://heig-vd-dai-course.freeddns.org>.

Locally - Compile the project:

```sh
./mvnw clean package
```

Locally - Build the Docker image with Docker Compose:

```sh
docker build -t <docker tag> .
```

Locally - Publish the Docker image to the container registry:

```sh
docker push <docker tag>
```

On the server - Pull the Docker image from the container registry:

```sh
docker compose pull
```

On the server - Start Traefik (the reverse proxy):

```sh
docker compose -f traefik/docker-compose.yaml up -d
```

On the server - Start the CRUD API:

```sh
docker compose -f api/docker-compose.yaml up -d
```

Create a few drinks:

```sh
# Hot wine
curl -X POST \
  -H "Content-Type: application/json" \
  -d '{"name":"Hot wine","description":"Hot wine with spices","price":3.0}' \
  https://heig-vd-dai-course.freeddns.org/drinks

# Christmas tea
curl -X POST \
  -H "Content-Type: application/json" \
  -d '{"name":"Christmas tea","description":"Warm tea","price":2.0}' \
  https://heig-vd-dai-course.freeddns.org/drinks
```

Get the list of drinks:

```sh
curl https://heig-vd-dai-course.freeddns.org/drinks
```

Output:

```json
[
	{
		"id": 1,
		"name": "Hot wine",
		"description": "Hot wine with spices",
		"price": 3.0
	}
	// All the other drinks
]
```

Filter the drinks with a price equal to 2.0 CHF:

```sh
curl https://heig-vd-dai-course.freeddns.org/drinks?price=2.0
```

Output:

```json
[
	{
		"id": 2,
		"name": "Christmas tea",
		"description": "Warm tea",
		"price": 2.0
	}
]
```

Get a specific drink:

```sh
curl https://heig-vd-dai-course.freeddns.org/drinks/1
```

Output:

```json
{
	"id": 1,
	"name": "Hot wine",
	"description": "Hot wine with spices",
	"price": 3.0
}
```

Update a drink:

```sh
curl -X PUT \
  -H "Content-Type: application/json" \
  -d '{"name":"Hot wine","description":"Nice hot wine","price":3.0}' \
  https://heig-vd-dai-course.freeddns.org/drinks/1
```

Output:

```json
{
	"id": 1,
	"name": "Hot wine",
	"description": "Nice hot wine",
	"price": 3.0
}
```

Delete a drink:

```sh
curl -X DELETE -i https://heig-vd-dai-course.freeddns.org/drinks/1
```

Output:

```text
HTTP/2 204
content-type: text/plain
date: Sat, 16 Dec 2023 13:31:56 GMT

```

No content as we return a `204` (No Content) status code!

Adding another drink with the same name:

```sh
curl -X POST \
  -H "Content-Type: application/json" \
  -d '{"name":"Christmas tea","description":"Another tea","price":2.0}' \
  https://heig-vd-dai-course.freeddns.org/drinks
```

Output:

```text
Conflict
```

Leads to a `409` (Conflict) status code as we want to keep the names unique.

Get the schedules of the Baleinev hot wine week:

```sh
curl https://heig-vd-dai-course.freeddns.org/schedules
```

Output:

```json
[
	{ "id": 0, "day": "MONDAY", "start": [10, 0], "end": [18, 0] },
	{ "id": 1, "day": "TUESDAY", "start": [10, 0], "end": [18, 0] },
	{ "id": 2, "day": "WEDNESDAY", "start": [10, 0], "end": [18, 0] },
	{ "id": 3, "day": "THURSDAY", "start": [10, 0], "end": [22, 0] },
	{ "id": 4, "day": "FRIDAY", "start": [10, 0], "end": [18, 0] }
]
```

## Group composition

You will work in groups of two (2) to three (3) students. You can choose your
partner(s). If you do not have a partner, we will assign you one.

To announce your group, create a new GitHub Discussion at
<https://github.com/orgs/heig-vd-dai-course/discussions> with the following
information:

- **Title**: [DAI 2025-2026 Class \<class ID\>] Practical work 3 - \<first name
  member 1\> \<last name member 1\>, \<first name member 2\> \<last name member
  2\> and \<first name member 3\> \<last name member 3\> (if applicable)
  (replace `<class ID>`, `<first name>` and `<last name>` with your information,
  where `<class ID>` is either `A`, `B` or `C` depending on your class).
- **Category**: Show and tell.
- **Description**: A quick description of what you will achieve during this
  practical work.

> [!CAUTION]
>
> **You must do it before the next course**, even if you do not have a clear
> idea yet as it will help us to plan the practical work presentations.
>
> Please refer to the [Constraints](#constraints) section to know what is
> expected from you.

## Idea validation

The teaching staff might ask you to change the scope of your practical work if
it is too complex or too simple.

This will ensure that you have a good balance between the complexity of the
practical work and the time you have to complete it.

If you do not have any idea, come to see us and we can help you finding some
ideas.

## Grading criteria

- **0 point** - The work is missing, off-topic, or shows a very limited
  understanding of the subject.
- **0.1 point** - The work shows partial understanding: some key elements are
  missing, unclear, or poorly implemented.
- **0.2 point** - The work is complete, accurate, and shows a clear and thorough
  understanding of the subject.

Maximum grade: 25 points \* 0.2 + 1 = 6

> [!CAUTION]
>
> While the grading criteria might not be as detailed as in the previous
> practical work(s) for each section, you **must** continue to apply all the
> good practices you have learned so far (Git, GitHub and Markdown, Java,
> IntelliJ IDEA and Maven, Define an application protocol, Java network
> concurrency, etc.). **You might be penalized if you do not follow these
> practices.**
>
> Check the [Constraints](#constraints) section for more information and
> remember the UNIX philosophy and the KISS principle: _Keep it simple, silly!_

If your repository is private, you must add us as collaborators to your
repository!

### Category 1 - SSH and SCP

|   # | Criterion                                                                                                                                                          | Points |
| --: | :----------------------------------------------------------------------------------------------------------------------------------------------------------------- | -----: |
|   1 | You and the teaching staff can access the virtual machine without a password using a SSH key[^cannot-access-vm-with-ssh]                                           |    0.2 |
|   2 | The virtual machine has the Docker Compose files of your project to be able to run it (via SCP or a cloned repository (HTTPS) is fine)[^cannot-access-vm-with-ssh] |    0.2 |

### Category 2 - Docker and Docker Compose

|   # | Criterion                                                                                                                                        | Points |
| --: | :----------------------------------------------------------------------------------------------------------------------------------------------- | -----: |
|   3 | Docker and Docker Compose are correctly installed on the virtual machine (version 2+ using the right APT repository)[^cannot-access-vm-with-ssh] |    0.2 |
|   4 | Docker can be ran without the need to use `sudo`[^cannot-access-vm-with-ssh]                                                                     |    0.2 |
|   5 | The Docker applications (Traefik and your web application) are split into multiple directories and share a common network                        |    0.2 |
|   6 | The Docker Compose files are correctly defined to run Traefik and your web application using the image from the GitHub Container Registry        |    0.2 |

### Category 3 - HTTP and curl

|   # | Criterion                                                                                                                                                                                    | Points |
| --: | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -----: |
|   7 | The README (or repository) contains the application programming interface (API) that describes the web application                                                                           |    0.2 |
|   8 | The web application makes usage of at least the following HTTP methods: `GET`, `POST`, `PATCH`/`PUT` (chose one between the two) and `DELETE`                                                |    0.2 |
|   9 | The web application return status codes must be consistent and reflect the HTTP methods                                                                                                      |    0.2 |
|  10 | The web application makes usage of at least one query parameter                                                                                                                              |    0.2 |
|  11 | The web application offers at least two resources (= domains) on which to operate CRUD operations (e.g. `/users` and `/products`)                                                            |    0.2 |
|  12 | The README explains how to use your web application with **explicit examples using curl** with outputs to demonstrate how to interact with your web application **deployed on the Internet** |    0.2 |

### Category 4 - Java network concurrency

|   # | Criterion                                                                                | Points |
| --: | :--------------------------------------------------------------------------------------- | -----: |
|  13 | The data structures used in the network application are resilient to concurrent accesses |    0.2 |

### Category 5 - Web infrastructures

|   # | Criterion                                                                                                                                   | Points |
| --: | :------------------------------------------------------------------------------------------------------------------------------------------ | -----: |
|  14 | The README (or repository) contains instructions or a link to the appropriate resources on how to install and configure the virtual machine |    0.2 |
|  15 | The README (or repository) contains instructions how to configure the DNS zone to access your web application                               |    0.2 |
|  16 | The README (or repository) contains a list of your DNS records (screenshot or text) for validation purposes                                 |    0.2 |
|  17 | The README (or repository) contains instructions how to deploy, run and access the web applications with Docker Compose                     |    0.2 |
|  18 | At least Traefik and your web application are deployed on the virtual machine                                                               |    0.2 |
|  19 | The web applications (the Traefik dashboard and your own application) are accessible using a domain name and/or subdomain names             |    0.2 |
|  20 | The web applications (the Traefik dashboard and your own application) use automatic HTTPS/TLS certificate generations with Let's Encrypt    |    0.2 |

### Category 6 - Caching and performance

|   # | Criterion                                                             | Points |
| --: | :-------------------------------------------------------------------- | -----: |
|  21 | The requests are cached to improve performance until the data changes |    0.2 |
|  22 | The caching strategy is explained in the README (or repository)       |    0.2 |

### Category 7 - Presentation and questions

|   # | Criterion                                                                                       | Points |
| --: | :---------------------------------------------------------------------------------------------- | -----: |
|  23 | The presentation is clear and well prepared                                                     |    0.2 |
|  24 | The application is presented so the teaching staff can understand what you created, why and how |    0.2 |
|  25 | Everyone speaks during the presentation.                                                        |    0.2 |

## Constraints

- **A demonstration of your web application is expected during the
  presentation.**
- The whole team must contribute to the project and all members must be able to
  explain it in details if asked.
- A GitHub Discussion must be opened during the first week of the project to
  explain the idea of the project so the teachers can validate the idea.
- The GitHub Discussion must be updated with the link to the repository and a
  related commit hash before the deadline - every 24 hours after the deadline
  will result in a -1 point penalty on the final grade.
- The web application can only use the HTTP/HTTPS protocols.
- The web application must use the Javalin dependency to create the API.
- The application must be slightly more complex and slightly different than the
  examples presented during the course (we emphasize the word _slightly_, no
  need to shoot for the moon).
- You must state your sources if you have used elements that you are not the
  author (code from the Internet, code generated from AI tools, etc.). You must
  also state for which usage you did use the source(s)/tool(s) in your README.
  If you plagiarize the code of another group, all groups involved will receive
  a grade of 1.
- Elements that are supposed to be acquired through the teaching unit or
  previous practical work(s) must not be omitted, forgotten or poorly
  implemented (you must continue to use the Git/GitHub workflow, allow users to
  understand your application, etc.).

> [!CAUTION]
>
> Failure to comply with these constraints may result in serious penalties, up
> to -1 point penalty on the final grade _**for each criterion not met**_.

## Submission

Your work is due as follows:

- DAI-TIC-C (Wednesday mornings): **Tues. 20.01.26 at 23:59**.
- DAI-TIC-B (Wednesday afternoons): **Wed. 21.01.26 at 11:59**.
- DAI-TIC-A (Thursdays): **Wed. 21.01.26 at 23:59**.

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

- DAI-TIC-C (Wednesday mornings): **Wednesday 21.01.26** starting at **10:30**
  in room **TBD**.
- DAI-TIC-B (Wednesday afternoons): **Wednesday 21.01.26** starting at **14:45**
  in room **TBD**.
- DAI-TIC-A (Thursdays): **Thursday 22.01.26** starting at **16:30** in room
  **TBD**.

The exact schedule will be communicated once the groups are known.

<!-- (Un)comment the following lines to hide/show the note about the presentations -->

<!--

We only have **8 minutes per group**. You decide what you want to show us and
how you want to present it.

**Come 5 minutes before your time slot** with your computer. You will have
access to a video projector.

The presentation order is random and is stated in the next tables:

- [DAI-TIC-C (Wednesday mornings)](#dai-tic-c-wednesday-mornings)
- [DAI-TIC-B (Wednesday afternoons)](#dai-tic-b-wednesday-afternoons)
- [DAI-TIC-A (Thursdays)](#dai-tic-a-thursdays)

### DAI-TIC-C (Wednesday mornings)

|   # | Group                                                           | Passage     |
| --: | :-------------------------------------------------------------- | :---------- |
|   1 | Gabriel Bader and Mauro Santos                                  | 10:30-10:38 |
|   2 | Theo Bensaci and Yasser Gasmi                                   | 10:40-10:48 |
|   3 | Pierre Thiébaud and Victor Giordani                             | 10:50-10:58 |
|   4 | Koray Akgul and Nathan Stampfli                                 | 11:00-11:08 |
|   5 | Romain Durussel and Abram Zweifel                               | 11:10-11:18 |
|   6 | Léo Bernard and Yann Mermoud                                    | 11:20-11:28 |
|   7 | Sofian Ethenoz, François de Courville and Mouhamed Sakho        | 11:30-11:38 |
|   8 | Nolan Evard, Maikol Correia Da Silva and Alberto De Sousa Lopes | 11:40-11:48 |

### DAI-TIC-B (Wednesday afternoons)

| # | Group                                 | Passage     |
|--:|:--------------------------------------|:------------|
| 1 | Pierre Gellet and Mirco Profico       | 14:45-14:53 |
| 2 | Yuuta Jorand and Agron Markaj         | 14:55-15:03 |
| 3 | Samuel dos Santos and Fabien Léger    | 15:05-15:13 |
| 4 | Arnaud Bersier and Jonathan Nicolet   | 15:15-15:23 |
| 5 | Marc Ischi and Arnaut Leyre           | 15:25-15:33 |
| 6 | Julien Gorgerat and Audrey Mauroux    | 15:35-15:43 |
| 7 | Louis Garcia and Tiago Ferreira       | 15:45-15:53 |
| 8 | Maxime Regenass and Santiago Sugrañes | 15:55-16:03 |

### DAI-TIC-A (Thursdays)

|   # | Group                                                        | Passage     |
| --: | :----------------------------------------------------------- | :---------- |
|   1 | Thomas Boltshauser, Christopher Pardo and Charles Perfect    | 10:05-10:13 |
|   2 | Sofia Garfo Henriques, Quentin Eschmann and Thibault Matthey | 12:10-12:18 |
|   3 | Pei-Wen Liao, Maksym Makovskyi and Guo Yu Wu                 | 12:20-12:28 |
|   4 | Kym Bolomey, Paul Reynard and Robiel Tesfazghi               | 12:40-12:48 |
|   5 | Gianni Bee and Quentin Michon                                | 16:30-16:38 |
|   6 | Aymeric Siegenthaler, Fateme Pirhayati and Luis Oswaldo      | 16:40-16:48 |
|   7 | Louis Bindschedler, Benoît Essinger and Laszlo Meylan        | 16:50-16:58 |
|   8 | Tadeusz Kondracki, Yanni Skawronski and Jules Rossier        | 17:00-17:08 |
|   9 | Colin Stefani and Simão Romano Schindler                     | 17:10-17:18 |

-->

<!-- (Un)comment the following lines to hide/show the note about the presentations -->

## Grades and feedback

Grades will be entered into GAPS, followed by an email with the feedback.

The evaluation will use exactly the same grading grid as shown in the course
material.

Each criterion will be accompanied by a comment explaining the points obtained,
a general comment on your work and the final grade.

If you have any questions about the evaluation, you can contact us!

<details>
<summary>Email template for the teaching staff</summary>

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

## Tips

You are allowed to reuse your _"Bases de données relationnelles (BDR)"_ project
for this practical work.

You can decide to merge the two projects into one if you want or keep the idea
and implement it in a different way (in memory as you will see in the course
materials).

However, you must ensure that you meet all the criteria of this practical work
and that you respect all the constraints.

In our experience, it might be easier to start from scratch with a new idea. But
you are welcome to try!

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

[^cannot-access-vm-with-ssh]:
    If the teaching staff cannot access your virtual machine, some other
    criteria of the grading grid might not be graded as we will not be able to
    check them. Feel free to ask us for testing the SSH access before the
    deadline.

[license]:
	https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/119
