# Practical work 1

![Main illustration](./images/main-illustration.jpg)

L. Delafontaine and H. Louis, with the help of
[GitHub Copilot](https://github.com/features/copilot).

This work is licensed under the [CC BY-SA 4.0][license] license.

## Resources

- Objectives, teaching and learning methods, and evaluation methods:
  [Link to content](..)
- Course material: [Link to content](../01-course-material/README.md) ·
  [Presentation (web)](<https://heig-vd-dai-course.github.io/heig-vd-dai-course/02.02-practical-work-1-(1-of-5)/01-course-material/index.html>)
  ·
  [Presentation (PDF)](<https://heig-vd-dai-course.github.io/heig-vd-dai-course/02.02-practical-work-1-(1-of-5)/01-course-material/02.02-practical-work-1-(1-of-5)-presentation.pdf>)

## Table of contents

- [Resources](#resources)
- [Table of contents](#table-of-contents)
- [Introduction](#introduction)
- [Objectives](#objectives)
- [Demo](#demo)
  - [Compile and run the CLI](#compile-and-run-the-cli)
  - [Run the CLI](#run-the-cli)
  - [See the results](#see-the-results)
- [Group composition](#group-composition)
- [Idea validation](#idea-validation)
- [Grading criteria](#grading-criteria)
  - [Category 1 - Git, GitHub and Markdown](#category-1---git-github-and-markdown)
  - [Category 2 - Java, IntelliJ IDEA and Maven](#category-2---java-intellij-idea-and-maven)
  - [Category 3 - Java IOs](#category-3---java-ios)
  - [Category 4 - Presentation and questions](#category-4---presentation-and-questions)
- [Constraints](#constraints)
- [Submission](#submission)
- [Presentations](#presentations)
  - [DAI-TIC-C (Wednesday mornings)](#dai-tic-c-wednesday-mornings)
  - [DAI-TIC-B (Wednesday afternoons)](#dai-tic-b-wednesday-afternoons)
  - [DAI-TIC-A (Thursdays)](#dai-tic-a-thursdays)
- [Grades and feedback](#grades-and-feedback)
- [Tips](#tips)
  - [The Unix philosophy and the KISS principle](#the-unix-philosophy-and-the-kiss-principle)
  - [External dependencies](#external-dependencies)
  - [Add members to your repository](#add-members-to-your-repository)
  - [Protect your main branch](#protect-your-main-branch)
  - [How and what to present](#how-and-what-to-present)
- [Milestones](#milestones)
  - [Milestone 1/5](#milestone-15)
  - [Milestone 2/5](#milestone-25)
  - [Milestone 3/5](#milestone-35)
  - [Milestone 4/5](#milestone-45)
  - [Milestone 5/5 (presentations)](#milestone-55-presentations)
- [Finished? Was it easy? Was it hard?](#finished-was-it-easy-was-it-hard)
- [Sources](#sources)

## Introduction

We use command line interface (CLI) tools every day. For example, we use Git to
manage our code (with its `git` command line interface), Maven to build our
projects (with its `mvn` and `mvnw` command line interfaces), Java to run our
programs (with its `javac` and `java` command line interfaces), etc.

In this practical work, you will create a CLI using
[picocli](https://picocli.info/) to process files.

The CLI will take an input file and an output file as arguments. It will also
take optional arguments to customize the CLI (such as the input file encoding
and the output file encoding - the default being UTF-8 for example). The CLI
will process the input file and write the result in the output file. It will
display a message on success and a message on failure.

You have the freedom to define what the CLI will do. You can be creative! For
example, you can choose to transform a text file (find/replace/count number of
occurrences/etc.), process images (grayscale, transform, scale), add metadata to
pictures, apply cryptographic transformations (encrypt/decrypt/sign/verify),
process audio files (convert sample rates, change the volume, apply effects like
reverb), etc.

Multiple groups can choose the same processing and you can share your
methodology and take inspiration from/help each other. However, you are not
allowed to plagiarize the code of another group. You will be penalized if you do
so.

## Objectives

- Create a CLI to process files.
- Practice Java IOs.
- Practice Java, Maven and [picocli](https://picocli.info/).
- Practice a Git workflow to share your work with your team.

## Demo

### Compile and run the CLI

Compile the project:

```sh
./mvnw clean package
```

Run the CLI without any arguments:

```sh
java -jar target/practical-work-1-demo-1.0-SNAPSHOT.jar
```

### Run the CLI

```text
Missing required options: '--input=<inputFile>', '--output=<outputFile>'
Usage: practical-work-1-demo-1.0-SNAPSHOT.jar [-hV] -i=<inputFile>
       [-I=<inputEncoding>] -o=<outputFile> [-O=<outputEncoding>] [COMMAND]
Process an input file and return a result.
  -h, --help                Show this help message and exit.
  -i, --input=<inputFile>   The input file.
  -I, --input-encoding=<inputEncoding>
                            The input file encoding (default: UTF-8).
  -o, --output=<outputFile> The output file.
  -O, --output-encoding=<outputEncoding>
                            The output file encoding (default: UTF-8).
  -V, --version             Print version information and exit.
Commands:
  uppercase  Converts the input file to uppercase.
  lowercase  Converts the input file to lowercase.
```

Run the CLI with the `uppercase` command:

```sh
java -jar target/practical-work-1-demo-1.0-SNAPSHOT.jar \
  --input input.txt \
  --output output.txt \
  uppercase
```

You can also specify the encoding of the input and output files:

```sh
java -jar target/practical-work-1-demo-1.0-SNAPSHOT.jar \
  --input input.txt --input-encoding UTF-8 \
  --output output.txt --output-encoding US-ASCII \
  uppercase
```

### See the results

Input file:

```text
$ cat input.txt
Bonjour, comment ça va aujourd'hui ?
```

Output file:

```text
$ cat output.txt
BONJOUR, COMMENT ?A VA AUJOURD'HUI ?
```

Why is the `ç` not converted to uppercase?

## Group composition

You will work in groups of two (2) to three (3) students. You can choose your
partner(s). If you do not have a partner, we will assign you one.

To announce your group, create a new GitHub Discussion at
<https://github.com/orgs/heig-vd-dai-course/discussions> with the following
information:

- **Title**: [DAI 2025-2026 Class \<class ID\>] Practical work 1 - \<first name
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

### Category 1 - Git, GitHub and Markdown

If your repository is private, you must add the teaching staff as collaborators
to your repository!

|   # | Criterion                                                                                                                                                                                                                          | Points |
| --: | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -----: |
|   1 | The README is well structured, easy to read and has a professional look.                                                                                                                                                           |    0.2 |
|   2 | The README contains the authors of the application so new users know who is behind the application.                                                                                                                                |    0.2 |
|   3 | The README explains the purpose of the application so new users know what the application does.                                                                                                                                    |    0.2 |
|   4 | The README explains how to use your application with examples and outputs so a new user/developer can understand your application without having to run it locally.                                                                |    0.2 |
|   5 | The README describes explicit commands[^explicit-commands] to clone and build your application with Git and Maven so new developers can start and develop your project on their own computer.                                      |    0.2 |
|   6 | Issues are created all along the project to describe new features, elements to improve, etc. to plan work.                                                                                                                         |    0.2 |
|   7 | Pull requests are created all along the project to integrate new work iteratively.                                                                                                                                                 |    0.2 |
|   8 | Pull requests are reviewed, discussed and merged, indicating that the team is working together and that the code is reviewed by the team.                                                                                          |    0.2 |
|   9 | The issue, pull request and commit messages are descriptive so a new comer can understand what has been done.                                                                                                                      |    0.2 |
|  10 | The commits are signed to increase the security and the confidence of the project.                                                                                                                                                 |    0.2 |
|  11 | The repository contains meaningful example files[^meaningful-example-files] to allow new users/developers to try out your application locally - these files can be the same as the ones used in the examples and outputs snippets. |    0.2 |

### Category 2 - Java, IntelliJ IDEA and Maven

|   # | Criterion                                                                                                                                                                                                                                      | Points |
| --: | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -----: |
|  12 | The codebase is well structured, easy to access, easy to understand and is documented so it is easier for new comers to understand the codebase.                                                                                               |    0.2 |
|  13 | The codebase contains the two IntelliJ IDEA configuration files (_"Run the application"_ and _"Package application as JAR file"_) so developers can run and build the application within their IDE.                                            |    0.2 |
|  14 | The codebase contains the Maven wrapper configuration file and scripts so developers can build the application without an IDE and without having to install Maven.                                                                             |    0.2 |
|  15 | The codebase is built with Maven and outputs an executable JAR file so the application can be ran everywhere Java is installed.                                                                                                                |    0.2 |
|  16 | The codebase contains a meaningful gitignore file[^meaningful-gitignore-file] to ignore all unwanted files (Maven output, IntelliJ IDEA files related to local computer, etc.) to keep the repository clean/small and to avoid security leaks. |    0.2 |

### Category 3 - Java IOs

|   # | Criterion                                                                                                                                | Points |
| --: | :--------------------------------------------------------------------------------------------------------------------------------------- | -----: |
|  17 | The CLI offers at least two distinct commands with comprehensive help messages using mandatory and optional arguments for customization. |    0.2 |
|  18 | The CLI processes the files efficiently.                                                                                                 |    0.2 |
|  19 | The CLI processes the files so that they are compatible across operating systems and languages.                                          |    0.2 |
|  20 | The CLI correctly manages resources in case a problem occurs when processing the files.                                                  |    0.2 |
|  21 | The CLI correctly processes the input file(s) and writes the result(s) to the output file(s).                                            |    0.2 |
|  22 | The CLI displays explicit error messages[^explicit-error-messages] on invalid/missing inputs and/or processing errors.                   |    0.2 |

### Category 4 - Presentation and questions

|   # | Criterion                                                                                                                                              | Points |
| --: | :----------------------------------------------------------------------------------------------------------------------------------------------------- | -----: |
|  23 | The presentation is clear and well prepared.                                                                                                           |    0.2 |
|  24 | The application is presented as you would do it to a colleague/another team/boss/client/investor so they can understand what you created, why and how. |    0.2 |
|  25 | Everyone speaks during the presentation.                                                                                                               |    0.2 |

## Constraints

The practical work must comply with the following rules:

- The whole team must contribute to the project and all members must be able to
  explain it in details if asked.
- A GitHub Discussion must be opened during the first week of the project to
  explain the idea of the project so the teachers can validate the idea.
- The GitHub Discussion must be updated with the link to the repository and a
  related commit hash before the deadline - every 24 hours after the deadline
  will result in a -1 point penalty on the final grade.
- The application must use Java classes seen in the course to process the files
  (you can use other libraries to help you once the files are opened) - See the
  [External dependencies](#external-dependencies) section.
- The application must be slightly more complex and slightly different than the
  examples presented during the course (we emphasize the word _slightly_, no
  need to shoot for the moon).
- You must state your sources if you have used elements that you are not the
  author (code from the Internet, code generated from AI tools, etc.). You must
  also state for which usage you did use the source(s)/tool(s) in your README.
  If you plagiarize the code of another group, all groups involved will receive
  a grade of 1.

> [!CAUTION]
>
> Failure to comply with these constraints may result in serious penalties, up
> to -1 point penalty on the final grade _**for each criterion not met**_.

## Submission

Your work is due as follows:

- DAI-TIC-C (Wednesday mornings): **Tuesday 14.10.25 at 23:59**
- DAI-TIC-B (Wednesday afternoons): **Tuesday 14.10.25 at 23:59**
- DAI-TIC-A (Thursdays): **Wednesday 15.10.25 at 23:59**

> [!CAUTION]
>
> Each day of delay will result in a penalty of -1 point on the final grade as
> mentioned in the [Constraints](#constraints) section.

You must update the GitHub Discussion you created previously with the following
information:

- **Description**: The link to your repository as well as the commit hash you
  want to submit.

> [!CAUTION]
>
> If you do not update the GitHub Discussion with the link to your repository
> and the commit hash before the deadline, it is considered as a late submission
> and you will be penalized.

## Presentations

The practical work presentations will take place on:

- DAI-TIC-C (Wednesday mornings): **Wednesday 15.10.25** starting at **10:30**
  in room **B51a** (the room next to the stairs).
- DAI-TIC-B (Wednesday afternoons): **Wednesday 15.10.25** starting at **14:45**
  in room **B38**
- DAI-TIC-A (Thursdays): **Thursday 16.10.25** starting at **15:30** in room
  **B51a** (the room next to the stairs).

The exact schedule will be communicated once the groups are known.

<!-- (Un)comment the following lines to hide/show the note about the presentations -->

We only have **8 minutes per group**. You decide what you want to show us and
how you want to present it.

**Come 5 minutes before your time slot** with your computer. You will have
access to a video projector.

The presentation order is random and is stated in the next tables:

- [DAI-TIC-C (Wednesday mornings)](#dai-tic-c-wednesday-mornings)
- [DAI-TIC-B (Wednesday afternoons)](#dai-tic-b-wednesday-afternoons)
- [DAI-TIC-A (Thursdays)](#dai-tic-a-thursdays)

### DAI-TIC-C (Wednesday mornings)

| #   | Group                                                           | Passage     |
| --- | --------------------------------------------------------------- | ----------- |
| 1   | Sofian Ethenoz, François de Courville and Mouhamed Sakho        | 10:10-10:18 |
| 2   | Nolan Evard, Maikol Correia Da Silva and Alberto De Sousa Lopes | 10:30-10:38 |
| 3   | Romain Durussel and Abram Zweifel                               | 10:50-10:58 |
| 4   | Léo Bernard and Yann Mermoud                                    | 11:00-11:08 |
| 5   | Pierre Thiébaud and Victor Giordani                             | 11:10-11:18 |
| 6   | Koray Akgul and Nathan Stampfli                                 | 11:20-11:28 |
| 7   | Theo Bensaci and Yasser Gasmi                                   | 11:30-11:38 |
| 8   | Gabriel Bader and Mauro Santos                                  | 11:40-11:48 |

### DAI-TIC-B (Wednesday afternoons)

| #   | Group                                 | Passage     |
| --- | ------------------------------------- | ----------- |
| 1   | Maxime Regenass and Santiago Sugrañes | 14:45-14:53 |
| 2   | Marc Ischi and Arnaut Leyre           | 14:55-15:03 |
| 3   | Louis Garcia and Tiago Ferreira       | 15:05-15:13 |
| 4   | Arnaud Bersier and Jonathan Nicolet   | 15:15-15:23 |
| 5   | Julien Gorgerat and Audrey Mauroux    | 15:25-15:33 |
| 6   | Yuuta Jorand and Agron Markaj         | 15:35-15:43 |
| 7   | Samuel dos Santos and Fabien Léger    | 15:45-15:53 |
| 8   | Pierre Gellet and Mirco Profico       | 15:55-16:03 |

### DAI-TIC-A (Thursdays)

| #   | Group                                                        | Passage     |
| --- | ------------------------------------------------------------ | ----------- |
| 1   | Tadeusz Kondracki, Yanni Skawronski and Jules Rossier        | 16:20-16:28 |
| 2   | Pei-Wen Liao, Maksym Makovskyi and Guo Yu Wu                 | 16:30-16:38 |
| 3   | Sofia Garfo Henriques, Quentin Eschmann and Thibault Matthey | 16:40-16:48 |
| 4   | Louis Bindschedler, Benoît Essinger and Laszlo Meylan        | 16:50-16:58 |
| 5   | Aymeric Siegenthaler, Fateme Pirhayati and Luis Oswaldo      | 17:10-17:18 |
| 6   | Colin Stefani and Simão Romano Schindler                     | 17:20-17:28 |
| 7   | Gianni Bee and Quentin Michon                                | 17:30-17:38 |
| 8   | Thomas Boltshauser, Christopher Pardo and Charles Perfect    | 17:40-17:48 |
| 9   | Kym Bolomey, Reynard Paul and Robiel Tesfazghi               | 17:50-17:58 |

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

### The Unix philosophy and the KISS principle

> The Unix philosophy, originated by Ken Thompson, is a set of cultural norms
> and philosophical approaches to minimalist, modular software development. It
> is based on the experience of leading developers of the Unix operating system.
>
> <https://en.wikipedia.org/wiki/Unix_philosophy>

The Unix philosophy is a set of rules that defines how Unix programs should be
designed. It is used to define the Unix operating system and the programs that
are used on this operating system.

The Unix philosophy can be defined by the following rules, among others:

- Write programs that do one thing and do it well.
- Write programs to work together.
- Write programs to handle text streams, because that is a universal interface.

You can inspire yourself from the Unix philosophy to define your own
applications.

The KISS principle summarizes the Unix philosophy in a simple sentence: _Keep it
simple, silly!_

Sometimes it is better to use a simple solution than a complex one.

If your implementation is too complex, we might penalize you.

### External dependencies

You can use any other dependencies you want in your Maven project. You must
however explain why and how you use it in your README.

As mentioned in the [Constraints](#constraints) section, you cannot use an
external dependency that manages the files for you (open/close the files).

### Add members to your repository

You can add your team members to your repository as collaborators to allow them
to push directly to the repository as seen in the
[Git, GitHub and Markdown](../../01.03-git-github-and-markdown/) course.

### Protect your main branch

You can protect the `main` branch of your repository to prevent any push on it
and force signed commits from team members. This will force all team members to
use signed pull requests and reviews before merging their work.

You can check the official documentation to know how to protect your main branch
on GitHub:
<https://docs.github.com/en/repositories/configuring-branches-and-merges-in-your-repository/managing-protected-branches/managing-a-branch-protection-rule>.

### How and what to present

You are free to present your work as you want. You can use slides, poster, a
small theater piece, etc. However:

- No need to remind us the objectives (we know them).
- No need to present us the code if not relevant (we will grade it later - OK if
  interesting, complex, or tricky (= relevant)).
- Focus your presentation on the _"what"_ and the _"why"_.

Aim to explain/pitch your project to someone that has a good technical
understanding but who has no idea about your project.

## Milestones

This practical work is divided into five (5) sessions (four (4) work sessions of
90 minutes + one (1) presentation session).

As it can sometimes be difficult to know if we are on the right track (_"Am I
behind or ahead in my work?"_), we have defined the following milestones to help
you to keep track of your progress.

These milestones are optional to follow but can help you to organize your work
and to ensure that you are on the right track (not too late, not too early).

You are free to manage your time as you wish.

### Milestone 1/5

- [x] You have decided with your team what you want to do for this practical
      work.
- [x] You have created a GitHub Discussion to announce your group and your idea.
- [x] You have created a GitHub repository for your practical work.
- [x] You have added your team members to your repository as collaborators.
- [x] You have added the teaching staff as collaborators to your repository (if
      it is private).
- [x] You have initialized your IntelliJ IDEA project/Maven project with the
      necessary files.

### Milestone 2/5

- [x] You have started to implement the CLI with at least two subcommands.

### Milestone 3/5

- [x] You have started to implement the CLI to process files with Java IOs.

### Milestone 4/5

- [x] You have almost finished implementing the CLI to process files with Java
      IOs.
- [x] You have added the necessary documentation to your README.

### Milestone 5/5 (presentations)

- [x] You have committed your final code to your repository.
- [x] You have updated the GitHub Discussion with the link to your repository
      and the commit hash you want to submit.
- [x] You have prepared your presentation and your demo.
- [x] You have tested your application and your demo.

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

- Main illustration by
  [Birmingham Museums Trust](https://unsplash.com/@birminghammuseumstrust) on
  [Unsplash](https://unsplash.com/photos/ScZwMqoxcls)

[^explicit-commands]:
    Explicit commands are commands that can be run in a terminal to clone and
    build your application. It has to be working commands that can be run by a
    new user/developer without any additional information.

[^meaningful-example-files]:
    Meaningful example files are files that can be used to test your
    application. They should be representative of the files that your
    application will process.

[^meaningful-gitignore-file]:
    A meaningful gitignore file is a file that contains all the files and
    directories that should not be tracked by Git. It should be specific to your
    environment and not contain any generic rules that are not relevant to your
    environment.

[^explicit-error-messages]:
    Explicit error messages are error messages that clearly explain what went
    wrong and how to fix it. They should be user-friendly and easy to
    understand.

[license]:
	https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/5
