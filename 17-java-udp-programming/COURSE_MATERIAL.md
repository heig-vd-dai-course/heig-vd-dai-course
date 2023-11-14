[markdown]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/17-java-udp-programming/COURSE_MATERIAL.md
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/17-java-udp-programming/17-java-udp-programming-course-material.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/120
[illustration]:
  https://images.unsplash.com/photo-1578054041218-5ee0003926dd?fit=crop&h=720

# Java UDP programming - Course material

<https://github.com/heig-vd-dai-course>

[Markdown][markdown] · [PDF][pdf]

L. Delafontaine and H. Louis, with the help of Copilot.

Based on the original course by O. Liechti and J. Ehrensberger.

This work is licensed under the [CC BY-SA 4.0][license] license.

![Main illustration][illustration]

## Table of contents

- [Table of contents](#table-of-contents)
- [Objectives](#objectives)
- [Difference between TCP and UDP](#difference-between-tcp-and-udp)
- [UDP datagrams](#udp-datagrams)
- [Reliability](#reliability)
- [Unicast, broadcast and multicast](#unicast-broadcast-and-multicast)
  - [Unicast](#unicast)
  - [Broadcast](#broadcast)
  - [Multicast](#multicast)
- [Messaging patterns](#messaging-patterns)
  - [Fire-and-forget](#fire-and-forget)
  - [Request-response](#request-response)
- [Service discovery protocols](#service-discovery-protocols)
- [The Socket API (UDP version)](#the-socket-api-udp-version)
- [Practical content](#practical-content)
  - [Create an UDP client to find a server and send a file](#create-an-udp-client-to-find-a-server-and-send-a-file)
  - [Create an UDP server](#create-an-udp-server)
  - [Create a UDP server with Unicast](#create-a-udp-server-with-unicast)
  - [Create a UDP server with Multicast](#create-a-udp-server-with-multicast)
  - [Create a UDP server with Broadcast](#create-a-udp-server-with-broadcast)
  - [Create a UDP server to discover other servers](#create-a-udp-server-to-discover-other-servers)
  - [Go further](#go-further)
- [Conclusion](#conclusion)
  - [What did you do and learn?](#what-did-you-do-and-learn)
  - [Test your knowledge](#test-your-knowledge)
- [Finished? Was it easy? Was it hard?](#finished-was-it-easy-was-it-hard)
- [What will you do next?](#what-will-you-do-next)
- [Additional resources](#additional-resources)
- [Sources](#sources)

## Objectives

## Difference between TCP and UDP

UDP is a transport layer protocol, like TCP. It is used to send data over the
network. It is a connectionless protocol, which means that it does not require
to establish a connection before sending data.

UDP is a simple protocol. It does not provide any reliability mechanism. It does
not guarantee that the data will be received by the receiver. It does not
guarantee that the data will be received in the same order as it was sent.

A good analogy is to think of UDP as a postcard. You write a message on multiple
postcards and send them to someone. You do not know if the postcards will be
received nor in the same order as they were sent. You do not know if the
postcard will be received at all.

Unlike TCP, UDP is not a stream protocol. It is a datagram protocol. It means
that UDP sends data in discrete chunks called datagrams.

## UDP datagrams

UDP datagrams are composed of a header and a payload. The header contains
information about the datagram, such as the source and destination port. The
payload contains the data to send.

The payload of a UDP datagram is limited to 65,507 bytes. It is because the
payload length is encoded on 16 bits in the header.

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

In certain cases, reliability is not required. Some applications are tolerant to
data loss.

For example, streaming is a perfect use case for UDP. If a datagram is lost, it
does not matter much: the receiver will receive the next datagram and the stream
will continue.

If a few datagrams are lost, the receiver might notice it with a few glitches
(on videos with artifacts such as a Twitch stream if your connection is not good
for example) but it will not affect the stream.

If too many datagrams are lost, the receiver will not be able to reassemble the
payload and the stream will stop.

As mentioned before, it is up to the application to implement a reliability
mechanism if required (with a message ID and an acknowledgement for example).

Handling reliability is quite challenging. In the context of this course,
reliability is not required. We will focus on the UDP protocol itself and not on
the reliability mechanism.

## Unicast, broadcast and multicast

Unlike TCP, UDP supports three types of communication: unicast, broadcast and
multicast.

### Unicast

Unicast is the most common type of communication. It is a one-to-one
communication. It means that a datagram is sent from one host to another host,
just like TCP.

Think of it as a private conversation between two people.

### Broadcast

Broadcast is a one-to-all communication. It means that a datagram is sent from
one host to all hosts on the network.

Think of it as a public announcement.

### Multicast

Multicast is a one-to-many communication. It means that a datagram is sent from
one host to multiple hosts.

Think of it as a group conversation.

## Messaging patterns

As UDP does not provide a connection mechanism, it is up to the application to
define the messaging pattern (how to send and receive data).

There are two common messaging patterns: fire-and-forget and request-response.

### Fire-and-forget

The fire-and-forget pattern is the simplest messaging pattern. It is a one-way
communication. It means that a datagram is sent from one host to another host
without expecting a response.

The fire-and-forget pattern is used when the sender does not need to know if the
datagram was received or not.

### Request-response

The request-response (sometimes called request-reply) pattern is a two-way
communication. It means that a datagram is sent from one host to another host
and a response is expected.

The request-response pattern is used when the sender needs to know if the
datagram was received or not.

Both sides of the communication can send a request and receive a response.

## Service discovery protocols

With unicast, the sender must know who the receiver is. It means that the sender
must know the IP address of the receiver.

With broadcast and multicast, the sender does not need to know who the receivers
are. It means that the sender does not need to know the IP address of the
receivers. The sender knows that nodes nearby (or those who expressed interest
in the broadcast) will receive the datagram.

Using this property, it is possible to create service discovery protocols.

Service discovery protocols are used to discover services on the network. They
are used to find services without knowing their IP address.

There are two types of service discovery protocols: passive and active.

Passive service discovery protocols are based on broadcast or multicast. They
are used to announce the presence of a service on the network.

Active service discovery protocols are based on unicast. They are used to query
the network to find a service.

There are many service discovery protocol mechanisms. The most common are the
following:

- Advertisement: a service (called a service provider) announces its presence on
  the network. The service provider sends a broadcast or multicast datagram to
  announce its presence. The datagram contains information about the service
  (name, IP address, port, etc.). The datagram is sent periodically to announce
  that the service is still available.

  The clients (called service consumers) listen to the broadcast or multicast
  datagrams to discover the services on the network.

  TODO: Add schema

- Query: a client (called a service consumer) queries the network to find a
  service. The client sends a unicast datagram on the network to request
  information about a service.

  If a service that provides the requested service (called a service provider)
  is available, it replies with a unicast datagram containing the requested
  information to connect to the service.

  TODO: Add schema

## The Socket API (UDP version)

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

A multicast datagram is created with the `MulticastSocket` class. It is used to
create a multicast datagram with a payload and a multicast address, allowing
multiple hosts to receive the datagram.

## Practical content

### Create an UDP client to find a server and send a file

### Create an UDP server

### Create a UDP server with Unicast

### Create a UDP server with Multicast

### Create a UDP server with Broadcast

### Create a UDP server to discover other servers

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

- Main illustration by
  [Possessed Photography](https://unsplash.com/@possessedphotography) on
  [Unsplash](https://unsplash.com/photos/tiNCpHudGrw)
