[markdown]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/18-practical-work-3/COURSE_MATERIAL.md
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/18-practical-work-3/18-practical-work-3-course-material.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/118
[illustration]:
  https://images.unsplash.com/photo-1636357582639-27620e21d7c5?fit=crop&h=720

# Practical work 3

<https://github.com/heig-vd-dai-course>

[Markdown][markdown] · [PDF][pdf]

L. Delafontaine and H. Louis, with the help of Copilot.

This work is licensed under the [CC BY-SA 4.0][license] license.

![Main illustration][illustration]

## Table of contents

- [Table of contents](#table-of-contents)
- [Introduction](#introduction)
- [Objectives](#objectives)
- [Group composition](#group-composition)
- [Tips for the practical work](#tips-for-the-practical-work)
  - [Concurrency with UDP](#concurrency-with-udp)
  - [Concurrent collections](#concurrent-collections)
  - [Run multiple tasks in parallel](#run-multiple-tasks-in-parallel)
- [Grading criteria](#grading-criteria)
  - [Category 1 - Git, GitHub and Markdown](#category-1---git-github-and-markdown)
  - [Category 2 - Define an application protocol](#category-2---define-an-application-protocol)
  - [Category 3 - Docker and Docker Compose](#category-3---docker-and-docker-compose)
  - [Category 4 - Java UDP programming](#category-4---java-udp-programming)
  - [Category 5 - Presentation and questions](#category-5---presentation-and-questions)
- [Constraints](#constraints)
- [Remarks](#remarks)
- [Submission](#submission)
- [Grades and feedback](#grades-and-feedback)
- [Finished? Was it easy? Was it hard?](#finished-was-it-easy-was-it-hard)

## Introduction

Streaming and notifications are everywhere: streaming is used to stream music,
videos, game states, etc. and notifications are used to send emails, messages,
etc. to a user or a group of users.

These classes of network applications are mostly based on the UDP protocol.

In this practical work, you will create a network application that uses the UDP
protocol.

The network application will be defined by an application protocol, some
emitters and some receivers using a mix of unicast, broadcast and multicast
communications.

The application protocol will be defined by you.

Your application must be built around UDP.

Feel free to be creative! For example, you can choose to create a sophisticated
chat application, a game of cooperation, a streaming application, the simulation
of an Internet of Things (IoT) network, etc.

## Objectives

- Define a network application protocol
- Make usage of the UDP protocol
- Use Java UDP programming to implement the network application
- Use Docker and Docker Compose to run the network application

## Group composition

As this practical work is more complex than the previous ones, you can work in
groups between two and three students. You can choose your partners. If you do
not have a partner or a group, we will assign you one.

To announce your group, create a new GitHub Discussion at
<https://github.com/orgs/heig-vd-dai-course/discussions> with the following
information:

- **Title**: DAI 2023-2024 - Practical work 3 - First name Last name member 1,
  First name Last name member 2 and First name Last name member 3
- **Category**: Show and tell
- **Description**: A quick description of what you will achieve during this
  practical work

The teaching staff might ask you to change the scope of your practical work if
it is too complex or too simple.

**Please do it a soon as possible, even if you do not have a clear idea yet as
it will help us to plan the practical work review.**

## Tips for the practical work

In order for this practical work to be successful, you might need to the
following tips to help you.

The type of application you want to create will determine if you need those tips
or not. Some elements mentioned here might not be relevant for your application
so feel free to ignore them.

### Concurrency with UDP

To handle multiple clients at the same time, you will need to use concurrency,
as seen in the
[Java TCP programming](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/13-java-tcp-programming)
chapter.

Using the same example we shared in the practical content of the
[Java UDP programming](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/17-java-udp-programming),
you can use the following code to handle multiple clients at the same time:

```java
package ch.heigvd.receivers;

import picocli.CommandLine.Command;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Command(
        name = "unicast-receiver",
        description = "Start an UDP unicast receiver"
)
public class UnicastReceiver extends AbstractReceiver {

    // This is new - could be passed as a parameter with picocli
    private static final int NUMBER_OF_THREADS = 1;

    @Override
    public Integer call() {
        // This is new - we define an executor service
        ExecutorService executor = null;

        try (DatagramSocket socket = new DatagramSocket(parent.getPort())) {
            // This is new - the executor service has a pool of threads
            executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

            String myself = InetAddress.getLocalHost().getHostAddress() + ":" + parent.getPort();
            System.out.println("Unicast receiver started (" + myself + ")");

            byte[] receiveData = new byte[1024];

            while (true) {
                DatagramPacket packet = new DatagramPacket(
                        receiveData,
                        receiveData.length
                );

                socket.receive(packet);

                // This is new - we submit a new task to the executor service
                executor.submit(new ClientHandler(packet, myself));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    // This is new - we define a new class to handle the client
    static class ClientHandler implements Runnable {

        private final DatagramPacket packet;
        private final String myself;

        public ClientHandler(DatagramPacket packet, String myself) {
            this.packet = packet;
            this.myself = myself;
        }

        @Override
        public void run() {
            String message = new String(
                    packet.getData(),
                    packet.getOffset(),
                    packet.getLength(),
                    StandardCharsets.UTF_8
            );

            System.out.println("Unicast receiver (" + myself + ") received message: " + message);

            System.out.println("Going to sleep for 10 seconds...");

            // Sleep for a while to simulate a long-running task
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("End of sleep");
        }
    }
}
```

### Concurrent collections

Java provides a set of concurrent collections that can be used to manage data
shared between threads.

Using these data structures, you can avoid using `synchronized` blocks or
methods. It is more efficient and easier to use.

You can find all the concurrent collections in the
[`java.util.concurrent`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/concurrent/package-summary.html)
package.

Some useful collections are:

- `ConcurrentHashMap`
- `CopyOnWriteArrayList`
- `CopyOnWriteArraySet`
- `ConcurrentLinkedDeque`
- `ConcurrentLinkedQueue`

### Run multiple tasks in parallel

If you want to run multiple (different) tasks in parallel, you can use the
following snippet in your code.

As seen in the
[Java TCP programming](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/13-java-tcp-programming)
chapter, you can use
`ExecutorService executorService = Executors.newFixedThreadPool(2);` to create a
pool of $n$ threads, one for each task to run in parallel. Then you can use the
`submit` method and give as parameter the method to run.

For more details regarding the `submit` method, check the official Java
documentation:
<https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/concurrent/ExecutorService.html#submit(java.util.concurrent.Callable)>.

Here is a simple example to run two tasks in parallel:

```java
public Integer call() {
  ExecutorService executorService = Executors.newFixedThreadPool(2); // The number of threads in the pool must be the same as the number of tasks you want to run in parallel

  try {
      executorService.submit(this::worker1); // Start the first task
      executorService.submit(this::worker2); // Start the second task

      executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS); // Wait for termination
  } catch (Exception e) {
      e.printStackTrace();
      return 1;
  } finally {
      executorService.shutdown();
  }

  return 0;
}

public Integer worker1() {
  // ...
}

public Integer worker2() {
  // ...
}
```

## Grading criteria

- 0 point - The work is not done
- 0.1 point - The work is insufficient
- 0.2 point - The work is done

Maximum grade: 25 points \* 0.2 + 1 = 6

### Category 1 - Git, GitHub and Markdown

If your repository is private, you must add us as collaborators to your
repository!

| #   | Criterion                                                                                                               | Points |
| --- | ----------------------------------------------------------------------------------------------------------------------- | -----: |
| 1   | The README is well structured and explains what the network application is for with its documented application protocol |    0.2 |
| 2   | The README explains how to build and publish the network application with Docker                                        |    0.2 |
| 3   | The README explains how to run the network application with examples and outputs                                        |    0.2 |

### Category 2 - Define an application protocol

| #   | Criterion                                                                                     | Points |
| --- | --------------------------------------------------------------------------------------------- | -----: |
| 4   | The application protocol defines the port and protocol to use                                 |    0.2 |
| 5   | The application protocol defines who initiates the connection and how                         |    0.2 |
| 6   | The application protocol defines the available messages/actions with their input(s)/output(s) |    0.2 |
| 7   | The application protocol defines the success/error codes and their explanations               |    0.2 |
| 8   | The application protocol is described using one or multiple diagrams                          |    0.2 |
| 9   | The application protocol defines the edge-cases when something could go wrong with a diagram  |    0.2 |

### Category 3 - Docker and Docker Compose

| #   | Criterion                                                                                  | Points |
| --- | ------------------------------------------------------------------------------------------ | -----: |
| 10  | One or multiple Dockerfiles allow to build the network application                         |    0.2 |
| 11  | The network application is published to a Docker registry (e.g. GitHub Container Registry) |    0.2 |
| 12  | One or multiple Docker Compose files allow to run the network application                  |    0.2 |

### Category 4 - Java UDP programming

| #   | Criterion                                                                                                                                                      | Points |
| --- | -------------------------------------------------------------------------------------------------------------------------------------------------------------- | -----: |
| 13  | The network application starts on the defined port (but you must be able to change it if needed) and accept connections from multiple clients at the same time |    0.2 |
| 14  | Some actions are private (unique to one user), some actions are common (affect all users)                                                                      |    0.2 |
| 15  | No one can manipulate items from another client if it is not authorized                                                                                        |    0.2 |
| 16  | The client and server correctly process the input/output commands                                                                                              |    0.2 |
| 17  | The network application makes usage of at the fire-and-forget messaging pattern                                                                                |    0.2 |
| 18  | The network application makes usage of at the request-response messaging pattern                                                                               |    0.2 |
| 19  | The network application makes usage of at least two multicast addresses                                                                                        |    0.2 |
| 20  | A client can interact with the network application through unicast                                                                                             |    0.2 |

### Category 5 - Presentation and questions

| #   | Criterion                                                                            | Points |
| --- | ------------------------------------------------------------------------------------ | -----: |
| 21  | The presentation is clear and well prepared                                          |    0.2 |
| 22  | Everyone speaks during the presentation, and the presentation lasts the time allowed |    0.2 |
| 23  | The presentation presents the network application                                    |    0.2 |
| 24  | A demo of the network application is made                                            |    0.2 |
| 25  | The answers to the questions are correct                                             |    0.2 |

## Constraints

- The network application must be written in Java, compatible with Java 17
- The network application must be built using Maven
- You must use one or more of the Java classes seen in the course
- Your application must be slightly more complex and different than the ones
  presented during the course
- The network application can only use the UDP protocol
- You must build and publish the application using Docker and Docker Compose

## Remarks

Remember the KISS principle: Keep It Simple, Silly! Sometimes it is better to
use a simple solution than a complex one.

If your implementation is too complex, we might penalize you.

If elements that are supposed to be acquired through the course or previous
practical works are omitted, forgotten or poorly implemented, we might penalize
you.

You can use [PlantUML](https://plantuml.com/), [Draw.io](https://draw.io/) or
any other tools you want to create your sequence diagrams.

You can use any other dependencies you want in your Maven project. You must
however explain why and how you use it in your README.

You can protect the `main` branch of your repository to prevent any push on it
and force signed commits from team members. This will force all team members to
use signed pull requests to merge your work.

## Submission

Your work is due on the **day of the presentations** (the _"Practical work
review"_ sessions in the official planning available at
<https://github.com/orgs/heig-vd-dai-course/projects>) at **13:15**.

Any commit after the deadline will not be taken into account. Each day of delay
will result in a penalty of -1 point on the final grade.

You must update the GitHub Discussion you created previously with the following
information:

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
<summary>Grading grid template for the teaching staff</summary>

```markdown
# Practical work 3 - Grading grid for First name Last name member 1 and First name Last name member 2

Here are the grades and comments for each criterion for the practical work.

## Grading criteria

- 0 point - The work is not done
- 0.1 point - The work is insufficient
- 0.2 point - The work is done

Maximum grade: 25 points \* 0.2 + 1 = 6

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

## Sources

- Main illustration by [Jorge Ramirez](https://unsplash.com/@jorgedevs) on
  [Unsplash](https://unsplash.com/photos/a-cell-phone-tower-in-a-park-with-a-lake-in-the-background-0vmMg1r7FRU)
