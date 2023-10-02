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
not have a partner, we will assign you one. In this practical work, you have to
work with someone else.

To announce your group, create a new GitHub Discussion at
<https://github.com/orgs/heig-vd-dai-course/discussions> with the following
information:

- **Title**: DAI 2023-2024 - Practical work 4 - First name Last name member 1
  and First name Last name member 2
- **Category**: Show and tell
- **Description**: A quick description of what you will achieve during this
  practical work

The teaching staff might ask you to change the scope of your practical work if
it is too complex or too simple.

## Grading criteria

- 0 point - The work is not done
- 0.1 point - The work is insufficient
- 0.2 point - The work is done

Maximum grade: 25 points \* 0.2 + 1 = 6

### Category 1 - Git, GitHub and Markdown

If your repository is private, you must add us as collaborators to your
repository!

| #   | Criterion                                                                             | Points |
| --- | ------------------------------------------------------------------------------------- | -----: |
| 1   | The whole team contributes to the project and can explain it in details               |    0.2 |
| 2   | The README is well structured and explains what the repository is for and its sources |    0.2 |
| 3   | The README explains how to install and configure the server                           |    0.2 |
| 4   | The README explains how deploy and run the web infrastructure                         |    0.2 |
| 5   | The README explains how to access the applications with a domain name                 |    0.2 |
| 6   | The repository is cloned using SSH on the server to run the web infrastructure        |    0.2 |

### Category 2 - Docker and Docker Compose

| #   | Criterion                                                  | Points |
| --- | ---------------------------------------------------------- | -----: |
| 7   | The codebase has all required files and is well structured |    0.2 |
| 8   | The codebase is well documented                            |    0.2 |
| 9   | Docker is correctly installed on the server                |    0.2 |
| 10  | Docker Compose is correctly installed on the server        |    0.2 |

### Category 3 - SSH and SCP

| #   | Criterion                                                    | Points |
| --- | ------------------------------------------------------------ | -----: |
| 11  | You can access the server without a password using a SSH key |    0.2 |

### Category 4 - Web infrastructures

| #   | Criterion                                                                                                                                                                                                                                   | Points |
| --- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -----: |
| 12  | At least two applications are deployed on the server                                                                                                                                                                                        |    0.2 |
| 13  | The applications are accessible using a domain name with the help of a reverse proxy                                                                                                                                                        |    0.2 |
| 14  | The domain names are correctly configured in the DNS zone                                                                                                                                                                                   |    0.2 |
| 15  | The applications use automatic HTTPS/TLS certificate generations with Let's Encrypt                                                                                                                                                         |    0.2 |
| 16  | The applications must persiste their data                                                                                                                                                                                                   |    0.2 |
| 17  | The applications must have a health check that Docker or the load balancer can use to notify the user or restart the application if something is wrong                                                                                      |    0.2 |
| 18  | All applications are protected with an authentication, either using the built-in authentication mechanism of the application or by protecting the application with a authentication portal (Basic Authentication is enough for this course) |    0.2 |

### Category 4 - Presentation and questions

| #   | Criterion                                                                                          | Points |
| --- | -------------------------------------------------------------------------------------------------- | -----: |
| 19  | The presentation is clear and well prepared                                                        |    0.2 |
| 20  | Everyone speaks during the presentation, and the presentation lasts the time allowed               |    0.2 |
| 21  | The presentation presents the access to the server and how to clone and run the web infrastructure |    0.2 |
| 22  | The presentation presents the configuration of the DNS zone with its (sub-)domain names            |    0.2 |
| 23  | The presentation presents the web infrastructure                                                   |    0.2 |
| 24  | A demo to access the web infrastructure                                                            |    0.2 |
| 25  | The answers to the questions are correct                                                           |    0.2 |

## Constraints

- You must use a reverse proxy with a domain name to access the web applications
- You must use Docker and Docker Compose to deploy the web applications

## Remarks

Remember the KISS principle: Keep It Simple, Silly! Sometimes it is better to
use a simple solution than a complex one.

If your implementation is too complex, we might penalize you.

If elements that are supposed to be acquired through the course or previous
practical works are omitted, forgotten or poorly implemented, we might penalize
you.

If you have a domain name, you can use it. If you do not have a domain name, we
can provide you one.

You can protect the `main` branch of your repository to prevent any push on it
and force signed commits from team members. This will force all team members to
use signed pull requests to merge your work.

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
# Practical work 4 - Grading grid for First name Last name member 1

and First name Last name member 2

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
