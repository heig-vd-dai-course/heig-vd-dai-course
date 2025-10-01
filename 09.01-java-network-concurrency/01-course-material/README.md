[markdown]:
	https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/14-java-network-concurrency/COURSE_MATERIAL.md
[pdf]:
	https://heig-vd-dai-course.github.io/heig-vd-dai-course/14-java-network-concurrency/14-java-network-concurrency-course-material.pdf
[license]:
	https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/453
[illustration]: ./images/main-illustration.jpg

# Java network concurrency - Course material

<https://github.com/heig-vd-dai-course>

[Markdown][markdown] · [PDF][pdf]

L. Delafontaine and H. Louis, with the help of
[GitHub Copilot](https://github.com/features/copilot).

Based on the original course by O. Liechti and J. Ehrensberger.

This work is licensed under the [CC BY-SA 4.0][license] license.

![Main illustration][illustration]

## Table of contents

- [Table of contents](#table-of-contents)
- [Objectives](#objectives)
- [Disclaimer](#disclaimer)
- [Explore the code examples](#explore-the-code-examples)
- [Concurrency: an introduction](#concurrency-an-introduction)
  - [What is a processor?](#what-is-a-processor)
  - [What is a core?](#what-is-a-core)
  - [What is a process?](#what-is-a-process)
  - [What is a thread?](#what-is-a-thread)
  - [What problems can concurrency cause?](#what-problems-can-concurrency-cause)
  - [What happens when multiple threads access the same resource?](#what-happens-when-multiple-threads-access-the-same-resource)
- [Handling one client at a time](#handling-one-client-at-a-time)
- [Handling multiple clients with concurrency](#handling-multiple-clients-with-concurrency)
  - [Multi-processing](#multi-processing)
  - [Multi-threading](#multi-threading)
  - [Asynchronous programming](#asynchronous-programming)
- [Handling multiple threads in Java](#handling-multiple-threads-in-java)
- [Concurrent safe variable types and data structures in Java](#concurrent-safe-variable-types-and-data-structures-in-java)
- [Practical content](#practical-content)
  - [Execute the code examples](#execute-the-code-examples)
  - [Answer the following questions](#answer-the-following-questions)
  - [Compare your solution with the official one](#compare-your-solution-with-the-official-one)
  - [Go further](#go-further)
- [Conclusion](#conclusion)
  - [What did you do and learn?](#what-did-you-do-and-learn)
  - [Test your knowledge](#test-your-knowledge)
- [Finished? Was it easy? Was it hard?](#finished-was-it-easy-was-it-hard)
- [Additional resources](#additional-resources)
- [Solution](#solution)
- [Sources](#sources)

## Objectives

You might have notice in previous chapters that your network applications could
only handle one client at a time. This is not very useful in a production
environment.

In this chapter, you will have a quick introduction to concurrency to handle
multiple clients at the same time.

You will then learn how to implement and manage concurrency in Java network
applications to allow the handling of multiple clients at the same time.

## Disclaimer

In this chapter, you will learn how to create network applications with
concurrency to handle multiple clients at the same time. We will focus on
network applications and the different ways to handle concurrency.

Even though you will have a good understanding of concurrency at the end of this
chapter, **this is not a concurrency course**.

The Java programming language has a few classes to handle concurrency, described
in modules such as `java.util.concurrent`, `java.util.concurrent.atomic`, and
`java.util.concurrent.locks` (among others).

We will explore and use some of these classes in this chapter but we will not
dive into the details of each classes.

The most important is to understand the concept of concurrency and how to handle
multiple clients at the same time in Java network applications.

We will use the strict minimum to handle concurrency in the context of this
course. You might discover other ways to handle concurrency in other/future
courses.

## Explore the code examples

Individually, or in pair/group, **take 10 minutes to explore and discuss the
code examples** provided in the
[`heig-vd-dai-course/heig-vd-dai-course-code-examples`](https://github.com/heig-vd-dai-course/heig-vd-dai-course-code-examples)
repository. Clone it or pull the latest changes to get the code examples.

The code examples are located in the `14-java-network-concurrency` directory.

Try to answer the following questions:

- How do the code examples work?
- What are the main takeaways of the code examples?
- What are the main differences between the code examples?

You can use the following theoretical content to help you.

## Concurrency: an introduction

Concurrency is the ability of an application to handle multiple tasks at a given
time. It differs from parallelism, which is the ability of an application to
execute multiple tasks at the same time.

But before we dive into concurrency, let's take a step back and remember what a
processor is.

### What is a processor?

A processor is a piece of hardware that executes instructions. It can execute
only one instruction at a time.

A processor can execute instructions very quickly (millions of instructions per
second). It therefore gives the impression that it can execute multiple
instructions at the same time.

However, most computers and servers only have one processor. They can only
execute one instruction at a time.

When a processor manage multiple tasks at a given time, it is called concurrency
and makes use of threads by switching between tasks very quickly.

### What is a core?

A core is a part of a processor that can execute instructions. A processor can
have multiple cores. It is called a multi-core processor.

When multiple processors and/or multiple cores are present, they can execute
multiple instructions at the same time. When an application make usage of this
feature for one common goal, this is called parallelism or
[parallel computing](https://en.wikipedia.org/wiki/Parallel_computing).

Parallel computing is quite complex to implement. It is therefore not covered in
this course.

In this course, we will focus on concurrency to manage multiple clients at a
given time, even on a single-core processor.

### What is a process?

A process is a program in execution. It is identified by a process ID.

Each process has its own memory space. It cannot access the memory space of
another process and can have multiple threads.

A process is a heavy-weight object. It is quite expensive to create and destroy.

Processes can communicate with each other using inter-process communication
(IPC) but it is quite complex to implement.

### What is a thread?

A processor (or core) can manage multiple threads at the same time. A thread is
a sequence of instructions that can be managed independently of the main thread.

The main thread is the thread that is created when the application starts.

It can create other threads to handle other tasks.

Think of a thread as a sub-task that can be executed independently of the main
program.

A thread is quite similar to a process, except that it shares the same memory
space as the other threads. It is therefore much cheaper to create and destroy
than a process (but still more expensive than a simple object).

Threads can communicate with each other using shared memory.

Threads are more lightweight than processes but their number is limited by the
operating system.

You have used threads in this course while using picocli, maybe without knowing
it. Each command is executed in a separate thread and is marked with the
interface `Runnable` or `Callable` to accomplish this.

Using threads, a server can manage multiple clients at the same time. Each
client is handled by a thread and can communicate with the server using shared
memory.

### What problems can concurrency cause?

Managing multiple clients (processes) at the same time is a common requirement
for network applications and has a few quirks:

- What happens when a client connects to the server?
- How to isolate the data sent by one client from the others?
- What happens when multiple clients want to access the same resource
  (variables) at the same time?

We will discuss and solve some these problems in this chapter.

### What happens when multiple threads access the same resource?

When multiple threads access the same resource (variables) at the same time, it
can create problems:

- A thread can read a variable while another thread is writing to it.
- A thread can write to a variable while another thread is reading from it.
- A thread can write to a variable while another thread is writing to it.

Remember: a processor can only execute one instruction at a time. When multiple
threads access the same resource, the processor must decide which thread to
execute first. At any time, the processor can switch from one thread to another,
even in the middle of an instruction.

These problems are called race conditions. Race conditions are the most common
problems when multiple threads access the same resource and can lead to
unexpected results/errors/crashes/bugs.

These issues and best safe practices will be discussed in this chapter.

## Handling one client at a time

A server that handles one client at a time is called single-threaded, or
single-threaded server.

A single-threaded server is quite simple and trivial to implement:

1. It creates a socket to listen for incoming connections.
2. When a connection is accepted, it creates a socket to communicate with the
   client.
3. It then reads the data sent by the client and sends a response.

The main drawback of a single-threaded server is that it can only handle one
client at a time. If another client tries to connect, it will have to wait until
the first client is disconnected.

An analogy is to think of a single-threaded server as a restaurant with only one
table. If a customer is already sitting at the table, another customer will have
to wait until the first customer leaves.

A single-threaded server is therefore not suitable for production. It is
suitable for testing and learning purposes. In order to manage multiple clients,
a server must handle multiple sockets.

Multiple ways exist to handle multiple sockets at the same time and is called
concurrency.

## Handling multiple clients with concurrency

Concurrency is the ability of an application to handle multiple clients at the
same time.

There are multiple ways to handle multiple clients with concurrency (among
others):

- Multi-processing
- Multi-threading
- Asynchronous programming

Java has a package for concurrency called
[`java.util.concurrent`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/package-summary.html).

In this course, we will focus on multi-threading but the other methods are
equally valid and interesting to learn.

### Multi-processing

Multi-processing is the ability of an application to handle multiple processes
at the same time.

A process is a program in execution. It is identified by a process ID.

A process has its own memory space. It cannot access the memory space of another
process.

The main process is the process that is created when the application starts.

It creates other processes to handle multiple clients.

A process is a heavy-weight object. It is quite expensive to create and destroy
as it is a copy of the main process.

Processes can communicate with each other using inter-process communication
(IPC) but it is quite complex to implement.

An analogy is to think of a process as restaurant chain with multiple
restaurants. Each restaurant has only one table and can handle one customer. If
a customer is already sitting at a table of a given restaurant, another customer
can sit at a table at another restaurant.

### Multi-threading

Multi-threading is the ability of an application to handle multiple threads at
the same time.

A thread is a sequence of instructions that can be executed independently of the
main thread.

The main thread is the thread that is created when the application starts.

It creates other threads to handle multiple clients.

Each thread has its own stack and its own program counter.

A thread is therefore quite similar to a process, except that it shares the same
memory space as the other threads. It is therefore much cheaper to create and
destroy than a process (but still more expensive than a simple object).

Threads can communicate with each other using shared memory.

Threads are more lightweight than processes but their number is limited by the
operating system.

There are two ways to manage threads:

- Unlimited threads
- Thread pool that limits the number of threads

When discussing the unlimited threads approach, an analogy is to think of a
restaurant with no tables at all. When a new customer arrives, the restaurant
manager adds a new table for the customer. Each table can handle one customer.

Using this approach, the more customers arrive, the more tables are added. This
approach is not suitable for production as space and resources are limited.

When discussing the thread pool approach, an analogy is to think of a restaurant
with a limited number of tables. When a new customer arrives, the restaurant
manager checks if a table is available. If a table is available, the customer
can sit at the table. If no table is available, the customer will have to wait
until a table is available.

Using this approach, the number of tables is limited. This approach is suitable
for production as space and resources are managed and limited.

### Asynchronous programming

Asynchronous programming is the ability of an application to handle multiple
tasks at the same time, without blocking the main thread.

Using asynchronous programming, the main thread can perform other tasks while
waiting for a task to complete.

Asynchronous programming is based on the concept of callbacks. A callback is a
function that is called when a task is completed.

An analogy is to think of asynchronous programming as a food truck without any
tables. Once a customer wants something to eat, the person managing the food
truck gives the customer a ticket. The customer then waits until the food is
ready but can do other things in the meantime.

Once the food is ready, the person managing the food truck calls the customer.
The customer then comes to the food truck to get the food.

Asynchronous programming is quite complex to implement. It is therefore not
covered in this course.

[Node.js](https://nodejs.org/) is a good example of asynchronous programming.

## Handling multiple threads in Java

In Java, you can manage multiple threads using the
[`ExecutorService`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/ExecutorService.html)
interface.

The `ExecutorService` interface provides a way to run multiple methods in
parallel. It is a high-level API that provides a way to manage multiple threads
and run multiple methods in parallel.

The `ExecutorService` interface has multiple
[`Executors`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/Executors.html)
implementations that you will discover in deeper in the practical content of
this chapter. Each implementation has its own pros and cons.

This snippet taken from the
[Java UDP programming - Practical content template](https://github.com/heig-vd-dai-course/heig-vd-dai-course-java-udp-programming-practical-content-template/tree/main)
repository in the
[`Receiver.java`](https://github.com/heig-vd-dai-course/heig-vd-dai-course-java-udp-programming-practical-content-template/blob/main/src/main/java/ch/heigvd/dai/commands/Receiver.java)
file shows how to use the `ExecutorService` interface to run multiple methods in
parallel with a `newFixedThreadPool` implementation with two threads (one for
each method):

```java
@Override
public Integer call() {
  try (ExecutorService executorService = Executors.newFixedThreadPool(2); ) {
    executorService.submit(this::emittersWorker);
    executorService.submit(this::operatorsWorker);
  } catch (Exception e) {
    System.out.println("[Receiver] Exception: " + e);

    return 1;
  }

  return 0;
}

public Integer emittersWorker() {
  // Manage emitters
}


public Integer operatorsWorker() {
  // Manage operators
}
```

## Concurrent safe variable types and data structures in Java

When multiple threads access the same resource (= the same variable), it is
important to use concurrency safe variables types and/or data structures.

A concurrency safe variable type and/or data structure is a variable type or
data structure that can be accessed by multiple threads at the same time without
creating inconsistencies that can lead to unexpected
results/errors/crashes/bugs.

Using these variable types and data structures, you can avoid using
`synchronized` blocks or methods. It is more efficient, more modern, and easier
to use.

Java provides a set of safe variable types that can be used to manage data
shared between threads.

You can find all the safe variable types in the
[`java.util.concurrent.atomic`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/atomic/package-summary.html)
package.

Some useful safe variable types are (among others):

- `AtomicBoolean`
- `AtomicInteger`
- `AtomicLong`

These variable types are thread-safe and can be used to manage data shared
between threads and must be used instead of the standard variable types
(`int`/`Integer`, `long`/`Long`, `boolean`/`Boolean`, etc.) when multiple
threads access the same resource.

Java provides a set of concurrent collections (= data structures) that can be
used to manage data shared between threads.

You can find all the concurrent collections in the
[`java.util.concurrent`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/package-summary.html)
package.

Some useful concurrent collections are (among others):

- `ConcurrentHashMap`
- `CopyOnWriteArrayList`
- `CopyOnWriteArraySet`
- `ConcurrentLinkedQueue`

These collections are thread-safe and can be used to manage data shared between
threads and must be used instead of the standard collections (`HashMap`,
`ArrayList`, `HashSet`, `LinkedList`, etc.) when multiple threads access the
same resource.

When multiple concurrent variable types and/or data structures are co-dependent,
it is important to use them together with locks to avoid inconsistencies (the
same as mutexes and semaphores in C/C++).

Locks will not be covered (and not expected to be used) in this course but you
can find additional information in the
[`java.util.concurrent.locks`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/locks/package-summary.html)
package if you are interested.

## Practical content

### Execute the code examples

Return to the code examples and take some time to execute them, understand them
and see the results.

### Answer the following questions

Using the
[official Java documentation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/Executors.html),
can you answer these questions?

- Explain the differences between the following different implementations?
  - `TcpServerSimpleExample`
  - `TcpServerSingleThreadExample`
  - `TcpServerMultiThreadExample`
  - `TcpServerCachedThreadPoolExample`
  - `TcpServerFixedThreadPoolExample`
  - `TcpServerVirtualThreadExample`
- When and why should you use one or the other?
- What is the difference between a thread and a virtual thread?
- Are you able to explain why the `TcpServerSingleThreadExample` does not work
  as expected?

### Compare your solution with the official one

Compare your solution with the official one stated in the [Solution](#solution)
section.

If you have any questions about the solution, feel free to ask as described in
the [Finished? Was it easy? Was it hard?](#finished-was-it-easy-was-it-hard)
section.

### Go further

This is an optional section. Feel free to skip it if you do not have time.

#### Update the _"Guess the number"_ game to handle multiple clients

Are you able to update the _"Guess the number"_ to handle multiple clients at
the same time?

#### Update the _"Temperature monitoring"_ application to handle multiple clients

Are you able to update the "_Temperature monitoring_" application to handle
multiple clients at the same time?

## Conclusion

### What did you do and learn?

In this chapter, you have learned how to handle multiple clients at the same
time using concurrency.

You now have all the knowledge to create your own TCP and/or UDP network
applications in a robust and efficient way.

You now have everything to create your own network applications, such as a chat
server, a file server, a web server, games, etc. Congratulations!

### Test your knowledge

At this point, you should be able to answer the following questions:

- What is a thread?
- What is the purpose of concurrency?
- Cite three ways to handle multiple clients with concurrency.
- How to handle multiple threads in Java?

## Finished? Was it easy? Was it hard?

Can you let us know what was easy and what was difficult for you during this
chapter?

This will help us to improve the course and adapt the content to your needs. If
we notice some difficulties, we will come back to you to help you.

> [!NOTE]
>
> Vous pouvez évidemment poser toutes vos questions et/ou vos propositions
> d'améliorations en français ou en anglais.
>
> N'hésitez pas à nous dire si vous avez des difficultés à comprendre un concept
> ou si vous avez des difficultés à réaliser les éléments demandés dans le
> cours. Nous sommes là pour vous aider !

➡️ [GitHub Discussions][discussions]

You can use reactions to express your opinion on a comment!

## Additional resources

_Resources are here to help you. They are not mandatory to read._

- _None yet_

_Missing item in the list? Feel free to open a pull request to add it! ✨_

## Solution

You can find the solution to the practical content in the
[`heig-vd-dai-course/heig-vd-dai-course-solutions`](https://github.com/heig-vd-dai-course/heig-vd-dai-course-solutions)
repository.

If you have any questions about the solution, feel free to open an issue to
discuss it!

## Sources

- Main illustration by [Brent Olson](https://unsplash.com/@helixgames) on
  [Unsplash](https://unsplash.com/photos/person-in-green-and-black-shorts-riding-on-black-and-red-bicycle-_aV5y0nLNew)
