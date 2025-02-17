---
marp: true
---

<!--
theme: gaia
size: 16:9
paginate: true
author: L. Delafontaine and H. Louis, with the help of GitHub Copilot
title: HEIG-VD DAI Course - Practical work 3
description: Practical work 3 for the DAI course at HEIG-VD, Switzerland
url: https://heig-vd-dai-course.github.io/heig-vd-dai-course/24-practical-work-3/
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
headingDivider: 6
-->

[web]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/24-practical-work-3/
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/24-practical-work-3/24-practical-work-3-presentation.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/119
[illustration]: ./images/main-illustration.jpg
[course-material]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/24-practical-work-3/COURSE_MATERIAL.md
[course-material-qr-code]:
  https://quickchart.io/qr?format=png&ecLevel=Q&size=400&margin=1&text=https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/24-practical-work-3/COURSE_MATERIAL.md

# Practical work 3

<!--
_class: lead
_paginate: false
-->

<https://github.com/heig-vd-dai-course>

[Web][web] · [PDF][pdf]

<small>L. Delafontaine and H. Louis, with the help of GitHub Copilot.</small>

<small>This work is licensed under the [CC BY-SA 4.0][license] license.</small>

![bg opacity:0.1][illustration]

## Objectives

- Acquire a virtual machine from a cloud provider
- Access the virtual machine (SSH)
- Install Docker and Docker Compose
- Develop a simple CRUD API
- Deploy the applications (reverse proxy + CRUD API)
- Access the applications from a (free) domain name

![bg right:40%](https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720)

---

- The CRUD API manages resources. You can choose what the CRUD API does/manages:
  - Music
  - Books
  - Video games
  - A todo/groceries list
  - ...

The CRUD API must be accessible from the internet.

![bg right:40%](https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720)

## Demo

<!-- _class: lead -->

The API for the demonstration is accessible at  
<https://heig-vd-dai-course.duckdns.org>.

---

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

---

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

---

Create a few drinks:

```sh
# Hot wine
curl -X POST \
  -H "Content-Type: application/json" \
  -d '{"name":"Hot wine","description":"Hot wine with spices","price":3.0}' \
  https://heig-vd-dai-course.duckdns.org/drinks

# Christmas tea
curl -X POST \
  -H "Content-Type: application/json" \
  -d '{"name":"Christmas tea","description":"Warm tea","price":2.0}' \
  https://heig-vd-dai-course.duckdns.org/drinks
```

---

Get the list of drinks:

```sh
curl https://heig-vd-dai-course.duckdns.org/drinks
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

---

Filter the drinks with a price equal to 2.0 CHF:

```sh
curl https://heig-vd-dai-course.duckdns.org/drinks?price=2.0
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

---

Get a specific drink:

```sh
curl https://heig-vd-dai-course.duckdns.org/drinks/1
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

---

Update a drink:

```sh
curl -X PUT \
  -H "Content-Type: application/json" \
  -d '{"name":"Hot wine","description":"Nice hot wine","price":3.0}' \
  https://heig-vd-dai-course.duckdns.org/drinks/1
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

---

Delete a drink:

```sh
curl -X DELETE -i https://heig-vd-dai-course.duckdns.org/drinks/1
```

Output:

```text
HTTP/2 204
content-type: text/plain
date: Sat, 16 Dec 2023 13:31:56 GMT

```

No content as we return a `204` (No Content) status code!

---

Adding another drink with the same name:

```sh
curl -X POST \
  -H "Content-Type: application/json" \
  -d '{"name":"Christmas tea","description":"Another tea","price":2.0}' \
  https://heig-vd-dai-course.duckdns.org/drinks
```

Output:

```text
Conflict
```

Leads to a `409` (Conflict) status code as we want to keep the names unique.

---

Get the schedules of the Baleinev hot wine week:

