# TCP REPL client/server example

An example of a
[Read-Eval-Print Loop (REPL)](https://en.wikipedia.org/wiki/Read%E2%80%93eval%E2%80%93print_loop)
client/server application.

The scope is to open the server on a specific port and wait for a client to
connect. Once the client is connected, the server will read the input from the
client, evaluate it, and send back the result to the client.

Only until the client or the server decide to close the connection, the client
can send messages to the server.

If you try to connect with multiple clients, you will notice that the subsequent 
clients can still connect to the server, even if it is busy with another client 
and has not yet called the `accept()` method.

This is because the server socket has a backlog queue that can hold multiple
incoming TCP connection requests as explained in the [course material](../../01-course-material/README.md)