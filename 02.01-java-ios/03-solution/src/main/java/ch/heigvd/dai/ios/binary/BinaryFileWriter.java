package ch.heigvd.dai.ios.binary;

import ch.heigvd.dai.ios.Writable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * A class that writes binary files. This implementation writes the file byte per byte. It manages
 * the file output stream properly with a try-catch-finally block.
 */
public class BinaryFileWriter implements Writable {

  @Override
  public void write(String filename, int sizeInBytes) {
    OutputStream fos = null;

    try {
      fos = new FileOutputStream(filename);

      for (int i = 0; i < sizeInBytes; i++) {
        fos.write(1);
      }
    } catch (IOException e) {
      System.err.println("Error: " + e.getMessage());
    } finally {
      if (fos != null) {
        try {
          fos.close();
        } catch (IOException e) {
          System.err.println("Error: " + e.getMessage());
        }
      }
    }
  }
}
