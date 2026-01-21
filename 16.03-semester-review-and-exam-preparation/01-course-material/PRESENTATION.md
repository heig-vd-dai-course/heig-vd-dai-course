---
marp: true
---

<!--
theme: custom-marp-theme
size: 16:9
paginate: true
author: L. Delafontaine and H. Louis, with the help of GitHub Copilot
title: HEIG-VD DAI - Semester review and exam preparation
description: Semester review and exam preparation for the DAI course at HEIG-VD, Switzerland
header: '[**Semester review and exam preparation**](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/16.03-semester-review-and-exam-preparation)'
footer: '[**HEIG-VD**](https://heig-vd.ch) - [DAI 2025-2026](https://github.com/heig-vd-dai-course/heig-vd-dai-course) - [CC BY-SA 4.0](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md)'
headingDivider: 6
-->

# Semester review and exam preparation

<!--
_class: lead
_paginate: false
-->

[Link to the course][course]

<small>L. Delafontaine and H. Louis, with the help of
[GitHub Copilot](https://github.com/features/copilot).</small>

<small>This work is licensed under the [CC BY-SA 4.0][license] license.</small>

![bg opacity:0.1][illustration]

## Semester review

<!-- _class: lead -->

You made it! Congratulations! 🎉

### Retrospective

<!-- _class: lead -->

Let's have a look back on what **you** did during this semester.

---

> You will learn the following topics during this teaching unit:
>
> - Network programming (inputs/outputs, encodings, TCP and UDP).
> - Application-level protocols (SMTP, SSH, HTTP, and your own).
> - Web infrastructures (reverse proxy, load balancer, sticky sessions).
> - How to read and write technical documentation.
>
> At the end of the course, you will be able to create applications that can
> communicate over the network (for example, business applications, APIs, games,
> etc.)!

---

> You will learn the following technologies during this course:
>
> - Git and GitHub.
> - Markdown.
> - Java for network programming.
> - Docker & Docker Compose.
> - Network utilities.
> - The terminal. :heart:

![bg right:40%](https://images.unsplash.com/photo-1530124566582-a618bc2615dc?fit=crop&h=720)

### Introduction to the teaching unit

<!--
_class: lead
_paginate: false
-->

Set up a Windows development environment <br>+<br> Considerations for a
development environment

[Find this course on GitHub](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/01.01-introduction-to-the-teaching-unit)

**This course will not be in the exam!**

![bg opacity:0.1](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/01.01-introduction-to-the-teaching-unit/01-course-material/images/main-illustration.jpg?raw=true)

#### Key points to remember for this course

- Setting up a professional development environment can really help you be more
  efficient.
- You have gained valuable Linux experience using WSL.
- For us, the usage of WSL was really positive:
  - Less bugs/edge-cases.
  - Easy access to UNIX tools.
- While not always easy to setup, you did very well to use it efficiently.

#### Elements to improve for next year

- Nothing much to improve in our opinion. Do you agree?

We would like to push these recommandations/tools in the very first weeks of
your studies so you can use these tools from the beginning and in all teaching
units. We will see if it is possible.

### Part 1: Input/output processing

<!--
_class: lead
_paginate: false
-->

![bg opacity:0.1](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/01.02-introduction-to-part-1-input-output-processing/01-course-material/images/main-illustration.jpg?raw=true)

#### Git, GitHub and Markdown

<!--
_class: lead
_paginate: false
-->

[Find this course on GitHub](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/01.03-git-github-and-markdown)

![bg opacity:0.1](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/01.03-git-github-and-markdown/01-course-material/images/main-illustration.jpg?raw=true)

##### Key points to remember for this course

0. Set up your Git environment with SSH and signed commits.
1. Open an issue to discuss the feature (written in Markdown).
2. Clone or fork the project with SSH and checkout to a new branch.
3. Make your changes, commit and push them as often as you want.
4. Resolve conflicts if any.
5. Create the pull request and add details if needed.
6. Other members review and approve if everything is OK.
7. The work is merged and you can delete the branch or the fork.

##### Elements to improve for next year

- Reorganize the course to have a better flow..? But then, we might not enough
  time for the practical work and Java IOs...

|     |                               |                                |
| --: | :---------------------------- | :----------------------------- |
|  01 | Git, GitHub and Markdown      | Practical work 1 (1/5)         |
|  02 | Java, IntelliJ IDEA and Maven | Practical work 1 (2/5)         |
|  03 | Java IOs                      | Practical work 1 (3/5)         |
|  04 | Docker and Docker Compose     | Practical work 1 (4/5)         |
|  05 | SMTP and ncat                 | Practical work 1 (5/5) - Pres. |

#### Java, IntelliJ IDEA and Maven

<!--
_class: lead
_paginate: false
-->

[Find this course on GitHub](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/01.04-java-intellij-idea-and-maven)

![bg opacity:0.1](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/01.04-java-intellij-idea-and-maven/01-course-material/images/main-illustration.jpg?raw=true)

##### Key points to remember for this course

- Java and the JVM.
- Maven as a build tool:
  - `pom.xml` file.
  - Plugins vs. dependencies.
- Sharing code with Git and GitHub:
  - `.gitignore` files.
  - IntelliJ IDEA (and IDEs in general) configuration files.
- Managing multiple versions of Java/dependencies with SDKMAN!.

##### Elements to improve for next year

- Nothing much to improve in our opinion. Do you agree?

#### Java IOs

<!--
_class: lead
_paginate: false
-->

[Find this course on GitHub](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/02.01-java-ios)

![bg opacity:0.1](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/02.01-java-ios/01-course-material/images/main-illustration.jpg?raw=true)

##### Key points to remember for this course

- Java IOs classes and use cases (text files vs. binary files).
- Those 🤬 charset encodings (Unicode vs. UTF-8 vs. other charsets).
- Buffering and flushing.
- End of line characters (`\n`, `\r`, `\r\n`, etc.).
- Dealing with exceptions (try-with-resources, etc.).

You **should always specify encodings and end of line characters explicitly** as
the defaults are dependent on the platform your code is running on. Marking them
explicitly will make your code **portable**.

##### Elements to improve for next year

- It seems to us that the practical content for this course was hard to grasp
  for some people, mainly regarding picocli.
- The practical content of the course
  [Java, IntelliJ IDEA and Maven](#java-intellij-idea-and-maven) was supposed to
  give you all the elements needed to understand picocli.
- From our point of view, everything was there but maybe not clear enough.
- Do you have any feedback on how we could improve this point?

#### Docker and Docker Compose

<!--
_class: lead
_paginate: false
-->

[Find this course on GitHub](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/04.01-docker-and-docker-compose)

![bg opacity:0.1](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/04.01-docker-and-docker-compose/01-course-material/images/main-illustration.jpg?raw=true)

##### Key points to remember for this course

- Differences between bare-metal vs. virtualization vs. containerization.
- Docker as a containerization tool:
  - Images.
  - Containers.
  - Registries.
  - Dockerfile files.
- Docker Compose as a tool to manage multiple containers through Compose files.

##### Elements to improve for next year

It is still a quite difficult and abstract course to teach. We did try our best
to give you all the elements needed to understand this topic incrementally so
you would not be overwhelmed.

#### Practical work 1

<!--
_class: lead
_paginate: false
-->

[Find this practical work on GitHub](<https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/02.02-practical-work-1-(1-of-5)>)

![bg opacity:0.1](<https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/02.02-practical-work-1-(1-of-5)/01-course-material/images/main-illustration.jpg?raw=true>)

##### What you were ask to do

- A CLI to process files.
- Use Java, Maven and [picocli](https://picocli.info/).
- You can choose what the CLI will do.
- Practice a professional Git workflow and publish your CLI on GitHub for others
  to discover and use.

We have seen some very interesting projects! Caesar cipher, image processing,
JSON-XML convertor, etc.

Do not hesitate to share your project and to continue to work on it!

##### Elements to improve for next year

- Nothing much to improve in our opinion. Do you agree?

### Part 2: Network programming with TCP and UDP

<!--
_class: lead
_paginate: false
-->

![bg opacity:0.1](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/05.02-introduction-to-part-2-network-programming-with-tcp-and-udp/01-course-material/images/main-illustration.jpg?raw=true)

#### SMTP and ncat

<!--
_class: lead
_paginate: false
-->

[Find this course on GitHub](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/05.03-smtp-and-ncat)

![bg opacity:0.1](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/05.03-smtp-and-ncat/01-course-material/images/main-illustration.jpg?raw=true)

##### Key points to remember for this course

- Differences between SMTP, POP3 and IMAP.
- SMTP security concerns.
- How is an email sent and received from one client to another through multiple
  SMTP servers.
- Using a SMTP mock server to test your email invoices without sending real
  emails.

##### Elements to improve for next year

- Nothing much to improve in our opinion. Do you agree?

#### Define an application protocol

<!--
_class: lead
_paginate: false
-->

[Find this course on GitHub](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/06.01-define-an-application-protocol)

![bg opacity:0.1](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/05.02-introduction-to-part-2-network-programming-with-tcp-and-udp/01-course-material/images/main-illustration.jpg?raw=true)

##### Key points to remember for this course

Defining an application protocol is **not an easy task**. There are many ways to
do it, and there is no "one size fits all" solution. You should always keep in
mind the following points:

1. Context - What the application protocol is used for?
2. Transport - What protocol(s) is/are involved? On which port(s)? How are
   messages/actions encoded? How are messages/actions delimited? How are
   messages/actions treated? Who initiates/closes the communication? What
   happens on an unknown message/action/exception?

---

3. Messages/actions - What are the messages/actions? What are the parameters?
   What are the return values? What are the exceptions?

   Always try to describe these **for a given context**, not from each point of
   view (e.g. "_making an order_" with the input/outputs from the client to the
   server and the responses instead of "_the client sends these messages and the
   server replies these messages with these outputs_"). It makes it _way_ easier
   to understand and to implement.

4. Example diagrams - What are the examples of messages/actions? What are the
   examples of exceptions? Illustrate your application protocol with diagrams to
   make it easier to understand.

##### Elements to improve for next year

- Nothing much to improve in our opinion. Do you agree?

#### Java TCP and UDP programming

<!--
_class: lead
_paginate: false
-->

[Find this course on GitHub](<https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/07.01-java-tcp-and-udp-programming-(1-of-2)>)

![bg opacity:0.1](<https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/07.01-java-tcp-and-udp-programming-(1-of-2)/01-course-material/images/main-illustration.jpg?raw=true>)

##### Key points to remember for this course (TCP)

- TCP as a reliable protocol.
- TCP is unicast only.
- A client and a server communicate using `Socket` and `ServerSocket` classes on
  a given port for a given host.
- Dealing with sockets' streams is the same as with files: buffering, flushing,
  charsets, end of line characters, exceptions handling, etc.

##### Key points to remember for this course (UDP)

- Differences between TCP and UDP.
- Reliability of UDP.
- Unicast, broadcast and multicast.
- A client/server (unicast) and or emitter/receiver (multicast) communicate with
  the `DatagramSocket`, `DatagramPacket` and `MulticastSocket` classes.
- Messaging patterns.
- Service discovery protocols.

##### Elements to improve for next year

- Nothing much to improve in our opinion. Do you agree?

#### Java network concurrency

<!--
_class: lead
_paginate: false
-->

[Find this course on GitHub](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/09.01-java-network-concurrency)

![bg opacity:0.1](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/09.01-java-network-concurrency/01-course-material/images/main-illustration.jpg?raw=true)

##### Key points to remember for this course

- Concurrency allows to manage multiple task simultaneously.
- Java offers classes and data structures to manage concurrency.
- Multiple strategies exist to manage concurrency, with different trade-offs:
  - Unlimited threads can use all the available resources.
  - threadpools can set the maximum number of threads but need to calculate the
    right amount to use resources efficiently.
  - Recommended: Threadpools for Java < 19 and virtual threads for Java > 19.

##### Elements to improve for next year

- This course came a bit late in the teaching unit (mostly regarding the
  practical work). Maybe we could move it earlier by merging the Java TCP and
  UDP programming courses together?

#### Practical work 2

<!--
_class: lead
_paginate: false
-->

[Find this practical work on GitHub](<https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/06.02-practical-work-2-(1-of-6)>)

![bg opacity:0.1](<https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/06.02-practical-work-2-(1-of-6)/01-course-material/images/main-illustration.jpg?raw=true>)

##### What you were ask to do

- A network application using TCP and/or UDP with its own application protocol.
- You can choose what the network application will do.
- Your first experiments with Docker to publish your application to the GitHub
  Container Registry.

We have seen some very interesting projects! Chat applications, hanging man
(poor boy...) games, naval battle games, etc.

Do not hesitate to share your project and to continue to work on it!

##### Elements to improve for next year

- Nothing much to improve in our opinion. Do you agree?

### Part 3: Network programming with HTTP

<!--
_class: lead
_paginate: false
-->

![bg opacity:0.1](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/11.02-introduction-to-part-3-network-programming-with-http/01-course-material/images/main-illustration.jpg?raw=true)

#### SSH and SCP

<!--
_class: lead
_paginate: false
-->

[Find this course on GitHub](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/11.03-ssh-and-scp)

![bg opacity:0.1](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/11.03-ssh-and-scp/01-course-material/images/main-illustration.jpg?raw=true)

##### Key points to remember for this course

- Obtain a real remote server on a cloud provider (Azure).
- SSH keys and how to clone/sign commits using Git.
- SSH keys and how to connect to a remote server.
- SCP and how to copy files to a remote server.

##### Elements to improve for next year

- Azure seems to have some issues this year (mysterious validation errors that
  are hard to debug and understand).
- However, you have free credits to use it.
- We could consider using another cloud provider such as
  [DigitalOcean](https://www.digitalocean.com) as we have
  [free credits with GitHub Education Program](https://www.digitalocean.com/github-students),
  but it requires a credit card...
- We might switch to another provider next year.
- Other than that, nothing much to improve in our opinion. Do you agree?

#### HTTP and curl

<!--
_class: lead
_paginate: false
-->

[Find this course on GitHub](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/12.01-http-and-curl)

![bg opacity:0.1](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/12.01-http-and-curl/01-course-material/images/main-illustration.jpg?raw=true)

##### Key points to remember for this course

- HTTP request methods and their response status codes.
- HTTP path parameters, query parameters and body.
- HTTP headers.
- HTTP content negotiation.
- Structure of a HTTP request/response (raw HTTP).
- HTTP sessions using a query parameter or a cookie.
- API design.

##### Elements to improve for next year

- Add a bit of content regarding HTML, JavaScript and CSS (optional content?).
- Refer to official documentation to generate full web applications (UI + API)
  using the official resources (optional content?):
  - <https://javalin.io/plugins/rendering>.
  - <https://javalin.io/tutorials/>.
  - It might help for the BDR + DAI/personal projects.
- We would love to go deeper on this topic but the time is limited. You will
  learn more about this topic in future teaching units.

#### Web infrastructures

<!--
_class: lead
_paginate: false
-->

[Find this course on GitHub](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/13.01-web-infrastructures)

![bg opacity:0.1](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/13.01-web-infrastructures/01-course-material/images/main-illustration.jpg?raw=true)

##### Key points to remember for this course

- Functional and non-functional requirements.
- How HTTP features can be used to build web infrastructures:
  - The `Host` header.
  - Reverse proxy.
  - System scaling:
    - Vertical: add more hardware (CPU, RAM, etc.).
    - Horizontal: add more instances.
  - Load balancing.

##### Elements to improve for next year

- DuckDNS seems to have some issues this year. We have updated the course
  material to use [Dyno](https://dyno.com/) instead (see PR
  [#976](https://github.com/heig-vd-dai-course/heig-vd-dai-course/pull/976)).
- Move the instructions to obtain a domain name to the SSH and SCP course to
  allow to access the server using a domain name earlier.
- Other than that, nothing much to improve in our opinion. Do you agree?

#### Caching and performance

<!--
_class: lead
_paginate: false
-->

[Find this course on GitHub](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/14.01-caching-and-performance)

![bg opacity:0.1](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/14.01-caching-and-performance/01-course-material/images/main-illustration.jpg?raw=true)

##### Key points to remember for this course

- How HTTP features can be used to implement caching and improve performance of
  web applications:
  - Expiration model based on time.
  - Validation model based on content:
    - `ETag`
    - `Last-Modified`
- Different types of cache.
- Where to cache.

##### Elements to improve for next year

- Improve the diagrams for better comprehension.
- Other than that, nothing much to improve in our opinion. Do you agree?

#### Practical work 3

<!--
_class: lead
_paginate: false
-->

[Find this practical work on GitHub](<https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/12.02-practical-work-3-(1-of-5)>)

![bg opacity:0.1](<https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/12.02-practical-work-3-(1-of-5)/01-course-material/images/main-illustration.jpg?raw=true>)

##### What you were ask to do

- Obtain and configure a virtual machine on the cloud.
- Install Docker and Docker Compose on the virtual machine.
- Develop a simple CRUD API to manage resources.
- Deploy the applications (reverse proxy + CRUD API).
- Access the applications from a (free) domain name.

We have seen some very interesting projects! Pokédexes, GPG keys management,
etc.

Do not hesitate to share your project and to continue to work on it!

##### Elements to improve for next year

- Improve some criteria in the evaluation grid to make them clearer.
- Other than that, nothing else to improve in our opinion. We think it is the
  perfect practical work to close the loop of the teaching unit. Do you agree?

### Course materials

<!--
_class: lead
_paginate: false
-->

![bg opacity:0.1][illustration]

#### Elements to improve for next year

- Make usage of a quiz application to kickoff each course session with content
  from the previous session.
- Use previous evaluation questions as discussion points during the teaching
  unit.
- Improve Git repository structure to make it easier to navigate (see
  [PR #886](https://github.com/heig-vd-dai-course/heig-vd-dai-course/pull/886)).

### Practical works

<!--
_class: lead
_paginate: false
-->

![bg opacity:0.1][illustration]

#### Elements to improve for next year

- Nothing much to improve in our opinion. Do you agree?

### Evaluations

<!--
_class: lead
_paginate: false
-->

![bg opacity:0.1][illustration]

#### Elements to improve for next year

- Move the first evaluation earlier in the semester.

### GAPS evaluation

<!-- _class: lead -->

Let's check these _beautiful_ charts!

<small>You can find all Framasoft and GAPS evaluations
[on the repository](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/16.03-semester-review-and-exam-preparation).</small>

## Remaining questions

Here are some remaining questions we never take the time to discuss and I would
like your opinion on them. There will be no judgement and no consequences. I
just want to understand your point of view.

- Did you find the course too difficult or having too much content?
- Is there anything that you feel was not fair during the semester?
- Do you have a remaining question you would like to ask?

## Exam preparation

<!-- _class: lead -->

What you need to know for the exam

### Exam preparation

**Where and when?**

- **Date**: 03.02.2026 (Tuesday)
- **Time**: 13:30
- **Duration**: 60 minutes
- **Place(s)**: G01, G02 and G03

Find all examens on [SACHEM](https://sachem.heig-vd.ch/examens/actuel/).

![bg right:40%][illustration]

---

**What to expect?**

A paper exam that will test your knowledge on everything we have seen during the
semester (theoretical content, practical content and practical works).

You will be asked to read/write/understand some code.

**You must be ready as there will be no time to lose.**

![bg right:40%][illustration]

---

**Allowed resources?**

Two (2) double-sided sheets (so four (4) single-sided sheets) of personal notes.

**What to do during the exam?**

Read the exam carefully.

Always try to write something.

You all have the skills to pass the exam.

![bg right:40%][illustration]

---

**How to revise?**

All typical questions are at the end of each course you studied.

All previous evaluations are available in the course repository:

- [Evaluation 1](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/10.01-evaluation-1)
- [Evaluation 2](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/15.01-evaluation-2)

You can find the archives as well in these directories.

![bg right:40%][illustration]

## Questions

<!-- _class: lead -->

Do you have any questions?

## Conclusion

<!-- _class: lead -->

---

> This teaching course defines the basics of network communication and how all
> these communications are programmed.
>
> At the end of the teaching unit, you will know how to define, program and
> deploy network applications, how to interact with them, and the different
> elements to pay attention to make robust applications.
>
> Whether you are in software, security, data science, embedded or network, you
> will have to deal with network applications (APIs, devices, etc.). This
> teaching unit will give you a solid grounding in this world.

### You did it! Congrats!

You can be proud of yourself! You all did a great job! We had a blast following
your progress during this semester.

This teaching unit is now over, but we hope you enjoyed it and learned a lot.

This teaching unit is part of a larger curriculum, and we hope you will be able
to apply what you learned in the next teaching units.

This teaching unit is only the start of what you can learn about. We hope you
will continue to learn about these topics in the future.

### How to stay up to date?

Staying up to date is a challenge in the IT world. Here are some resources to
help you with content related to this teaching unit:

<div class="two-columns">
<div>

- [Hacker News](https://news.ycombinator.com/)
- [Lobsters](https://lobste.rs/)
- [Dev.to](https://dev.to/)
- [GitHub](https://github.com/explore) -
  [1](https://github.com/awesome-selfhosted/awesome-selfhosted),
  [2](https://github.com/sindresorhus/awesome)
- [Reddit](https://www.reddit.com/) - [1](https://www.reddit.com/r/java/),
  [2](https://www.reddit.com/r/programming/),
  [3](https://www.reddit.com/r/linux/),
  [4](https://www.reddit.com/r/selfhosted/),
  [5](https://www.reddit.com/r/docker/), [6](https://www.reddit.com/r/webdev/),
  [7](https://www.reddit.com/r/networking/),
  [8](https://www.reddit.com/r/sysadmin/),
  [9](https://www.reddit.com/r/commandline/)
- [ByteByteGo](https://bytebytego.com/)

</div>
<div>

- [LinkedIn](https://www.linkedin.com/)
- [Stack Overflow](https://stackoverflow.com/)
- [Stack Exchange Network](https://stackexchange.com/sites)
- [Medium](https://medium.com/)
- (Avoid AI...)

</div>

### Well, what now?

You have gained significant knowledge during this teaching unit. Use this
knowledge wisely. With great power comes great responsibility. You can now:

- Go deeper in the web development world.
- Enter the game of self-hosting.
- Interact with the open-source community.

Thrive to learn more, and do not hesitate to share your knowledge with others.

### Closing remarks

Some closing remarks :

- **Always ask yourself the right questions**: _Why?_ _How?_ _What?_ _Am I doing
  the right thing for the right cause?_ _Do I listen to myself?_
- **Always do what is good for you**: Health, relationships, friends are more
  important than work! _You_ are more important than work!
- **Always trust yourself and your guts**: Do what you think is right!
- **Help others, be kind**: Cooperation is better than competition!
- **Stay critical**: Your opinion matters and can make a difference.

### Acknowledgements

Thank you **Olivier Tischhauser** (2025-2026), **Hadrien Louis** (2023-2026),
**Gaétan Zwick** (2025-2026), **Ylli Fazlija** (2025-2026), **Géraud Silvestri**
(2024-2025) and **Camille Koestli** (2024-2025) for helping preparing this
teaching unit.

Thank you **Olivier Tischhauser** (2025-2026) and **Juergen Ehrensberger**
(2023-2025) for sharing the teaching with the other classe(s).

And of course, **you**, for your participation and your interest in this course!
It was a pleasure to teach you and I hope to see you again!

### Thank you, good luck, and farewell!

<!-- _class: lead -->

Apéro time! 🎉

## Sources

- Main illustration by [MChe Lee](https://unsplash.com/@mclee) on
  [Unsplash](https://unsplash.com/photos/PC91Jm1DlWA)
- Illustration by [Kenny Eliason](https://unsplash.com/@neonbrand) on
  [Unsplash](https://unsplash.com/photos/60krlMMeWxU)
- All other illustrations' sources are available in their respective course
  materials.

[course]:
	https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/16.03-semester-review-and-exam-preparation
[license]:
	https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[illustration]: ./images/main-illustration.jpg
