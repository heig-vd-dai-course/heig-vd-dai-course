package ch.heigvd.dai.ios.text;

import ch.heigvd.dai.ios.Readable;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * A class that reads text files. This implementation reads the file using a buffered reader around
 * a file reader. It manages the reader and the buffered reader properly with a try-with-resources
 * block.
 */
public class BufferedTextFileReader implements Readable {

  @Override
  public void read(String filename) {
    try (Reader reader = new FileReader(filename, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(reader)) {
      int b;
      while ((b = br.read()) != -1) {
        // Do nothing - simulate processing
      }
    } catch (java.io.IOException e) {
      System.err.println("Error: " + e.getMessage());
    }
  }
}
