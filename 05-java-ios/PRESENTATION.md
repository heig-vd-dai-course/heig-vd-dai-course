---
marp: true
---

<!--
theme: gaia
size: 16:9
paginate: true
author: L. Delafontaine and H. Louis, with the help of GitHub Copilot
title: HEIG-VD DAI Course - Java IOs
description: Java IOs for the DAI course at HEIG-VD, Switzerland
url: https://heig-vd-dai-course.github.io/heig-vd-dai-course/05-java-ios/
footer: '**HEIG-VD** - DAI Course 2024-2025 - CC BY-SA 4.0'
style: |
    :root {
        --color-background: #fff;
        --color-foreground: #333;
        --color-highlight: #f96;
        --color-dimmed: #888;
        --color-headings: #7d8ca3;
    }
    blockquote {
        font-style: italic;
    }
    table {
        width: 100%;
    }
    th:first-child {
        width: 15%;
    }
    h1, h2, h3, h4, h5, h6 {
        color: var(--color-headings);
    }
    h2, h3, h4, h5, h6 {
        font-size: 1.5rem;
    }
    h1 a:link, h2 a:link, h3 a:link, h4 a:link, h5 a:link, h6 a:link {
        text-decoration: none;
    }
    section:not([class=lead]) > p, blockquote {
        text-align: justify;
    }
headingDivider: 4
-->

[web]: https://heig-vd-dai-course.github.io/heig-vd-dai-course/05-java-ios/
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/05-java-ios/05-java-ios-presentation.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/4
[illustration]: ./images/main-illustration.jpg
[course-material]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/05-java-ios/COURSE_MATERIAL.md
[course-material-qr-code]:
  https://quickchart.io/qr?format=png&ecLevel=Q&size=400&margin=1&text=https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/05-java-ios/COURSE_MATERIAL.md

# Java IOs

<!--
_class: lead
_paginate: false
-->

<https://github.com/heig-vd-dai-course>

[Web][web] · [PDF][pdf]

<small>L. Delafontaine and H. Louis, with the help of GitHub Copilot.</small>

<small>Based on the original course by O. Liechti and J. Ehrensberger.</small>

<small>This work is licensed under the [CC BY-SA 4.0][license] license.</small>

![bg opacity:0.1][illustration]

## Objectives

- Know the different types of data (binary vs. text)
- Understand the abstract notion of sources, streams ang sink
- Use the different IO types for different use-cases
- Use the Java IO API

![bg right:40%](https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720)

## Prepare and setup your environment

<!-- _class: lead -->

