import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * This program demonstrates how to read a text file and write it to another file using buffers. It
 * reads the file TextReadAndWriteFileExample.java in a buffer and writes it to
 * TextReadAndWriteFileExample.txt using a buffer.
 */
class TextBufferReadAndWriteFileExample {

  public static void main(String[] args) throws IOException {
    Reader reader = new FileReader("TextBufferReadAndWriteFileExample.java", StandardCharsets.UTF_8);
    BufferedReader br = new BufferedReader(reader);

    Writer writer = new FileWriter("TextBufferReadAndWriteFileExample.txt", StandardCharsets.UTF_8);
    BufferedWriter bw = new BufferedWriter(writer);

    // -1 indicates the end of the file
    int c;
    while ((c = br.read()) != -1) {
      bw.write(c);
    }

    // Flush the buffer to write the remaining bytes
    bw.flush();
    bw.close();
    br.close();
  }
}
