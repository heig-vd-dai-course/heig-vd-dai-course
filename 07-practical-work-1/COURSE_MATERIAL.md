[markdown]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/07-practical-work-1/COURSE_MATERIAL.md
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/07-practical-work-1/07-practical-work-1-course-material.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/5
[illustration]:
  https://images.unsplash.com/photo-1583736902935-6b52b2b2359e?fit=crop&h=720

# Practical work 1

<https://github.com/heig-vd-dai-course>

[Markdown][markdown] · [PDF][pdf]

L. Delafontaine and H. Louis, with the help of GitHub Copilot.

This work is licensed under the [CC BY-SA 4.0][license] license.

![Main illustration][illustration]

## Table of contents

- [Table of contents](#table-of-contents)
- [Introduction](#introduction)
- [Objectives](#objectives)
- [Group composition](#group-composition)
- [Grading criteria](#grading-criteria)
  - [Category 1 - Git, GitHub and Markdown](#category-1---git-github-and-markdown)
  - [Category 2 - Java, IntelliJ IDEA and Maven](#category-2---java-intellij-idea-and-maven)
  - [Category 3 - Java IOs](#category-3---java-ios)
  - [Category 4 - Presentation and questions](#category-4---presentation-and-questions)
- [Constraints](#constraints)
- [Remarks](#remarks)
- [Submission](#submission)
- [Grades and feedback](#grades-and-feedback)
- [Finished? Was it easy? Was it hard?](#finished-was-it-easy-was-it-hard)
- [Sources](#sources)

## Introduction

We use CLI tools every day. For example, we use Git (with its `git` command line
interface) to manage our code , Maven (with its `mvn` and `mvnw` command line
interface) to build our projects, Java (with its `javac` and `java` command line
interface) to run our programs, etc.

In this practical work, you will create a CLI using
[picocli](https://picocli.info/) to process files.

The CLI will take an input file and an output file as arguments. It will also
take optional arguments to customize the CLI (such as the input file encoding
and the output file encoding - the default being UTF-8 for example). The CLI
will process the input file and write the result in the output file. It will
display a message on success and a message on failure.

You have the freedom to define what the CLI will do. You can be creative! For
example, you can choose to transform a text file (find/replace/count number of
occurrences/etc.), to grayscale a JPEG/PNG binary file manipulating its pixel
values, add metadata to existing TIFF files, etc.

If you do not have any idea, come to see us and we can give you some ideas.

Multiple groups can choose the same processing and you can share your
methodology but please do not copy/paste code from other groups.

## Objectives

- Create a CLI to process files using the Java classes seen in class
- Practice a Git workflow to work in a team
- Share common configurations (IDE + build tool)

## Group composition

You will work in groups of two students. You can choose your partner. If you do
not have a partner, we will assign you one.

To announce your group, create a new GitHub Discussion at
<https://github.com/orgs/heig-vd-dai-course/discussions> with the following
information:

- **Title**: DAI 2024-2025 - Practical work 1 - First name Last name member 1
  and First name Last name member 2
- **Category**: Show and tell
- **Description**: A quick description of what you will achieve during this
  practical work

> [!IMPORTANT]
>
> **Please do it a soon as possible**, even if you do not have a clear idea yet
> as it will help us to plan the practical work presentations.
>
> Please refer to the grading criteria to know what is expected from you.

The teaching staff might ask you to change the scope of your practical work if
it is too complex or too simple.

## Grading criteria

- 0 point - The work is insufficient
- 0.1 point - The work is done
- 0.2 point - The work is well done (without being perfect)

Maximum grade: 25 points \* 0.2 + 1 = 6

### Category 1 - Meta

| #   | Criterion                                                                                                                                                                                               | Points |
| --- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -----: |
| 1   | The whole team contributes to the project and can explain it in details to share knowledge between the team                                                                                             |    0.2 |
| 2   | A GitHub Discussion is opened during the first week of the project to explain the idea of the project so the teachers can validate the idea                                                             |    0.2 |
| 3   | The GitHub Discussion is updated with the link to the repository and a related commit hash before the deadline - every 24 hours after the deadline will result in a -1 point penalty on the final grade |    0.2 |

### Category 2 - Git, GitHub and Markdown

| #   | Criterion                                                                                                                                                                                                                           | Points |
| --- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -----: |
| 4   | Issues are created all along the project to describe new features, elements to improve, etc. to plan work                                                                                                                           |    0.2 |
| 5   | Pull requests linked to the Issues are created, discussed and reviewed all along the project to integrate new work iteratively                                                                                                      |    0.2 |
| 6   | The issue, pull request and commit messages are descriptive so a new comer can understand what has been done                                                                                                                        |    0.2 |
| 7   | The commits are signed to increase the security and the confidence of the project                                                                                                                                                   |    0.2 |
| 8   | The repository contains a gitignore file to ignore all unwanted files (Maven output, Intellij IDEA files related to local computer, etc.) to keep the repository clean/small and to avoid security leaks                            |    0.2 |
| 9   | The README is well structured and explains the purpose of your application so new users can understand it                                                                                                                           |    0.2 |
| 10  | The README explains how to use your application with examples and outputs so a new user/developer can understand your application without having to run it locally                                                                  |    0.2 |
| 11  | The README describes explicit commands to clone and build your application with Git and Maven so new developers can start and develop your project on their own computer                                                            |    0.2 |
| 12  | The repository contains meaningful example files to allow new users/developers (such as the teaching staff) to try out your application locally - these files can be the same as the ones used in the examples and outputs snippets |    0.2 |

### Category 3 - Java, IntelliJ IDEA and Maven

| #   | Criterion                                                                                                                                                                                          | Points |
| --- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -----: |
| 13  | The codebase is well structued, easy to access, easy to understand and is documented so it is easier for new comers to understand the codebase                                                     |    0.2 |
| 14  | The codebase contains the two IntelliJ IDEA configuration files (_"Run the application"_ and _"Package application as JAR file"_) so developers can run and build the application within their IDE |    0.2 |
| 15  | The codebase contains the Maven wrapper configuration file and scripts so developers can build the application without an IDE and without having to install Maven                                  |    0.2 |
| 16  | The codebase is built with Maven and outputs an executable JAR file so the application can be ran everywhere Java is installed                                                                     |    0.2 |

### Category 4 - Java IOs

| #   | Criterion                                                                                                                                                                        | Points |
| --- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -----: |
| 17  | The CLI displays a comprehensive help message on how to use the application and displays errors on invalid/missing inputs and/or processing errors                               |    0.2 |
| 18  | The CLI takes an input file and an output file as mandatory arguments and other optional arguments for customization (such as the input file/output file character encodings)    |    0.2 |
| 19  | The CLI processes the files with buffers so it stays efficient even with large files                                                                                             |    0.2 |
| 20  | The CLI processes the files respecting their respective charset(s)/character encoding(s) to ensure readability between operating systems/languages                               |    0.2 |
| 21  | The CLI correctly manages resources with try-with-resources or try-catch-finally blocks to cleanly manage allocated resources in case a problem occurs when processing the files |    0.2 |
| 22  | The CLI correctly processes the input file and writes the result in the output file with its execution time                                                                      |    0.2 |

### Category 5 - Presentation and questions

| #   | Criterion                                                                                                                                                                | Points |
| --- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | -----: |
| 23  | The application is presented and a demo is made as you would do it to a colleague/another team/boss/client/investor so they can understand what you created, why and how |    0.2 |
| 24  | The presentation is clear and well prepared. Everyone speaks during the presentation                                                                                     |    0.2 |
| 25  | The answers to the questions are correct                                                                                                                                 |    0.2 |

## Constraints

- The application must be written in Java, compatible with Java 21
- The application must be built using Maven wlth the `maven-shade-plugin` plugin
- The application must use the picocli dependency
- You can only use the Java classes seen in the course to process the files
- Your application must be slightly more complex and slightly different than the
  ones presented during the course (we emphasize the word **slightly**, no need
  to shoot for the moon!)

## Remarks

Remember the KISS principle: Keep It Simple, Silly! Sometimes it is better to
use a simple solution than a complex one.

If your implementation is too complex, we might penalize you.

You can use any other dependencies you want in your Maven project. You must
however explain why and how you use it in your README.

You can protect the `main` branch of your repository to prevent any push on it
and force signed commits from team members. This will force all team members to
use signed pull requests to merge your work.

## Submission

You must update the GitHub Discussion you created previously with the following
information:

- **Description**: The link to your repository as well as the latest commit hash
  of your work before submission

**Your work is due on the day before the presentations at 23h59**. Check the
[Planning](https://github.com/orgs/heig-vd-dai-course/projects) for the exact
date.

Any commit after the deadline will not be taken into account. Each day of delay
will result in a penalty of -1 point on the final grade.

## Grades and feedback

Grades will be entered into GAPS, followed by an email with the feedback.

The evaluation will use exactly the same grading grid as shown in the course
material.

Each criterion will be accompanied by a comment explaining the points obtained,
a general comment on your work and the final grade.

If you have any questions about the evaluation, you can contact us!

<details>
<summary>Grading grid template for the teaching staff</summary>

```markdown
# [DAI 202X-202Y] Retours sur le travail pratique Z

Bonjour,

Vous trouverez en pièce jointe les retours que nous vous avons faits pour le
travail pratique.

La note a été saisie dans GAPS également.

Nous restons à votre disposition pour toute question.

Cordialement, Ludovic Delafontaine et Hadrien Louis
```

</details>

## Finished? Was it easy? Was it hard?

Can you let us know what was easy and what was difficult for you during this
practical work?

This will help us to improve the course and adapt the content to your needs. If
we notice some difficulties, we will come back to you to help you.

➡️ [GitHub Discussions][discussions]

You can use reactions to express your opinion on a comment!

## Sources

- Main illustration by
  [Birmingham Museums Trust](https://unsplash.com/@birminghammuseumstrust) on
  [Unsplash](https://unsplash.com/photos/ScZwMqoxcls)
