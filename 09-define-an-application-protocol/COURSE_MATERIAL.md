[markdown]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/09-define-an-application-protocol/COURSE_MATERIAL.md
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/09-define-an-application-protocol/09-define-an-application-protocol-course-material.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/95
[illustration]:
  https://images.unsplash.com/photo-1549319114-d67887c51aed?fit=crop&h=720

# Define an application protocol - Course material

<https://github.com/heig-vd-dai-course>

[Markdown][markdown] · [PDF][pdf]

L. Delafontaine and H. Louis, with the help of Copilot.

This work is licensed under the [CC BY-SA 4.0][license] license.

![Main illustration][illustration]

## Table of contents

- [Table of contents](#table-of-contents)
- [Objectives](#objectives)
- [What is an application protocol?](#what-is-an-application-protocol)
- [How is structured an application protocol?](#how-is-structured-an-application-protocol)
- [How to define an application protocol?](#how-to-define-an-application-protocol)
- [Practical content](#practical-content)
  - [Explore the existing application protocols](#explore-the-existing-application-protocols)
  - [Define your own application protocol](#define-your-own-application-protocol)
  - [Go further](#go-further)
- [Conclusion](#conclusion)
  - [What did you do and learn?](#what-did-you-do-and-learn)
  - [Test your knowledge](#test-your-knowledge)
- [Finished? Was it easy? Was it hard?](#finished-was-it-easy-was-it-hard)
- [What will you do next?](#what-will-you-do-next)
- [Additional resources](#additional-resources)
- [Sources](#sources)

## Objectives

This chapter will help you understand how to understand and define an
application protocol.

An application protocol is a document that is used to define how applications
exchange information between them (usually a between a client and a server). It
is defined by a set of rules that each party must follow to communicate.

In this chapter, you will learn where to find information about application
protocols, how is defined an application protocol and how to define your own
application protocol. In future chapters, you will learn how to interact with
well known application protocol.

## What is an application protocol?

An application protocol is a document that defines how two applications can
communicate.

These documents are usually called RFC (Request For Comments) and are available
on the [IETF website](https://www.ietf.org/), an organization that defines
standards for the Internet (among others).

The name RFC comes from the fact that these documents are usually the result of
a discussion between multiple people. The RFC is a document that is open to
comments and suggestions. It is usually updated multiple times before being
considered as a standard.

An application protocol relies on a transport protocol (TCP or UDP) and a
network protocol (IP). It comes on top of these protocols and defines how
applications can communicate.

Multiple revisions of the same protocol can exist. For example, the HTTP
protocol has multiple revisions (HTTP/1.0, HTTP/1.1, HTTP/2, HTTP/3). Each
revision is defined by a different RFC and has different features.

## How is structured an application protocol?

An application protocol is usually defined by a set of rules that each party
must follow to communicate.

These rules are usually defined in a RFC as messages. The RFC defines the
messages that can be exchanged between the client and the server, the format of
these messages and the order in which they can be exchanged.

For example, the SMTP protocol defines the following messages (among others):

- `HELO`: used to initiate a connection with the server
- `EHLO`: used to initiate a connection with the server
- `MAIL`: used to specify the sender of the message
- `RCPT`: used to specify the recipient of the message
- `DATA`: used to send the content of the message
- `RSET`: used to reset the connection

Each message has a specific format. For example, the `MAIL` message has the
following format:

```
MAIL FROM:<sender>
```

The `MAIL` message is used to specify the sender of the message. The sender is
specified after the `MAIL FROM:` keyword. You will learn more about the SMTP
protocol in a future chapter to illustrate this example.

A RFC also defines the order in which messages can be or must be exchanged.

This is done using a state machine or a sequence diagram, depending on the
nature/complexity of the protocol.

A sequence diagram is a diagram that defines the different messages that can be
exchanged between the client and the server and the order in which they can be
exchanged.

A state machine is a diagram that defines the different states of the protocol
and the messages that can be exchanged between these states.

An RFC also defines edge cases and error cases, using the same diagrams. It is
important to define these cases to avoid any ambiguity and define how the
protocol should behave in these cases.

## How to define an application protocol?

Defining an application protocol is not an easy task. It requires a lot of
thinking and a lot of testing.

The first step is to define the purpose of the protocol. What is the goal of the
protocol? What is the problem that it tries to solve?

The second step is to define the messages that can be exchanged between the
client and the server. What are the messages that the client can send to the
server? What are the messages that the server can send to the client?

The third step is to define the format of the messages. What is the format of
the messages? What are the different fields that compose a message? What is the
format of these fields?

The fourth step is to define the order in which messages can be exchanged. What
is the order in which messages can be exchanged? What is the order in which
messages must be exchanged?

The fifth step is to define the state machine or the sequence diagram. What are
the different states of the protocol? What are the messages that can be
exchanged between these states?

The sixth step is to define the transport protocol and the network protocol that
will be used. What is the transport protocol that will be used? What is the
network protocol that will be used?

The seventh step is to define the security of the protocol. What are the
security mechanisms that will be used? What are the security mechanisms that
will be implemented?

The eighth step is to define the implementation of the protocol. How will the
protocol be implemented? What are the different libraries that can be used to
implement the protocol?

The ninth step is to define the testing of the protocol. How will the protocol
be tested? What are the different tests that will be implemented?

The tenth step is to define the deployment of the protocol. How will the
protocol be deployed? What are the different environments that will be used to
deploy the protocol?

It is also important to keep in mind that a protocol is never perfect. It can
always be improved. It is important to keep an open mind and to be ready to
change the protocol if needed.

## Practical content

### Explore the existing application protocols

In this section, you will explore the existing application protocols. This will
help you to better understand how an application protocol is defined and how to
define your own application protocol.

These protocols are some of the most common protocols. Many other protocols
exist but we might not have the time to explore them all. Some of them will be
studied in future chapters.

#### Better understand the SMTP protocol

Try to answer the following questions using the
[official RFC for the SMTP protocol](https://tools.ietf.org/html/rfc5321):

- What is the purpose of the SMTP protocol?
- On which port does the SMTP protocol work?
- On which protocol does the SMTP protocol work?
- Who initiates the connection?
- What are the available messages?

#### Better understand the POP3 protocol

Try to answer the following questions using the
[official RFC for the POP3 protocol](https://datatracker.ietf.org/doc/html/rfc1939):

- What is the purpose of the POP3 protocol?
- On which port does the POP3 protocol work?
- On which protocol does the POP3 protocol work?
- Who initiates the connection?
- What are the available messages?
- What is the difference between POP3 and SMTP?

#### Better understand the IMAP protocol

Try to answer the following questions using the
[official RFC for the IMAP protocol](rfc3501):

- What is the purpose of the IMAP protocol?
- On which port does the IMAP protocol work?
- On which protocol does the IMAP protocol work?
- Who initiates the connection?
- What are the available messages?
- What is the difference between POP3, SMTP and IMAP?

#### Better understand the SSH protocol

Try to answer the following questions using the
[official RFC for the SSH protocol](https://tools.ietf.org/html/rfc4253):

- What is the purpose of the SSH protocol?
- On which port does the SSH protocol work?
- On which protocol does the SSH protocol work?
- Who initiates the connection?
- What are the available messages?
- How is the version exchange done?

#### Better understand the HTTP protocol

Try to answer the following questions using the
[official RFC for the HTTP/3 protocol](https://datatracker.ietf.org/doc/html/rfc9113):

- What is the purpose of the HTTP protocol?
- On which port does the HTTP protocol work?
- On which protocol does the HTTP protocol work? Is there a difference between
  HTTP/2 and HTTP/3?
- Who initiates the connection?
- What are the available messages?

### Define your own application protocol

In this section, you will define your own application protocol based on a given
context.

#### The context

You are working for a company that wants to create a new application protocol
for their new application. This application will be used to send text messages
between users.

The users use a client to interact with the server.

The server runs on a specific port (1234). The clients connect to the server.
The server can only accept a limited number of connections (5). The server can
refuse a connection if it is already full.

Once connected, the users can send text messages to other users.

The server accepts text messages from the client and sends them to the
recipient.

The serveur can only accept text messages from users that are connected. The
text messages can only be of a certain length (100 characters).

#### The exercise

You are asked to define the application protocol that will be used by the
clients and the server.

Keep in mind the following points:

- What is the purpose of the protocol?
- On which port(s) does the protocol work?
- On which protocol(s) does the SSH protocol work?
- Who initiates the connection?
- What are the available messages/actions?
- What is the format of the messages/actions?
- Are there any edge cases or error cases? What happens in these cases?

You can represent your application protocol using a state machine or a sequence
diagram.

You can use [PlantUML](https://plantuml.com/), [Draw.io](https://draw.io/) or
any other tools you want to create your diagrams.

#### Share your application protocol

Share your application protocol in the GitHub Discussions of this organization:
<https://github.com/orgs/heig-vd-dai-course/discussions>.

Create a new discussion with the following information:

- **Title**: DAI 2023-2024 - Check out my application protocol! - First name
  Last Name
- **Category**: Show and tell
- **Description**: Copy/paste your application protocol.

This will notify us that you have completed the exercise and we can check your
work.

### Go further

This is an optional section. Feel free to skip it if you do not have time.

- You can check the RFC for the FTP protocol, DNS protocol and the DHCP
  protocol. Are they similar to the protocols you have seen before? What are the
  differences?

## Conclusion

### What did you do and learn?

In this chapter, you have learned how an application protocol is defined using
RFCs.

You are able to understand an existing application protocol and define your own
application protocol.

You have also learned the importance of defining an application protocol and the
different steps to follow to define an application protocol.

These skills are essential to understand how applications communicate with each
other and how to define your own application protocol for others to use.

### Test your knowledge

At this point, you should be able to answer the following questions:

- How is structured an application protocol?
- Why is it important to define an application protocol?
- How to define an application protocol?
- Where can you find information about application protocols?
- What is a RFC?
- How can a diagram help you to understand an application protocol?

## Finished? Was it easy? Was it hard?

Can you let us know what was easy and what was difficult for you during this
chapter?

This will help us to improve the course and adapt the content to your needs. If
we notice some difficulties, we will come back to you to help you.

➡️ [GitHub Discussions][discussions]

You can use reactions to express your opinion on a comment!

## What will you do next?

In the next chapter, you will learn the following topics:

- Docker and Docker Compose

## Additional resources

_Resources are here to help you. They are not mandatory to read._

- _None yet_

_Missing item in the list? Feel free to open a pull request to add it! ✨_

## Sources

- Main illustration by [Nathan Dumlao](https://unsplash.com/@nate_dumlao) on
  [Unsplash](https://unsplash.com/photos/KixfBEdyp64)
