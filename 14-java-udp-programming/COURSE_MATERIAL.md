[markdown]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/14-java-udp-programming/COURSE_MATERIAL.md
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/14-java-udp-programming/14-java-udp-programming-course-material.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/120
[illustration]:
  https://images.unsplash.com/photo-1578054041218-5ee0003926dd?fit=crop&h=720

# Java UDP programming - Course material

<https://github.com/heig-vd-dai-course>

[Markdown][markdown] · [PDF][pdf]

L. Delafontaine and H. Louis, with the help of GitHub Copilot.

Based on the original course by O. Liechti and J. Ehrensberger.

This work is licensed under the [CC BY-SA 4.0][license] license.

![Main illustration][illustration]

## Table of contents

- [Table of contents](#table-of-contents)
- [Objectives](#objectives)
- [UDP](#udp)
- [Differences between TCP and UDP](#differences-between-tcp-and-udp)
- [UDP datagrams](#udp-datagrams)
- [Reliability](#reliability)
- [UDP in the Socket API](#udp-in-the-socket-api)
- [Unicast, broadcast and multicast](#unicast-broadcast-and-multicast)
  - [Unicast](#unicast)
  - [Broadcast](#broadcast)
  - [Multicast](#multicast)
- [Messaging patterns](#messaging-patterns)
- [Service discovery protocols](#service-discovery-protocols)
- [Practical content](#practical-content)
  - [Run the emitters and receivers example](#run-the-emitters-and-receivers-example)
  - [Dockerize the emitters and receivers example](#dockerize-the-emitters-and-receivers-example)
  - [Isolate broadcast emitters and receivers to their own network](#isolate-broadcast-emitters-and-receivers-to-their-own-network)
  - [Share your project](#share-your-project)
  - [Go further](#go-further)
- [Conclusion](#conclusion)
  - [What did you do and learn?](#what-did-you-do-and-learn)
  - [Test your knowledge](#test-your-knowledge)
- [Finished? Was it easy? Was it hard?](#finished-was-it-easy-was-it-hard)
- [What will you do next?](#what-will-you-do-next)
- [Additional resources](#additional-resources)
- [Solution](#solution)
- [Sources](#sources)

## Objectives

You have seen and experimented with TCP in the previous chapter. You have seen
that TCP is a connection-oriented protocol. It means that a connection must be
established before sending data.

In this chapter, you will see and experiment with UDP. UDP is a connectionless
protocol. It means that a connection does not need to be established before
sending data.

UDP is mainly used when reliability is not required. It is used for streaming,
gaming, etc.

UDP is sensibly different from TCP and it is important to understand the
differences between the two protocols.

## UDP

UDP is a transport layer protocol, like TCP. It is used to send data over the
network. However, there are numerous differences between TCP and UDP.

UDP is a connectionless protocol, which means that it does not require to
establish a connection before sending data.

UDP does not provide any reliability mechanism. It does not guarantee that the
data will be received by the receiver at all, nor that the data will be received
in the same order as it was sent.

A good analogy is to think of UDP as the postal service with postcards. You
write multiple postcards and send them to someone. You do not know if the
postcards will be received nor if they arrive in the same order as they were
sent. You do not know if the postcards will be received at all if the postal
service loses them.

Just as with postcards, UDP is used when reliability is not required.

## Differences between TCP and UDP

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

## UDP datagrams

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

## Reliability

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

## UDP in the Socket API

As seen in the
[Java TCP programming](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/13-java-tcp-programming)
chapter, the Socket API is a Java API that allows you to create TCP/UDP clients
and servers. It is described in the
[`java.net` package](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/net/package-summary.html)
in the
[`java.base` module](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/module-summary.html).

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

## Unicast, broadcast and multicast

Unlike TCP, UDP supports three types of communication: unicast, broadcast and
multicast (TCP only supports unicast).

### Unicast

Unicast is the most common type of communication. It is a one-to-one
communication. It means that a datagram is sent from one host to another host,
just like TCP.

Think of it as a private conversation between two people.

To send a unicast datagram, the sender must know the IP address and port of the
receiver. It is mostly the same as TCP, without all the features provided by TCP
but all the performance of UDP.

### Broadcast

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

### Multicast

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

## Messaging patterns

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

## Service discovery protocols

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

## Practical content

### Run the emitters and receivers example

In this section, you will start an example of emitters and receivers that use
UDP to communicate.

#### Create and clone the repository

You can create a new GitHub project using the template we have prepared for you.
When you create a new repository, you can choose to use a template. Select the
`heig-vd-dai-course/heig-vd-dai-course-java-udp-programming-practical-content-template`
template as shown in the following screenshot:

> [!WARNING]  
> Please make sure that the repository owner is your personal GitHub account and
> not the `heig-vd-dai-course` organization.

![Create the new repository from the template](./images/practical-content-create-and-clone-the-repository.png)

Clone the repository locally.

#### Check the application's help message

Take some time to explore the codebase from the template we have prepared for
you.

Using Maven, build the application as seen in previous chapters, using the
provided Maven wrapper.

Run the Java application with the following command:

```sh
# Run the application
java -jar java-udp-programming-1.0-SNAPSHOT.jar --help
```

Take some time to read and understand the help message.

#### Run the unicast emitter and receiver

Using the help message, start the following applications in different terminals:

- A unicast emitter with the following configuration:
  - Delay: 0 seconds
  - Frequency: 5 seconds
  - Host: `127.0.0.1` or `localhost`
  - Port: `9876`
- A unicast receiver with the following configuration:
  - Port: `9876`

What are the commands to start the unicast emitter and receiver?

Once the emitter is started, you should see that messages are emitted at the
specified frequency in the terminal.

The receiver should receive the messages and print them in the terminal.

Do not stop the emitter and receiver yet.

#### Run the broadcast emitter and receivers

Using the help message, start the following applications in different terminals:

- A broadcast emitter with the following configuration:
  - Delay: 5 seconds
  - Frequency: 30 seconds
  - Host: `255.255.255.255`
  - Port: `9877`
- A broadcast receiver with the following configuration:
  - Port: `9877`

What are the commands to start the broadcast emitter and receiver?

Once the emitter is started, you should see that messages are emitted at the
specified frequency in the terminal.

The receiver should receive the messages and print them in the terminal.

Do not stop the emitter and receiver yet.

#### Run the multicast emitter and receivers

Using the help message, start the following applications in different terminals:

- A multicast emitter with the following configuration:
  - Delay: 10 seconds
  - Frequency: 15 seconds
  - Host: `239.1.1.1`
  - Port: `9878`
  - Network interface: check the note below
- A multicast receiver with the following configuration:
  - Host: `239.1.1.1`
  - Port: `9878`
  - Network interface: check the note below

> [!IMPORTANT]]  
> For the multicast emitter, you must specify a network interface to listen to
> multicast datagrams. Check the help message to know how to do it.

What are the commands to start the multicast emitter and receiver?

Once the emitter is started, you should see that messages are emitted at the
specified frequency in the terminal.

The receiver should receive the messages and print them in the terminal.

Do not stop the emitter and receiver yet.

#### Check the logs of the emitters and receivers

Take some time to read and understand the logs.

What are your conclusions to the following questions?

- What messages do the unicast receiver receives? Why?
- What messages do the broadcast receiver receives? Why?
- What messages do the multicast receiver receives? Why?

#### Stop the emitters and receivers

Stop all the emitters and receivers with `Ctrl` + `C`.

### Dockerize the emitters and receivers example

In this section, you will dockerize the emitters and receivers example to run
them in containers using Docker and Docker Compose.

#### Create the Dockerfile

At the root level of your project, create a `Dockerfile` with the following
content:

```dockerfile
# Start from the Java 17 Temurin image
FROM eclipse-temurin:17

# Set the working directory
WORKDIR /app

# Copy the jar file
COPY target/java-udp-programming-1.0-SNAPSHOT.jar /app/java-udp-programming-1.0-SNAPSHOT.jar

# Set the entrypoint
ENTRYPOINT ["java", "-jar", "java-udp-programming-1.0-SNAPSHOT.jar"]

# Set the default command
CMD ["--help"]
```

Take some time to understand this Dockerfile. Can you explain each line with
your own words?

#### Build and run the Docker image

Just as seen in the
[Docker and Docker Compose](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/06-docker-and-docker-compose)
chapter, build the image accordingly with the tag `java-udp-programming` and run
the container with the name `java-udp-programming`.

Which command(s) did you use to build the Docker image?

Which command(s) did you use to run the Docker image?

#### Publish the Docker image

Just as seen in the
[Docker and Docker Compose](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/06-docker-and-docker-compose)
chapter, publish your Docker image to the GitHub Container Registry.

Which command(s) did you use to publish the Docker image?

#### Create the Docker Compose file

At the root level of your project, create a `docker-compose.yml` file.

Using the examples from the
[Docker and Docker Compose](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/06-docker-and-docker-compose)
chapter, add the same containers as mentioned before as services to your Docker
Compose file:

- A unicast emitter with the following configuration:
  - Delay: 0 seconds
  - Frequency: 5 seconds
  - Host: `unicast-receiver-1`
  - Port: `9876`
- A broadcast emitter with the following configuration:
  - Delay: 5 seconds
  - Frequency: 30 seconds
  - Host: `255.255.255.255`
  - Port: `9876`
- A multicast emitter with the following configuration:
  - Delay: 10 seconds
  - Frequency: 15 seconds
  - Host: `239.1.1.1`
  - Port: `9876`
  - Network interface: `eth0` (the default network interface of the container)
- Two unicast receivers with the following configuration:
  - Unicast receiver 1:
    - Port: `9876`
  - Unicast receiver 2:
    - Port: `9876`
- Two broadcast receivers with the following configuration:
  - Broadcast receiver 1:
    - Port: `9876`
  - Broadcast receiver 2:
    - Port: `9876`
- Three multicast receivers with the following configuration:
  - Multicast receiver 1:
    - Host: `239.1.1.1`
    - Port: `9876`
    - Network interface: `eth0` (the default network interface of the container)
  - Multicast receiver 2:
    - Host: `239.1.1.1`
    - Port: `9876`
    - Network interface: `eth0` (the default network interface of the container)
  - Multicast receiver 3:
    - Host: `239.1.1.2`
    - Port: `9876`
    - Network interface: `eth0` (the default network interface of the container)

Here is a template that can help you:

```yaml
<name of the service>:
  image: <name/link of the docker image>
  command:
    - <pass command arguments to the entrypoint>
```

You should know that Docker Compose creates a DNS hostname for each service it
starts. This means you can access another service using its name.

Example:

```yaml
unicast-emitter:
  image: java-udp-programming
  command:
    - unicast
    - --host=unicast-receiver-1
    - --port=4040
    - --delay=1000
    - --frequency=10000
```

For receivers, you can even add the following line to your service to
start/depend on another service before it starts:

```yaml
depends_on:
  - <name of the service to wait on>
```

#### Run the Docker Compose file

Just as seen in the Docker and Docker Compose chapter, run the Docker Compose
file.

When running your Docker Compose, you should be able to see the outputs of all
the emitters and receivers.

Which command(s) did you use to run the Docker Compose file?

#### Check the logs of the emitters and receivers

Take some time to read and understand the logs.

What are your conclusions to the following questions?

- What messages do the unicast receivers receive? Why?
- What messages do the broadcast receivers receive? Why?
- What messages do the multicast receivers receive? Why?
- What are the differences between the outputs of the emitters and receivers
  when running them with Docker Compose and when running them manually?

> [!TIP]  
> To help you filter and understand the outputs, you can start only a subset of
> the services specified in your Docker Compose file if you want to. For
> example, to start only the unicast emitter and receivers, you can use the
> following command:
>
> ```sh
> # Start only the unicast emitter and receivers
> docker compose up unicast-emitter unicast-receiver-1 unicast-receiver-2
> ```

### Isolate broadcast emitters and receivers to their own network

As you might have noticed, broadcasting will notify all receivers on the
network.

To isolate the broadcast emitters in their own network, Docker and Docker
Compose can make usage of networks.

Docker networks can isolate a number of containers to a specific network. A
network can link multiple containers and containers can be linked to multiple
networks.

In this section, you will add networks to your Docker Compose file to isolate
some containers.

#### Define the network

At the root level of the Docker Compose file, define a Docker network with the
following content:

```yaml
networks:
  my-isolated-network:
    name: my-isolated-network-name
```

This will create a Docker network. You can check the list of Docker networks
with the following command:

```sh
# List Docker networks
docker network list
```

You can find the network you just created with the name
`my-isolated-network-name`.

You should also notice that Docker Compose has created a default network for all
other containers. This network is named with the name of the current directory
in which you ran the Docker Compose commands and add `_default` to the current
directory name.

Docker networks is a topic on its own. We will not go further than this in the
context of this course. We just want to be able to link/isolate containers
together so they can communicate between them.

#### Isolate the broadcast emitters and receivers

To isolate the broadcast emitters and receivers, add the following key to the
`broadcast-emitter`, `broadcast-receiver-1`, `broadcast-receiver-2` containers:

```yaml
networks:
  - my-isolated-network
```

As networks is an array, you can add multiple networks to a container if needed.

#### Run the network again with the isolated networks

Start all containers again. You should notice that the broadcast emitters do not
interfere with the other containers, thanks to the isolated network!

How and why did the network helped for the broadcast emitters and receivers?

### Share your project

Share your project in the GitHub Discussions of this organization:
<https://github.com/orgs/heig-vd-dai-course/discussions>.

Create a new discussion with the following information:

- **Title**: DAI 2023-2024 - UDP emitters and receivers with Docker Compose -
  First name Last Name
- **Category**: Show and tell
- **Description**: The link to your GitHub repository, answers to all questions
  asked in this practical content.

This will notify us that you have completed the exercise and we can check your
work.

You can compare your solution with the official one stated in the
[Solution](#solution) section, however, **we highly recommend you to try to
complete the practical content by yourself first to learn the most**.

### Go further

This is an optional section. Feel free to skip it if you do not have time.

- Are you able to double the number of receivers and emitters but keeping them
  isolated in their own network?

## Conclusion

### What did you do and learn?

In this chapter, you have learned how to use the UPD protocol to build different
kind of network applications and the differences between TCP and UDP.

Using Java and Docker and Docker Compose, you were able to containerize your
network application to use it anywhere.

Just as with TCP, you have now all the knowledge to build bigger and better
network applications. We continue our journey toward network application
programming, understanding and shipment.

### Test your knowledge

At this point, you should be able to answer the following questions:

- What are the differences between UDP and TCP?
- Why is UDP unreliable? How to mitigate this?
- What is a datagram? How can a datagram be sent without a server listening?
- What are the differences between unicast, broadcast and multicast?
- What are the messaging protocols and their differences?
- What are the service discovery protocols? How do they compare to each other?

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

## Solution

You can find the solution to the practical content in the
[`heig-vd-dai-course/heig-vd-dai-course-solutions`](https://github.com/heig-vd-dai-course/heig-vd-dai-course-solutions)
repository.

If you have any questions about the solution, feel free to open an issue to
discuss it!

## Sources

- Main illustration by
  [Possessed Photography](https://unsplash.com/@possessedphotography) on
  [Unsplash](https://unsplash.com/photos/tiNCpHudGrw)
