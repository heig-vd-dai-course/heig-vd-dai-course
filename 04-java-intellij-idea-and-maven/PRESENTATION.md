---
marp: true
---

<!--
theme: gaia
size: 16:9
paginate: true
author: L. Delafontaine and H. Louis, with the help of GitHub Copilot
title: HEIG-VD DAI Course - Java, IntelliJ IDEA and Maven
description: Java, IntelliJ IDEA and Maven for the DAI course at HEIG-VD, Switzerland
url: https://heig-vd-dai-course.github.io/heig-vd-dai-course/04-java-intellij-idea-and-maven/
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
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/04-java-intellij-idea-and-maven/
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/04-java-intellij-idea-and-maven/04-java-intellij-idea-and-maven-presentation.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/3
[illustration]: ./images/main-illustration.jpg
[course-material]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/04-java-intellij-idea-and-maven/COURSE_MATERIAL.md
[course-material-qr-code]:
  https://quickchart.io/qr?format=png&ecLevel=Q&size=400&margin=1&text=https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/04-java-intellij-idea-and-maven/COURSE_MATERIAL.md

# Java, IntelliJ IDEA and Maven

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

- Learn why Java is a popular programming language
- Manage multiple Java versions with SDKMAN!
- Develop Java apps with IntelliJ IDEA and Maven
- Manage dependencies with Maven
- Develop essential skills for professional Java development

![bg right:40%](https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720)

## Java

<!-- _class: lead -->

