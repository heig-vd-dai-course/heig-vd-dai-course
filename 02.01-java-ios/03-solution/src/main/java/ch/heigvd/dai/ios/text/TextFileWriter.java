package ch.heigvd.dai.ios.text;

import ch.heigvd.dai.ios.Writable;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * A class that writes text files. This implementation write the file byte per byte. It manages the
 * file writer properly with a try-catch-finally block.
 */
public class TextFileWriter implements Writable {

  @Override
  public void write(String filename, int sizeInBytes) {
    Writer writer = null;

    try {
      // A charset is explicitly set to avoid issues on other systems
      writer = new FileWriter(filename, StandardCharsets.UTF_8);

      for (int i = 0; i < sizeInBytes; i++) {
        writer.write('a');
      }
    } catch (IOException e) {
      System.err.println("Error: " + e.getMessage());
    } finally {
      if (writer != null) {
        try {
          writer.close();
        } catch (IOException e) {
          System.err.println("Error: " + e.getMessage());
        }
      }
    }
  }
}
