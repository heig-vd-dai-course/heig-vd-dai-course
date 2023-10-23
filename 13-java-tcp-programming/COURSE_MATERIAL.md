[markdown]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/13-java-tcp-programming/COURSE_MATERIAL.md
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/13-java-tcp-programming/13-java-tcp-programming-course-material.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/116
[illustration]:
  https://images.unsplash.com/photo-1554960750-9468c5d9e239?fit=crop&h=720

# Java TCP programming - Course material

<https://github.com/heig-vd-dai-course>

[Markdown][markdown] · [PDF][pdf]

L. Delafontaine and H. Louis, with the help of Copilot.

Based on the original course by O. Liechti and J. Ehrensberger.

This work is licensed under the [CC BY-SA 4.0][license] license.

![Main illustration][illustration]

## Table of contents

- [Table of contents](#table-of-contents)
- [Objectives](#objectives)
- [TCP](#tcp)
- [The Socket API](#the-socket-api)
- [Handling one client at a time](#handling-one-client-at-a-time)
- [Handling multiple clients with concurrency](#handling-multiple-clients-with-concurrency)
  - [Multi-processing](#multi-processing)
  - [Multi-threading](#multi-threading)
  - [Asynchronous programming](#asynchronous-programming)
- [Practical content](#practical-content)
  - [Check and try-out the code examples](#check-and-try-out-the-code-examples)
  - [Create a complete TCP client/server application in Java](#create-a-complete-tcp-clientserver-application-in-java)
  - [Go further](#go-further)
- [Conclusion](#conclusion)
  - [What did you do and learn?](#what-did-you-do-and-learn)
  - [Test your knowledge](#test-your-knowledge)
- [Finished? Was it easy? Was it hard?](#finished-was-it-easy-was-it-hard)
- [What will you do next?](#what-will-you-do-next)
- [Additional resources](#additional-resources)
- [Sources](#sources)

## Objectives

As you have seen in previous chapters, applications communicate with each other
using application protocols.

Some tools are created to interact with these protocols. For example, you can
use Telnet to interact with the SMTP protocol or SSH to interact with the SSH
protocol to transfer files.

In this chapter, you will learn how to program your own TCP clients and servers
in Java.

This will allow you to create your own network applications, such as a chat
server, a file server, a web server, etc.

## TCP

TCP is a transport protocol. It is used to transfer data between two
applications.

TCP is a connection-oriented protocol. This means that a connection must be
established between the two applications before data can be exchanged.

TCP is a reliable protocol. This means that the data sent is guaranteed to be
received by the other application.

TCP is a stream-oriented protocol. This means that the data is sent as a stream.
There is no notion of message.

A good analogy is to think of TCP as a phone call. You must first establish a
connection with the other person before you can talk to them. Once the
connection is established, you can talk to the other person. The other person
will hear everything you say.

With the help of port numbers, TCP allows multiple applications to communicate
with each other on the same machine.

Messages are sent from one application to another using sockets. A socket is
identified by an IP address and a port number.

In TCP, messages are called segments. A segment is a part of a message. A
segment is identified by a sequence number.

TCP segments are encapsulated in IP packets, called payloads.

Thanks to the sequence numbers, TCP is able to reassemble the segments in the
correct order. If a segment is lost, TCP will retransmit it.

## The Socket API

The Socket API is a Java API that allows you to create TCP clients and servers.

It has originally been developed in C in the context of the Unix operating
system. It has been ported to Java and is now available on many platform and
languages.

A socket is identified by an IP address and a port number.

A socket can act as a client or as a server:

- A socket accepting connections is called a server socket.
- A socket initiating a connection is called a client socket.

A socket can be blocking or non-blocking.

A blocking socket will block the thread until the operation is completed. No
other operation can be performed on the socket while the thread is blocked.

A non-blocking socket will not block the thread. It will return immediately with
a result. If the operation is not completed, the result will be an error.

## Handling one client at a time

A server can handle one client at a time. It is called single-threaded, or
single-threaded server.

A single-threaded server is quite simple to implement. It creates a socket to
listen for incoming connections. When a connection is accepted, it creates a
socket to communicate with the client. It then reads the data sent by the client
and sends a response.

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
restaurant. Each restaurant has one table and can handle one customer. If a
customer is already sitting at a table of a given restaurant, another customer
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

In order to manage multiple threads, a thread pool is used. A thread pool is a
pool of threads that can be reused to handle multiple clients.

If the thread pool is full, the main thread will wait until a thread is
available.

An analogy is to think of a thread as a restaurant with multiple tables. Each
table can handle one customer. If a customer is already sitting at a table, the
customer can sit to another table. If all tables are occupied, the customer will
have to wait until a table is available.

### Asynchronous programming

Asynchronous programming is the ability of an application to handle multiple
tasks at the same time, without blocking the main thread.

Using asynchronous programming, the main thread can perform other tasks while
waiting for a task to complete.

Asynchronous programming is based on the concept of callbacks. A callback is a
function that is called when a task is completed.

An analogy is to think of asynchronous programming as a food truck without a
table. Once a customer wants something to eat, the person managing the food
truck gives the customer a ticket. The customer then waits until the food is
ready but can do other things in the meantime.

Once the food is ready, the person managing the food truck calls the customer.
The customer then comes to the food truck to get the food.

Asynchronous programming is quite complex to implement. It is therefore not
covered in this course.

Node.js is a good example of asynchronous programming.

## Practical content

### Check and try-out the code examples

In this section, you will learn how to start a client/server application with
the Socket API.

#### Clone the repository

Pull the latest changes from the previously cloned
[`heig-vd-dai-course/heig-vd-dai-course-code-examples`](https://github.com/heig-vd-dai-course/heig-vd-dai-course-code-examples)
repository or clone it if you have not done it yet.

#### Explore and run the code examples

In the `13-java-tcp-programming` directory, checkout the `README.md` file to
learn how to run the code examples.

Take some time to explore the code examples. Run them and see what they do.

### Create a complete TCP client/server application in Java

In this section, you will create a complete TCP client/server application in Java using the Socket API and a thread pool.

#### The application protocol

You will implement a simple application protocol based on the application protocol
presented in the course.

##### Overview

The DAI protocol is meant to transfer files over the network.

The DAI protocol is a client-server protocol.

The client connects to a server and request a file. The server sends the file
or an error message if the file does not exist.

##### Transport protocol

The DAI protocol uses the TCP protocol. The server runs on port 55555.

The client has to know the IP address of the server to connect to. It
establishes the connection with the server.

The server closes the connection when the transfer is done or if an error
occurs (e.g. the file was not found).

##### Messages

The client can send the following messages:

- `GET <file>`: used to request a file from the server
  - `<file>`: the name of the file to request - The filename is an absolute
    path to the file (`/data/file.txt`)
- `QUIT`: used to close the connection with the server

The server can send the following messages:

- `OK`: used to notify the client that the connection was successful and the
  server is ready to receive commands
- `FILE <file>`: used to send the content of the requested file - the
  connection is closed after this message
- `ERROR <code>`: used to notify the client that an error occurred - the
  connection is closed after this message
  - `400`: the request was malformed
  - `404`: the file was not found

All messages are UTF-8 encoded and end with a new line character (`\n`).

If the file exists, the server sends the file content as binary data.

#### Implement the client

Using the code examples, implement a TCP client that can request a file from a
server with Maven.

#### Implement the server

Using the code examples, implement a TCP server that can send a file to a
client with Maven.

#### Test the client/server application

Using your TCP client, request a file from your TCP server.

Try to request a file that does not exist.

Try with multiple clients at the same time. Can they all connect to the server?
Can they all request a file at the same time? Try and change the number of
threads in the thread pool (1, 2, 5 and 10 for example).

#### Share your results

Create a new Git repository and push your code to it. Do not forget to add all necessary files to your repository and ignore the files that are not necessary.

Share your results in the GitHub Discussions of this organization:
<https://github.com/orgs/heig-vd-dai-course/discussions>.

Create a new discussion with the following information:

- **Title**: DAI 2023-2024 - Java TCP benchmarking - First name Last Name
- **Category**: Show and tell
- **Description**: The link to your GitHub repository and add your conclusions to the following
  questions:
  - Which number of threads is the best? Why?
  - Why do more threads not necessarily mean better performance?

This will notify us that you have completed the exercise and we can check your
work.

### Go further

This is an optional section. Feel free to skip it if you do not have time.

- TODO

## Conclusion

### What did you do and learn?

TODO

### Test your knowledge

At this point, you should be able to answer the following questions:

- TODO

## Finished? Was it easy? Was it hard?

Can you let us know what was easy and what was difficult for you during this
chapter?

This will help us to improve the course and adapt the content to your needs. If
we notice some difficulties, we will come back to you to help you.

➡️ [GitHub Discussions][discussions]

You can use reactions to express your opinion on a comment!

## What will you do next?

You will start the practical work!

## Additional resources

_Resources are here to help you. They are not mandatory to read._

- _None yet_

_Missing item in the list? Feel free to open a pull request to add it! ✨_

## Sources

- Main illustration by [Carl Nenzen Loven](https://unsplash.com/@archduk3) on
  [Unsplash](https://unsplash.com/photos/N8GdKC4Rcvs)
