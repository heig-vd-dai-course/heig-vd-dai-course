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

[markdown]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/04-java-intellij-idea-and-maven/README.md
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

[Markdown][markdown] | [Web][web] |
[PDF][pdf]<!-- | [Video (in French)][video]-->

<small>L. Delafontaine and H. Louis, with the help of Copilot</small>

![bg opacity:0.1][illustration]

## Table of contents

- **[Theoretical content](#theoretical-content)**
  - [Java](#java)
  - [IntelliJ IDEA](#intellij-idea)
  - [Maven](#maven)
- **[Practical content](#practical-content)**
  - [What will you do?](#what-will-you-do)
  - [Find the practical content](#find-the-practical-content)

## Theoretical content

<!-- _class: lead -->

### Java

> [Java](https://www.java.com/) is a general-purpose, class-based,
> object-oriented programming language. It is intended to let programmers write
> once, run anywhere (WORA), meaning that compiled Java code can run on all
> platforms that support Java, thanks to the Java virtual machine (JVM).

![bg right:40% w:50%](https://upload.wikimedia.org/wikipedia/en/3/30/Java_programming_language_logo.svg)

---

Java was created by James Gosling at Sun Microsystems (now part of Oracle
Corporation) and released in 1995.

Java is a **compiled** language, meaning that the source code is compiled to
bytecode, which is then executed by a **Java virtual machine (JVM)**.

Java is a very popular programming language, especially for client-server web
applications.

Java is intended to be **portable**, meaning that compiled Java code can run on
all platforms that support Java, without the need for recompilation.

---

Many implementations of the JVM exist, targeting **different hardware and
software environments and/or specific optimizations** for a given platform
and/or use-case.

In order to install Java on your computer, you may find the **JDK (Java
Development Kit)** or the **JRE (Java Runtime Environment)** packages.

If you want to develop Java applications, you will need the JDK. If you want to
run Java applications, you will need the JRE.

Java has various **versions**, each with its **own set of features and
improvements**. The latest Long term support (LTS) version is **Java 17**.

---

As projects can use different versions of Java, it is common to use a **version
manager** such as [SDKMAN!](https://sdkman.io/) or [asdf](https://asdf-vm.com/).

Version managers allow you to **install and switch between different versions of
Java**.

While working on a project, you should **use the same version of Java as the
other developers** to ensure that the project compiles and runs correctly.

You can develop Java applications using a text editor and the command line, but
it is more convenient to use an **Integrated Development Environment (IDE)**.

---

A Java application can be compiled using the `javac` command:

```bash
javac HelloWorld.java
```

The resulting bytecode can be executed using the `java` command:

```bash
java HelloWorld
```

Output:

```text
Hello DAI students!
```

---

A Java application can be packaged into a **JAR (Java ARchive)** file, which is
a **ZIP file** containing the compiled bytecode and other resources.

A JAR file can be executed using the `java` command:

```bash
java -jar HelloWorld.jar
```

As many Java applications depend on external libraries, it is common to use a
**dependency manager** such as **[Maven](https://maven.apache.org/)** or
**[Gradle](https://gradle.org/)**.

#### Summary

- Java is a general-purpose, class-based, object-oriented programming language.
- Java is compiled to bytecode, which is then executed by a Java virtual machine
  (JVM).
- Java is intended to be portable, thanks to the JVM.
- Java has various versions, each with its own set of features and improvements.
- Versions managers allow you to install and switch between different versions
  of Java.

#### Alternatives

- [Kotlin](https://kotlinlang.org/)
- [Scala](https://www.scala-lang.org/)
- [Groovy](https://groovy-lang.org/)

_Missing item in the list? Feel free to open a pull request to add it!
:sparkles:_

#### Resources

- [Which Version of JDK Should I Use?](https://whichjdk.com/) - Very useful
  website to help you choose the right version of Java for your project. TL;DR:
  Use
  [Adoptium Eclipse Temurin 17](https://whichjdk.com/#adoptium-eclipse-temurin).
- [SDKMAN!](https://sdkman.io/) - SDKMAN! is a tool for managing parallel
  versions of multiple Software Development Kits on most Unix-based systems.
- [asdf](https://asdf-vm.com/) - asdf is a CLI tool that can manage multiple
  language runtime versions on a per-project basis.

_Missing item in the list? Feel free to open a pull request to add it!
:sparkles:_

### IntelliJ IDEA

> [IntelliJ IDEA](https://www.jetbrains.com/idea/) is an integrated development
> environment (IDE) written in Java for developing computer software. It is
> developed by JetBrains, and is available as an Apache 2 Licensed community
> edition, and in a proprietary commercial edition.

![bg right:40% w:50%](https://upload.wikimedia.org/wikipedia/commons/9/9c/IntelliJ_IDEA_Icon.svg)

---

IntelliJ IDEA is a very popular IDE for Java development, but it also supports
many other programming languages.

IntelliJ IDEA is available in two editions: the **Community Edition** (free and
open-source) and the **Ultimate Edition** (proprietary).

You are eligible for a **free student license** for the Ultimate Edition, which
you can obtain by following the instructions on the
[JetBrains Student License](https://www.jetbrains.com/community/education/#students)
page.

IntelliJ IDEA is available for Windows, macOS and Linux. Feel free to use
another IDE if you prefer, but we have great experience with IntelliJ IDEA.

---

When creating a new project, IntelliJ IDEA will create a `.idea` directory
containing the project configuration files.

Some of these files must be **ignored** by Git, as they contain **local
configuration** that is specific to your computer.

Other files must be **committed** to Git, as they contain **project
configuration** that is shared between all developers.

This allows you to **share the project configuration** with other developers, so
that they can open the project in their instance of IntelliJ IDEA and have the
same configuration as you and ensure that the project compiles and runs
correctly.

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

- [Visual Studio Code](https://code.visualstudio.com/) with the
  [Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
- [Eclipse](https://www.eclipse.org/ide/) if you **really** want to use it
- [NetBeans](https://netbeans.apache.org/) if you **really** want to use it

_Missing item in the list? Feel free to open a pull request to add it!
:sparkles:_

#### Resources

- _None for now_

_Missing item in the list? Feel free to open a pull request to add it!
:sparkles:_

### Maven

> [Apache Maven](https://maven.apache.org/) is a software project management and
> comprehension tool. Based on the concept of a project object model (POM),
> Maven can manage a project's build, reporting and documentation from a central
> piece of information.

![bg right:40% w:50%](https://upload.wikimedia.org/wikipedia/commons/5/52/Apache_Maven_logo.svg)

---

Maven is a **dependency manager** for Java projects. It is used to **manage
external libraries** (also called **dependencies**) used by your application.
Maven is a **command-line tool**. It can be used using the `mvn` command.

Maven is also a **build automation tool**. It is used to **compile** your
application, **run** your unit tests, **package** your application, etc.

Maven defines a **standard directory structure** for Java projects, so that all
developers can find the source code, unit tests, etc. in the same place. It
**standardizes the build process** of your application, so that all developers
can build the project in the same way.

---

When creating a new project in IntelliJ IDEA, you can choose between different
**project templates**.

In this course, we will use the **Maven** project template.

IntelliJ IDEA will automatically create a **Maven project structure** for you,
with the following files:

- `pom.xml`: the **Project Object Model (POM)** file, which is the core of a
  Maven project.
- `src/main/java`: the **source code** of your application.
- `src/test/java`: the **unit tests** of your application.

---

The `pom.xml` file contains the **configuration** of your Maven project.

It also contains the **build configuration** of your application, which defines
how your application is compiled, tested, packaged, etc.

It contains the **dependencies** of your application, which are **external
libraries** used by your application.

The `pom.xml` file is **shared** between all developers, so that they can
**compile** and **run** the application in the same way.

---

The standard `pom.xml` file contains the following sections:

- `project`: the root element of the POM file.
- `groupId`: the group ID of the project.
- `artifactId`: the artifact ID of the project.
- `version`: the version of the project.
- `packaging`: the packaging type of the project.
- `name` and `description`: the name and description of the project.
- `dependencies`: the dependencies of the project.
- `build`: the build configuration of the project.

---

The Maven lifecycle consists of **phases** and **goals**.

A **phase** is a step in the build lifecycle, which is an ordered sequence of
phases.

A **goal** is a specific task that contributes to the building and managing of a
project.

The `mvn` command can be used to **compile** your application:

```bash
mvn compile
```

#### Summary

- Maven is a software project management and comprehension tool.
- Maven is a dependency manager for Java projects.
- Maven is a build automation tool for Java projects.
- Maven defines a standard directory structure for Java projects.
- Maven defines a standard build process for Java projects.
- The `pom.xml` file contains the configuration of your Maven project.

#### Alternatives

- [Gradle](https://gradle.org/)
- [Ant](https://ant.apache.org/)
- [Make](https://www.gnu.org/software/make/)
- [Bazel](https://bazel.build/)

_Missing item in the list? Feel free to open a pull request to add it!
:sparkles:_

#### Resources

- [Introduction to the Build Lifecycle](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html)
- [Maven Build Lifecycle, Phases, and Goals](https://www.digitalocean.com/community/tutorials/maven-build-lifecycle-phases-goals)

_Missing item in the list? Feel free to open a pull request to add it!
:sparkles:_

## Practical content

<!-- _class: lead -->

### What will you do?

- Install and configure Java, IntelliJ IDEA and Maven
- Create a Java project with Maven
- Add a dependency to a Maven project
- Build and run a Maven project

![bg vertical right](https://fakeimg.pl/800x600/0288d1/fff/?text=A)
![bg](https://fakeimg.pl/800x600/02669d/fff/?text=B)
![bg](https://fakeimg.pl/800x600/67b8e3/fff/?text=C)

### Find the practical content

<!-- _class: lead -->

You can find the practical content for this session on
[GitHub](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/04-java-intellij-idea-and-maven/PRACTICAL_CONTENT.md).

## Conclusion

<!-- _class: lead -->

### What did you do and learn?

In this session, you have installed and configured Java, IntelliJ IDEA and
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

In the next session, you will learn the following topics:

- Java IOs: input/output processing and how to manage problems

## Sources

- Main illustration by [Nathan Dumlao](https://unsplash.com/@nate_dumlao) on
  [Unsplash](https://unsplash.com/photos/KixfBEdyp64)
