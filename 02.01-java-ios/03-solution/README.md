# Java IOs - Solution

L. Delafontaine and H. Louis, with the help of
[GitHub Copilot](https://github.com/features/copilot).

This work is licensed under the [CC BY-SA 4.0][license] license.

## Resources

- Objectives, teaching and learning methods, and evaluation methods:
  [Link to content](..)
- Course material: [Link to content](../01-course-material/README.md) ·
  [Presentation (web)](https://heig-vd-dai-course.github.io/heig-vd-dai-course/02.01-java-ios/01-course-material/index.html)
  ·
  [Presentation (PDF)](https://heig-vd-dai-course.github.io/heig-vd-dai-course/02.01-java-ios/01-course-material/02.01-java-ios-presentation.pdf)
- Code examples: [Link to content](../02-code-examples/)
- Solution: [Link to content](../03-solution/)

## Solution

This directory contains the solution to the practical content of the course.

Feel free to explore the code and use it as a reference for your own work.

If you have any questions or need further assistance, please don't hesitate to
ask for help in the [GitHub Discussions][discussions] or by opening an issue or
creating a pull request (PR) on the course repository.

## Benchmark results

These benchmark were done on a laptop with the following specifications:

- **Processor**: AMD Ryzen™ 7 7840U
- **Memory**: Kingston FURY Impact 2 x 16GB DDR5 (5600MHz, CL40)
- **Storage**: SOLIDIGM P44 Pro SSD M.2 2.0TB (read: 7 GB/s, write: 6.5 GB/s)
- **Operating System**: Fedora 39 (Linux 6.9.12-100.fc39.x86_64)

Each benchmark was run 10 times, and the average time was calculated with the
help of the `run_benchmarks.sh` script.

### Binary data

<details>
<summary>Click to show the commands used to run the benchmark</summary>

```sh
## 1 byte

# Write a file with 1 byte with the BINARY implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation BINARY 1-byte.bin write --size 1

# Read a file with 1 byte with the BINARY implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation BINARY 1-byte.bin read

# Write a file with 1 byte with the BUFFERED_BINARY implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation BUFFERED_BINARY 1-byte.bin write --size 1

# Read a file with 1 byte with the BUFFERED_BINARY implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation BUFFERED_BINARY 1-byte.bin read

## 1 KiB (= 1 * 1024 = 1024 bytes)

# Write a file with 1024 bytes with the BINARY implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation BINARY 1024-bytes.bin write --size 1024

# Read a file with 1024 bytes with the BINARY implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation BINARY 1024-bytes.bin read

# Write a file with 1024 bytes with the BUFFERED_BINARY implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation BUFFERED_BINARY 1024-bytes.bin write --size 1024

# Read a file with 1024 bytes with the BUFFERED_BINARY implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation BUFFERED_BINARY 1024-bytes.bin read

## 1 MiB (= 1 * 1024 * 1024 = 1048576 bytes)

# Write a file with 1048576 bytes with the BINARY implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation BINARY 1048576-bytes.bin write --size 1048576

# Read a file with 1048576 bytes with the BINARY implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation BINARY 1048576-bytes.bin read

# Write a file with 1048576 bytes with the BUFFERED_BINARY implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation BUFFERED_BINARY 1048576-bytes.bin write --size 1048576

# Read a file with 1048576 bytes with the BUFFERED_BINARY implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation BUFFERED_BINARY 1048576-bytes.bin read

## 5 MiB (= 5 * 1024 * 1024 = 5242880 bytes)

# Write a file with 5242880 bytes with the BINARY implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation BINARY 5242880-bytes.bin write --size 5242880

# Read a file with 5242880 bytes with the BINARY implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation BINARY 5242880-bytes.bin read

# Write a file with 5242880 bytes with the BUFFERED_BINARY implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation BUFFERED_BINARY 5242880-bytes.bin write --size 5242880

# Read a file with 5242880 bytes with the BUFFERED_BINARY implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation BUFFERED_BINARY 5242880-bytes.bin read
```

</details>

The following table shows the benchmark results for each stream type:

|   Size | Implementation   | Average write (ms) | Average read (ms) |
| -----: | ---------------- | -----------------: | ----------------: |
| 1 byte | BINARY           |               76.8 |              76.5 |
| 1 byte | BUFFERED_BINARY  |               76.1 |              76.6 |
|        | Performance gain |                1.0 |              0.99 |
|  1 KiB | BINARY           |               89.8 |              85.7 |
|  1 KiB | BUFFERED_BINARY  |               85.4 |              85.5 |
|        | Performance gain |               1.05 |               1.0 |
|  1 MiB | BINARY           |             4437.7 |             605.6 |
|  1 MiB | BUFFERED_BINARY  |               94.4 |              91.8 |
|        | Performance gain |               47.0 |               6.6 |
|  5 MiB | BINARY           |            21921.1 |            2710.2 |
|  5 MiB | BUFFERED_BINARY  |              115.3 |             108.4 |
|        | Performance gain |             190.12 |                25 |

### Text data

<details>
<summary>Click to show the commands used to run the benchmark</summary>

```sh
## 1 byte

# Write a file with 1 char with the TEXT implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation TEXT 1-char.txt write --size 1

# Read a file with 1 char with the TEXT implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation TEXT 1-char.txt read

# Write a file with 1 char with the BUFFERED_TEXT implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation BUFFERED_TEXT 1-char.txt write --size 1

# Read a file with 1 char with the BUFFERED_TEXT implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation BUFFERED_TEXT 1-char.txt read

## 1 KiB (= 1 * 1024 = 1024 chars)

# Write a file with 1024 chars with the TEXT implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation TEXT 1024-chars.txt write --size 1024

# Read a file with 1024 chars with the TEXT implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation TEXT 1024-chars.txt read

# Write a file with 1024 chars with the BUFFERED_TEXT implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation BUFFERED_TEXT 1024-chars.txt write --size 1024

# Read a file with 1024 chars with the BUFFERED_TEXT implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation BUFFERED_TEXT 1024-chars.txt read

## 1 MiB (= 1 * 1024 * 1024 = 1048576 chars)

# Write a file with 1048576 chars with the TEXT implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation TEXT 1048576-chars.txt write --size 1048576

# Read a file with 1048576 chars with the TEXT implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation TEXT 1048576-chars.txt read

# Write a file with 1048576 chars with the BUFFERED_TEXT implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation BUFFERED_TEXT 1048576-chars.txt write --size 1048576

# Read a file with 1048576 chars with the BUFFERED_TEXT implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation BUFFERED_TEXT 1048576-chars.txt read

## 5 MiB (= 5 * 1024 * 1024 = 5242880 chars)

# Write a file with 5242880 chars with the TEXT implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation TEXT 5242880-chars.txt write --size 5242880

# Read a file with 5242880 chars with the TEXT implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation TEXT 5242880-chars.txt read

# Write a file with 5242880 chars with the BUFFERED_TEXT implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation BUFFERED_TEXT 5242880-chars.txt write --size 5242880

# Read a file with 5242880 chars with the BUFFERED_TEXT implementation
java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation BUFFERED_TEXT 5242880-chars.txt read
```

</details>

The following table shows the benchmark results for each stream type:

|   Size | Implementation   | Average write (ms) | Average read (ms) |
| -----: | ---------------- | -----------------: | ----------------: |
| 1 byte | TEXT             |               76.7 |              77.2 |
| 1 byte | BUFFERED_TEXT    |               84.3 |              83.7 |
|        | Performance gain |               0.91 |              0.92 |
|  1 KiB | TEXT             |               83.5 |              80.8 |
|  1 KiB | BUFFERED_TEXT    |               84.8 |              81.7 |
|        | Performance gain |               0.98 |              0.99 |
|  1 MiB | TEXT             |              143.5 |             118.4 |
|  1 MiB | BUFFERED_TEXT    |               99.2 |              96.2 |
|        | Performance gain |               1.45 |              1.23 |
|  5 MiB | TEXT             |              335.0 |             201.7 |
|  5 MiB | BUFFERED_TEXT    |              123.8 |             118.0 |
|        | Performance gain |               2.71 |              1.71 |

## Answers to the questions

### Which type of stream is the most efficient for each use case?

- For binary data, the most efficient stream is the `BufferedInputStream` and
  `BufferedOutputStream`.
- For text data, the most efficient stream is the `BufferedReader` and
  `BufferedWriter`.

Even though for small files, the difference is negligible, for large files, the
buffered streams are way more efficient.

We always recommend using the buffered streams because they are more efficient
and provide better performance even for small files.

### Why is it more efficient than the other types of streams?

- The `BufferedInputStream` and `BufferedOutputStream` use a buffer to read and
  write data. This buffer reduces the number of system calls, which is more
  efficient.

### What is the difference between binary data and text data?

The binary data is a sequence of bytes, while the text data is a sequence of
characters.

When dealing with text data, we need to consider the character encoding. The
character encoding is a mapping between characters and bytes. The most common
character encoding is UTF-8.

### What is a character encoding?

A character encoding is a mapping between characters and bytes. The character
encoding defines how characters are represented as bytes.

### Why is this benchmark methodology important?

> This methodology is important because it provides a structured and systematic
> approach to solving problens or conducting research, ensuring consistency,
> reliability, and the ability to replicate results.
>
> [apirakas](https://github.com/apirakas), in GitHub Discussion
> <https://github.com/orgs/heig-vd-dai-course/discussions/83>

[license]:
	https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/4
