[markdown]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/23-practical-work-4/COURSE_MATERIAL.md
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/23-practical-work-4/23-practical-work-4-course-material.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions

# Practical work 4

<https://github.com/heig-vd-dai-course>

[Markdown][markdown] · [PDF][pdf]

L. Delafontaine and H. Louis, with the help of Copilot.

This work is licensed under the [CC BY-SA 4.0][license] license.

Network applications are everywhere. They are used to communicate, to play
games, to watch videos, to listen to music, to browse the web, to send emails,
etc.

People just like you are creating network applications every day. Most of them
are really simple and super useful. They do not even require a lot of resources
to run. You could deploy them on your own infrastructure (your own computer/NAS,
a Raspberry Pi, a virtual machine, etc.) for your own use and needs and have a
control over your data (and a lot of fun as well).

In this practical work, you will create and deploy a little web infrastructure
with a collection of web application containers with the help of Docker, Docker
Compose and a reverse proxy, such as [Traefik](https://traefik.io/traefik/).

As always, you have the freedom to choose the applications you want to deploy.

A great resource to find applications is the
[`awesome-selfhosted`](https://github.com/awesome-selfhosted/awesome-selfhosted)
repository on GitHub.

## Objectives

- Dialog with the IT department of the HEIG-VD to get a virtual machine on our
  cloud infrastructure
- Access the virtual machine with SSH
- Install Docker and Docker Compose on the virtual machine
- Define a Docker Compose file to deploy a collection of web application
  containers with a reverse proxy
- Deploy the web infrastructure on the virtual machine
- Access the web applications with a web browser and a domain name

## Group composition

You will work in groups of two students. You can choose your partner. If you do
not have a partner, we will assign you one.

## Grading criteria

- 0 point - The work is not done
- 0.1 point - The work is insufficient
- 0.2 point - The work is done

Maximum grade: 25 points \* 0.2 + 1 = 6

### Category 1 - Git, GitHub and Markdown

If your repository is private, you must add us as collaborators to your
repository!

| #   | Criterion                                                        | Points |
| --- | ---------------------------------------------------------------- | -----: |
| 1   | The entire team contributes to the project and can explain it    |    0.2 |
| 2   | The README is well structured and explains what the CLI is for   |    0.2 |
| 3   | The README explains how to build the CLI                         |    0.2 |
| 4   | The README explains how to use the CLI with examples and outputs |    0.2 |

### Category 2 - Docker and Docker Compose

| #   | Criterion                                                  | Points |
| --- | ---------------------------------------------------------- | -----: |
| 5   | The codebase has all required files and is well structured |    0.2 |
| 6   | The codebase is well documented                            |    0.2 |

## Constraints

- You must deploy at least 2 web applications
- You must use a reverse proxy with a domain name to access the web applications
- You must use Docker and Docker Compose to deploy the web applications

## Remarks

Remember the KISS principle: Keep It Simple, Silly! Sometimes it is better to
use a simple solution than a complex one.

If your solution is too complex, we might penalize you.

If elements that are supposed to be acquired through the course or previous
practical works are omitted, forgotten or poorly implemented, we might penalize
you.

If you have a domain name, you can use it. If you do not have a domain name, we
can provide you one.

## Submission

The planning of the course is available at
<https://github.com/orgs/heig-vd-dai-course/projects>. The **deadline** is just
**before the Practical work review and feedback session**.

Any commit after the deadline will not be taken into account. Each day of delay
will result in a penalty of -1 point on the final grade.

You must create a new GitHub Discussion at
<https://github.com/orgs/heig-vd-dai-course/discussions> with the following
information:

- **Title**: DAI 2023-2024 - Practical work 4 - @member1 and @member2
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
# Practical work 4 - Grading grid for @member1 and @member2

Here are the grades and comments for each criterion for the practical work 1.

## Grading criteria

- 0 point - The work is not done
- 0.1 point - The work is insufficient
- 0.2 point - The work is done

Maximum grade: 25 points \* 0.2 + 1 = 6

TODO

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
