[markdown]: https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/05-practical-work-1/README.md
[pdf]: https://heig-vd-dai-course.github.io/heig-vd-dai-course/05-practical-work-1/05-practical-work-1.pdf
[feedback]: https://github.com/orgs/heig-vd-dai-course/discussions/1

# Practical work 1 - A CLI to process files

<https://github.com/heig-vd-dai-course>

<!-- [Markdown][markdown] | [PDF][pdf] | -->[Feedback][feedback]

L. Delafontaine and H. Louis, with the help of Copilot

In this practical work, you will create a CLI to process files. The CLI will take an input file and an output file as arguments. It will also take the input file encoding and the output file encoding as arguments. The CLI will process the input file and write the result in the output file. It will display a message on success and a message on failure. It will also display the execution time.

You will create two versions of the CLI. The first version will not use buffers. The second version will use buffers. You will compare the two versions.

You will define what the CLI will do. You can choose to copy the input file to the output file, to convert the input file to uppercase, to convert the input file to lowercase, to convert the input file to a specific encoding, etc. If you do not have any idea, come to see us and we can give you some ideas.

Multiple groups can choose the same processing and you can share your methodology but please do not copy/paste code from other groups.

## Objectives

- Create a CLI to process files
- Learn how to use Java IOs to process files with different encodings

## Group composition

You will work in groups of two students. You can choose your partner. If you do not have a partner, we will assign you one.

## Grading criteria

- 0 point - The work is not done
- 0.1 point - The work is insufficient
- 0.2 point - The work is done

Maximum grade: 30 points * 0.2 = 6

| #     | Category                  | Criteria | Points |
|-------|---------------------------|----------|-------:|
| 1     | Git, GitHub and Markdown  | The repository has all members and teaching staff as reporters | 0.2 |
| 2     | Git, GitHub and Markdown  | The repository is managed using issues and pull requests | 0.2 |
| 3     | Git, GitHub and Markdown  | The commits are signed | 0.2 |
| 4     | Git, GitHub and Markdown  | The issues, pull requests and commits messages are descriptive | 0.2 |
| 5     | Git, GitHub and Markdown  | The entire team contributes to the project and can explain it | 0.2 |
| 6     | Git, GitHub and Markdown  | The repository contains a gitignore file to ignore unwanted files | 0.2 |
| 7     | Git, GitHub and Markdown  | The repository contains tags to the two versions | 0.2 |
| 8     | Git, GitHub and Markdown  | The README is well written and structured and what the CLI is for | 0.2 |
| 9     | Git, GitHub and Markdown  | The README explains how to build the CLI | 0.2 |
| 10    | Git, GitHub and Markdown  | The README explains how to use the CLI | 0.2 |
| 11    | Git, GitHub and Markdown  | The README explains how to run the tests | 0.2 |
| 12    | Git, GitHub and Markdown  | The README explains the differences between the not Buffer version and the buffer version with links to their respective tag | 0.2 |
| 13    | Git, GitHub and Markdown  | The README explains the benchmark methodology between the two versions | 0.2 |
| 14    | Git, GitHub and Markdown  | The README displays the benchmarks | 0.2 |
| 15    | Java, IntelliJ and Maven     | The code is well structured | 0.2 |
| 16    | Java, IntelliJ and Maven     | The code is well documented | 0.2 |
| 17    | Java, IntelliJ and Maven     | The code is built with Maven | 0.2 |
| 18    | Java, IntelliJ and Maven     | The CLI displays a help message on how to use the CLI | 0.2 |
| 19    | Java IOs                  | The CLI takes an input file and an output file as arguments | 0.2 |
| 20    | Java IOs                  | The CLI takes the input file encoding and the output file encoding as arguments | 0.2 |
| 21    | Java IOs                  | The CLI displays an error on invalid/missing inputs | 0.2 |
| 22    | Java IOs                  | The CLI processes the input file and writes the result in the output file | 0.2 |
| 24    | Java IOs                  | The CLI displays a message on failure | 0.2 |
| 23    | Java IOs                  | The CLI displays a message on success | 0.2 |
| 25    | Java IOs                  | The CLI displays the execution time | 0.2 |
| 26    | Presentation              | The presentation is clear and well prepared | 0.2 |
| 27    | Presentation              | The presentation presents the CLI application | 0.2 |
| 28    | Presentation              | A demo of the CLI application is made | 0.2 |
| 29    | Presentation              | The presentation presents the benchmark methodology and the results | 0.2 |
| 30    | Presentation              | Everyone talks during the presentation  | 0.2 |

## Constraints

- The CLI must be written in Java
- The CLI must be built using Maven

## Submission

The deadline for the practical work can be visualized in the planning of the course at <https://github.com/orgs/heig-vd-dai-course/projects>.

You must create a new GitHub Discussion at <https://github.com/orgs/heig-vd-dai-course/discussions> with the following information:

- **Title**: DAI 2023-2024 - Practical work 1 - @member1 and @member2
- **Category**: Show and tell
- **Description**: The link to your repository as well as the latest commit hash of your work before submission

## Resources

Everything is presented in the following sessions:

- [Git, GitHub and Markdown](../05-practical-work-1/README.md)
- [Java, IntelliJ and Maven](../03-java-intellij-and-maven/README.md)
- [Java IOs](../04-java-ios/README.md)

## Feedback

Please take a few minutes to give us some feedback about this session. It will help us to improve it for the next one!

[GitHub Discussions - Practical work 1 - Feedback][feedback]

We are interested to see if the session was too theoretical / too practical, too slow / too fast, too easy / too difficult, not enough time / too much time, useful / not useful, etc.

You can use reactions to express your opinion on a comment.
