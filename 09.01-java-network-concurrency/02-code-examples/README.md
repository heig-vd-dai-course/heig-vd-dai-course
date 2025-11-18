# Java network concurrency - Code examples

L. Delafontaine and H. Louis, with the help of
[GitHub Copilot](https://github.com/features/copilot).

Based on the original course by O. Liechti and J. Ehrensberger.

This work is licensed under the [CC BY-SA 4.0][license] license.

## Resources

- Objectives, teaching and learning methods, and evaluation methods:
  [Link to content](..)
- Course material: [Link to content](../01-course-material/README.md) ·
  [Presentation (web)](https://heig-vd-dai-course.github.io/heig-vd-dai-course/09.01-java-network-concurrency/01-course-material/index.html)
  ·
  [Presentation (PDF)](https://heig-vd-dai-course.github.io/heig-vd-dai-course/09.01-java-network-concurrency/01-course-material/09.01-java-network-concurrency-presentation.pdf)
- Code examples: [Link to content](../02-code-examples/)
- Solution: [Link to content](../03-solution/)

## Code examples

This directory contains several examples of TCP client/server applications that
demonstrate different ways to handle concurrency.

We recommend you to try each example and understand how it works.

Please be aware that some examples require to be run in a specific order (the
server before the client for example).

They are ordered by complexity. You should explore them in the following order:

1. [`TcpClientExample.java`](./01-tcp-client-example/)
2. [`TcpServerSimpleExample`](./02-tcp-server-simple-example/)
3. [`TcpServerSingleThreadExample`](./03-tcp-server-single-thread-example/)
4. [`TcpServerMultiThreadExample`](./04-tcp-server-multi-thread-example/)
5. [`TcpServerCachedThreadPoolExample`](./05-tcp-server-cached-thread-pool-example/)
6. [`TcpServerFixedThreadPoolExample`](./06-tcp-server-fixed-thread-pool-example/)
7. [`TcpServerVirtualThreadExample`](./07-tcp-server-virtual-thread-example/)
8. [`TcpServerWithConcurrentDataStructuresExample`](./08-tcp-server-with-concurrent-data-structures-example/)

## Usage

To run the examples, you can use the following commands:

```sh
# Compile the example
javac <ExampleName>.java

# Run the example
java <ExampleName>
```

[license]:
	https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
