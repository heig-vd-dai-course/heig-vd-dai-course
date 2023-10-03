[markdown]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/09-define-an-application-protocol/COURSE_MATERIAL.md
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/09-define-an-application-protocol/09-define-an-application-protocol-course-material.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/4
[illustration]:
  https://images.unsplash.com/photo-1549319114-d67887c51aed?fit=crop&h=720

# Application protocol - Course material

<https://github.com/heig-vd-dai-course>

[Markdown][markdown] · [PDF][pdf]

L. Delafontaine and H. Louis, with the help of Copilot.

This work is licensed under the [CC BY-SA 4.0][license] license.

![Main illustration][illustration]

## Table of contents

- [Table of contents](#table-of-contents)
- [Objectives](#objectives)
- [What is an application protocol?](#what-is-an-application-protocol)
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
- [Resources](#resources)
- [Sources](#sources)

## Objectives

This chapter will help you understand how to define an application protocol.

An application protocol is a protocol that is used to exchange information
between two applications (usually a between a client and a server). It is
defined by a set of rules that each party must follow to communicate.

In this chapter, you will learn where to find information about application
protocols, how to define an application protocol and how to interact with an
application that uses a well-defined application protocol.

## What is an application protocol?

An application protocol is a document that defines how two applications can
communicate.

These documents are usually called RFC (Request For Comments) and are available
on the [IETF website](https://www.ietf.org/), an organization that defines
standards for the Internet (among others).

An application protocol relies on a transport protocol (TCP or UDP) and a
network protocol (IP). It comes on top of these protocols and defines how
applications can communicate.

Multiple revisions of the same protocol can exist. For example, the HTTP
protocol has multiple revisions (HTTP/1.0, HTTP/1.1, HTTP/2, HTTP/3). Each
revision is defined by a different RFC and has different features.

## How to define an application protocol?

An application protocol is usually defined by a set of rules that each party
must follow to communicate.

These rules are usually defined in a RFC. The RFC defines the messages that can
be exchanged between the client and the server, the format of these messages and
the order in which they can be exchanged.

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

- Learn where to find information about application protocols
- Learn how is defined an application protocol
- Learn how to define an application protocol
- Learn how to use an application protocol

## Practical content

### Explore the existing application protocols

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

Diagramme de séquence

### Go further

This is an optional section. Feel free to skip it if you do not have time.

- You can check the RFC for the FTP protocol, DNS protocol and the DHCP
  protocol. Are they similar to the protocols you have seen before? What are the
  differences?

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

In the next chapter, you will learn the following topics:

- Java TCP programming

## Resources

_Resources are here to help you. They are not mandatory to read._

- _None yet_

_Missing item in the list? Feel free to open a pull request to add it! ✨_

## Sources

- Main illustration by [Nathan Dumlao](https://unsplash.com/@nate_dumlao) on
  [Unsplash](https://unsplash.com/photos/KixfBEdyp64)