More details for this section in the
[course material](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/04-java-intellij-idea-and-maven/COURSE_MATERIAL.md#java).
You can find other resources and alternatives as well.

### Java

- General-purpose, object-oriented language
- Write once, run anywhere (WORA)
- Created by James Gosling, 1995 at Sun Microsystems
- The documentation seems scary but you will get used to it and it is very
  useful

![bg right h:60%](https://upload.wikimedia.org/wikipedia/en/3/30/Java_programming_language_logo.svg)

### Java virtual machine

- Compiles source code to bytecode
- Executes in Java virtual machine (JVM)
- Where a JVM exists, Java can run (most of the time)

![bg right contain](./images/java-api-specification.png)

### JVM versions

- Multiple implementations exist
- Can target different platforms and/or specific features
- JDK for development, JRE for running
- Eclipse Temurin is recommended.

![bg right contain](./images/which-version-of-jdk-should-i-use.png)

### Java versions and version managers

- Java 21 is the latest LTS
- You can use [SDKMAN!](https://sdkman.io/) to manage multipe versions of Java
- Match versions for project consistency

![bg right w:80%](https://sdkman.io/assets/img/sdk-man-small-pattern.svg)

### Compiling and running Java programs

- Compile manually with `javac` command

  ```sh
  javac HelloWorld.java
  ```

- Execute with `java` command

  ```sh
  java HelloWorld
  ```

- Modern way: package into JAR files with the help of Maven

  ```sh
  java -Xmx1024M -Xms1024M -jar minecraft_server.1.20.1.jar nogui
  ```

### Summary

- Java is a general-purpose, class-based, object-oriented programming language.
- Java is compiled to bytecode, which is then executed by a Java virtual machine
  (JVM).
- Java is intended to be portable, thanks to the JVM.
- Java has various versions, each with its own set of features and improvements.
- Versions managers allow you to install and switch between different versions
  of Java.

## IntelliJ IDEA

<!-- _class: lead -->

More details for this section in the
[course material](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/04-java-intellij-idea-and-maven/COURSE_MATERIAL.md#intellij-idea).
You can find other resources and alternatives as well.

## IntelliJ IDEA

- IDE for (Java) software development
- Developed by JetBrains
- Works on Windows, macOS, Linux

![bg right w:60%](https://resources.jetbrains.com/storage/products/company/brand/logos/IntelliJ_IDEA_icon.svg)

### Community Edition and Ultimate Edition

- Community (free) and Ultimate (paid)
- Free student license available

![bg right contain](./images/intellij-community-and-ultimate-edition.png)

### IntelliJ IDEA Toolbox App

- Manage multiple JetBrains IDEs
- Install and update in one place
- Optional but useful

![bg right w:60%](https://resources.jetbrains.com/storage/products/company/brand/logos/Toolbox_icon.svg)

### Configuration files and Git

- `.idea` directory for project config
- Ignore local config in Git
- Commit shared project config

![bg right contain](./images/gitignore-example.png)

### Summary

- IntelliJ IDEA is an integrated development environment (IDE) written in Java
  for developing computer software.
- IntelliJ IDEA is available in two editions: the Community Edition (free and
  open-source) and the Ultimate Edition (proprietary).
- You are eligible for a free student license for the Ultimate Edition.
- When creating a new project, IntelliJ IDEA will create a `.idea` directory
  containing the project configuration files.
- Some of these files must be ignored by Git, as they contain local
  configuration that is specific to your computer.

## Maven

<!-- _class: lead -->

More details for this section in the
[course material](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/04-java-intellij-idea-and-maven/COURSE_MATERIAL.md#maven).
You can find other resources and alternatives as well.

### Maven

- Maintained by Apache Software Foundation
- Software project management tool
- Manages dependencies
- Build automation tool

![bg right w:80%](https://upload.wikimedia.org/wikipedia/commons/5/52/Apache_Maven_logo.svg)

### Maven project structure

- Standardized directory structure
  - `src/main/java`
  - `src/main/resources`
  - `src/test/java`
- Simplifies build process with conventions

![bg right contain](./images/maven-project-structure.png)

### `pom.xml` file

- Configuration and build settings
- Shared among developers
- Defines dependencies and plugins
  - Plugins extend Maven functionality
  - Dependencies are external libraries

![bg right contain](./images/maven-pom-file.png)

### Maven lifecycle

- Maven defines build process
- Composed of phases and goals
- Phases load plugin goals
- Goals execute tasks on your project (e.g., compile, test, package)

![bg right contain](./images/maven-lifecycle.png)

### Maven Repository

- Public repository of Java libraries
- Maven can download dependencies automatically
- You can publish your own libraries
- Many libraries available such as picocli, a library for building CLI
  applications

![bg right contain](./images/maven-repository.png)

### Maven wrapper

- Allows to use Maven without installing it
- Wrapper script downloads Maven
- Ensures consistent Maven version
- Use `mvnw` or `mvnw.cmd` instead of `mvn`

![bg right contain](./images/maven-wrapper.png)

### Summary

- Maven is a software project management and comprehension tool.
- Maven is a dependency manager for Java projects.
- Maven is a build automation tool for Java projects.
- Maven defines a standard directory structure for Java projects.
- Maven defines a standard build process for Java projects.
- The `pom.xml` file contains the configuration of your Maven project.

## Practical content

<!-- _class: lead -->

### What will you do?

- Install and configure SDKMAN!, Java, Maven and IntelliJ IDEA
- Create and run a small CLI application with picocli, an external Maven
  dependency
- Publish your project on GitHub

![bg right w:90%](./images/what-will-you-do.png)

### Find the practical content

<!-- _class: lead -->

You can find the practical content for this chapter on
[GitHub][course-material].

![bg right w:75%][course-material-qr-code]

## Finished? Was it easy? Was it hard?

Can you let us know what was easy and what was difficult for you during this
chapter?

This will help us to improve the course and adapt the content to your needs. If
we notice some difficulties, we will come back to you to help you.

➡️ [GitHub Discussions][discussions]

You can use reactions to express your opinion on a comment!

## What will you do next?

In the next chapter, you will learn the following topics:

- Java IOs: input/output processing
  - How to read and write files?
  - Why is encoding important?
  - How to deal with exceptions?

![bg right:40%](https://images.unsplash.com/photo-1549319114-d67887c51aed?fit=crop&h=720)

## Sources

- Main illustration by [Nathan Dumlao](https://unsplash.com/@nate_dumlao) on
  [Unsplash](https://unsplash.com/photos/KixfBEdyp64)
- Illustration by [Aline de Nadai](https://unsplash.com/@alinedenadai) on
  [Unsplash](https://unsplash.com/photos/j6brni7fpvs)
- Java logo by [Java](https://www.java.com/)
- SDKMAN! logo by [SDKMAN!](https://sdkman.io/)
- IntelliJ IDEA and Intellij Toolbox logos by
  [JetBrains](https://www.jetbrains.com/)
- Maven logo by [Apache Software Foundation](https://maven.apache.org/)
- Illustration by [Nathan Dumlao](https://unsplash.com/@nate_dumlao) on
  [Unsplash](https://unsplash.com/photos/KixfBEdyp64)
