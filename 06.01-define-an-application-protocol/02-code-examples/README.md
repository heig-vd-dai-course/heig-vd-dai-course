# The Short Message Service (SMS) protocol

You are working for a startup that wants to create a new communication app.

The app is simple: it allows users (with unique usernames) to send small text
messages (maximum 100 characters) to each other. The server is in charge of
sending the messages to the recipients.

You are asked to define the application protocol that will be used by the
clients and the server.

Here is **one of the possible results**.

> [!NOTE]
>
> Each person can have a different way to define the protocol. This is one of
> the possible ways to define the protocol. Your might be different and that is
> totally fine. The most important is to define the protocol in a clear and
> explicit way.

## Section 1 - Overview

The Short Message Service (SMS) protocol is a communication protocol that allows
the sending of text messages (generally short) between users.

## Section 2 - Transport protocol

The SMS protocol is a text message transport protocol. It must use the TCP
(Transmission Control Protocol) to ensure the reliability of data transmission
and must also use port 1234.

> [!NOTE]
>
> Almost all applications can be implemented using different transport protocols
> (TCP, UDP, etc.).
>
> The choice of the transport protocol depends on the requirements of the
> application. For example, if the application requires reliable data
> transmission, it is better to use TCP. If the application requires fast data
> transmission, it is better to use UDP.

> [!NOTE]
>
> The port should be one of the unused ports bigger than 1023.
>
> However, no matter which port you choose to use, you **must** define one for
> your application protocol(s) so other people know which one to use to
> integrate/interact with your application.

Every message must be encoded in UTF-8 and delimited by a newline character
(`\n`). The messages are treated as text messages.

The initial connection must be established by the client.

Once the connection is established, the client can join the server with a given
username.

The server must verify that the username is not already taken by another user.

If these conditions are met, the server allows the client to join.

Otherwise, the server denies the client access.

Then, the client can send a text message to the server indicating the message
recipient.

The server must verify that the recipient is connected and that the message does
not exceed 100 characters.

> [!NOTE]
>
> Other constraints can be added to the application protocol, even when not
> asked for. It is important to define these constraints to ensure the
> robustness of the application.

If these conditions are met, the server sends the message to the recipient.

Otherwise, the server sends an error message to the client who sent the message.

On an unknown message, the server must send an error message to the client.

Once a client has disconnected, the server must close the connection and remove
the client from the list of connected clients.

## Section 3 - Messages

### Join the server

The client sends a join message to the server indicating the client's username.

#### Request

```text
JOIN <name>
```

- `name`: the name of the client

#### Response

- `OK`: the client has been granted access to the server
- `ERROR <code>`: an error occurred during the join. The error code is an
  integer between 1 and 1 inclusive. The error codes are as follow:
  - 1: the client's name is already in use

### List connected clients

The client sends a message to the server to request the list of connected
clients.

#### Request

```text
LIST
```

#### Response

- `CLIENTS <client1> <client2> <client3> ...`: the list of connected clients.
  The clients are separated by a space.

### Send a message

The client sends a message to the server indicating the recipient of the
message. The server is then responsible for sending the message to the
recipient.

#### Request

```text
SEND <recipient> <message>
```

#### Response

- `OK`: the message has been successfully sent
- `ERROR <code>`: an error occurred while sending the message. The error code is
  an integer between 1 and 2 inclusive. The error codes are as follow:
  - 1: the recipient is not connected
  - 2: the message exceeds 100 characters

### Receive a message

The server sends a message to the recipient indicating the sender of the
message. The client is then responsible for displaying the received message.

#### Request

```text
RECEIVE <message> <sender>
```

- `message`: the received message
- `sender`: the name of the message sender

#### Response

None.

## Section 4 - Examples

### Functional example

![Functional example](./images/example-1-functional-example.png)

### Join the server with a duplicate client name

![CJoin the server with a duplicate client name example](./images/example-2-join-the-server-with-a-duplicate-client-name.png)

### Send a message to an unconnected recipient

![Send a message to an unconnected recipient example](./images/example-3-send-a-message-to-an-unconnected-recipient.png)

### Send a message that is too long

![Send a message that is too long example](./images/example-4-send-a-message-that-is-too-long.png)
