# Java network concurrency

_Some of these examples are based on the original course by O. Liechti and J.
Ehrensberger._

This repository contains several examples of TCP client/server applications that
demonstrate different ways to handle concurrency.

We recommend you to try each example and understand how it works.

Please be aware that some examples require to be run in a specific order (the
server before the client for example).

They are ordered by complexity. You should explore them in the following order:

- [`TcpClientExample.java`](./TcpClientExample.java)
- [`TcpServerSimpleExample`](./TcpServerSimpleExample.java)
- [`TcpServerSingleThreadExample`](./TcpServerSingleThreadExample.java)
- [`TcpServerMultiThreadExample`](./TcpServerMultiThreadExample.java)
- [`TcpServerCachedThreadPoolExample`](./TcpServerCachedThreadPoolExample.java)
- [`TcpServerFixedThreadPoolExample`](./TcpServerFixedThreadPoolExample.java)
- [`TcpServerVirtualThreadExample`](./TcpServerVirtualThreadExample.java)

## Usage

To run the examples, you can use the following commands:

```bash
# Compile the example
javac <ExampleName>.java

# Run the example
java <ExampleName>
```
