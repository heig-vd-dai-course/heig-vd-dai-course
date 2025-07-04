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

## 📅 Calendar

This teaching unit is equivalent to three ECTS credits (~75-90 hours of work):

- 48 hours in class (= 64 periods of 45 minutes).
- ~27-42 hours outside of the class - we try our best to ensure you do not have
  to work that much outside of the class.

64 periods in class are planned for this course, divided in three main parts:

- Part 1 - Input/output processing (18 periods)
- Part 2 - Network programming with TCP and UDP (24 periods)
- Part 3 - Network programming with HTTP (20 periods)

Details of each course within the teaching unit are available below. Each course
is detailed with content, objectives, teaching and learning methods, and
assessment methods.

The week numbers are taken from the
[_"HEIG-VD Calendrier académique"_](https://heig-vd.ch/formation/bachelor/calendrier-academique/).

| Week                                              | Content(s)                                                                                                                                                                                               | Redaction status[^redaction-status] |
| :------------------------------------------------ | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | :---------------------------------- |
| [_Before the start of the semester_](#-course-00) | Set up a Windows development environment + Considerations for a development environment                                                                                                                  | 🔴 To do                            |
| [1 (15.09. - 21.09.25)](#-course-01)              | Introduction and course organization + Introduction to part 1 - Input/output processing + Git, GitHub and Markdown + Java, IntelliJ IDEA and Maven                                                       | 🔴 To do                            |
| [2 (22.09. - 28.09.25)](#-course-02)              | Java IOs + Practical work 1 - Input/output processing (1/3)                                                                                                                                              | 🔴 To do                            |
| [3 (29.09. - 05.10.25)](#-course-03)              | Practical work 1 - Input/output processing (2/3)                                                                                                                                                         | 🔴 To do                            |
| [4 (06.10. - 12.10.25)](#-course-04)              | Docker and Docker Compose + Practical work 1 - Input/output processing (3/3)                                                                                                                             | 🔴 To do                            |
| 🚨 [5 (13.10. - 19.10.25)](#-course-05)           | Presentation of practical work 1 - Input/output processing + Conclusion to part 1 - Input/output processing + Introduction to part 2 - Network programming with TCP and UDP + SMTP and ncat              | 🔴 To do                            |
| _Interdisciplinary week - 20.10. - 26.10.25_      | -                                                                                                                                                                                                        | 🔴 To do                            |
| [6 (27.10. - 02.11.25)](#-course-06)              | Define an application protocol + Practical work 2 - Network programming with TCP and UDP (1/5)                                                                                                           | 🔴 To do                            |
| [7 (03.11. - 09.11.25)](#-course-07)              | Java TCP programming + Practical work 2 - Network programming with TCP and UDP (2/5)                                                                                                                     | 🔴 To do                            |
| [8 (10.11. - 16.11.25)](#-course-08)              | Java UDP programming + Practical work 2 - Network programming with TCP and UDP (3/5)                                                                                                                     | 🔴 To do                            |
| [9 (17.11. - 23.11.25)](#-course-09)              | Java network concurrency + Practical work 2 - Network programming with TCP and UDP                                                                                                                       | 🔴 To do                            |
| 🚨 [10 (24.11. - 30.11.25)](#-course-10)          | Evaluation 1 - Input/output processing + Network programming with TCP and UDP + Practical work 2 - Network programming with TCP and UDP (5/5)                                                            | 🔴 To do                            |
| 🚨 [11 (01.12. - 07.12.25)](#-course-11)          | Presentation of practical work 2 - Network programming with TCP and UDP + Conclusion to part 2 - Network programming with TCP and UDP + Introduction to part 3 - Network programming with HTTP + SSH a + | 🔴 To do                            |
| [12 (08.12. - 14.12.25)](#-course-12)             | HTTP and curl + Practical work 3 - Network programming with HTTP (1/4)                                                                                                                                   | 🔴 To do                            |
| [13 (15.12. - 21.12.25)](#-course-13)             | Web infrastructures + Practical work 3 - Network programming with HTTP (2/4)                                                                                                                             | 🔴 To do                            |
| _Holidays (22.12. - 28.12.25)_                    | -                                                                                                                                                                                                        | 🔴 To do                            |
| _Holidays (29.12. - 04.01.26)_                    | -                                                                                                                                                                                                        | 🔴 To do                            |
| [14 (05.01. - 11.01.26)](#-course-14)             | Caching and performance + Practical work 3 - Network programming with HTTP (3/4)                                                                                                                         | 🔴 To do                            |
| 🚨 [15 (12.01. - 18.01.26)](#-course-15)          | Evaluation 2 - Network programming with HTTP + Practical work 3 - Network programming with HTTP (4/4)                                                                                                    | 🔴 To do                            |
| 🚨 [16 (19.01. - 25.01.26)](#-course-16)          | Presentation of practical work 3 - Network programming with HTTP + Conclusion to part 3 - Network programming with HTTP + Semester review and exam preparation                                           | 🔴 To do                            |
| _Exam preparation (26.01. - 01.02.26)_            | -                                                                                                                                                                                                        | 🔴 To do                            |
| _Exam (02.02. - 08.02.26)_                        | -                                                                                                                                                                                                        | 🔴 To do                            |

## 🕛 Course 00

### Set up a Windows development environment

### Considerations for a development environment

## 🕐 Course 01

### Introduction and course organization

### Introduction to part 1 - Input/output processing

### Git, GitHub and Markdown

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

### Evaluation 1 - Input/output processing + Network programming with TCP and UDP

### Practical work 2 - Network programming with TCP and UDP (5/5)

## 🕚 Course 11

### Presentation of practical work 2 - Network programming with TCP and UDP

### Conclusion to part 2 - Network programming with TCP and UDP

### Introduction to part 3 - Network programming with HTTP

### SSH and SCP

## 🕛 Course 12

### HTTP and curl

### Practical work 3 - Network programming with HTTP (1/4)

## 🕜 Course 13

### Web infrastructures

### Practical work 3 - Network programming with HTTP (2/4)

## 🕝 Course 14

### Caching and performance

### Practical work 3 - Network programming with HTTP (3/4)

## 🕞 Course 15

### Evaluation 2 - Network programming with HTTP

### Practical work 3 - Network programming with HTTP (4/4)

## 🕟 Course 16

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

[^redaction-status]:

🟢 Complete: the course is complete and ready for use. 🟡 In progress: the
course is being written/updated. 🔴 To do: the course has not yet been written.
