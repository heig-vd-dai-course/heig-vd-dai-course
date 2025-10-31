import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * This program demonstrates how to read a text file byte per byte and write it to another file byte
 * per byte. It reads the file TextReadAndWriteFileExample.java byte per byte and writes it byte per
 * byte to TextReadAndWriteFileExample.txt.
 */
class TextReadAndWriteFileExample {

  public static void main(String[] args) throws IOException {
    Reader reader = new FileReader("TextReadAndWriteFileExample.java", StandardCharsets.UTF_8);
    Writer writer = new FileWriter("TextReadAndWriteFileExample.txt", StandardCharsets.UTF_8);

    // -1 indicates the end of the file
    int c;
    while ((c = reader.read()) != -1) {
      writer.write(c);
    }

    writer.close();
    reader.close();
  }
}
