# Java TCP and UDP programming

![Main illustration](./images/main-illustration.jpg)

L. Delafontaine and H. Louis, with the help of
[GitHub Copilot](https://github.com/features/copilot).

Based on the original course by O. Liechti and J. Ehrensberger.

This work is licensed under the [CC BY-SA 4.0][license] license.

## Resources

- Objectives, teaching and learning methods, and evaluation methods:
  [Link to content](..)
- Course material: [Link to content](../01-course-material/README.md) ·
  [Presentation (web)](<https://heig-vd-dai-course.github.io/heig-vd-dai-course/07.01-java-tcp-and-udp-programming-(1-of-2)/01-course-material/index.html>)
  ·
  [Presentation (PDF)](<https://heig-vd-dai-course.github.io/heig-vd-dai-course/07.01-java-tcp-and-udp-programming-(1-of-2)/01-course-material/07.01-java-tcp-and-udp-programming-(1-of-2)-presentation.pdf>)
- Code examples: [Link to content](../02-code-examples/)
- Solution: [Link to content](../03-solution/)

## Table of contents

- [Resources](#resources)
- [Table of contents](#table-of-contents)
- [Objectives](#objectives)
- [Part 1](#part-1)
  - [Explore the code examples](#explore-the-code-examples)
  - [TCP](#tcp)
  - [UDP](#udp)
- [Part 2](#part-2)
  - [Unicast, broadcast and multicast](#unicast-broadcast-and-multicast)
  - [Messaging patterns](#messaging-patterns)
  - [Service discovery protocols](#service-discovery-protocols)
  - [Read-eval-print loop (REPL)](#read-eval-print-loop-repl)
  - [Variable length data](#variable-length-data)
- [Practical content](#practical-content)
  - [Execute the code examples](#execute-the-code-examples)
  - [Try to access the server from multiple clients at the same time](#try-to-access-the-server-from-multiple-clients-at-the-same-time)
  - [Update your application protocol](#update-your-application-protocol)
  - [Explore the Java TCP programming template](#explore-the-java-tcp-programming-template)
  - [Go further](#go-further)
- [Conclusion](#conclusion)
  - [What did you do and learn?](#what-did-you-do-and-learn)
  - [Test your knowledge](#test-your-knowledge)
- [Finished? Was it easy? Was it hard?](#finished-was-it-easy-was-it-hard)
- [Additional resources](#additional-resources)
- [Solution](#solution)
- [Sources](#sources)

## Objectives

As you have seen in previous chapters, applications communicate with each other
using application protocols.

In this chapter, you will learn how to program your own TCP clients and servers
in Java.

This will allow you to create your own network applications, such as a chat
server, a file server, a web server, etc.

## Part 1

### Explore the code examples

Individually, or in pair/group, **take 10 minutes to explore and discuss the
code examples** provided in the
[`heig-vd-dai-course/heig-vd-dai-course-code-examples`](https://github.com/heig-vd-dai-course/heig-vd-dai-course-code-examples)
repository. Clone it or pull the latest changes to get the code examples.

The code examples are located in the `12-java-tcp-programming` directory.

Try to answer the following questions:

- How do the code examples work?
- What are the main takeaways of the code examples?
- What are the main differences between the code examples?

You can use the following theoretical content to help you.

### TCP

TCP is a transport protocol. It is used to transfer data between two
applications.

TCP is a connection-oriented protocol: a connection must be established between
the two applications before data can be exchanged in a bidirectional way.

TCP can only do unicast: one application can only communicate with one other
application at the same time.

It is considered as a reliable protocol as data sent is guaranteed to be
received by the other application.

A good analogy is to think of TCP as a phone call: you must first establish a
connection with the other person before you can talk to them. Once the
connection is established, you can talk to the other person and they will hear
everything you say. If they did not hear you well, you can repeat what you said
until they hear you. They can, of course, also talk to you.

TCP is a stream-oriented protocol: data is sent as a stream of bytes. The
application must split the data into segments. Each segment is identified by a
sequence number.

TCP segments are encapsulated in IP packets, called payloads.

Thanks to the sequence numbers, TCP is able to reassemble the segments in the
correct order. If a segment is lost, TCP will retransmit it.

#### The Socket API

The Socket API is a Java API that allows you to create TCP clients and servers.
It is described in the
[`java.net` package](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/net/package-summary.html)
in the
[`java.base` module](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/module-summary.html).

It has originally been developed in C in the context of the Unix operating
system by Berkeley University. It has been ported to Java and is now available
on many platform and languages.

To make it simple, a socket is just like a file that you can open, read from,
write to and close. To exchange data, sockets on both sides must be connected.
The processing is the same as with files, seen in the
[Java IOs chapter](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/05-java-ios).

A socket is identified by an IP address and a port number.

A socket can act as a client or as a server:

- A socket accepting connections is called a server socket (class
  [`ServerSocket`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/net/ServerSocket.html)).
- A socket initiating a connection is called a client socket (class
  [`Socket`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/net/Socket.html)).

The following schema shows the workflow of a client/server application:

![Client/server application workflow](./images/client-server-workflow.png)

##### Client/server common methods

| Operation           | Description                        |
| ------------------- | ---------------------------------- |
| `socket()`          | Creates a new socket               |
| `getInputStream()`  | Gets the input stream of a socket  |
| `getOutputStream()` | Gets the output stream of a socket |
| `close()`           | Closes a socket                    |

##### Client workflow and methods

In order to create a client, the following workflow is followed:

> 1. Create a socket (class `Socket`)
> 2. Connect the socket to an IP address and a port number
> 3. Read and write data from/to the socket
> 4. Flush and close the socket

The available methods are the following:

| Operation   | Description                                          |
| ----------- | ---------------------------------------------------- |
| `connect()` | Connects a socket to an IP address and a port number |

#### Server structure and methods

In order to create a server, the following workflow is followed:

> 1. Create a socket (class `ServerSocket`)
> 2. Bind the socket to an IP address and a port number
> 3. Listen for incoming connections
> 4. Loop
>    1. Accept an incoming connection - creates a new socket (class `Socket`) on
>       a random port number
>    2. Read and write data from/to the socket
>    3. Flush and close the socket
> 5. Close the socket (`ServerSocket`)

The available methods are the following:

| Operation  | Description                                       |
| ---------- | ------------------------------------------------- |
| `bind()`   | Binds a socket to an IP address and a port number |
| `listen()` | Listens for incoming connections                  |
| `accept()` | Accepts an incoming connection                    |

#### Processing data from streams

Sockets use data streams to send and receive data, just like files.

You get an input stream to read data from a socket and an output stream to write
data to a socket.

```java
// Get input stream
input = socket.getInputStream();

// Get output stream
output = socket.getOutputStream();
```

You can then decorate the input and output streams with other streams to process
the data, just as with IOs.

```java
// Get input stream as text
input = new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8);

// Get output stream as text
output = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
```

Use buffered streams to improve performance:

```java
// Get input stream as binary with buffer
input = new BufferedReader(new InputStreamReader(socket.getInputStream());

// Get output stream as binary with buffer
output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream());
```

> [!IMPORTANT]
>
> Do not forget to flush the output stream after writing data to it. Otherwise,
> the remaining data in the buffer will not be sent to the other application!
>
> ```java
> out.flush();
> ```
>
> Also, do not forget all the good practices seen in the
> [Java IOs chapter](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/05-java-ios)
> (encoding, buffering, etc.). They must be applied here too!

### UDP

UDP is a transport layer protocol, like TCP. It is used to send data over the
network. However, there are numerous differences between TCP and UDP.

UDP is a connectionless protocol, which means that it does not require to
establish a connection before sending data.

UDP does not provide any reliability mechanism. It does not guarantee that the
data will be received by the receiver at all, nor that the data will be received
in the same order as it was sent.

A good analogy is to think of UDP as the postal service with postcards: you
write multiple postcards and send them to someone. You do not know if the
postcards will be received nor if they arrive in the same order as they were
sent. You do not know if the postcards will be received at all if the postal
service loses them.

Just as with postcards, UDP is used when reliability is not required.

#### Differences between TCP and UDP

The following table summarizes the differences between TCP and UDP.

| TCP                                 | UDP                                        |
| ----------------------------------- | ------------------------------------------ |
| Connection-oriented                 | Connectionless                             |
| Reliable                            | Unreliable                                 |
| Stream protocol                     | Datagram protocol                          |
| Unicast                             | Unicast, broadcast and multicast           |
| Request-response                    | Fire-and-forget, request-response (manual) |
| -                                   | Service discovery protocols                |
| Used for FTP, HTTP, SMTP, SSH, etc. | Used for DNS, streaming, gaming, etc.      |

#### UDP datagrams

Unlike TCP, UDP is not a stream protocol. It is a datagram protocol. It means
that UDP sends data in discrete chunks called datagrams.

Datagrams are like the postcards in the previous analogy. They are sent
independently from each other. They are not related to each other. They contain
a destination address, a payload and the sender address. If you need to, you can
use the sender address to reply to the sender.

UDP datagrams are composed of a header and a payload. The header contains
information about the datagram, such as the source and destination port. The
payload contains the data to send.

The size of the payload is limited to 65,507 bytes. It is because the payload
length is encoded on 16 bits in the header.

The payload of a UDP datagram can be a notification, a request, a query, a
response, etc. It is up to the application to define the payload format.

If the payload is too large, the datagram will be fragmented. It means that the
payload will be split into multiple datagrams. The receiver will have to
reassemble the datagrams to get the original payload.

#### Reliability

As UDP does not provide any reliability mechanism, it is up to the application
to implement it. For example, the application can implement a mechanism to
acknowledge the reception of a datagram and retransmit it if it was not
received.

What is offered by TCP has to be implemented by the application with UDP.

In certain cases, reliability is not required. Some applications are tolerant to
data loss.

For example, streaming can be a perfect use case for UDP. If a datagram is lost,
it does not matter much: the receiver will receive the next datagram and the
stream will continue. A good example would be the streaming of a live event on
your television:

- If a few datagrams are lost, the receiver might notice it with a few glitches
  (video artifacts) but it will not affect the entire stream.
- If too many datagrams are lost, the receiver will not be able to reassemble
  the payload and the stream will stop.

Some video services such as [Jitsi](https://jitsi.org/) (an open source
Zoom/Google Meet/Teams alternative) can make usage of the UDP protocol with the
help of [WebRTC](https://webrtc.org/). However, even these applications might
prefer to make usage of the TCP protocol to guarantee the reliability of their
services.

The game [Factorio](https://www.factorio.com/) (a game where you build and
manage factories) is another good example of an application that make usage of
the UDP protocol when playing on a multiplayer server:

> Factorio uses UDP only. The game builds its own "reliable delivery" layer
> built on UDP to deal with packet loss and reordering issues.
>
> <https://wiki.factorio.com/Multiplayer>

As mentioned before, it is up to the application to implement a reliability
mechanism if required (with a message ID and an acknowledgement for example,
just as TCP).

We can illustrate this with the following example:

You have developed a very simple application protocol where clients can send
`INCREMENT` and `DECREMENT` commands to increment/decrement a counter on the
server. The counter is shared between all clients.

If the clients send 10 `INCREMENT` commands, the counter should be incremented
by 10.

In a perfect world, the server would receive 10 `INCREMENT` commands and the
counter would be incremented by 10.

However, we know one of the datagrams could be lost. If the server receives 9
`INCREMENT` commands, the counter will be incremented by 9 instead of 10.

Both parties (the client and the server) could implement a reliability mechanism
to solve this issue.

The server could implement a reliability mechanism to acknowledge the reception
of a datagram. If a client does not receive an acknowledgement _within a
specific period_, it should retransmit the datagram.

However, even the acknowledgement could be lost. The client could retransmit the
datagram multiple times and the server could receive it multiple times.

The server could implement a mechanism to detect duplicate datagrams and ignore
them. It could also implement a mechanism to detect out-of-order datagrams and
reorder them.

Handling reliability is quite challenging. In the context of this course,
reliability is not required. We will focus on the UDP protocol itself and not on
the reliability mechanism(s).

If you are interested, you can have a look at the
[Automatic Repeat reQuest (ARQ)](https://en.wikipedia.org/wiki/Automatic_repeat_request)
protocol. It is a mechanism used to detect and retransmit lost datagrams.

#### UDP in the Socket API

As seen in the
[Java TCP programming](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/12-java-tcp-programming)
chapter, the Socket API is a Java API that allows you to create TCP/UDP clients
and servers. It is described in the
[`java.net` package](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/net/package-summary.html)
in the
[`java.base` module](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/module-summary.html).

In the UDP world, the `Socket` class is replaced by the `DatagramSocket` class.

The `DatagramSocket` class is used to create UDP clients and servers. It is used
to send and receive UDP datagrams.

A datagram is created with the `DatagramPacket` class. It is used to create a
datagram with a payload and a destination address.

A multicast socket is created with the `MulticastSocket` class. It is used to
create a multicast datagram with a payload and a multicast address, allowing
multiple hosts to receive the datagram.

UDP can be used to create a client-server architecture. However, it is not
required. It is possible to create a peer-to-peer architecture with UDP.

## Part 2

### Unicast, broadcast and multicast

Unlike TCP, UDP supports three types of communication: unicast, broadcast and
multicast (TCP only supports unicast).

#### Unicast

Unicast is the most common type of communication. It is a one-to-one
communication. It means that a datagram is sent from one host to another host,
just like TCP.

Think of it as a private conversation between two people.

To send a unicast datagram, the sender must know the IP address and port of the
receiver. It is mostly the same as TCP, without all the features provided by TCP
but all the performance of UDP.

#### Broadcast

Broadcast is a one-to-all communication. It means that a datagram is sent from
one host to all hosts on the network.

Think of it as a public announcement.

To send a broadcast datagram, the sender must know the broadcast address. The
broadcast address is a special address that represents all hosts on the network
and/or all hosts of a specific subnet.

The broadcast address is defined by the subnet mask. The subnet mask is a 32-bit
number. It is represented as four numbers separated by a dot (e.g.
`255.255.255.0`). Sometimes, the subnet mask is represented as a single number
(e.g. `/24` for `255.255.255.0` as 24 bits are set to `1`).

A good example is stated in the following table (source:
<https://en.wikipedia.org/wiki/Broadcast_address>):

| Network IP address breakdown for `172.16.0.0/12`                                                                                                                                                                                                                                  | Binary form                             | Dot-decimal notation |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------- | -------------------- |
| 1. Network IP Address                                                                                                                                                                                                                                                             | 10101100.0001**0000.00000000.00000000** | 172.16.0.0           |
| 2. Subnet Mask, or just "Netmask" for short (The `/12` in the IP address in this case means only the left-most 12 bits are `1`s, as shown here. This reserves the left 12 bits for the network address (prefix) and the right `32 - 12 = 20` bits for the host address (suffix).) | 11111111.1111**0000.00000000.00000000** | 255.240.0.0          |
| 3. Bit Complement (Bitwise NOT) of the Subnet Mask                                                                                                                                                                                                                                | 00000000.0000**1111.11111111.11111111** | 0.15.255.255         |
| 4. Broadcast address (Bitwise OR of _Network IP Address_ and _Bit Complement of the Subnet Mask_. This makes the broadcast address the _largest possible IP address (and host address, since the host address portion is all `1`s) for any given network address._)               | 10101100.0001**1111.11111111.11111111** | 172.31.255.255       |

If you want to send a broadcast to all devices on all network subnets, you can
use the `255.255.255.255` broadcast address.

> [!IMPORTANT]  
> You must be aware that there can be restrictions on the use of broadcast. For
> example, broadcast is limited to the local network but can still be blocked by
> a firewall and/or a router.

#### Multicast

Multicast is a one-to-many communication. It means that a datagram is sent from
one host to multiple hosts.

Think of it as a group conversation.

To send a multicast datagram, the sender uses a multicast address. The multicast
address is a special address that represents a group of hosts on the network.
Think of it as a radio channel or a Discord channel: everyone on the channel
will receive the messages sent in a given channel.

Multicast addresses are specific IP addresses in the range from `224.0.0.0` to
`239.255.255.255` for IPv4 and `f00::/8` for IPv6.

Just as for ports, some multicast addresses are reserved for specific purposes.
A complete list is available on the
[IANA website](https://www.iana.org/assignments/multicast-addresses/multicast-addresses.xhtml)
and further described in the
[RFC 5771](https://datatracker.ietf.org/doc/html/rfc5771).

For local networks, the multicast range is from the **Administratively Scoped
Bloc** of the RFC. More details are available in the
[RFC 2365](https://datatracker.ietf.org/doc/html/rfc2365).

Any multicast addresses in the range `239.0.0.0` to `239.255.255.255` can be
used for your own applications.

Just as for broadcast, the sender must know the multicast address to send a
datagram to a multicast group. Just as for broadcast as well, there can be
restrictions on the use of multicast.

Multicast is quite guaranteed **not** to work on the public Internet. It is only
guaranteed to work on a local network. If you need to use multicast between
multiple networks, you must use a tunnel such as a virtual private network (VPN)
to bypass this restriction.

Multicast is presented in this course because it is an important concept in
service discovery protocols. However, you must be aware that it is quite not
possible to use multicast on the public Internet, thus it greatly limits its
usage.

Also, Multicast is a complex topic. It is not covered in depth in this course.
For a deeper understanding of possible usages of multicast on the Internet, you
can read the following resources:

- [IP multicast](https://en.wikipedia.org/wiki/IP_multicast)
- [Internet Group Management Protocol](https://en.wikipedia.org/wiki/Internet_Group_Management_Protocol)
- [Internet Protocol television](https://en.wikipedia.org/wiki/Internet_Protocol_television)

### Messaging patterns

As UDP does not provide a connection mechanism, it is up to the application to
define the messaging pattern (how to send and receive data).

There are two common messaging patterns: fire-and-forget and request-response.

The fire-and-forget pattern is the simplest messaging pattern. It is a one-way
communication. It means that a datagram is sent from one host to another host
without expecting a response.

The fire-and-forget pattern is used when the sender does not need to know if the
datagram was received or not.

The request-response (sometimes called request-reply) pattern is a two-way
communication. It means that a datagram is sent from one host to another host
and a response is expected.

When creating a datagram, it is possible to specify a port. While not mandatory,
this port can be used by the receiver to know whom to reply to.

If no port is specified, the operating system will simply assign a random port
for the out going datagram.

The receiver of the datagram can then extract the sender's IP address and port
and use them to reply to the sender using unicast.

The request-response pattern can be used when the sender needs to know if the
datagram was received or not.

Both sides of the communication can send a request and receive a response.

### Service discovery protocols

With unicast, the sender must know who the receiver is; the sender must know the
IP address of the receiver.

With broadcast and multicast, the sender does not need to know who the receivers
are; the sender does not need to know the IP address of the receivers. The
sender knows that nodes nearby (or those who expressed interest in the
broadcast) will receive the datagram.

Using this property, it is possible to create service discovery protocols.

Service discovery protocols are used to discover services on the network. They
are used to find services without knowing their IP address.

There are two types of service discovery protocols: passive and active.

Passive service discovery protocols are based on broadcast or multicast. They
are used to announce the presence of a service on the network.

Active service discovery protocols are also based on broadcast or multicast but
then switch to unicast. They are used to query the network to find a service.

There are many service discovery protocol patterns. The most common are the
following:

- Advertisement - A passive discovery protocol pattern: a server (called a
  service provider) announces its presence on the network. The service provider
  sends a broadcast or multicast datagram to announce its presence. The datagram
  contains information about the service (name, IP address, port, etc.). The
  datagram is sent periodically to announce that the service is still available.

  The clients (called service consumers) listen to the broadcast or multicast
  datagrams to discover the services on the network.

  If a service consumer is interested by the service provider announcement, it
  can manifest its interest.

  ![Service discovery protocols - Advertisement pattern](images/service-discovery-protocols-advertisement.png)

- Query - An active discovery protocol pattern: a client (called a service
  consumer) queries the network to find a service. The client sends a unicast
  datagram on the network to request information about a service.

  If a service that provides the requested service (called a service provider)
  is available, it replies with a unicast datagram containing the requested
  information to connect to the service, just as seen with the request-response
  messaging pattern.

  ![Service discovery protocols - Query pattern](images/service-discovery-protocols-query.png)

These patterns can still be used with other protocols such as TCP.

### Read-eval-print loop (REPL)

In order to run multiple commands/actions on the server without closing the
connection, you can use what is called a
[read-eval-print loop (REPL)](https://en.wikipedia.org/wiki/Read%E2%80%93eval%E2%80%93print_loop).

To make it simple, a REPL is simply a loop that will ask the user to input
commands. The loop will then execute the command and display the result. The
loop will continue until the user decides to exit the loop.

In the context of a server, the server will wait for the client to send a
command. The server will then execute the command and send the result back to
the client. The server will continue to wait for the client to send a new
command without closing the connection.

On the client side, the client can interact with the server by sending commands
to the server until they decide to close the connection.

Both the client and the server can close the connection at any time. It is up to
the developer to decide when and who manage to close the connection.

---

### Variable length data

Depending on the application protocol, the data sent can have a variable length.

There are two ways to handle variable length data:

- Use a delimiter
- Use a fixed length

If the data has a delimiter, you can use a buffered reader to read the data
until the delimiter is found.

```java
// End of transmission character
String EOT = "\u0004";

// Read data until the delimiter is found
String line;
while ((line = in.readLine()) != null && !line.equals(EOT)) {
  System.out.println(
    "[Server] received data from client: " + line
  );
}
```

If the data has a fixed length, you must send the length of the data before
sending the data itself.

```java
// Send the length of the data
out.write("DATA_LENGTH " + data.length() + "\n");

// Send the data
out.write(data);
```

```java
// Read the length of the data
String[] parts = in.readLine().split(" ");
int dataLength = Integer.parseInt(parts[1]);

// Read the data
for (int i = 0; i < dataLength; i++) {
  System.out.print((char) in.read());
}
```

---

## Practical content

### Execute the code examples

Return to the code examples and take some time to execute them, understand them
and see the results.

### Try to access the server from multiple clients at the same time

Try to access the server from multiple clients at the same time (start the
client multiple times). You will see that the server can only handle one client
at a time.

Do you have any idea why? You will find the answer in a future chapter but you
can try to find it by yourself now. Discuss with your peers if needed to share
your findings.

### Update your application protocol

Now that you have gained new knowledge regarding TCP, update the application
protocol you have created for the _"Guess the number"_ game in the
[Define an application protocol chapter](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/11-define-an-application-protocol)
chapter to reflect the usage of the TCP protocol.

You can check the official solution in the
[Define an application protocol chapter](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/11-define-an-application-protocol).

### Explore the Java TCP programming template

In this section, you will explore the Java TCP programming template.

This is a simple template that you can use to create your own TCP clients and
servers in Java.

The template is located in the
[`heig-vd-dai-course/heig-vd-dai-course-java-tcp-programming-template`](https://github.com/heig-vd-dai-course/heig-vd-dai-course-java-tcp-programming-practical-content-template).

Take some time to explore the template. Then, try to answer the following
questions:

- How would you use it to create your own TCP clients and servers?
- What are the main takeaways of the template?
- How you would you implement a TCP network application using the template and
  the provided code examples?

You can use the template to create your own TCP network applications.

### Go further

This is an optional section. Feel free to skip it if you do not have time.

#### Implement the _"Guess the number"_ game

Implement the _"Guess the number"_ game using the application protocol you have
made from the
[Define an application protocol chapter](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/11-define-an-application-protocol).

You can use the application protocol you have made or the one provided in the
solution if you have not done it.

Use the template and the code examples you just explored to help you implement
the game.

When you create a new repository, you can choose to use a template. Select the
`heig-vd-dai-course/heig-vd-dai-course-java-tcp-programming-practical-content`
template.

> [!WARNING]
>
> Please make sure that the repository owner is your personal GitHub account and
> not the `heig-vd-dai-course` organization.

#### Dockerize the application

Using the Docker knowledge you have acquired in the
[Docker and Docker Compose chapter](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/06-docker-and-docker-compose),
dockerize the application.

The steps to dockerize the application are the following:

- Create a `Dockerfile` for the application
- Publish the application to GitHub Container Registry

You should then be able to run the server and the client in Docker containers
and access the server from the client using the following commands:

```sh
# Start the server
docker run --rm -it --name the-server <docker-image-tag> server

# Start the client and access the server container
docker run --rm -it <docker-image-tag> client --host the-server
```

> [!NOTE]
>
> I (Ludovic) was not able to test these commands thoroughly. You might need to
> adapt them to make them work. If something does not work, feel free to tell me
> so I can update the commands.

The `--name` sets the name of the container as well as the hostname of the
container. This allows to access the server container using its hostname from
the client.

You might notice that no ports are published to the host. As both container run
on Docker, they share the same network bridge. They can thus communicate
together without passing by the host.

#### Compare your solution with the official one

Compare your solution with the official one stated in the [Solution](#solution)
section.

If you have any questions about the solution, feel free to ask as described in
the [Finished? Was it easy? Was it hard?](#finished-was-it-easy-was-it-hard)
section.

#### Go one step further

- Can you update the network application to allow the client to specify the
  range of the number to guess before starting the game?
- Can you implement the "_Temperature monitoring_" application with TCP?

## Conclusion

### What did you do and learn?

In this chapter, you have learned how to use the Socket API to create your own
TCP clients and servers in Java.

Congratulations! It is a big step forward!

You are now able to create your own network applications, such as a chat server,
a file server, a web server, etc.

As for now, only one client can access the server at the same time. You will see
in a future chapter how to manage multiple clients at the same time!

### Test your knowledge

At this point, you should be able to answer the following questions:

- What is a socket?
- What is the difference between a server socket and a client socket?
- How do sockets compare to files?
- Why is TCP considered as a reliable protocol?

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

- Main illustration by [Carl Nenzen Loven](https://unsplash.com/@archduk3) on
  [Unsplash](https://unsplash.com/photos/N8GdKC4Rcvs)

[markdown]:
	https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/12-java-tcp-programming/COURSE_MATERIAL.md
[pdf]:
	https://heig-vd-dai-course.github.io/heig-vd-dai-course/12-java-tcp-programming/12-java-tcp-programming-course-material.pdf
[license]:
	https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/116
[illustration]: ./images/main-illustration.jpg
