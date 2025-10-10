# Java TCP and UDP programming - Code examples

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

## Code examples

This directory contains several examples of Java TCP and UDP programming
implementations.

We recommend you to try each example and understand how it works.

They are ordered by complexity. You should explore them in the following order:

### Part (1/2)

1. [TCP binary client/server](./01-tcp-binary-client-server).
2. [TCP textual client/server example](./02-tcp-textual-client-server/).
3. [UDP unicast client/server example](./03-udp-unicast-client-server/).

### Part (2/2)

1. [UDP broadcast emitter/receiver example](./04-udp-broadcast-emitter-receiver/).
2. [UDP multicast emitter/receiver example](./05-udp-multicast-emitter-receiver/).
3. [UDP request-response messaging pattern example](./06-udp-request-response-messaging-pattern/).
4. [UDP fire-and-forget messaging pattern example](./07-udp-fire-and-forget-messaging-pattern/)
5. [TCP REPL client/server example](./08-tcp-repl-client-server/)

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