More details for this section in the
[course material](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/05-java-ios/COURSE_MATERIAL.md#prepare-and-setup-your-environment).
You can find other resources and alternatives as well.

### Check and run the code examples

- Check the code examples
- Run the code examples
- Helps to understand the concepts
- Modify/play with the code examples

![bg right w:80%](./images/code-examples-github-repository.png)

## Sources, streams and sinks of data

<!-- _class: lead -->

More details for this section in the
[course material](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/05-java-ios/COURSE_MATERIAL.md#sources-streams-and-sinks-of-data).
You can find other resources and alternatives as well.

### Sources, streams and sinks of data

- Abstraction of data flow
- Source: where data comes from (input)
- Sink: where data goes to (output)
- Stream: data flow between source and sink

![bg right:40%](https://images.unsplash.com/photo-1543674892-7d64d45df18b?fit=crop&h=720)

## The Java IO API

<!-- _class: lead -->

More details for this section in the
[course material](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/05-java-ios/COURSE_MATERIAL.md#the-java-io-api).
You can find other resources and alternatives as well.

### The Java IO API

- Part of `java.base` module
  - `java.io`
  - `java.nio`
- Different classes for different IO types:
  - Binary data
  - Text data

![bg right contain](./images/the-java-io-api.png)

## Types of data

<!-- _class: lead -->

More details for this section in the
[course material](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/05-java-ios/COURSE_MATERIAL.md#types-of-data).
You can find other resources and alternatives as well.

### Types of data

- Two types of data:
  - Binary
  - Text
- Both are `0`s and `1`s - the difference is in interpretation:
  - Binary data - raw data
  - Text data - interpretation

![bg right:45% w:90%](./images/processing-binary-data-vs-text-data.png)

## Processing binary data with the Java IO API

<!-- _class: lead -->

More details for this section in the
[course material](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/05-java-ios/COURSE_MATERIAL.md#processing-binary-data-with-the-java-io-api).
You can find other resources and alternatives as well.

### Processing binary data with the Java IO API

- Most basic type of data processing:
  1. Open a file
  2. Read/write/modify the bytes as they are
  3. Close the file

![bg right:45% w:90%](./images/processing-binary-data.png)

### Reading binary data

- Most simple way is to read byte by byte (not efficient)
- `InputStream` and `FileInputStream` classes are used to read binary data
- Let's have a look at the code example `BinaryReadFileExample`

![bg right:45% w:90%](./images/processing-binary-data.png)

---

```java
class BinaryReadFileExample {

  public static void main(String[] args) throws IOException {
    InputStream fis = new FileInputStream("binary-file.bin");

    // -1 indicates the end of the file
    int b;
    while ((b = fis.read()) != -1) {
      System.out.print(b);
    }

    fis.close();
  }
}
```

### Writing binary data

- Most simple way is to write byte by byte (not efficient)
- `OutputStream` and `FileOutputStream` classes are used to write binary data
- Let's have a look at the code example `BinaryWriteFileExample`

![bg right:45% w:90%](./images/processing-binary-data.png)

---

```java
class BinaryWriteFileExample {

  public static void main(String[] args) throws IOException {
    OutputStream fos = new FileOutputStream("binary-file.bin");

    for (int i = 0; i < 256; i++) {
      fos.write(i);
    }

    fos.close();
  }
}
```

### Reading and writing binary data with a buffer

- Reading and writing byte by byte is not efficient: each `read()` or `write()`
  call results in a system call every time
- Buffers can be used to read write multiple bytes at once

![bg right:45% w:90%](./images/processing-binary-data.png)

---

Use a buffer to read multiple bytes at once:

1. First time, a system call is made to read a block of data
2. Subsequent reads are done from the buffer
3. When the buffer is empty, a new block is read

![bg right:45% w:90%](./images/processing-binary-data.png)

---

The same applies for writing:

1. First time, a buffer is created
2. Data is written to the buffer
3. When the buffer is full, a system call is made to write the block
4. The buffer is then emptied
5. Bytes can remain in the buffer

   - A flush might be needed to empty the buffer

![bg right:45% w:90%](./images/processing-binary-data.png)

---

- `BufferedInputStream` and `BufferedOutputStream` classes are used to
  read/write binary data with a buffer
- Let's have a look at the code examples `BinaryBufferReadFileExample` and
  `BinaryBufferWriteFileExample`

![bg right:45% w:90%](./images/processing-binary-data.png)

---

```diff
 class BinaryBufferReadFileExample {

   public static void main(String[] args) throws IOException {
     InputStream fis = new FileInputStream("binary-file.bin");
+    InputStream bis = new BufferedInputStream(fis);

     // -1 indicates the end of the file
     int b;
-    while ((b = fis.read()) != -1) {
+    while ((b = bis.read()) != -1) {
       System.out.print(b);
     }

+    bis.close();
     fis.close();
   }
 }
```

---

```diff
 class BinaryBufferWriteFileExample {

   public static void main(String[] args) throws IOException {
     OutputStream fos = new FileOutputStream("binary-file.bin");
+    BufferedOutputStream bos = new BufferedOutputStream(fos);

     for (int i = 0; i < 256; i++) {
-      fos.write(i);
+      bos.write(i);
     }

+    // Flush the buffer to write the remaining bytes
+    bos.flush();
+    bos.close();
     fos.close();
   }
 }
```

### A quick note on little endian vs. big endian

- Little endian: least significant byte first
- Big endian: most significant byte first
- Java uses big endian by default
- The class `ByteBuffer` can be used to convert between the two (not covered in
  this course)
- Example: `12345678`
  - Little endian: `0x78 0x56 0x34 0x12`
  - Big endian: `0x12 0x34 0x56 0x78`

## Processing text data with the Java IO API

<!-- _class: lead -->

More details for this section in the
[course material](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/05-java-ios/COURSE_MATERIAL.md#processing-text-data-with-the-java-io-api).
You can find other resources and alternatives as well.

### Processing text data with the Java IO API

- Text data: interpretation of binary data
- Different character encodings
- Different end of line characters
- Different IO classes for text data

![bg right:45% w:90%](./images/processing-text-data.png)

### Ancestor of character representations: ASCII

- ASCII: 128 binary values
- Mapping binary to characters
- Published in 1963 and meant for English

![bg right w:90%](https://upload.wikimedia.org/wikipedia/commons/c/cf/USASCII_code_chart.png)

### Extended ASCII: codes pages

- Extended ASCII (code pages)
- Support for more characters using the remaining 128 values

![bg right w:80%](https://upload.wikimedia.org/wikipedia/commons/a/ac/Latin-1-infobox.svg)

### Unicode

- Unicode: solves ASCII limitations
- Standard to support all languages
- Different implementations:
  - UTF-8
  - UTF-16
  - UTF-32

![bg right contain](./images/unicode.png)

### UTF-8

- UTF-8: variable-length encoding
- Most common Unicode implementation
- ASCII compatible
- Quite the standard for web and software development

![bg right contain](./images/utf-8-wikipedia-article.png)

### What happens if you ignore the character encoding?

- Not stored in the file itself
- Misinterpretation leads to issues
- Check, compile and run the `TextCharacterEncodingsExample` code example!

![bg right:40% w:80%](https://upload.wikimedia.org/wikipedia/commons/7/7f/Replacement_character.svg)

### Reading and writing text data

- `Reader` and `Writer` classes are used to read/write text data
- **Always specify the encoding!** If not set, it can be incompatible with other
  systems
- Let's have a look at the code example `TextReadAndWriteFileExample`

![bg right:45% w:90%](./images/processing-text-data.png)

---

```java
class TextReadAndWriteFileExample {

  public static void main(String[] args) throws IOException {
    Reader reader = new FileReader("file.java", StandardCharsets.UTF_8);
    Writer writer = new FileWriter("file.txt", StandardCharsets.UTF_8);

    // -1 indicates the end of the file
    int c;
    while ((c = reader.read()) != -1) {
      writer.write(c);
    }

    writer.close();
    reader.close();
  }
}
```

---

- Just like with binary data, reading and writing text data byte by byte is not
  efficient
- `BufferedReader` and `BufferedWriter` classes are used to read/write text data
  with a buffer
- Let's have a look at the code example `TextBufferReadAndWriteFileExample`

![bg right:45% w:90%](./images/processing-text-data.png)

---

```diff
 class TextBufferReadAndWriteFileExample {

   public static void main(String[] args) throws IOException {
     Reader reader = new FileReader("file.java", StandardCharsets.UTF_8);
+    BufferedReader br = new BufferedReader(reader);
+
     Writer writer = new FileWriter("file.txt", StandardCharsets.UTF_8);
+    BufferedWriter bw = new BufferedWriter(writer);

     // -1 indicates the end of the file
     int c;
-    while ((c = reader.read()) != -1) {
-      writer.write(c);
+    while ((c = br.read()) != -1) {
+      bw.write(c);
     }

+    writer.flush();
     writer.close();
     reader.close();
   }
```

### End of line characters

- Different end of line characters on different systems
  - Unix/Linux/macOS: `\n`, called _"Line feed"_ (`LF`)
  - Windows: `\r\n`, called _"Carriage Return + Line feed"_ (`CR`+`LF`)

![bg right w:90%](https://devblogs.microsoft.com/wp-content/uploads/sites/33/2019/02/Notepad-before.png)

---

```java
class TextEndOfLineCharactersExample {

  public static String END_OF_LINE = "\n";

  public static void main(String[] args) throws IOException {
    InputStream is = new FileInputStream("file.java");
    Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
    BufferedReader br = new BufferedReader(reader);

    OutputStream os = new FileOutputStream("file.txt");
    Writer writer = new OutputStreamWriter(os, StandardCharsets.UTF_8);
    BufferedWriter bw = new BufferedWriter(writer);

    String line;
    while ((line = br.readLine()) != null) {
      // Careful: line does not contain end of line characters
      bw.write(line + END_OF_LINE);
    }

    bw.flush();
    br.close();
    is.close();
  }
}
```

### Dealing with errors

- All kinds of errors can occur when reading/writing files
- Files must be properly opened and closed
- Ensure no files are corrupted
- Two main ways to handle exceptions:
  - `try-catch-finally` blocks
  - `try-with-resources` blocks

![bg right:40%](https://images.unsplash.com/photo-1579373903781-fd5c0c30c4cd?fit=crop&h=720)

---

```java
// Bad example: try-catch without finally
public static void tryCatchWithoutFinallyExample() {
  try {
    Reader reader = new FileReader("missing.file");
    Writer writer = new FileWriter("missing.file");

    writer.write(reader.read());
  } catch (IOException e) {
    System.out.println("Exception: " + e);
  }
}
```

---

```java
// Better example: try-catch with finally
public static void tryCatchFinallyExample() {
  Reader reader = null;
  Writer writer = null;

  try {
    reader = new FileReader("missing.file");
    writer = new FileWriter("missing.file");

    writer.write(reader.read());
  } catch (IOException e) {
    System.out.println("Exception: " + e);
  } finally {
    if (writer != null) {
      try {
        writer.close();
      } catch (IOException e) {
        System.out.println("Exception in close writer: " + e);
      }
    }

    if (reader != null) {
      try {
        reader.close();
      } catch (IOException e) {
        System.out.println("Exception in close reader: " + e);
      }
    }
  }
}
```

---

```java
// Best example: try-with-resources
public static void tryWithResourcesExample() {
  try (Reader reader = new FileReader("missing.file");
      Writer writer = new FileWriter("missing.file")) {
    writer.write(reader.read());
  } catch (IOException e) {
    System.out.println("Exception: " + e);
  }
}
```

## When to use which IO?

<!-- _class: lead -->

More details for this section in the
[course material](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/05-java-ios/COURSE_MATERIAL.md#when-to-use-which-io).
You can find other resources and alternatives as well.

### When to use which IO?

![bg w:80%](./images/when-to-use-which-io.png)

## Common pitfalls

<!-- _class: lead -->

More details for this section in the
[course material](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/05-java-ios/COURSE_MATERIAL.md#common-pitfalls).
You can find other resources and alternatives as well.

### Common pitfalls

- Not using buffers
- Not closing the streams
- Not handling exceptions properly
- Not specifying the character encoding
- Not specifying the end of line characters
- Do not use `PrintWriter` - it swallows exceptions
- Do not use `System.lineSeparator()` - it is platform dependent

## Practical content

<!-- _class: lead -->

### What will you do?

Benchmark the different types of streams you have learned:

- Assemble all the code examples to satisfy the use-cases
- Run some benchmarks to determine the best IOs for the given use-cases

![bg right w:80%](./images/what-will-you-do.png)

### Find the practical content

<!-- _class: lead -->

You can find the practical content for this chapter on
[GitHub][course-material].

![bg right w:75%][course-material-qr-code]

## Finished? Was it easy? Was it hard?

Can you let us know what was easy and what was difficult for you during this
chapter?

This will help us to improve the course and adapt the content to your needs. If
we notice some difficulties, we will come back to you to help you.

➡️ [GitHub Discussions][discussions]

You can use reactions to express your opinion on a comment!

## What will you do next?

In the next chapter, you will learn the following topics:

- Docker and Docker Compose: how to containerize your applications
  - What is an image?
  - What is a container?
  - How to try out new software without installing it?

![bg right:40%](https://images.unsplash.com/photo-1511578194003-00c80e42dc9b?fit=crop&h=720)

## Sources

- Main illustration by [Martijn Baudoin](https://unsplash.com/@martijnbaudoin)
  on [Unsplash](https://unsplash.com/photos/4h0HqC3K4-c)
- Illustration by [Aline de Nadai](https://unsplash.com/@alinedenadai) on
  [Unsplash](https://unsplash.com/photos/j6brni7fpvs)
- Illustration by [T K](https://unsplash.com/@realaxer) on
  [Unsplash](https://unsplash.com/photos/9AxFJaNySB8)
- Illustration by [Anna Dudkova](https://unsplash.com/@annadudkova) on
  [Unsplash](https://unsplash.com/photos/urs_y9NwFcc)
- Illustration by [Sigmund](https://unsplash.com/@sigmund) on
  [Unsplash](https://unsplash.com/photos/By-tZImt0Ms)
