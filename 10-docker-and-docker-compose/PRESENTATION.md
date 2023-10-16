---
marp: true
---

<!--
theme: gaia
size: 16:9
paginate: true
author: L. Delafontaine and H. Louis, with the help of ChatGPT
title: HEIG-VD DAI Course - Docker and Docker Compose
description: Docker and Docker Compose for the DAI course at HEIG-VD, Switzerland
url: https://heig-vd-dai-course.github.io/heig-vd-dai-course/10-docker-and-docker-compose/
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
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/10-docker-and-docker-compose/
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/10-docker-and-docker-compose/10-docker-and-docker-compose-presentation.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions
[illustration]:
  https://images.unsplash.com/photo-1511578194003-00c80e42dc9b?fit=crop&h=720
[course-material]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/10-docker-and-docker-compose/COURSE_MATERIAL.md
[course-material-qr-code]:
  https://quickchart.io/qr?format=png&ecLevel=Q&size=400&margin=1&text=https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/10-docker-and-docker-compose/COURSE_MATERIAL.md

# Docker and Docker Compose

<!--
_class: lead
_paginate: false
-->

<https://github.com/heig-vd-dai-course>

[Web][web] · [PDF][pdf]

<small>L. Delafontaine and H. Louis, with the help of ChatGPT.</small>

<small>This work is licensed under the [CC BY-SA 4.0][license] license.</small>

![bg opacity:0.1][illustration]

## Objectives

Learn software installation challenges and containerization benefits.

- Traditional software installation vs. containerization
- Learn what an OCI images and containers are
- Install & run software with Docker
- Long, yet (very) useful chapter

![bg right:40%](https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720)

## Installation of software: traditional vs. containerization

- Traditional: download installer, easy steps but hard to migrate. Can lead to
  version issues.
- Containerization: software in isolated environment

![bg right:40%](https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720)

## OCI, images, containers, and registries

OCI standard for images and runtimes, implemented by Docker and others.

- Image: read-only template for container creation
- Container: runnable instance of an image
- Registry: service storing images

Container Image:

- Contains app & dependencies
- Immutable, create new image to modify
- Composed of read-only layers
- Stored in a registry (e.g., Docker Hub)
- Download/upload to registry
- Create multiple containers from an image
- Containers isolated from each other and the computer.

![bg right:40%](https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720)

## Docker

![bg right:40%](https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720)

### Dockerfile specification

### Security considerations

### Ignore files

### Summary

- Docker is a container engine composed of two parts: the Docker daemon and the
  Docker CLI
- The Docker CLI is used to manage containers and images
- The Dockerfile specification defines a standard for building Docker images
- A Dockerfile is used to build a Docker image
- A Docker image is used to create a container
- A container is a runnable, isolated, instance of an image

## Docker Compose

### Docker Compose specification

### Docker Compose v1 vs. Docker Compose v2

### Summary

- Docker Compose allows to define a multi-container Docker application in a
  Docker Compose file
- A Docker Compose file can consist of a set of services, volumes and networks
- A Docker Compose file (`docker-compose.yml`) can be easily shared and
  versioned with the application
- Docker Compose v2 is the recommended version to use

## Docker Desktop


## Docker Hub and GitHub Container Registry

## Practical content

<!-- _class: lead -->

### What will you do?

-

![bg vertical right](https://fakeimg.pl/800x600/0288d1/fff/?text=A)
![bg](https://fakeimg.pl/800x600/02669d/fff/?text=B)
![bg](https://fakeimg.pl/800x600/67b8e3/fff/?text=C)

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

In the next chapter, you will learn the following topics:

- Experiment with the SMTP protocol and telnet with Docker and Docker Compose
  - How to send emails with SMTP? How is structured an email?
  - Run a SMTP server with Docker and send an email with telnet

![bg right:40%](https://images.unsplash.com/photo-1526554850534-7c78330d5f90?fit=crop&h=720)

## Sources

- Main illustration by [CHUTTERSNAP](https://unsplash.com/@chuttersnap) on
  [Unsplash](https://unsplash.com/photos/xewrfLD8emE)
- Illustration by [Aline de Nadai](https://unsplash.com/@alinedenadai) on
  [Unsplash](https://unsplash.com/photos/j6brni7fpvs)
- Illustration by [Joanna Kosinska](https://unsplash.com/@joannakosinska) on
  [Unsplash](https://unsplash.com/photos/uGcDWKN91Fs)
