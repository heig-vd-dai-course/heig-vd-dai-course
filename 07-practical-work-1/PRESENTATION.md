---
marp: true
---

<!--
theme: gaia
size: 16:9
paginate: true
author: L. Delafontaine and H. Louis, with the help of GitHub Copilot
title: HEIG-VD DAI Course - Practical work 1
description: Practical work 1 for the DAI course at HEIG-VD, Switzerland
url: https://heig-vd-dai-course.github.io/heig-vd-dai-course/07-practical-work-1/
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
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/07-practical-work-1/
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/07-practical-work-1/07-practical-work-1-presentation.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/5
[illustration]:
  https://images.unsplash.com/photo-1583736902935-6b52b2b2359e?fit=crop&h=720
[course-material]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/07-practical-work-1/COURSE_MATERIAL.md
[course-material-qr-code]:
  https://quickchart.io/qr?format=png&ecLevel=Q&size=400&margin=1&text=https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/07-practical-work-1/COURSE_MATERIAL.md

# Practical work 1

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

- Create a command line tool (CLI) to process files with Java IOs
- Practice Java, Maven and [picocli](https://picocli.info/)
- Practice a Git workflow to share your work with your team
- You can choose what the CLI will do (you can be creative! - extract metrics
  from a text file, grayscale a JPEG file, etc.)

![bg right:40%](https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720)

## Demo

- Compile the project

```sh
./mvnw clean package
```

- Run the CLI without any arguments

```sh
java -jar target/practical-work-1-demo-1.0-SNAPSHOT.jar
```

---

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

---

- Run the CLI with the `uppercase` command:

  ```sh
  java -jar target/practical-work-1-demo-1.0-SNAPSHOT.jar \
    --input input.txt \
    --output output.txt \
    uppercase
  ```

- You can also specify the encoding of the input and output files:

  ```sh
  java -jar target/practical-work-1-demo-1.0-SNAPSHOT.jar \
    --input input.txt --input-encoding UTF-8 \
    --output output.txt --output-encoding US-ASCII \
    uppercase
  ```

## See the result

- Input file:

  ```text
  $ cat input.txt
  Bonjour, comment ça va aujourd'hui ?
  ```

- Output file:

  ```text
  $ cat output.txt
  BONJOUR, COMMENT ?A VA AUJOURD'HUI ?
  ```

- Why is the `ç` not converted to uppercase?

## Group composition

<!-- _class: lead -->

More details for this section in the [course material][course-material].

### Group composition

- 2 students per group
- Create a GitHub Discussion to:
  - Announce your group members
  - Announce your idea (even a draft is fine)
- **Do it as soon before next week!**
  - This helps us to plan the presentations

![bg right:40%](https://images.unsplash.com/photo-1491911923017-19f90d8d7f83?fit=crop&h=720)

## Grading criteria

<!-- _class: lead -->

More details for this section in the [course material][course-material].

### Grading criteria

You can find all the grading criteria in the [course material][course-material]:

- 0 point - The work is insufficient
- 0.1 point - The work is done
- 0.2 point - The work is well done (without the need of being perfect)

Maximum grade: 25 points \* 0.2 + 1 = 6

![bg right:40%](https://images.unsplash.com/photo-1491911923017-19f90d8d7f83?fit=crop&h=720)

## Constraints

<!-- _class: lead -->

More details for this section in the [course material][course-material].

### Constraints

- The application must be written in Java, compatible with Java 21
- The application must be built using Maven with the `maven-shade-plugin` plugin
- The application must use the picocli dependency
- You can only use the Java classes seen in the course to process the files (you
  can use other libraries to help you once the files are opened)
- Your application must be slightly more complex and slightly different than the
  examples presented during the course

## Remarks

<!-- _class: lead -->

More details for this section in the [course material][course-material].

### The KISS principle

- Keep it simple, silly!
- Don't try to do too much
- Focus on the essentials and **do it well**

Do not be Numérobis from the movie _Astérix et Obélix : Mission Cléopâtre_!

<small>If you have not seen the movie scene, check it here:
[YouTube](https://www.youtube.com/watch?v=dEP7aEyTOf0).</small>

![bg right:40%](./images/asterix-et-obelix-mission-cleopatre-porte-au-plafond.png)

## Submission

<!-- _class: lead -->

More details for this section in the [course material][course-material].

### Submission

- Update the GitHub Discussion with the link to your repository to include:
  - A link to your GitHub repository
  - The commit hash of the version you want to submit

**Your work is due on the day before the presentations at 23h59**. Check the
[Planning](https://github.com/orgs/heig-vd-dai-course/projects) for the exact
date.

## Grades and feedback

Grades will be entered into GAPS, followed by an email with the feedback.

The evaluation will use exactly the same grading grid as shown in the course
material.

Each criterion will be accompanied by a comment explaining the points obtained,
a general comment on your work and the final grade.

If you have any questions about the evaluation, you can contact us!

## Presentations

The practical work presentations will take place on:

- **TODO XX.YY.202Z** in **room TODO** (class A)
- **TODO 11.10.2023** in **room TODO** (class B)

We only have **5 minutes per group**. You decide what you want to show us and
how you want to present it. **Come 5 minutes before your time slot** with your
computer.

**Please state your group on GitHub Discussions before next week.**

<!--
The order of presentation is random and is stated in the next slides.

---

| #   | Group                                   | Passage |
| --- | --------------------------------------- | ------- |
| 1   | Alan Sottile and Calvin Graf            | 13:40   |
| 2   | Lionel Pollien and Arthur Menétrey      | 13:46   |
| 3   | Thomas Vuilleumier and Sebastian Diaz   | 13:52   |
| 4   | Olin Bourquin and Kevin Farine          | 13:58   |
| 5   | Guillaume Trüeb and Gwendal Piemontesi  | 14:04   |
| 6   | Esteban Lopez                           | 14:10   |
| 7   | Loïc Herman                             | 14:16   |
| 8   | Alexandre Philibert and Valentin Ricard | 14:22   |

---

| #   | Group                           | Passage |
| --- | ------------------------------- | ------- |
| 9   | Rémy Bleuer                     | 14:28   |
| 10  | Theodros Mulugeta               | 14:34   |
|     | Break                           |         |
| 11  | Sarah Jallon                    | 17:00   |
| 12  | Alexandre Iorio                 | 17:06   |
| 13  | Colin Jaques                    | 17:12   |
| 14  | Romain Humair and Lucas Lattion | 17:18   |
| 15  | Slimani Walid                   | 17:24   |

---

| #   | Group                                 | Passage |
| --- | ------------------------------------- | ------- |
| 16  | Aurélien Richard                      | 17:30   |
| 17  | Massimo Stefani and Jonas Troeltsch   | 17:36   |
| 18  | Ahmad Jano                            | 17:42   |
| 19  | Simon Guggisberg and Jeremiah Steiner | 17:48   |
| 20  | Sergey Komarov                        | 17:54   |
| 21  | Pirakas Anthon                        | 18:00   |
-->

## Find the practical work

<!-- _class: lead -->

You can find the practical work for this part on [GitHub][course-material].

[![bg right w:75%][course-material-qr-code]][course-material]

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
