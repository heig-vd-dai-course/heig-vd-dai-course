[markdown]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/06-practical-work-1/README.md
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/06-practical-work-1/06-practical-work-1.pdf
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/5

# Practical work 1

<https://github.com/heig-vd-dai-course>

[Markdown][markdown] | [PDF][pdf]

L. Delafontaine and H. Louis, with the help of Copilot

In this practical work, you will create a CLI to process files. The CLI will
take an input file and an output file as arguments. It will also take the input
file encoding and the output file encoding as arguments. The CLI will process
the input file and write the result in the output file. It will display a
message on success and a message on failure. It will also display the execution
time.

You will create two versions of the CLI. The first version will not use buffers.
The second version will use buffers. You will compare the two versions.

You will define what the CLI will do. You can choose to copy the input file to
the output file, to convert the input file to uppercase, to convert the input
file to lowercase, to convert the input file to a specific encoding, etc. If you
do not have any idea, come to see us and we can give you some ideas.

Multiple groups can choose the same processing and you can share your
methodology but please do not copy/paste code from other groups.

## Objectives

- Create a CLI to process files
- Learn how to use Java IOs to process files with different encodings

## Group composition

You will work in groups of two students. You can choose your partner. If you do
not have a partner, we will assign you one.

## Grading criteria

- 0 point - The work is not done
- 0.1 point - The work is insufficient
- 0.2 point - The work is done

Maximum grade: 25 points \* 0.2 + 1 = 6

### Category 1 - Git, GitHub and Markdown

| #   | Criteria                                                                        | Points |
| --- | ------------------------------------------------------------------------------- | -----: |
| 1   | The repository contains all members - if private, the teaching staff is invited |    0.2 |
| 2   | The repository is managed using issues and pull requests                        |    0.2 |
| 3   | The commits are signed                                                          |    0.2 |
| 4   | The issues, pull requests and commits messages are descriptive                  |    0.2 |
| 5   | The entire team contributes to the project and can explain it                   |    0.2 |
| 6   | The repository contains a gitignore file to ignore unwanted files               |    0.2 |
| 7   | The README is well structured and explains what the CLI is for                  |    0.2 |
| 8   | The README explains how to build the CLI                                        |    0.2 |
| 9   | The README explains how to use the CLI                                          |    0.2 |
| 10  | The README shows an example of the CLI execution                                |    0.2 |

### Category 2 - Java, IntelliJ IDEA and Maven

| #   | Criteria                                                       | Points |
| --- | -------------------------------------------------------------- | -----: |
| 11  | The code is well structured                                    |    0.2 |
| 12  | The code is well documented                                    |    0.2 |
| 13  | The code is built with Maven and output an executable JAR file |    0.2 |
| 14  | The CLI displays a help message on how to use the CLI          |    0.2 |

### Category 3 - Java IOs

| #   | Criteria                                                                            | Points |
| --- | ----------------------------------------------------------------------------------- | -----: |
| 15  | The CLI takes an input file and an output file as arguments                         |    0.2 |
| 16  | The CLI takes the input file encoding and the output file encoding as arguments     |    0.2 |
| 17  | The CLI displays an error on invalid/missing inputs                                 |    0.2 |
| 18  | The CLI correctly processes the input file and writes the result in the output file |    0.2 |
| 19  | The CLI displays a message on failure                                               |    0.2 |
| 20  | The CLI displays a message on success                                               |    0.2 |

### Category 4 - Presentation and questions

| #   | Criteria                                      | Points |
| --- | --------------------------------------------- | -----: |
| 21  | The presentation is clear and well prepared   |    0.2 |
| 22  | Everyone talks during the presentation        |    0.2 |
| 23  | The presentation presents the CLI application |    0.2 |
| 24  | A demo of the CLI application is made         |    0.2 |
| 25  | The answers to the questions are correct      |    0.2 |

## Constraints

- The CLI must be written in Java, using the Java IO API and Java 17
- The CLI must be built using Maven

## Remarks

You can use any dependency you want in your Maven project. You must however
explain why and how you use it in your README.

Here are some examples of dependencies you can use:

- <https://picocli.info/>

Remember the KISS principle: Keep It Simple, Silly! Sometimes it is better to
use a simple solution than a complex one.

If your solution is too complex, we might penalize you.

## Submission

The planning of the course is available at
<https://github.com/orgs/heig-vd-dai-course/projects>. The deadline is one day
before the Practical work review and feedback session at 23:59.

Any commit after the deadline will not be taken into account. Each day of delay
will result in a penalty of -1 point on the final grade.

You must create a new GitHub Discussion at
<https://github.com/orgs/heig-vd-dai-course/discussions> with the following
information:

- **Title**: DAI 2023-2024 - Practical work 1 - @member1 and @member2
- **Category**: Show and tell
- **Description**: The link to your repository as well as the latest commit hash
  of your work before submission

## Finished? Was it easy? Was it hard?

Can you let us know what was easy and what was difficult for you during this
chapter?

This will help us to improve the course and adapt the content to your needs. If
we notice some difficulties, we will come back to you to help you.

:arrow_right: [GitHub Discussions][discussions]

You can use reactions to express your opinion on a comment!
