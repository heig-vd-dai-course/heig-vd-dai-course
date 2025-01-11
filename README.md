# HEIG-VD DAI Course [![License](https://img.shields.io/github/license/heig-vd-dai-course/heig-vd-dai-course)](./LICENSE.md)

The main repository to the
[Développement d'applications internet (DAI) course](https://gaps.heig-vd.ch/consultation/fiches/uv/uv.php?id=6573)
at [HEIG-VD](https://heig-vd.ch), Switzerland!

## Getting started

Do not know where to start? Have a look at the
[Introduction and course organization](./01-introduction-and-course-organization/README.md)!

## Course planning and material

This course is equivalent to 3 ECTS credits (= ~75-90 hours of work):

- 48 hours in class (= 64 periods of 45 minutes)
- ~27-42 hours outside of the class - we try our best to ensure you do not have
  to work that much outside of the class

64 periods in class are planned for this course, divided in 3 main parts:

- Part 1 - Input/output processing (18 periods)
- Part 2 - Network programming with TCP and UDP (24 periods)
- Part 3 - Network programming with HTTP (20 periods)

The following table displays the course planning. It is subject to change. The
week numbers are taken from the
[_"HEIG-VD Calendrier académique"_](https://heig-vd.ch/formation/bachelor/calendrier-academique/).

| Week                      | Course                                                                                                                                                                                                                                                                                                                           | Practical work                                               |
| :------------------------ | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | :----------------------------------------------------------- |
| _To do before the course_ | _Considerations for a development environment_                                                                                                                                                                                                                                                                                   | _Set up a Windows development environment_                   |
| 1                         | [Introduction and course organization](./01-introduction-and-course-organization/README.md)<br><br>[Introduction to part 1](./02-introduction-to-part-1/README.md)<br><br>[Git, GitHub and Markdown](./03-git-github-and-markdown/README.md)<br><br>[Java, IntelliJ IDEA and Maven](./04-java-intellij-idea-and-maven/README.md) | _No practical work_                                          |
| 2                         | [Java IOs](./05-java-ios/README.md)                                                                                                                                                                                                                                                                                              | [Practical work 1 (1/4)](./07-practical-work-1/README.md)    |
| 3                         | [Docker and Docker Compose](./06-docker-and-docker-compose/README.md)                                                                                                                                                                                                                                                            | [Practical work 1 (2/4)](./07-practical-work-1/README.md)    |
| 4                         | 🚨 [Evaluation 1](./08-evaluation-1/README.md)                                                                                                                                                                                                                                                                                   | [Practical work 1 (3/4)](./07-practical-work-1/README.md)    |
| 5                         | [Conclusion to part 1](./09-conclusion-to-part-1/README.md)<br><br>[Introduction to part 2](./10-introduction-to-part-2/README.md)<br><br>[SMTP and ncat](./15-smtp-and-ncat/README.md)                                                                                                                                          | 🚨 [Practical work 1 (4/4)](./07-practical-work-1/README.md) |
| _Interdisciplinary week_  | _No course_                                                                                                                                                                                                                                                                                                                      | _No practical work_                                          |
| 6                         | [Define an application protocol](./11-define-an-application-protocol/README.md)                                                                                                                                                                                                                                                  | [Practical work 2 (1/6)](./16-practical-work-2/README.md)    |
| 7                         | [Java TCP programming](./12-java-tcp-programming/README.md)<br><br>[Java UDP programming](./13-java-udp-programming/README.md)                                                                                                                                                                                                   | [Practical work 2 (2/6)](./16-practical-work-2/README.md)    |
| 8                         | _No course_                                                                                                                                                                                                                                                                                                                      | [Practical work 2 (3/6)](./16-practical-work-2/README.md)    |
| 9                         | [Java network concurrency](./14-java-network-concurrency/README.md)                                                                                                                                                                                                                                                              | [Practical work 2 (4/6)](./16-practical-work-2/README.md)    |
| 10                        | 🚨 [Evaluation 2](./17-evaluation-2/README.md)                                                                                                                                                                                                                                                                                   | [Practical work 2 (5/6)](./16-practical-work-2/README.md)    |
| 11                        | [Conclusion to part 2](./18-conclusion-to-part-2/README.md)<br><br>[Introduction to part 3](./19-introduction-to-part-3/README.md)<br><br>[SSH and SCP](./20-ssh-and-scp/README.md)                                                                                                                                              | 🚨 [Practical work 2 (6/6)](./16-practical-work-2/README.md) |
| 12                        | [HTTP and curl](./21-http-and-curl/README.md)                                                                                                                                                                                                                                                                                    | [Practical work 3 (1/5)](./24-practical-work-3/README.md)    |
| 13                        | [Web infrastructures](./22-web-infrastructures/README.md)                                                                                                                                                                                                                                                                        | [Practical work 3 (2/5)](./24-practical-work-3/README.md)    |
| _Holidays_                | _No course_                                                                                                                                                                                                                                                                                                                      | _No practical work_                                          |
| _Holidays_                | _No course_                                                                                                                                                                                                                                                                                                                      | _No practical work_                                          |
| 14                        | [Caching and performance](./23-caching-and-performance/README.md)                                                                                                                                                                                                                                                                | [Practical work 3 (3/5)](./24-practical-work-3/README.md)    |
| 15                        | 🚨 [Evaluation 3](./25-evaluation-3/README.md)                                                                                                                                                                                                                                                                                   | [Practical work 3 (4/5)](./24-practical-work-3/README.md)    |
| 16                        | [Semester review and exam preparation](./27-semester-review-and-exam-preparation/README.md)                                                                                                                                                                                                                                      | 🚨 [Practical work 3 (5/5)](./24-practical-work-3/README.md) |
| _Exam preparation_        | _No course_                                                                                                                                                                                                                                                                                                                      | _No practical work_                                          |
| _Exam_                    | _No course_                                                                                                                                                                                                                                                                                                                      | _No practical work_                                          |

### Introduction

- [1. Introduction and course organization](./01-introduction-and-course-organization/README.md)

### Part 1 - Input/output processing (18 periods)

- [2. Introduction to part 1](./02-introduction-to-part-1/README.md)
- [3. Git, GitHub and Markdown (2 periods)](./03-git-github-and-markdown/README.md)
- [4. Java, IntelliJ IDEA and Maven (2 periods)](./04-java-intellij-idea-and-maven/README.md)
- [5. Java IOs (2 periods)](./05-java-ios/README.md)
- [6. Docker and Docker Compose (2 periods)](./06-docker-and-docker-compose/README.md)
- [7. Practical work 1 (8 periods)](./07-practical-work-1/README.md)
- [8. Evaluation 1 (2 periods)](./08-evaluation-1/README.md)
- [9. Conclusion to part 1](./09-conclusion-to-part-1/README.md)

### Part 2 - Network programming with TCP and UDP (24 periods)

- [10. Introduction to part 2](./10-introduction-to-part-2/README.md)
- [11. Define an application protocol (2 periods)](./11-define-an-application-protocol/README.md)
- [12. Java TCP programming (2 periods)](./12-java-tcp-programming/README.md)
- [13. Java UDP programming (2 periods)](./13-java-udp-programming/README.md)
- [14. Java network concurrency (2 periods)](./14-java-network-concurrency/README.md)
- [15. SMTP and ncat (2 periods)](./15-smtp-and-ncat/README.md)
- [16. Practical work 2 (12 periods)](./16-practical-work-2/README.md)
- [17. Evaluation 2 (2 periods)](./17-evaluation-2/README.md)
- [18. Conclusion to part 2](./18-conclusion-to-part-2/README.md)

### Part 3 - Network programming with HTTP (20 periods)

- [19. Introduction to part 3](./19-introduction-to-part-3/README.md)
- [20. SSH and SCP (2 periods)](./20-ssh-and-scp/README.md)
- [21. HTTP and curl (2 periods)](./21-http-and-curl/README.md)
- [22. Web infrastructures (2 periods)](./22-web-infrastructures/README.md)
- [23. Caching and performance (2 periods)](./23-caching-and-performance/README.md)
- [24. Practical work 3 (10 periods)](./24-practical-work-3/README.md)
- [25. Evaluation 3 (2 periods)](./25-evaluation-3/README.md)
- [26. Conclusion to part 3](./26-conclusion-to-part-3/README.md)

### Conclusion (2 periods)

- [27. Semester review and exam preparation (2 periods)](./27-semester-review-and-exam-preparation/README.md)

## GitHub Discussions

GitHub Discussions are available at
<https://github.com/orgs/heig-vd-dai-course/discussions>.

## GitHub Teams

GitHub Teams are available at
<https://github.com/orgs/heig-vd-dai-course/teams>. The following teams are
available:

- Teaching staff (teachers and assistants)
- Students (all students)
- Old members (people who have completed the course)

## License

This work is licensed under a
[Creative Commons Attribution-ShareAlike 4.0 International](./LICENSE.md)
license.

## Contributing

Contributions are welcome! Please read the
[`CONTRIBUTING.md`](./CONTRIBUTING.md) file for details.
