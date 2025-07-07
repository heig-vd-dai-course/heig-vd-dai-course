# HEIG-VD DAI Course

[![License](https://img.shields.io/github/license/heig-vd-dai-course/heig-vd-dai-course)](./LICENSE.md)

Welcome to the
[Développement d'applications internet (DAI)](https://gaps.heig-vd.ch/consultation/fiches/uv/uv.php?id=6573)
teaching unit taught at
[Haute Ecole d'Ingénierie et de Gestion du Canton de Vaud (HEIG-VD)](https://heig-vd.ch),
Switzerland!

## 🎯 General objectives

On completion of this course, the student will be able to:

- Understand the principles of network communication and how to program
  efficient network applications.
- Use Java, Maven and Git/GitHub to develop network applications.
- Define, implement and interact with various network applications using TCP,
  UDP and HTTP protocols.
- Deploy network applications in a containerized environment with Docker and
  Docker Compose on a web infrastructure (servers, reverse proxies, caching,
  etc.).

Thanks to these skills, the student will be able to develop efficient and robust
applications that can communicate over the network (for example, business
applications, APIs, games, etc.).

## ➡️ Getting started

Do not know where to start? Have a look at the
[Introduction and course organization](./01-introduction-and-course-organization/README.md)!

## 📅 Program

This teaching unit consists of 64 periods. These periods are divided in three
main parts:

- Part 1 - Input/output processing (18 periods)
- Part 2 - Network programming with TCP and UDP (24 periods)
- Part 3 - Network programming with HTTP (20 periods)

The teaching unit is equivalent to three ECTS credits (~75-90 hours of work):

- 64 periods of 45 minutes (= 48 hours in class).
- ~27-42 hours outside of the class.

We try our best to ensure you do not have to work that much outside of the class
but you should expect to spend some time on the course outside of the class.

Details of each course within the teaching unit are available below. Each course
is detailed with content, objectives, teaching and learning methods, and
assessment methods.

Dates are taken from the
[HEIG-VD academic calendar](https://heig-vd.ch/formation/bachelor/calendrier-academique/).

|               Course | Dates                              | Main content for the first two periods   | Main content for the last two periods        | Redaction status[^status] |
| -------------------: | :--------------------------------- | :--------------------------------------- | :------------------------------------------- | :------------------------ |
|    [00](#-course-00) | _Before the start of the semester_ | Set up a Windows development environment | Considerations for a development environment | 🔴 To complete            |
|    [01](#-course-01) | 15.09. - 21.09.25                  | Git, GitHub and Markdown                 | Java, IntelliJ IDEA and Maven                | 🔴 To complete            |
|    [02](#-course-02) | 22.09. - 28.09.25                  | Java IOs                                 | Practical work 1 (1/3)                       | 🔴 To complete            |
|    [03](#-course-03) | 29.09. - 05.10.25                  | Practical work 1 (2/3)                   | Practical work 1 (2/3)                       | 🔴 To complete            |
|    [04](#-course-04) | 06.10. - 12.10.25                  | Docker and Docker Compose                | Practical work 1 (3/3)                       | 🔴 To complete            |
| 🚨 [05](#-course-05) | 13.10. - 19.10.25                  | Presentation of practical work 1         | SMTP and ncat                                | 🔴 To complete            |
|                    - | 20.10. - 26.10.25                  | _No course: interdisciplinary week_      | _No course: interdisciplinary week_          | 🔴 To complete            |
|    [06](#-course-06) | 27.10. - 02.11.25                  | Define an application protocol           | Practical work 2 (1/5)                       | 🔴 To complete            |
|    [07](#-course-07) | 03.11. - 09.11.25                  | Java TCP and UDP programming (1/2)       | Practical work 2 (2/5)                       | 🔴 To complete            |
|    [08](#-course-08) | 10.11. - 16.11.25                  | Java TCP and UDP programming (2/2)       | Practical work 2 (3/5)                       | 🔴 To complete            |
|    [09](#-course-09) | 17.11. - 23.11.25                  | Java network concurrency                 | Practical work 2 (4/5)                       | 🔴 To complete            |
| 🚨 [10](#-course-10) | 24.11. - 30.11.25                  | Evaluation 1                             | Practical work 2 (5/5)                       | 🔴 To complete            |
| 🚨 [11](#-course-11) | 01.12. - 07.12.25                  | Presentation of practical work 2         | SSH and SCP                                  | 🔴 To complete            |
|    [12](#-course-12) | 08.12. - 14.12.25                  | HTTP and curl                            | Practical work 3 (1/4)                       | 🔴 To complete            |
|    [13](#-course-13) | 15.12. - 21.12.25                  | Web infrastructures                      | Practical work 3 (2/4)                       | 🔴 To complete            |
|                    - | 22.12. - 28.12.25                  | _No course: holidays_                    | _No course: holidays_                        | 🔴 To complete            |
|                    - | 29.12. - 04.01.26                  | _No course: holidays_                    | _No course: holidays_                        | 🔴 To complete            |
|    [14](#-course-14) | 05.01. - 11.01.26                  | Caching and performance                  | Practical work 3 (3/4)                       | 🔴 To complete            |
| 🚨 [15](#-course-15) | 12.01. - 18.01.26                  | Evaluation 2                             | Practical work 3 (4/4)                       | 🔴 To complete            |
| 🚨 [16](#-course-16) | 19.01. - 25.01.26                  | Presentation of practical work 3         | Semester review and exam preparation         | 🔴 To complete            |
|                    - | 26.01. - 01.02.26                  | _Exam preparation_                       | _Exam preparation_                           | 🔴 To complete            |
|                    - | 02.02. - 08.02.26                  | _Exam_                                   | _Exam_                                       | 🔴 To complete            |

## 🕛 Course 00

### Set up a Windows development environment

- Guide:
  [Course material](./01-set-up-a-windows-development-environment+considerations-for-a-development-environment/01-set-up-a-windows-development-environment/README.md)

[_See details_](./01-set-up-a-windows-development-environment+considerations-for-a-development-environment/)

### Considerations for a development environment

- Guide:
  [Course material](./01-set-up-a-windows-development-environment+considerations-for-a-development-environment/02-considerations-for-a-development-environment/README.md)

## 🕐 Course 01

[_See details_](./02-git-github-and-markdown+java-intellij-idea-and-maven/)

### Introduction and course organization

- Theory:
  [Course material](./02-git-github-and-markdown+java-intellij-idea-and-maven/01-introduction-and-course-organization/README.md)
  ·
  [Presentation (web)](https://heig-vd-dai-course.github.io/heig-vd-dai-course/01-introduction-and-course-organization/)
  ·
  [Presentation (PDF)](https://heig-vd-dai-course.github.io/heig-vd-dai-course/01-introduction-and-course-organization/01-introduction-and-course-organization-presentation.pdf)

### Introduction to part 1 - Input/output processing

### Git, GitHub and Markdown

- Theory:
  [Course material](./02-git-github-and-markdown+java-intellij-idea-and-maven/01-introduction-and-course-organization/README.md)
  ·
  [Presentation (web)](https://heig-vd-dai-course.github.io/heig-vd-dai-course/01-introduction-and-course-organization/)
  ·
  [Presentation (PDF)](https://heig-vd-dai-course.github.io/heig-vd-dai-course/01-introduction-and-course-organization/01-introduction-and-course-organization-presentation.pdf)

### Java, IntelliJ IDEA and Maven

## 🕑 Course 02

### Java IOs

### Practical work 1 - Input/output processing (1/3)

## 🕒 Course 03

### Practical work 1 - Input/output processing (2/3)

## 🕓 Course 04

### Docker and Docker Compose

### Practical work 1 - Input/output processing (3/3)

## 🕔 Course 05

### Presentation of practical work 1 - Input/output processing

### Conclusion to part 1 - Input/output processing

### Introduction to part 2 - Network programming with TCP and UDP

### SMTP and ncat

## 🕕 Course 06

### Define an application protocol

### Practical work 2 - Network programming with TCP and UDP (1/5)

## 🕖 Course 07

### Java TCP programming

### Practical work 2 - Network programming with TCP and UDP (2/5)

## 🕗 Course 08

### Java UDP programming

### Practical work 2 - Network programming with TCP and UDP (3/5)

## 🕘 Course 09

### Java network concurrency

### Practical work 2 - Network programming with TCP and UDP (4/5)

## 🕙 Course 10

### Evaluation 1 - Input/output processing<br><br>Network programming with TCP and UDP

### Practical work 2 - Network programming with TCP and UDP (5/5)

## 🕚 Course 11

### Presentation of practical work 2 - Network programming with TCP and UDP

### Conclusion to part 2 - Network programming with TCP and UDP

### Introduction to part 3 - Network programming with HTTP

### SSH and SCP

## 🕛 Course 12

### HTTP and curl

### Practical work 3 - Network programming with HTTP (1/4)

## 🕐 Course 13

### Web infrastructures

### Practical work 3 - Network programming with HTTP (2/4)

## 🕑 Course 14

### Caching and performance

### Practical work 3 - Network programming with HTTP (3/4)

## 🕒 Course 15

### Evaluation 2 - Network programming with HTTP

### Practical work 3 - Network programming with HTTP (4/4)

## 🕓 Course 16

### Presentation of practical work 3 - Network programming with HTTP

### Conclusion to part 3 - Network programming with HTTP

### Semester review and exam preparation

## 📜 License

This work is licensed under a
[Creative Commons Attribution-ShareAlike 4.0 International](./LICENSE.md)
license.

## 🤝 Contributing

Contributions are welcome! Please read the
[`CONTRIBUTING.md`](./CONTRIBUTING.md) file for details.

[^status]:
    🟢 Complete: the course is complete and ready for use. 🟡 In progress: the
    course is being written/updated. 🔴 To complete: the course needs to be
    written/updated
