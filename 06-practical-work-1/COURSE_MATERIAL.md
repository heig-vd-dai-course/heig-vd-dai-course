[markdown]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/06-practical-work-1/COURSE_MATERIAL.md
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/06-practical-work-1/06-practical-work-1-course-material.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/5

# Practical work 1

<https://github.com/heig-vd-dai-course>

[Markdown][markdown] · [PDF][pdf]

L. Delafontaine and H. Louis, with the help of Copilot.

This work is licensed under the [CC BY-SA 4.0][license] license.

We use CLI tools every day. For example, we use `git` to manage our code, `mvn`
to build our projects, `java` to run our programs, etc.

In this practical work, you will create a CLI using
[picocli](https://picocli.info/) to process files.

The CLI will take an input file and an output file as arguments. It will also
take the input file encoding and the output file encoding as optional arguments
(the default will be UTF-8). The CLI will process the input file and write the
result in the output file. It will display a message on success and a message on
failure.

You have the freedom to define what the CLI will do. You can be creative! For
example, you can choose to copy the input file to the output file, to convert
the input file to lowercase/uppercase, count the number of `e` in the input
file, etc. If you do not have any idea, come to see us and we can give you some
ideas.

Multiple groups can choose the same processing and you can share your
methodology but please do not copy/paste code from other groups.

## Objectives

- Create a CLI to process files
- Use Java IOs to process files with different encodings
- Make usage of a Maven dependency

## Group composition

You will work in groups of two students. You can choose your partner. If you do
not have a partner, we will assign you one or you can work alone if you prefer.
Working alone will not give you any bonus points.

## Grading criteria

- 0 point - The work is not done
- 0.1 point - The work is insufficient
- 0.2 point - The work is done

Maximum grade: 25 points \* 0.2 + 1 = 6

### Category 1 - Git, GitHub and Markdown

If your repository is private, you must add us as collaborators to your
repository!

| #   | Criterion                                                         | Points |
| --- | ----------------------------------------------------------------- | -----: |
| 1   | The repository is managed using issues and pull requests          |    0.2 |
| 2   | The commits are signed                                            |    0.2 |
| 3   | The issues, pull requests and commits messages are descriptive    |    0.2 |
| 4   | The entire team contributes to the project and can explain it     |    0.2 |
| 5   | The repository contains a gitignore file to ignore unwanted files |    0.2 |
| 6   | The repository contains test files to use with the CLI            |    0.2 |
| 7   | The README is well structured and explains what the CLI is for    |    0.2 |
| 8   | The README explains how to build the CLI                          |    0.2 |
| 9   | The README explains how to use the CLI with examples and outputs  |    0.2 |

### Category 2 - Java, IntelliJ IDEA and Maven

| #   | Criterion                                                           | Points |
| --- | ------------------------------------------------------------------- | -----: |
| 10  | The codebase has all required files and is well structured          |    0.2 |
| 11  | The codebase is well documented                                     |    0.2 |
| 12  | The codebase is built and output an executable JAR file             |    0.2 |
| 13  | The CLI uses [picocli](https://picocli.info/) as a Maven dependency |    0.2 |
| 14  | The CLI displays a comprehensive help message on how to use the CLI |    0.2 |

### Category 3 - Java IOs

| #   | Criterion                                                                                | Points |
| --- | ---------------------------------------------------------------------------------------- | -----: |
| 15  | The CLI takes an input file and an output file as arguments                              |    0.2 |
| 16  | The CLI takes the input file encoding and the output file encoding as optional arguments |    0.2 |
| 17  | The CLI displays an error on invalid/missing inputs                                      |    0.2 |
| 18  | The CLI correctly processes the input file and writes the result in the output file      |    0.2 |
| 19  | The CLI displays a message on failure and a message on success with execution time       |    0.2 |
| 20  | The CLI uses all the best practices regarding file processing                            |    0.2 |

### Category 4 - Presentation and questions

| #   | Criterion                                     | Points |
| --- | --------------------------------------------- | -----: |
| 21  | The presentation is clear and well prepared   |    0.2 |
| 22  | Everyone talks during the presentation        |    0.2 |
| 23  | The presentation presents the CLI application |    0.2 |
| 24  | A demo of the CLI application is made         |    0.2 |
| 25  | The answers to the questions are correct      |    0.2 |

## Constraints

- The CLI application must be written in Java, compatible with Java 17
- The CLI application must be built using Maven

## Remarks

Remember the KISS principle: Keep It Simple, Silly! Sometimes it is better to
use a simple solution than a complex one.

If your solution is too complex, we might penalize you.

You can use any other dependencies you want in your Maven project. You must
however explain why and how you use it in your README.

## Submission

The planning of the course is available at
<https://github.com/orgs/heig-vd-dai-course/projects>. The **deadline** is just
**before the Practical work review and feedback session**.

Any commit after the deadline will not be taken into account. Each day of delay
will result in a penalty of -1 point on the final grade.

You must create a new GitHub Discussion at
<https://github.com/orgs/heig-vd-dai-course/discussions> with the following
information:

- **Title**: DAI 2023-2024 - Practical work 1 - @member1 and @member2
- **Category**: Show and tell
- **Description**: The link to your repository as well as the latest commit hash
  of your work before submission

## Grades and feedback

Grades will be entered into GAPS, followed by an email with the feedback.

The evaluation will use exactly the same grading grid as shown in the course
material.

Each criterion will be accompanied by a comment explaining the points obtained,
a general comment on your work and the final grade.

If you have any questions about the evaluation, you can contact us!

<details>
<summary>Grading grid for the teaching staff with comments</summary>

```markdown
# Practical work 1 - Grading grid for @member1 and @member2

Here are the grades and comments for each criterion for the practical work 1.

## Grading criteria

- 0 point - The work is not done
- 0.1 point - The work is insufficient
- 0.2 point - The work is done

Maximum grade: 25 points \* 0.2 + 1 = 6

### Category 1 - Git, GitHub and Markdown

| #   | Criterion                                                         | Points | Number of points obtained | Comment |
| --- | ----------------------------------------------------------------- | -----: | ------------------------: | ------- |
| 1   | The repository is managed using issues and pull requests          |    0.2 |                           |         |
| 2   | The commits are signed                                            |    0.2 |                           |         |
| 3   | The issues, pull requests and commits messages are descriptive    |    0.2 |                           |         |
| 4   | The entire team contributes to the project and can explain it     |    0.2 |                           |         |
| 5   | The repository contains a gitignore file to ignore unwanted files |    0.2 |                           |         |
| 6   | The repository contains test files to use with the CLI            |    0.2 |                           |         |
| 7   | The README is well structured and explains what the CLI is for    |    0.2 |                           |         |
| 8   | The README explains how to build the CLI                          |    0.2 |                           |         |
| 9   | The README explains how to use the CLI with examples and outputs  |    0.2 |                           |         |

### Category 2 - Java, IntelliJ IDEA and Maven

| #   | Criterion                                                           | Points | Number of points obtained | Comment |
| --- | ------------------------------------------------------------------- | -----: | ------------------------: | ------- |
| 10  | The codebase has all required files and is well structured          |    0.2 |                           |         |
| 11  | The codebase is well documented                                     |    0.2 |                           |         |
| 12  | The codebase is built and output an executable JAR file             |    0.2 |                           |         |
| 13  | The CLI uses [picocli](https://picocli.info/) as a Maven dependency |    0.2 |                           |         |
| 14  | The CLI displays a comprehensive help message on how to use the CLI |    0.2 |                           |         |

### Category 3 - Java IOs

| #   | Criterion                                                                                | Points | Number of points obtained | Comment |
| --- | ---------------------------------------------------------------------------------------- | -----: | ------------------------: | ------- |
| 15  | The CLI takes an input file and an output file as arguments                              |    0.2 |                           |         |
| 16  | The CLI takes the input file encoding and the output file encoding as optional arguments |    0.2 |                           |         |
| 17  | The CLI displays an error on invalid/missing inputs                                      |    0.2 |                           |         |
| 18  | The CLI correctly processes the input file and writes the result in the output file      |    0.2 |                           |         |
| 19  | The CLI displays a message on failure and a message on success with execution time       |    0.2 |                           |         |
| 20  | The CLI uses all the best practices regarding file processing                            |    0.2 |                           |         |

### Category 4 - Presentation and questions

| #   | Criterion                                     | Points | Number of points obtained | Comment |
| --- | --------------------------------------------- | -----: | ------------------------: | ------- |
| 21  | The presentation is clear and well prepared   |    0.2 |                           |         |
| 22  | Everyone talks during the presentation        |    0.2 |                           |         |
| 23  | The presentation presents the CLI application |    0.2 |                           |         |
| 24  | A demo of the CLI application is made         |    0.2 |                           |         |
| 25  | The answers to the questions are correct      |    0.2 |                           |         |

## General feedback

- ...

## Final grade

Your final grade is:

Feel free to contact us if you have any questions about the evaluation!
```

</details>

## Finished? Was it easy? Was it hard?

Can you let us know what was easy and what was difficult for you during this
practical work?

This will help us to improve the course and adapt the content to your needs. If
we notice some difficulties, we will come back to you to help you.

➡️ [GitHub Discussions][discussions]

You can use reactions to express your opinion on a comment!
