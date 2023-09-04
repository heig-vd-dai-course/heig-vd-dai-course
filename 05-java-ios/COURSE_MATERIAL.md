[markdown]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/05-java-ios/COURSE_MATERIAL.md#practical-content
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/05-java-ios/05-java-ios-course-material.pdf
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/4
[illustration]:
  https://images.unsplash.com/photo-1549319114-d67887c51aed?fit=crop&h=720

# Java IOs - Course material

<https://github.com/heig-vd-dai-course>

[Markdown][markdown] | [PDF][pdf]

L. Delafontaine and H. Louis, with the help of Copilot

Based on the original course by O. Liechti and J. Ehrensberger

![Main illustration][illustration]

## Table of contents

- [Table of contents](#table-of-contents)
- [Objectives](#objectives)
- [Processing binary data vs. text data](#processing-binary-data-vs-text-data)
  - [Ancestor of character representations: ASCII](#ancestor-of-character-representations-ascii)
  - [Extended ASCII: codes pages](#extended-ascii-codes-pages)
  - [Unicode](#unicode)
  - [UTF-8](#utf-8)
  - [What happens if you ignore the character encoding?](#what-happens-if-you-ignore-the-character-encoding)
  - [A quick note on little endian vs. big endian](#a-quick-note-on-little-endian-vs-big-endian)
- [Sources, streams and sinks of data](#sources-streams-and-sinks-of-data)
- [The Java IO API](#the-java-io-api)
- [Performance and buffering](#performance-and-buffering)
- [Dealing with errors](#dealing-with-errors)
- [When to use which IO?](#when-to-use-which-io)
- [Practical content](#practical-content)
  - [Open a binary file](#open-a-binary-file)
  - [Write a binary file](#write-a-binary-file)
  - [Open a text file](#open-a-text-file)
  - [Write a text file](#write-a-text-file)
  - [Open a binary file with a buffer](#open-a-binary-file-with-a-buffer)
  - [Write a binary file with a buffer](#write-a-binary-file-with-a-buffer)
  - [Open a text file with a buffer](#open-a-text-file-with-a-buffer)
  - [Write a text file with a buffer](#write-a-text-file-with-a-buffer)
- [Conclusion](#conclusion)
  - [What did you do and learn?](#what-did-you-do-and-learn)
  - [Test your knowledge](#test-your-knowledge)
- [Finished? Was it easy? Was it hard?](#finished-was-it-easy-was-it-hard)
- [What will you do next?](#what-will-you-do-next)
- [Sources](#sources)

## Objectives

This chapter will help you understand why IOs are important in network
programming and how to use them in Java.

Network programming is about reading and writing data (= files) from and to the
network. Files are a great example to understand how IOs work in the first place
without the hassle of network programming.

You might need to use different types of IOs depending on the type of data you
want to process. You will learn how to use the right IOs for the right data.

These skills are essential to be able to process data from the network later on
this course!

Let's get started!

## Processing binary data vs. text data

There are two main types of data you can process: binary data and text data.

Binary data processing is the most basic type of data processing: you open a
file, you read the bits and you write the bits to another file. You do not have
to interpret the bits, you just copy them.

What is the difference between binary data and text data?

Computers only understand binary data. Binary data is a sequence of bits (`0`s
and `1`s). Binary data can represent anything: text, images, videos, etc. On the
file system, everything is binary data.

The real question is: how do we interpret these bits?

### Ancestor of character representations: ASCII

The **American Standard Code for Information Interchange (ASCII)** is one of the
first character encodings. It is a character encoding that maps 128 binary
values to 128 characters. For example, the binary data `01000001` is mapped to
the character `A`.

The first implementation of ASCII was published in 1963. It was meant to be used
for the English language only. It was later extended to support other languages.

### Extended ASCII: codes pages

As ASCII is a very limited character encoding (only 8 bits, leaving 128 other
possible values), many other character encodings were created to support more
characters and languages.

These extended ASCII character encodings are called **code pages**. They were
then standardized by the **International Organization for Standardization
(ISO)**.

Common code pages are **ISO-8859-1** (also called **Latin-1**), **ISO-8859-15**
(also called **Latin-9**), **Windows-1252** (also called **CP1252**), etc.

### Unicode

**Unicode** is a newer character encoding standard that was meant to **solve the
issues of ASCII and code pages** that could not support all specificities of all
languages:

- Languages with more than 256 characters (like Chinese)
- Languages with more than one alphabet (like Serbian)
- Languages with more than one writing system (like Chinese or Japanese)

The Unicode specification defines 1,112,064 characters.

This is enough to **support all languages in the world** as well as emojis (for
our greatest pleasure... 🥲).

Implementations of the Unicode standard are called **Unicode Transformation
Formats (UTF)**. The most common implementations is **UTF-8**.

### UTF-8

**UTF-8** is a variable-length character encoding that uses 1 to 4 bytes to
encode a character. It is the most common implementation of the Unicode
standard. It is the default character encoding on the Internet and many other
applications.

UTF-8 is backward compatible with ASCII. This means that if you have a file
encoded in ASCII, it is also encoded in UTF-8.

<!--
## Try it yourself!

TODO: Add a "Try out!" section here to clone the required Git repository to execute the following section
-->

### What happens if you ignore the character encoding?

When you open a file, you need to know the character encoding used to encode the
file.

The character encoding is not stored in the file. You need to know it in advance
to be able to read the file correctly.

When the character encoding is not known in advance or misinterpreted, it can
lead to issues like displaying the wrong characters or not being able to display
the characters at all.

A good example is when you open a text file encoded in UTF-8 with a text editor
that does not support UTF-8. The text editor will try to interpret the file as
ASCII and will display the wrong characters (`Ã©` instead of `é` for example).

### A quick note on little endian vs. big endian

When working with binary data, you need to know if the data is encoded in
**little endian** or in **big endian**.

**Little endian** means that the least significant byte is stored first. **Big
endian** means that the most significant byte is stored first.

For example, the number `0x12345678` is stored as `0x78 0x56 0x34 0x12` in
little endian and as `0x12 0x34 0x56 0x78` in big endian.

This is important to know when you read or write binary data. If you read or
write binary data in the wrong endian, the data will be corrupted.

## Sources, streams and sinks of data

Whenever you want to read or write data, you need to have a source of data and a
sink of data, using a stream to let the data flow from the source to the sink.

A **source of data** is **where the data comes from**. It can be a file, a
network connection, a keyboard, etc. A common term for a source of data is
something that **produces** data (**a producer**).

A **sink of data** is **where the data goes**. It can be another file, a network
connection, a screen, etc. A common term for a sink of data is something that
**consumes** data (**a consumer**).

A **stream** is **a way to read or write data** from or to a source or a sink.

## The Java IO API

Java has a very powerful API to read and write data from and to different
sources and sinks of data using different types of streams called the **Java IO
API** (also called the standard Java IO API).

Another API called the **Java NIO API** was introduced in Java 1.4. It is a more
modern API that is more efficient and more flexible than the Java IO API. It is
also more complex to use and is meant for more advanced use cases (writing
scalable servers for example). We will not cover it in this course.

## Performance and buffering

When reading and writing data, data can be read or written byte by byte or using
a buffer.

Reading or writing byte by byte is not very efficient as each call is system
call to the operating system. This is very slow.

Reading or writing using a buffer is much more efficient as data is processed as
a chunk of data at once. This is much faster.

A **buffer** is a temporary storage area **in memory**. It is used to store data
before it is processed. Is is much faster.

## Dealing with errors

When accessing a file, many things can go wrong. The file might not exist, the
file might be corrupted, the file might be locked by another process, etc.

When you open a file, you need to handle these errors. You can do this by
catching the `IOException` exception. This is done with a `try`/`catch` block.

The common exceptions you might encounter are:

- `FileNotFoundException`: the file does not exist
- `IOException`: the file cannot be accessed for other reasons
- `UnsupportedEncodingException`: the file is encoded in an unsupported
  character encoding

The same applies when you use the network: the network might be down, the
connection might be lost, etc.

You will have to manage these errors when you will work with the network.

## When to use which IO?

The Java IO API is very powerful. It can be used to read and write data from and
to different sources and sinks of data using different types of streams.

It can sometimes be overwhelming to know which IO to use for which use case.

Here is a simple decision tree to help you choose the right IO for the right use
case:

TODO

## Practical content

### Open a binary file

TODO

### Write a binary file

TODO

### Open a text file

TODO

### Write a text file

TODO

### Open a binary file with a buffer

TODO

### Write a binary file with a buffer

TODO

### Open a text file with a buffer

TODO

### Write a text file with a buffer

TODO

## Conclusion

<!-- _class: lead -->

### What did you do and learn?

In this chapter, you have learned how to read and write data from and to
different sources and sinks of data using different types of streams, more
specifically binary and text data.

You have learned the importance of character encodings and how to handle them
when reading and writing data.

You have also learned how to handle errors to avoid your program to crash.

### Test your knowledge

At this point, you should be able to answer the following questions:

- What is a source of data?
- What is a sink of data?
- What is a stream?
- What is the difference between binary data and text data?
- What is a character encoding?
- What is UTF-8?
- What happens if you ignore the character encoding?
- How is a buffer more efficient than reading or writing byte by byte?

## Finished? Was it easy? Was it hard?

Can you let us know what was easy and what was difficult for you during this
chapter?

This will help us to improve the course and adapt the content to your needs. If
we notice some difficulties, we will come back to you to help you.

➡️ [GitHub Discussions][discussions]

You can use reactions to express your opinion on a comment!

## What will you do next?

You will start the practical work!

## Sources

- Main illustration by [Nathan Dumlao](https://unsplash.com/@nate_dumlao) on
  [Unsplash](https://unsplash.com/photos/KixfBEdyp64)
