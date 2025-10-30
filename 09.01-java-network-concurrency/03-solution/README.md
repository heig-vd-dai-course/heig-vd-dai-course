# Java network concurrency - Solution

L. Delafontaine and H. Louis, with the help of
[GitHub Copilot](https://github.com/features/copilot).

Based on the original course by O. Liechti and J. Ehrensberger.

This work is licensed under the [CC BY-SA 4.0][license] license.

## Resources

- Objectives, teaching and learning methods, and evaluation methods:
  [Link to content](..)
- Course material: [Link to content](../01-course-material/README.md) ·
  [Presentation (web)](https://heig-vd-dai-course.github.io/heig-vd-dai-course/09.01-java-network-concurrency/01-course-material/index.html)
  ·
  [Presentation (PDF)](https://heig-vd-dai-course.github.io/heig-vd-dai-course/09.01-java-network-concurrency/01-course-material/09.01-java-network-concurrency-presentation.pdf)
- Code examples: [Link to content](../02-code-examples/)
- Solution: [Link to content](../03-solution/)

This directory contains the solution to the
[Java network concurrency](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/14-java-network-concurrency)
practical content.

- [Resources](#resources)
- [Explain the differences between the following different implementations](#explain-the-differences-between-the-following-different-implementations)
  - [`TcpServerSimpleExample`](#tcpserversimpleexample)
  - [`TcpServerSingleThreadExample`](#tcpserversinglethreadexample)
  - [`TcpServerMultiThreadExample`](#tcpservermultithreadexample)
  - [`TcpServerCachedThreadPoolExample`](#tcpservercachedthreadpoolexample)
  - [`TcpServerFixedThreadPoolExample`](#tcpserverfixedthreadpoolexample)
  - [`TcpServerVirtualThreadExample`](#tcpservervirtualthreadexample)
- [What is the difference between a thread and a virtual thread?](#what-is-the-difference-between-a-thread-and-a-virtual-thread)
- [When and why should you use one or the other?](#when-and-why-should-you-use-one-or-the-other)
- [Are you able to explain why the `TcpServerSingleThreadExample` does not work as expected?](#are-you-able-to-explain-why-the-tcpserversinglethreadexample-does-not-work-as-expected)

## Explain the differences between the following different implementations

### `TcpServerSimpleExample`

This simple demonstration can only handle one client at a time. It is not very
useful but it is a good starting point to understand how the TCP protocol works.

### `TcpServerSingleThreadExample`

This example is no more complex than the previous example as it can still only
handle one client at a time.

However, it uses the
[`newSingleThreadExecutor`](<https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/Executors.html#newSingleThreadExecutor()>)
method from the
[`Executors`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/Executors.html)
class.

This method returns an
[`ExecutorService`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/ExecutorService.html)
that uses a single worker thread operating off an unbounded queue.

It will easily allow to update the server to handle multiple clients at the same
time in the next examples.

### `TcpServerMultiThreadExample`

This example can handle multiple clients with the help of
[Threads](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Thread.html).

Threads will be created infinitely to handle each client connection. This is not
a good solution as it will quickly consume all the resources of the server.

Threads are not cheap to create and use. They consume a lot of memory and CPU
time. It is better to use a thread pool to handle multiple clients.

### `TcpServerCachedThreadPoolExample`

This example is very similar to the previous one but it uses the
[`newCachedThreadPool`](<https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/Executors.html#newCachedThreadPool()>)
method from the
[`Executors`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/Executors.html)
class.

This method returns an
[`ExecutorService`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/ExecutorService.html)
that creates new threads as needed, but will reuse previously constructed
threads when they are available.

It is a slightly better solution than the previous one but it is still not
optimal.

### `TcpServerFixedThreadPoolExample`

This example is very similar to the previous one but it uses the
[`newFixedThreadPool`](<https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/Executors.html#newFixedThreadPool(int)>)
method from the
[`Executors`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/Executors.html)
class.

This method returns an
[`ExecutorService`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/ExecutorService.html)
that uses a fixed number of threads operating off a shared unbounded queue.

This solution allows a fine tuning of the number of threads used to handle the
clients. It is one of the best solutions to handle multiple clients at the same
time.

The difficulty is to find the right number of threads to use. Too few threads
will not allow to handle all the clients at the same time. Too many threads will
consume too much resources.

### `TcpServerVirtualThreadExample`

This example uses the
[`newVirtualThreadExecutor`](<https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/Executors.html#newVirtualThreadPerTaskExecutor()>)
method from the
[`Executors`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/Executors.html)
class.

This method returns an
[`ExecutorService`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/ExecutorService.html)
that creates new virtual threads as needed. Virtual threads are lightweight
threads that are scheduled by the Java virtual machine (JVM) rather than by the
operating system. This is only available since Java 21.

This solution is very similar to the previous one but it uses virtual threads
instead of native threads. It will create as many virtual threads as needed to
handle the clients but consume very few resources.

It is one of the best solutions to handle multiple clients at the same time as
it is very lightweight.

## What is the difference between a thread and a virtual thread?

A thread is managed by the operating system. A virtual thread is managed by the
Java virtual machine (JVM).

Virtual threads are more lightweight than operating system threads and are
scheduled by the JVM rather than by the operating system.

Virtual threads are only available since Java 21 and are suitable for
applications that require a large number of threads, specifically for blocking
I/O operations (reading from a file, reading from a socket, etc.).

You can read all the details about virtual threads in the
[Java documentation](https://docs.oracle.com/en/java/javase/21/core/virtual-threads.html).

## When and why should you use one or the other?

This question is a tricky one. It depends on the context and the use case.

The `TcpServerSimpleExample` and `TcpServerSingleThreadExample` solutions are
only useful to understand how the TCP protocol works. It is not useful in a real
world application.

The `TcpServerMultiThreadExample` solution is a good solution if you only have a
few number of clients to handle.

The `TcpServerCachedThreadPoolExample` solution is a good solution if you have a
large number of clients to handle. It is less resource intensive than the third
solution but it is still not optimal.

The `TcpServerFixedThreadPoolExample` and `TcpServerVirtualThreadExample`
solutions are good solutions if you have a large number of clients to handle and
want to have a good control on resources. They are the best solution to handle
multiple clients at the same time.

A rule of thumb is to use the `TcpServerFixedThreadPoolExample` solution if you
are using Java 17 or less and the `TcpServerVirtualThreadExample` solution if
you are using Java 21 or more.

## Are you able to explain why the `TcpServerSingleThreadExample` does not work as expected?

This is because we use a Unicode character with an `US_ASCII` encoding.

This is why encoding and decoding charsets are important. If you use the wrong
encoding, you will not be able to decode the message correctly.

[license]:
	https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
