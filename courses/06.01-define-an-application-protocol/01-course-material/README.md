# Define an application protocol

![Main illustration](./images/main-illustration.jpg)

L. Delafontaine and H. Louis, with the help of
[GitHub Copilot](https://github.com/features/copilot).

Based on the original course by O. Liechti and J. Ehrensberger.

This work is licensed under the [CC BY-SA 4.0][license] license.

## Resources

- Objectives, teaching and learning methods, and evaluation methods:
  [Link to content](..)
- Course material: [Link to content](../01-course-material/README.md) ·
  [Presentation (web)](https://heig-vd-dai-course.github.io/heig-vd-dai-course/06.01-define-an-application-protocol/01-course-material/index.html)
  ·
  [Presentation (PDF)](https://heig-vd-dai-course.github.io/heig-vd-dai-course/06.01-define-an-application-protocol/01-course-material/06.01-define-an-application-protocol-presentation.pdf)
- Code examples: [Link to content](../02-code-examples/)
- Solution: [Link to content](../03-solution/)

## Table of contents

- [Resources](#resources)
- [Table of contents](#table-of-contents)
- [Objectives](#objectives)
- [What is an application protocol](#what-is-an-application-protocol)
- [How is structured an application protocol](#how-is-structured-an-application-protocol)
- [How to define an application protocol](#how-to-define-an-application-protocol)
  - [Section 1 - Overview](#section-1---overview)
  - [Section 2 - Transport protocol](#section-2---transport-protocol)
  - [Section 3 - Messages](#section-3---messages)
  - [Section 4 - Examples](#section-4---examples)
- [Example - The SMS protocol](#example---the-sms-protocol)
- [Practical content](#practical-content)
  - [Define the application protocol for the _"Guess the number"_ game](#define-the-application-protocol-for-the-guess-the-number-game)
  - [Define the application protocol for the _"Temperature monitoring"_ application](#define-the-application-protocol-for-the-temperature-monitoring-application)
  - [Compare your application protocols with the official ones](#compare-your-application-protocols-with-the-official-ones)
  - [Go further](#go-further)
- [Conclusion](#conclusion)
  - [What did you do and learn?](#what-did-you-do-and-learn)
  - [Test your knowledge](#test-your-knowledge)
- [Finished? Was it easy? Was it hard?](#finished-was-it-easy-was-it-hard)
- [Additional resources](#additional-resources)
- [Solution](#solution)
- [Sources](#sources)

## Objectives

An application protocol is a document that is used to define how applications
exchange information between them (usually between a client and a server). It is
defined by a set of rules that each party must follow to communicate.

In this course, you will learn where to find information about application
protocols, how is defined an application protocol and how to define your own
application protocol. In future courses, you will learn how to interact with
well known application protocols.

In a nutshell, by the end of this course, you should be able to:

- Learn where to find information about application protocols.
- Understand application protocol.
- Define application protocols.
- How to use an application protocol.

> [!IMPORTANT]
>
> While quite short, this course is one of the most important in the teaching
> unit. It will help you to understand how applications communicate with each
> other and how to define your own application protocol for others to use.

## What is an application protocol

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

Here are some examples of application protocols:

- [Official RFC for the SMTP protocol](https://tools.ietf.org/html/rfc5321)
- [Official RFC for the POP3 protocol](https://datatracker.ietf.org/doc/html/rfc1939)
- [Official RFC for the IMAP protocol](https://datatracker.ietf.org/doc/html/rfc3501)
- [Official RFC for the SSH protocol](https://datatracker.ietf.org/doc/html/rfc4253)
- [Official RFC for the HTTP/3 protocol](https://datatracker.ietf.org/doc/html/rfc9113)

## How is structured an application protocol

An application protocol is usually defined by a set of rules that each party
must follow to communicate.

These rules are usually defined in a RFC as _messages_ (also known as _actions_
or _commands_). The RFC defines the messages that can be exchanged between the
client and the server, the format of these messages and the order in which they
can be exchanged.

For example, the SMTP protocol defines the following messages (among others):

- `HELO`: used to initiate a connection with the server.
- `EHLO`: used to initiate a connection with the server (extended version of
  `HELO`).
- `MAIL`: used to specify the sender of the message.
- `RCPT`: used to specify the recipient of the message.
- `DATA`: used to send the content of the message.
- `RSET`: used to reset the connection.

Each message has a specific format. For example, the `MAIL` message has the
following format:

```text
MAIL FROM:<sender>
```

The `MAIL` message is used to specify the sender of the message. The sender is
specified after the `MAIL FROM:` keyword.

A RFC also defines the order in which messages can be or must be exchanged.

This is done using a sequence diagram, depending on the nature/complexity of the
protocol.

A sequence diagram is a diagram that defines the different messages that can be
exchanged between the client and the server and the order in which they can be
exchanged.

An RFC also defines edge cases and error cases, using the same diagrams. It is
important to define these cases to avoid any ambiguity and define how the
protocol should behave in these cases.

## How to define an application protocol

Defining an application protocol is not an easy task. It requires a lot of
thinking and a lot of testing.

It is also important to keep in mind that a protocol is never perfect. It can
always be improved. It is important to keep an open mind and to be ready to
change the protocol if needed.

The more you think and design your application protocols, the less you will have
to change them in the future and discover issues.

As you have seen, an application protocol is defined by a RFC. A RFC is a
document that defines the rules that each party must follow to communicate.

These rules are usually defined in multiple sections. Each section defines a
specific part of the protocol but they can vary a lot depending on the protocol
and can be hard to define/understand as they can be very technical.

As there is no strict rule to define an application protocol, we will define a
simple structure that you can use to define your own application protocol used
in this course:

- [Section 1 - Overview](#section-1---overview)
- [Section 2 - Transport protocol](#section-2---transport-protocol)
- [Section 3 - Messages](#section-3---messages)
- [Section 4 - Examples](#section-4---examples)

This structure, while simple, will help you to define your own application
protocols in a clear and concise way.

### Section 1 - Overview

This section defines the purpose of the protocol:

- What is the goal of the protocol?
- What is the problem that it tries to solve?
- What the application protocol is used for?

### Section 2 - Transport protocol

This section defines the transport protocol used by the application protocol:

- What protocol(s) is/are involved? On which port(s)?
- How are messages/actions encoded?
- How are messages/actions delimited?
- How are messages/actions treated (text or binary)?
- Who initiates/closes the communication?
- What happens on an unknown message/action/exception?

### Section 3 - Messages

This section defines the messages that can be exchanged between the client and
the server.

- What are the messages/actions?
- What are the parameters?
- What are the return values?
- What are the exceptions?

Always try to describe these for a given context, not from each point of view
(e.g. _"making an order"_ with the input/outputs from the client to the server
and the responses instead of _"the client sends these messages and the server
replies these messages with these outputs"_). It makes it way easier to
understand and to implement.

### Section 4 - Examples

This section defines examples of messages that can be exchanged between the
client and the server and the exchange order:

- What are the examples of messages/actions?
- What are the examples of exceptions?

It is important to define these examples to illustrate the protocol and to help
the reader to understand the protocol using sequence or state diagrams.

## Example - The SMS protocol

> You are working for a startup that wants to create a new communication app.
>
> The app is simple: it allows users (with unique usernames) to send small text
> messages (maximum 100 characters) to each other. The server is in charge of
> sending the messages to the recipients.
>
> You are asked to define the application protocol that will be used by the
> clients and the server.

Check the complete example in the
[`heig-vd-dai-course/06.01-define-an-application-protocol/02-code-examples`](../02-code-examples/)
directory.

## Practical content

### Define the application protocol for the _"Guess the number"_ game

In this section, you will define your own application protocol based on a given
context.

#### The context

You are working for a game company that wants to create a new game called
_"Guess the number"_.

The game is simple: the server generates a random number between 1 and 100
(inclusive).

The client has to guess the number. The server will respond with a message to
indicate if the number is higher, lower or correct than the number guessed by
the client.

Once the client has guessed the number, the client can ask the server to restart
the game or to quit the game.

#### The exercise

You are asked to define the application protocol that will be used by the
clients and the server.

Keep in mind the following points:

- What is the purpose of the protocol?
- On which port(s) does the protocol work?
- On which protocol(s) does the protocol work?
- Who initiates the connection?
- What are the available messages/actions?
- What is the format of the messages/actions?
- Are there any edge cases or error cases? What happens in these cases?

You can represent your application protocol using a sequence diagram.

You can use [PlantUML](https://plantuml.com/), [Draw.io](https://draw.io/) or
any other tools you want to create your diagrams (even a simple pen and paper!).

This protocol will be used in a future course to implement the game.

> [!IMPORTANT]
>
> You might not be able to fill all sections of the protocol yet. It is totally
> fine as we have not seen TCP and UDP yet. Do not worry if some sections are
> empty or if you do not have all the information to fill them (such as the
> transport protocols).
>
> You will go back to this protocol in a future course to complete it.

### Define the application protocol for the _"Temperature monitoring"_ application

In this section, you will define your own application protocol based on a given
context.

#### The context

You are working for an energy company that is interested in monitoring the
temperature of its buildings. The company wants to create a new application
called _"Temperature monitoring"_.

The application is simple: each room (customizable) has a temperature sensor (an
emitter) that emits its own temperature to a receiver (a server) on a regular
basis (e.g. every 10 minutes).

The server will store the latest temperature of each room.

An operator (client) can connect to the server and request the temperature of a
specific room. The server will respond with the temperature of the room.

#### The exercise

You are asked to define the application protocol that will be used by the
sensors (the emitters), the receiver (the server) and the operator (client).

Keep in mind the following points:

- What is the purpose of the protocol?
- On which port(s) does the protocol work?
- On which protocol(s) does the protocol work?
- Who initiates the connection?
- What are the available messages/actions?
- What is the format of the messages/actions?
- Are there any edge cases or error cases? What happens in these cases?

You can represent your application protocol using a sequence diagram.

You can use [PlantUML](https://plantuml.com/), [Draw.io](https://draw.io/) or
any other tools you want to create your diagrams (even a simple pen and paper!).

This protocol will be used in a future course to implement the application.

> [!IMPORTANT]
>
> You might not be able to fill all sections of the protocol yet. It is totally
> fine as we have not seen TCP and UDP yet. Do not worry if some sections are
> empty or if you do not have all the information to fill them (such as the
> transport protocols).
>
> You will go back to this protocol in a future course to complete it.

### Compare your application protocols with the official ones

Compare your solutions with the official ones stated in the
[Solution](#solution) section.

If you have any questions about the solution, feel free to ask as described in
the [Finished? Was it easy? Was it hard?](#finished-was-it-easy-was-it-hard)
section.

### Go further

This is an optional section. Feel free to skip it if you do not have time.

#### _"Guess the number"_ game

- Can you update the application protocol to allow the client to specify the
  range of the number to guess before starting the game?

#### _"Temperature monitoring"_ application

- Can you update the application protocol to allow the operator to have the
  latest temperature for a given room or the average temperature of that room?
  - This will require to store all the temperatures received for a given room
    and to calculate the average temperature instead of storing only the latest
    temperature.

## Conclusion

### What did you do and learn?

In this course, you have learned how an application protocol is defined using
RFCs.

You are able to understand an existing application protocol and define your own
application protocols.

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
course?

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
[`solution`](../03-solution/) directory.

If you have any questions about the solution, feel free to ask as described in
the [Finished? Was it easy? Was it hard?](#finished-was-it-easy-was-it-hard)
section.

## Sources

- Main illustration by [Iñaki del Olmo](https://unsplash.com/@inakihxz) on
  [Unsplash](https://unsplash.com/photos/NIJuEQw0RKg)

[license]:
	https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/95
