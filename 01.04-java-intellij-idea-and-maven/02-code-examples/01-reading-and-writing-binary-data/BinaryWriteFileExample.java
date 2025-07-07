import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * This program demonstrates how to write a binary file byte per byte. It creates the file
 * FileOutputStreamExample.bin and fill it with the byte values 0-255.
 */
class BinaryWriteFileExample {

  public static void main(String[] args) throws IOException {
    OutputStream fos = new FileOutputStream("binary-file.bin");

    for (int i = 0; i < 256; i++) {
      fos.write(i);
    }

    fos.close();
  }
}
