---
marp: true
---

<!--
theme: gaia
size: 16:9
paginate: true
author: L. Delafontaine and H. Louis, with the help of ChatGPT
title: HEIG-VD DAI Course - Practical work 4
description: Practical work 4 for the DAI course at HEIG-VD, Switzerland
url: https://heig-vd-dai-course.github.io/heig-vd-dai-course/23-practical-work-4/
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
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/23-practical-work-4/
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/23-practical-work-4/23-practical-work-4-presentation.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/119
[illustration]:
  https://images.unsplash.com/photo-1572901334602-f40b66a0c71c?fit=crop&h=720
[practical-work]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/23-practical-work-4/COURSE_MATERIAL.md
[practical-work-qr-code]:
  https://quickchart.io/qr?format=png&ecLevel=Q&size=400&margin=1&text=https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/23-practical-work-4/COURSE_MATERIAL.md

# Practical work 4

<!--
_class: lead
_paginate: false
-->

<https://github.com/heig-vd-dai-course>

[Web][web] · [PDF][pdf]

<small>L. Delafontaine and H. Louis, with the help of ChatGPT.</small>

<small>This work is licensed under the [CC BY-SA 4.0][license] license.</small>

![bg opacity:0.1][illustration]

## Practical work 4

- Get a virtual machine on our cloud
- Access the virtual machine (SSH)
- Install Docker and Docker Compose
- Develop a simple CRUD API
- Deploy the applications (reverse proxy + CRUD API)
- Access the applications from a (free) domain name

![bg right:40%][illustration]

---

- A CRUD API to manage resources
- You can choose what the CRUD API does/manages:
  - Music
  - Books
  - Video games
  - A todo list
  - Groceries
  - ...
- **Groups of 4 students**

![bg right:40%][illustration]

## Demo

<!-- _class: lead -->

The API for the demonstration is accessible at  
<https://heig-vd-dai-course.dedyn.io>.

---

Locally - Compile the project:

```sh
./mvnw clean package
```

Locally - Build the Docker image with Docker Compose:

```sh
docker compose build
```

Locally - Publish the Docker image to the container registry:

```sh
docker compose push
```

---

On the server - Pull the Docker image from the container registry:

```sh
docker compose pull
```

On the server - Start Traefik (the reverse proxy):

```sh
docker compose -f traefik/docker-compose.yml up -d
```

On the server - Start the CRUD API:

```sh
docker compose -f api/docker-compose.yml up -d
```

---

Create a few drinks:

```sh
# Hot wine
curl -X POST \
  -H "Content-Type: application/json" \
  -d '{"name":"Hot wine","description":"Hot wine with spices","price":3.0}' \
  https://heig-vd-dai-course.dedyn.io/drinks

# Christmas tea
curl -X POST \
  -H "Content-Type: application/json" \
  -d '{"name":"Christmas tea","description":"Warm tea","price":2.0}' \
  https://heig-vd-dai-course.dedyn.io/drinks
```

---

Get the list of drinks:

```sh
curl https://heig-vd-dai-course.dedyn.io/drinks
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
curl https://heig-vd-dai-course.dedyn.io/drinks?price=2.0
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
curl https://heig-vd-dai-course.dedyn.io/drinks/1
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
  https://heig-vd-dai-course.dedyn.io/drinks/1
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
curl -X DELETE -i https://heig-vd-dai-course.dedyn.io/drinks/1
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
  https://heig-vd-dai-course.dedyn.io/drinks
```

Output:

```text
Conflict
```

Leads to a `409` (Conflict) status code as we want to keep the names unique.

## Guidelines

**This is important, please read carefully!**

- State your group on GitHub Discussions before the end of the day!
- Define someone in your group as the responsible
- **Write to the IT department** to get a virtual machine as soon as possible
  (**before the end of the day**!)
  - Use the template email provided in the course material.
  - Put the teaching staff in CC.

## Practical work review

The practical work review will take place on **Tuesday 23.01.2023** in the
**room B38**, at the very end of the corridor next to the door entry.

We only have **10 minutes per group** (10 minutes of presentation, no time for
questions). Please be prepared to present your work. You decide what you want to
show us and how you want to present it.

Come 5 minutes before your time slot with your computer.

The order of presentation is random and is stated in the next slides.

---

<!-- -->

**Please state your group on GitHub Discussions as soon as possible, even if you
do not have a clear idea yet as it will help us to plan the practical work
review.**

<!-- -->

| #   | Group | Passage |
| --- | ----- | ------- |
| 1   | TBD   | TBD     |

## Find the practical work

<!-- _class: lead -->

You can find the practical work for this part on [GitHub][practical-work].

[![bg right w:75%][practical-work-qr-code]][practical-work]

## Grades and feedback

Grades will be entered into GAPS, followed by an email with the feedback.

The evaluation will use exactly the same grading grid as shown in the course
material.

Each criterion will be accompanied by a comment explaining the points obtained,
a general comment on your work and the final grade.

If you have any questions about the evaluation, you can contact us!

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