```sh
curl https://heig-vd-dai-course.duckdns.org/schedules
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

<!-- _class: lead -->

More details for this section in the [course material][course-material].

### Group composition

- 2 or 3 students per group
- Create a GitHub Discussion to:
  - Announce your group members
  - Announce your idea (even a draft is fine)
- **Please do it a before the next week**, otherwise you will be penalized (-0.2
  point on the final grade)

![bg right:40%](https://images.unsplash.com/photo-1491911923017-19f90d8d7f83?fit=crop&h=720)

## Idea validation

<!-- _class: lead -->

More details for this section in the [course material][course-material].

### Idea validation

- You must state your idea on your GitHub Discussion
- We might ask you to change your idea if it is too simple or too complex
- We will help you to find a good idea if needed
- **Do it as soon as possible before next week!**

![bg right:40%](https://images.unsplash.com/photo-1543075137-5a97903aaa7a?fit=crop&h=720)

## Grading criteria

<!-- _class: lead -->

More details for this section in the [course material][course-material].

### Grading criteria

You can find all the grading criteria in the [course material][course-material]:

- 0 point - The work is insufficient
- 0.1 point - The work is done
- 0.2 point - The work is well done (without the need of being perfect)

Maximum grade: 25 points \* 0.2 + 1 = 6

![bg right:40%](https://images.unsplash.com/photo-1645500010250-01b5bc42239e?fit=crop&h=720)

## Constraints

<!-- _class: lead -->

More details for this section in the [course material][course-material].

### Constraints

- The application must be written in Java, compatible with Java 21
- The application must be built using Maven with the `maven-shade-plugin` plugin
- The application must use the Javalin dependency
- You can only use the Java classes seen in the course
- Your application must be slightly more complex and slightly different than the
  examples presented during the course (we emphasize the word **slightly**, no
  need to shoot for the moon!)
- The web application can only use the HTTP/HTTPS protocols

## Tips

<!-- _class: lead -->

More details for this section in the [course material][course-material].

### Tips

You are allowed to reuse your Bases de données relationnelles (BDR) project for
this practical work.

You can decide to merge the two projects into one if you want or keep the idea
and implement it in a different way (in memory for example, as you will see in
the course materials).

![bg right:40%](https://images.unsplash.com/photo-1544383835-bda2bc66a55d?fit=crop&h=720)

## Submission

<!-- _class: lead -->

More details for this section in the [course material][course-material].

### Submission

Your work is due as follow:

- DAI-TIC-B (Monday mornings): **19.01.2025 23:59**
- DAI-TIC-C (Friday mornings): **23.01.2025 23:59**

Update the GitHub Discussion with the link to your repository as mentioned in
the course material.

**If you do not submit your work on time and/or correctly, you will be penalized
(-1 point on the final grade for each day of delay).**

## Presentations

<!-- _class: lead -->

More details for this section in the [course material][course-material].

### Presentations

The practical work presentations will take place in **room B51a** (the same room
as the first presentation) on:

- DAI-TIC-B (Monday mornings): **20.01.2025**
- DAI-TIC-C (Friday mornings): **24.01.2025**

We only have **7 minutes per group**. You decide what you want to show us and
how you want to present it.

**Come 5 minutes before your time slot** with your computer. You will have
access to a video projector.

## Grades and feedback

Grades will be entered into GAPS, followed by an email with the feedback.

The evaluation will use exactly the same grading grid as shown in the course
material.

Each criterion will be accompanied by a comment explaining the points obtained,
a general comment on your work and the final grade.

If you have any questions about the evaluation, you can contact us!

## Questions

<!-- _class: lead -->

Do you have any questions?

## Find the practical work

<!-- _class: lead -->

You can find the practical work for this part on [GitHub][course-material].

[![bg right w:75%][course-material-qr-code]][course-material]

## Finished? Was it easy? Was it hard?

Can you let us know what was easy and what was difficult for you during this
practical work?

This will help us to improve the course and adapt the content to your needs. If
we notice some difficulties, we will come back to you to help you.

➡️ [GitHub Discussions][discussions]

You can use reactions to express your opinion on a comment!

## Sources

- Main illustration by [Lāsma Artmane](https://unsplash.com/@lasmaa) on
  [Unsplash](https://unsplash.com/photos/lighted-christmas-tree-surrounded-by-houses-5X8N9A2ruHM)
- Illustration by [Aline de Nadai](https://unsplash.com/@alinedenadai) on
  [Unsplash](https://unsplash.com/photos/j6brni7fpvs)
- Illustration by [Josh Calabrese](https://unsplash.com/@joshcala) on
  [Unsplash](https://unsplash.com/photos/five-men-riding-row-boat-Ev1XqeVL2wI)
- Illustration by [Nicole Baster](https://unsplash.com/@nicolebaster) on
  [Unsplash](https://unsplash.com/photos/traffic-light-aGx-CFsM3fE)
- Illustration by [Chris LaBarge](https://unsplash.com/@chrislabarge) on
  [Unsplash](https://unsplash.com/photos/a-sign-that-is-on-a-tree-in-the-woods-dy1GA9Ow6JA)
- Illustration by [Jan Antonin Kolar](https://unsplash.com/@jankolar) on
  [Unsplash](https://unsplash.com/photos/brown-wooden-drawer-lRoX0shwjUQ)
