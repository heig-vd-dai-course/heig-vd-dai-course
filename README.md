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

This teaching unit consists of 64 periods, equivalent to three ECTS credits
(~75-90 hours of work):

- 64 periods of 45 minutes (= 48 hours in class).
- ~27-42 hours outside of the class.

These periods are divided in three main parts:

- Part 1 - Input/output processing (18 periods)
- Part 2 - Network programming with TCP and UDP (24 periods)
- Part 3 - Network programming with HTTP (20 periods)

We try our best to ensure you do not have to work that much outside of the class
but you should expect to spend some time on the course outside of the class.

Details of each course within the teaching unit are available below. Each course
is detailed with content, objectives, teaching and learning methods, and
assessment methods.[^program]

Dates are taken from the
[HEIG-VD academic calendar](https://heig-vd.ch/formation/bachelor/calendrier-academique/).

|               Course | Dates                              | Main content for the first two periods   | Main content for the last two periods        | Redaction status[^status] |
| -------------------: | :--------------------------------- | :--------------------------------------- | :------------------------------------------- | :------------------------ |
|    [00](#-course-00) | _Before the start of the semester_ | Set up a Windows development environment | Considerations for a development environment | 🟡 In progress            |
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

### Set up a Windows development environment [🔼 Back to program](#-program)

- Course material:
  [Link to content](./00.01-set-up-a-windows-development-environment/01-course-material/README.md)

[_See details_](./00.01-set-up-a-windows-development-environment/)

### Considerations for a development environment [🔼 Back to program](#-program)

- Course material:
  [Link to content](./00.02-considerations-for-a-development-environment/01-course-material/README.md)

[_See details_](./00.02-considerations-for-a-development-environment/)

## 🕐 Course 01

### Introduction and course organization [🔼 Back to program](#-program)

- Course material:
  [Link to content](./01.01-introduction-and-course-organization/01-course-material/README.md)
- Presentation: [Web](#TODO) · [PDF](#TODO)

[_See details_](./01.01-introduction-and-course-organization/)

### Introduction to part 1 - Input/output processing [🔼 Back to program](#-program)

- Course material:
  [Link to content](./01.02-introduction-to-part-1-input-output-processing/01-course-material/README.md)
- Presentation: [Web](#TODO) · [PDF](#TODO)

[_See details_](./01.02-introduction-to-part-1-input-output-processing/)

### Git, GitHub and Markdown [🔼 Back to program](#-program)

- Course material:
  [Link to content](./01.03-git-github-and-markdown/01-course-material/README.md)
- Presentation: [Web](#TODO) · [PDF](#TODO)

[_See details_](./01.03-git-github-and-markdown/)

### Java, IntelliJ IDEA and Maven [🔼 Back to program](#-program)

- Course material:
  [Link to content](./01.04-java-intellij-idea-and-maven/01-course-material/README.md)
- Presentation: [Web](#TODO) · [PDF](#TODO)
- Code examples:
  [Link to content](./01.04-java-intellij-idea-and-maven/02-code-examples/README.md)
- Solution:
  [Link to content](./01.04-java-intellij-idea-and-maven/03-solution/README.md)

[_See details_](./01.04-java-intellij-idea-and-maven/)

## 🕑 Course 02

### Java IOs

- Course material:
  [Link to content](./02.01-java-ios/01-course-material/README.md)
- Presentation: [Web](#TODO) · [PDF](#TODO)
- Code examples: [Link to content](./02.01-java-ios/02-code-examples/README.md)
- Solution: [Link to content](./02.01-java-ios/03-solution/README.md)

[_See details_](./02.01-java-ios/)

### Practical work 1 (1/3) [🔼 Back to program](#-program)

- Course material:
  [Link to content](<./02.02-practical-work-1-(1-of-3)/01-course-material/README.md>)
- Presentation: [Web](#TODO) · [PDF](#TODO)

[_See details_](<./02.02-practical-work-1-(1-of-3)/>)

## 🕒 Course 03

### Practical work 1 (2/3) [🔼 Back to program](#-program)

- Course material:
  [Link to content](<./03.01-practical-work-1-(2-of-3)/01-course-material/README.md>)
- Presentation: [Web](#TODO) · [PDF](#TODO)

[_See details_](<./03.01-practical-work-1-(2-of-3)/>)

## 🕓 Course 04

### Docker and Docker Compose [🔼 Back to program](#-program)

- Course material:
  [Link to content](./04.01-docker-and-docker-compose/01-course-material/README.md)
- Presentation: [Web](#TODO) · [PDF](#TODO)
- Code examples:
  [Link to content](./04.01-docker-and-docker-compose/02-code-examples/README.md)
- Solution:
  [Link to content](./04.01-docker-and-docker-compose/03-solution/README.md)

[_See details_](./04.01-docker-and-docker-compose/)

### Practical work 1 (3/3) [🔼 Back to program](#-program)

- Course material:
  [Link to content](<./04.02-practical-work-1-(3-of-3)/01-course-material/README.md>)
- Presentation: [Web](#TODO) · [PDF](#TODO)

[_See details_](<./04.02-practical-work-1-(3-of-3)/>)

## 🕔 Course 05

### Presentation of practical work 1 [🔼 Back to program](#-program)

- **🚨 Graded evaluation**
- Course material:
  [Link to content](./05.01-presentation-of-practical-work-1/01-course-material/README.md)
- Presentation: [Web](#TODO) · [PDF](#TODO)

[_See details_](./05.01-presentation-of-practical-work-1/)

### Conclusion to part 1 - Input/output processing [🔼 Back to program](#-program)

- Course material:
  [Link to content](./05.02-conclusion-to-part-1-input-output-processing/01-course-material/README.md)
- Presentation: [Web](#TODO) · [PDF](#TODO)

[_See details_](./05.02-conclusion-to-part-1-input-output-processing/)

### Introduction to part 2 - Network programming with TCP and UDP [🔼 Back to program](#-program)

- Course material:
  [Link to content](./05.03-introduction-to-part-2-network-programming-with-tcp-and-udp/01-course-material/README.md)
- Presentation: [Web](#TODO) · [PDF](#TODO)

[_See details_](./05.03-introduction-to-part-2-network-programming-with-tcp-and-udp/)

### SMTP and ncat [🔼 Back to program](#-program)

- Course material:
  [Link to content](./05.04-smtp-and-ncat/01-course-material/README.md)
- Presentation: [Web](#TODO) · [PDF](#TODO)
- Code examples:
  [Link to content](./05.04-smtp-and-ncat/02-code-examples/README.md)
- Solution: [Link to content](./05.04-smtp-and-ncat/03-solution/README.md)

[_See details_](./05.04-smtp-and-ncat/)

## 🕕 Course 06

### Define an application protocol [🔼 Back to program](#-program)

- Course material:
  [Link to content](./06.01-define-an-application-protocol/01-course-material/README.md)
- Presentation: [Web](#TODO) · [PDF](#TODO)
- Code examples:
  [Link to content](./06.01-define-an-application-protocol/02-code-examples/README.md)
- Solution:
  [Link to content](./06.01-define-an-application-protocol/03-solution/README.md)

[_See details_](./06.01-define-an-application-protocol/)

### Practical work 2 (1/5) [🔼 Back to program](#-program)

- Course material:
  [Link to content](<./06.02-practical-work-2-(1-of-5)/01-course-material/README.md>)
- Presentation: [Web](#TODO) · [PDF](#TODO)

[_See details_](<./06.02-practical-work-2-(1-of-5)/>)

## 🕖 Course 07

### Java TCP and UDP programming [🔼 Back to program](#-program)

- Course material:
  [Link to content](<./07.01-java-tcp-and-udp-programming-(1-of-2)/01-course-material/README.md>)
- Presentation: [Web](#TODO) · [PDF](#TODO)
- Code examples:
  [Link to content](<./07.01-java-tcp-and-udp-programming-(1-of-2)/02-code-examples/README.md>)
- Solution:
  [Link to content](<./07.01-java-tcp-and-udp-programming-(1-of-2)/03-solution/README.md>)

[_See details_](<./07.01-java-tcp-and-udp-programming-(1-of-2)/>)

### Practical work 2 (2/5) [🔼 Back to program](#-program)

- Course material:
  [Link to content](<./07.02-practical-work-2-(2-of-5)/01-course-material/README.md>)
- Presentation: [Web](#TODO) · [PDF](#TODO)

[_See details_](<./07.02-practical-work-2-(2-of-5)/>)

## 🕗 Course 08

### Java TCP and UDP programming [🔼 Back to program](#-program)

- Course material:
  [Link to content](<./08.01-java-tcp-and-udp-programming-(2-of-2)/01-course-material/README.md>)
- Presentation: [Web](#TODO) · [PDF](#TODO)
- Code examples:
  [Link to content](<./08.01-java-tcp-and-udp-programming-(2-of-2)/02-code-examples/README.md>)
- Solution:
  [Link to content](<./08.01-java-tcp-and-udp-programming-(2-of-2)/03-solution/README.md>)

[_See details_](<./08.01-java-tcp-and-udp-programming-(2-of-2)/>)

### Practical work 2 (3/5) [🔼 Back to program](#-program)

- Course material:
  [Link to content](<./08.02-practical-work-2-(3-of-5)/01-course-material/README.md>)
- Presentation: [Web](#TODO) · [PDF](#TODO)

[_See details_](<./08.02-practical-work-2-(3-of-5)/>)

## 🕘 Course 09

### Java network concurrency [🔼 Back to program](#-program)

- Course material:
  [Link to content](./09.01-java-network-concurrency/01-course-material/README.md)
- Presentation: [Web](#TODO) · [PDF](#TODO)
- Code examples:
  [Link to content](./09.01-java-network-concurrency/02-code-examples/README.md)
- Solution:
  [Link to content](./09.01-java-network-concurrency/03-solution/README.md)

[_See details_](./09.01-java-network-concurrency/)

### Practical work 2 (4/5) [🔼 Back to program](#-program)

- Course material:
  [Link to content](<./09.02-practical-work-2-(4-of-5)/01-course-material/README.md>)
- Presentation: [Web](#TODO) · [PDF](#TODO)

[_See details_](<./09.02-practical-work-2-(4-of-5)/>)

## 🕙 Course 10

### Evaluation 1 [🔼 Back to program](#-program)

- **🚨 Graded evaluation**
- Course material:
  [Link to content](./10.01-evaluation-1/01-course-material/README.md)
- Presentation: [Web](#TODO) · [PDF](#TODO)
- Archives: [Link to content](./10.01-evaluation-1/02-archives/README.md)

[_See details_](./10.01-evaluation-1/)

### Practical work 2 (5/5) [🔼 Back to program](#-program)

- Course material:
  [Link to content](<./10.02-practical-work-2-(5-of-5)/01-course-material/README.md>)
- Presentation: [Web](#TODO) · [PDF](#TODO)

[_See details_](<./10.02-practical-work-2-(5-of-5)/>)

## 🕚 Course 11

### Presentation of practical work 2 [🔼 Back to program](#-program)

- **🚨 Graded evaluation**
- Course material:
  [Link to content](./11.01-presentation-of-practical-work-2/01-course-material/README.md)
- Presentation: [Web](#TODO) · [PDF](#TODO)

[_See details_](./11.01-presentation-of-practical-work-2/)

### Conclusion to part 2 - Network programming with TCP and UDP [🔼 Back to program](#-program)

- Course material:
  [Link to content](./11.02-conclusion-to-part-2-network-programming-with-tcp-and-udp/01-course-material/README.md)
- Presentation: [Web](#TODO) · [PDF](#TODO)

[_See details_](./11.02-conclusion-to-part-2-network-programming-with-tcp-and-udp/)

### Introduction to part 3 - Network programming with HTTP [🔼 Back to program](#-program)

- Course material:
  [Link to content](./11.03-introduction-to-part-3-network-programming-with-http/01-course-material/README.md)
- Presentation: [Web](#TODO) · [PDF](#TODO)

[_See details_](./11.03-introduction-to-part-3-network-programming-with-http/)

### SSH and SCP [🔼 Back to program](#-program)

- Course material:
  [Link to content](./11.04-ssh-and-scp/01-course-material/README.md)
- Presentation: [Web](#TODO) · [PDF](#TODO)

[_See details_](./11.04-ssh-and-scp/)

## 🕛 Course 12

### HTTP and curl [🔼 Back to program](#-program)

- Course material:
  [Link to content](./12.01-http-and-curl/01-course-material/README.md)
- Presentation: [Web](#TODO) · [PDF](#TODO)
- Solution: [Link to content](./12.01-http-and-curl/02-solution/README.md)

[_See details_](./12.01-http-and-curl/)

### Practical work 3 (1/4) [🔼 Back to program](#-program)

- Course material:
  [Link to content](<./12.02-practical-work-3-(1-of-4)/01-course-material/README.md>)
- Presentation: [Web](#TODO) · [PDF](#TODO)

[_See details_](<./12.02-practical-work-3-(1-of-4)/>)

## 🕐 Course 13

### Web infrastructures [🔼 Back to program](#-program)

- Course material:
  [Link to content](./13.01-web-infrastructures/01-course-material/README.md)
- Presentation: [Web](#TODO) · [PDF](#TODO)
- Code examples:
  [Link to content](./13.01-web-infrastructures/02-code-examples/README.md)

[_See details_](./13.01-web-infrastructures/)

### Practical work 3 (2/4) [🔼 Back to program](#-program)

- Course material:
  [Link to content](<./13.02-practical-work-3-(2-of-4)/01-course-material/README.md>)
- Presentation: [Web](#TODO) · [PDF](#TODO)

[_See details_](<./13.02-practical-work-3-(2-of-4)/>)

## 🕑 Course 14

### Caching and performance [🔼 Back to program](#-program)

- Course material:
  [Link to content](./14.01-caching-and-performance/01-course-material/README.md)
- Presentation: [Web](#TODO) · [PDF](#TODO)
- Solution:
  [Link to content](./14.01-caching-and-performance/02-solution/README.md)

[_See details_](./14.01-caching-and-performance/)

### Practical work 3 (3/4) [🔼 Back to program](#-program)

- Course material:
  [Link to content](<./14.02-practical-work-3-(3-of-4)/01-course-material/README.md>)
- Presentation: [Web](#TODO) · [PDF](#TODO)

[_See details_](<./14.02-practical-work-3-(3-of-4)/>)

## 🕒 Course 15

### Evaluation 2 [🔼 Back to program](#-program)

- **🚨 Graded evaluation**
- Course material:
  [Link to content](./15.01-evaluation-2/01-course-material/README.md)
- Presentation: [Web](#TODO) · [PDF](#TODO)
- Archives: [Link to content](./15.01-evaluation-2/02-archives/README.md)

[_See details_](./15.01-evaluation-2/)

### Practical work 3 (4/4) [🔼 Back to program](#-program)

- Course material:
  [Link to content](<./15.02-practical-work-3-(4-of-4)/01-course-material/README.md>)
- Presentation: [Web](#TODO) · [PDF](#TODO)

[_See details_](<./15.02-practical-work-3-(4-of-4)/>)

## 🕓 Course 16

### Presentation of practical work 3 [🔼 Back to program](#-program)

- **🚨 Graded evaluation**
- Course material:
  [Link to content](./16.01-presentation-of-practical-work-3/01-course-material/README.md)
- Presentation: [Web](#TODO) · [PDF](#TODO)

[_See details_](./16.01-presentation-of-practical-work-3/)

### Conclusion to part 3 - Network programming with HTTP [🔼 Back to program](#-program)

- Course material:
  [Link to content](./16.02-conclusion-to-part-3-network-programming-with-http/01-course-material/README.md)
- Presentation: [Web](#TODO) · [PDF](#TODO)

[_See details_](./16.02-conclusion-to-part-3-network-programming-with-http/)

### Semester review and exam preparation <small>[🔼 Back to program](#-program)</small>

- Course material:
  [Link to content](./16.03-semester-review-and-exam-preparation/01-course-material/README.md)
- Presentation: [Web](#TODO) · [PDF](#TODO)
- Feedback (Framaforms + GAPS):
  [Link to content](./16.03-semester-review-and-exam-preparation/02-feedback/README.md)

[_See details_](./16.03-semester-review-and-exam-preparation/)

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

[^program]:
    The program is subject to change. We will do our best to inform you in
    advance if there are any changes.
