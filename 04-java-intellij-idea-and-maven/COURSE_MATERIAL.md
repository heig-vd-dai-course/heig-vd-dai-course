[markdown]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/04-java-intellij-idea-and-maven/COURSE_MATERIAL.md
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/04-java-intellij-idea-and-maven/04-java-intellij-idea-and-maven-course-material.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/3
[illustration]:
  https://images.unsplash.com/photo-1497935586351-b67a49e012bf?fit=crop&h=720

# Java, IntelliJ and Maven - Course material

<https://github.com/heig-vd-dai-course>

[Markdown][markdown] | [PDF][pdf]

L. Delafontaine and H. Louis, with the help of Copilot.

This work is licensed under the [CC BY-SA 4.0][license] license.

![Main illustration][illustration]

## Table of contents

- [Table of contents](#table-of-contents)
- [Objectives](#objectives)
- [Java](#java)
  - [Java virtual machine](#java-virtual-machine)
  - [JVM versions](#jvm-versions)
  - [Java versions and version managers](#java-versions-and-version-managers)
  - [Compiling and running Java programs](#compiling-and-running-java-programs)
  - [Summary](#summary)
- [IntelliJ IDEA](#intellij-idea)
  - [Community Edition and Ultimate Edition](#community-edition-and-ultimate-edition)
  - [IntelliJ IDEA Toolbox App](#intellij-idea-toolbox-app)
  - [Configuration files and Git](#configuration-files-and-git)
  - [Summary](#summary-1)
- [Maven](#maven)
  - [Maven project structure](#maven-project-structure)
  - [`pom.xml` file](#pomxml-file)
  - [Maven "installation" and Maven wrapper](#maven-installation-and-maven-wrapper)
  - [Summary](#summary-2)
  - [Cheat sheet](#cheat-sheet)
- [Practical content](#practical-content)
  - [Install Java](#install-java)
  - [Check the installation](#check-the-installation)
  - [Install and configure IntelliJ IDEA](#install-and-configure-intellij-idea)
  - [Create and run a new Maven project with IntelliJ IDEA](#create-and-run-a-new-maven-project-with-intellij-idea)
- [Conclusion](#conclusion)
  - [What did you do and learn?](#what-did-you-do-and-learn)
  - [Test your knowledge](#test-your-knowledge)
- [Finished? Was it easy? Was it hard?](#finished-was-it-easy-was-it-hard)
- [What will you do next?](#what-will-you-do-next)
- [Sources](#sources)

## Objectives

This chapter will help you understand how Java can run on all platforms, how to
install and switch between different versions of Java, how to use IntelliJ IDEA
to develop Java applications, how to use Maven to manage dependencies and build
Java applications.

These skills are essential to develop Java applications in a professional
environment to share them with other developers.

Let's get started!

## Java

> [Java](https://www.java.com/) is a general-purpose, class-based,
> object-oriented programming language. It is intended to let programmers write
> once, run anywhere (WORA), meaning that compiled Java code can run on all
> platforms that support Java, thanks to the Java virtual machine (JVM).

Java was created by James Gosling at Sun Microsystems (now part of Oracle
Corporation) and released in 1995.

### Java virtual machine

Java is a **compiled** language, meaning that the source code is compiled to
bytecode, which is then executed by a **Java virtual machine (JVM)**.

Java is a very popular programming language, especially for client-server web
applications.

Java is intended to be **portable**, meaning that compiled Java code can run on
all platforms that support Java, without the need for recompilation, thanks to
the JVM.

### JVM versions

Many implementations of the JVM exist, targeting **different hardware and
software environments and/or specific optimizations** for a given platform
and/or use-case.

In order to install Java on your computer, you may find the **JDK (Java
Development Kit)** or the **JRE (Java Runtime Environment)** packages.

If you want to develop Java applications, you will need the JDK. If you want to
run Java applications, you will need the JRE.

### Java versions and version managers

Java has various **versions**, each with its **own set of features and
improvements**. The latest Long term support (LTS) version is **Java 17**.

As projects can use different versions of Java, it is common to use a **version
manager** such as [SDKMAN!](https://sdkman.io/) or [asdf](https://asdf-vm.com/).

Version managers allow you to **install and switch between different versions of
Java**.

While working on a project, you should **use the same version of Java as the
other developers** to ensure that the project compiles and runs correctly.

You can develop Java applications using a text editor and the command line, but
it is more convenient to use an **Integrated Development Environment (IDE)**.

### Compiling and running Java programs

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

A Java application can be packaged into a **JAR (Java ARchive)** file, which is
a **ZIP file** containing the compiled bytecode and other resources.

A JAR file can be executed using the `java` command:

```bash
java -jar HelloWorld.jar
```

As many Java applications depend on external libraries, it is common to use a
**dependency manager** such as **[Maven](https://maven.apache.org/)** or
**[Gradle](https://gradle.org/)**.

### Summary

- Java is a general-purpose, class-based, object-oriented programming language.
- Java is compiled to bytecode, which is then executed by a Java virtual machine
  (JVM).
- Java is intended to be portable, thanks to the JVM.
- Java has various versions, each with its own set of features and improvements.
- Versions managers allow you to install and switch between different versions
  of Java.

## IntelliJ IDEA

> [IntelliJ IDEA](https://www.jetbrains.com/idea/) is an integrated development
> environment (IDE) written in Java for developing computer software. It is
> developed by JetBrains, and is available as an Apache 2 Licensed community
> edition, and in a proprietary commercial edition.

IntelliJ IDEA is a very popular IDE for Java development, but it also supports
many other programming languages.

### Community Edition and Ultimate Edition

IntelliJ IDEA is available in two editions: the **Community Edition** (free and
open-source) and the **Ultimate Edition** (proprietary).

You are eligible for a **free student license** for the Ultimate Edition, which
you can obtain by following the instructions on the
[JetBrains Student License](https://www.jetbrains.com/community/education/#students)
page.

IntelliJ IDEA is available for Windows, macOS and Linux. Feel free to use
another IDE if you prefer, but we have great experience with IntelliJ IDEA.

### IntelliJ IDEA Toolbox App

The **IntelliJ IDEA Toolbox App** is a desktop application that allows you to
**install and manage multiple JetBrains IDEs**.

It is a convenient way to install and update IntelliJ IDEA and other JetBrains
IDEs in a single place.

### Configuration files and Git

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

> [Apache Maven](https://maven.apache.org/) is a software project management and
> comprehension tool. Based on the concept of a project object model (POM),
> Maven can manage a project's build, reporting and documentation from a central
> piece of information.

Maven is a **dependency manager** for Java projects. It is used to **manage
external libraries** (also called **dependencies**) used by your application.
Maven is a **command-line tool**. It can be used using the `mvn` command.

Maven is also a **build automation tool**. It is used to **compile** your
application, **run** your unit tests, **package** your application, etc.

### Maven project structure

Maven defines a **standard directory structure** for Java projects, so that all
developers can find the source code, unit tests, etc. in the same place. It
**standardizes the build process** of your application, so that all developers
can build the project in the same way.

When creating a new project in IntelliJ IDEA, you can choose between different
**project templates**.

In this course, you will use the **Maven** project template.

IntelliJ IDEA will automatically create a **Maven project structure** for you,
with the following files:

- `pom.xml`: the **Project Object Model (POM)** file, which is the core of a
  Maven project.
- `src/main/java`: the **source code** of your application.
- `src/test/java`: the **unit tests** of your application.

### `pom.xml` file

The `pom.xml` file contains the **configuration** of your Maven project.

It also contains the **build configuration** of your application, which defines
how your application is compiled, tested, packaged, etc.

It contains the **dependencies** of your application, which are **external
libraries** used by your application.

The `pom.xml` file is **shared** between all developers, so that they can
**compile** and **run** the application in the same way.

The standard `pom.xml` file contains the following sections (among others):

- `groupId`: the name of the organization that created the project. It defines
  the **namespace** of the project.
- `artifactId`: the name of the project.
- `version`: the version of the project.
- `packaging`: the packaging type of the project.
- `name` and `description`: the name and description of the project.
- `dependencies`: the dependencies of the project.

The `artifactId`, `version` and `packaging` sets the **name of the JAR file**.

### Maven "installation" and Maven wrapper

Maven is distributed as a **single JAR file**. This means that you can use it
with the `java -jar` command. But it is not very convenient.

Most Linux distributions provide a **package** for Maven, so that you can
install it using the package manager of your distribution. It will then be
available in your `PATH` and you will be able to use the `mvn` command anywhere.

The same applies to macOS with the help of [Homebrew](https://brew.sh/).

On Windows, you have to add Maven to your `PATH` manually. This is not very
convenient either.

This is why Maven projects use a **Maven wrapper**. The Maven wrapper is a
**script** (a shell script on Linux and macOS and a Batch script on Windows)
that will download and run Maven for you.

The Maven wrapper defines the **version of Maven** to use, so that all
developers use the same version of Maven.

The Maven wrapper and its configuration file is **committed** to Git but the
single JAR file is **ignored** by Git.

A new developer can then **run** the Maven wrapper to **download** the single
JAR file and **run** Maven.

### Summary

- Maven is a software project management and comprehension tool.
- Maven is a dependency manager for Java projects.
- Maven is a build automation tool for Java projects.
- Maven defines a standard directory structure for Java projects.
- Maven defines a standard build process for Java projects.
- The `pom.xml` file contains the configuration of your Maven project.

### Cheat sheet

```sh
# Delete the compiled classes
mvn clean

# Compile the source code
mvn compile

# Package the application
mvn package
```

Multiple phases can be executed in a single command:

```sh
# Delete the compiled classes, compile the source code and package the application
mvn clean compile package
```

## Practical content

### Install Java

In this section, you will install Java using the version 17 from Temurin.

If you are on Linux or macOS, you can install and use
[SDKMAN!](https://sdkman.io/) to install and switch between different versions
of Java.

Then, install Java 17 Temurin:

```sh
sdk install java 17.0.8-tem
```

If you are on Windows, we recommend to install Java 17 directly on your system,
without using a version manager even if you are using WSL.

Install Java 17 Temurin from the official website: <https://adoptium.net/>.

### Check the installation

Open a terminal and type `java --version`.

The output should be similar to this:

```text
openjdk 17.0.8 2023-07-18
OpenJDK Runtime Environment Temurin-17.0.8+7 (build 17.0.8+7)
OpenJDK 64-Bit Server VM Temurin-17.0.8+7 (build 17.0.8+7, mixed mode, sharing)
```

### Install and configure IntelliJ IDEA

In this section, you will install and configure IntelliJ IDEA Ultimate Edition.

You can use another IDE if you prefer, but we have great experience with
IntelliJ IDEA.

#### Enable the IntelliJ student license

Follow the official documentation to enable the IntelliJ student license:
<https://www.jetbrains.com/community/education/#students>

#### Download and install IntelliJ Toolbox App

Go to the official website and following the instructions on how to install
IntelliJ Toolbox App on your system: <https://www.jetbrains.com/toolbox/app>.

#### Enable the student license in IntelliJ Toolbox App

Open IntelliJ Toolbox App and login with your JetBrains account.

> **Note:**  
> I (Ludovic) am interested if one of you could improve this section with
> instructions and/or screenshots. I did not do it myself for a long time, maybe
> it has changed and my memory is not up to date anymore.
>
> Feel free to open an issue and a pull request on GitHub if you want to help!
> Thanks!

#### Install IntelliJ IDEA Ultimate Edition

Install IntelliJ IDEA from the Toolbox App and you should be good to go!

### Create and run a new Maven project with IntelliJ IDEA

TODO

#### Create the Maven project

TODO

#### Run the Maven project

TODO

#### Add a dependency

TODO

#### Build the Maven project

TODO

#### Run the project from the command line

TODO

#### Update the build section to include the dependencies

#### Initialize Git

TODO

#### Ignore files for Git

TODO

#### Create a GitHub repository


#### Push the project to GitHub


#### Add a README to the GitHub repository


#### Share your project in GitHub Discussions

Share your profile in the GitHub Discussions of this organization:
<https://github.com/orgs/heig-vd-dai-course/discussions>.

Create a new discussion with the following information:

- **Title**: DAI 2023-2024 - My first IntelliJ + Maven project -
  @YOUR_GITHUB_USERNAME
- **Category**: Show and tell
- **Description**: The link to your GitHub repository

This will notify us that you have completed the exercise and we can check your
work.

## Conclusion

### What did you do and learn?

In this chapter, you have installed and configured Java, IntelliJ IDEA and
Maven. You have created a Java project with Maven, added a dependency to a Maven
project, and built and ran a Maven project. You have learned how these tools can
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

➡️ [GitHub Discussions][discussions]

You can use reactions to express your opinion on a comment!

## What will you do next?

In the next chapter, you will learn the following topics:

- Java IOs: input/output processing

## Sources

- Main illustration by [Nathan Dumlao](https://unsplash.com/@nate_dumlao) on
  [Unsplash](https://unsplash.com/photos/KixfBEdyp64)
