package ch.heigvd.dai.ios.binary;

import ch.heigvd.dai.ios.Readable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * A class that reads binary files. This implementation reads the file byte per byte. It manages the
 * file input stream properly with a try-catch-finally block.
 */
public class BinaryFileReader implements Readable {

  @Override
  public void read(String filename) {
    InputStream fis = null;

    try {
      fis = new FileInputStream(filename);

      int b;
      while ((b = fis.read()) != -1) {
        // Do nothing - simulate processing
      }
    } catch (IOException e) {
      System.err.println("Error: " + e.getMessage());
    } finally {
      if (fis != null) {
        try {
          fis.close();
        } catch (IOException e) {
          System.err.println("Error: " + e.getMessage());
        }
      }
    }
  }
}
