---
marp: true
---

<!--
theme: gaia
size: 16:9
paginate: true
author: L. Delafontaine and H. Louis, with the help of Copilot
title: HEIG-VD DAI Course - Java, IntelliJ IDEA and Maven
description: Java, IntelliJ IDEA and Maven for the DAI course at HEIG-VD, Switzerland
url: https://heig-vd-dai-course.github.io/heig-vd-dai-course/04-java-intellij-idea-and-maven/
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
        hyphens: auto;
    }
headingDivider: 4
-->

[web]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/04-java-intellij-idea-and-maven/
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/04-java-intellij-idea-and-maven/04-java-intellij-idea-and-maven.pdf
[video]: #
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/3
[illustration]:
  https://images.unsplash.com/photo-1497935586351-b67a49e012bf?fit=crop&h=720

# Java, IntelliJ IDEA and Maven

<!--
_class: lead
_paginate: false
-->

<https://github.com/heig-vd-dai-course>

[Web][web] | [PDF][pdf]<!-- | [Video (in French)][video]-->

<small>L. Delafontaine and H. Louis, with the help of Copilot</small>

![bg opacity:0.1][illustration]

## Java

<!-- _class: lead -->

### Java

TODO

### Java virtual machine

TODO

### Java versions and version managers

TODO

### Compiling and running Java programs

TODO

### Summary

- Java is a general-purpose, class-based, object-oriented programming language.
- Java is compiled to bytecode, which is then executed by a Java virtual machine
  (JVM).
- Java is intended to be portable, thanks to the JVM.
- Java has various versions, each with its own set of features and improvements.
- Versions managers allow you to install and switch between different versions
  of Java.

### Alternatives

_Alternatives are here for general knowledge. No need to learn them._

- [Kotlin](https://kotlinlang.org/)
- [Scala](https://www.scala-lang.org/)
- [Groovy](https://groovy-lang.org/)

_Missing item in the list? Feel free to open a pull request to add it!
:sparkles:_

### Resources

_Resources are here to help you. They are not mandatory to read._

- [Which Version of JDK Should I Use?](https://whichjdk.com/) - Very useful
  website to help you choose the right version of Java for your project. TL;DR:
  Use
  [Adoptium Eclipse Temurin 17](https://whichjdk.com/#adoptium-eclipse-temurin).
- [SDKMAN!](https://sdkman.io/) - SDKMAN! is a tool for managing Java versions.
- [asdf](https://asdf-vm.com/) - An alternative to SDKMAN!.

_Missing item in the list? Feel free to open a pull request to add it!
:sparkles:_

## IntelliJ IDEA

<!-- _class: lead -->

### IntelliJ IDEA

TODO

### Community Edition and Ultimate Edition

TODO

### Configuration files and Git

TODO

#### Summary

- IntelliJ IDEA is an integrated development environment (IDE) written in Java
  for developing computer software.
- IntelliJ IDEA is available in two editions: the Community Edition (free and
  open-source) and the Ultimate Edition (proprietary).
- You are eligible for a free student license for the Ultimate Edition.
- When creating a new project, IntelliJ IDEA will create a `.idea` directory
  containing the project configuration files.
- Some of these files must be ignored by Git, as they contain local
  configuration that is specific to your computer.

#### Alternatives

_Alternatives are here for general knowledge. No need to learn them._

- [Visual Studio Code](https://code.visualstudio.com/) with the
  [Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
- [Eclipse](https://www.eclipse.org/ide/) if you **really** want to use it
- [NetBeans](https://netbeans.apache.org/) if you **really** want to use it

_Missing item in the list? Feel free to open a pull request to add it!
:sparkles:_

#### Resources

_Resources are here to help you. They are not mandatory to read._

- _None for now_

_Missing item in the list? Feel free to open a pull request to add it!
:sparkles:_

## Maven

<!-- _class: lead -->

### Maven

TODO

### Maven project structure

TODO

### `pox.xml` file

TODO

### Maven commands

TODO

### Summary

- Maven is a software project management and comprehension tool.
- Maven is a dependency manager for Java projects.
- Maven is a build automation tool for Java projects.
- Maven defines a standard directory structure for Java projects.
- Maven defines a standard build process for Java projects.
- The `pom.xml` file contains the configuration of your Maven project.

### Alternatives

_Alternatives are here for general knowledge. No need to learn them._

- [Gradle](https://gradle.org/)
- [Ant](https://ant.apache.org/)
- [Make](https://www.gnu.org/software/make/)
- [Bazel](https://bazel.build/)

_Missing item in the list? Feel free to open a pull request to add it!
:sparkles:_

### Resources

_Resources are here to help you. They are not mandatory to read._

- [Introduction to the Build Lifecycle](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html)
- [Maven Build Lifecycle, Phases, and Goals](https://www.digitalocean.com/community/tutorials/maven-build-lifecycle-phases-goals)

_Missing item in the list? Feel free to open a pull request to add it!
:sparkles:_

## Practical content

<!-- _class: lead -->

### What will you do?

- Install and configure Java, IntelliJ IDEA and Maven
- Create and run a new Maven project with IntelliJ IDEA

![bg vertical right](https://fakeimg.pl/800x600/0288d1/fff/?text=A)
![bg](https://fakeimg.pl/800x600/02669d/fff/?text=B)
![bg](https://fakeimg.pl/800x600/67b8e3/fff/?text=C)

### Find the practical content

<!-- _class: lead -->

You can find the practical content for this chapter on
[GitHub](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/04-java-intellij-idea-and-maven/COURSE_MATERIAL.md#practical-content).

## Conclusion

<!-- _class: lead -->

### What did you do and learn?

In this chapter, you have installed and configured Java, IntelliJ IDEA and
Maven. You have created a Java project with Maven, added a dependency to a Maven
project, and built and run a Maven project. You have learned how these tools can
help you to develop Java applications and share them with other developers.

Dependencies management is a very important (yet tricky) topic. In the context
of this course, we will not go any deeper as you will cover in other future
courses.

### Test your knowledge

At this point, you should be able to answer the following questions:

- How can Java run on all platforms?
- How can you install and switch between different versions of Java?
- Why should you ignore some files created by IntelliJ IDEA?
- What is the purpose of the `pom.xml` file?
- How can a tool like Maven help you to develop Java applications?

## Finished? Was it easy? Was it hard?

Can you let us know what was easy and what was difficult for you during this
chapter?

This will help us to improve the course and adapt the content to your needs. If
we notice some difficulties, we will come back to you to help you.

:arrow_right: [GitHub Discussions][discussions]

You can use reactions to express your opinion on a comment!

## What will you do next?

In the next chapter, you will learn the following topics:

- Java IOs: input/output processing and how to manage problems

## Sources

- Main illustration by [Nathan Dumlao](https://unsplash.com/@nate_dumlao) on
  [Unsplash](https://unsplash.com/photos/KixfBEdyp64)
