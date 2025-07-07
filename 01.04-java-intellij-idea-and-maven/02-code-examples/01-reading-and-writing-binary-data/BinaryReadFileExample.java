import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * This program demonstrates how to read a binary file byte per byte. It reads the file
 * FileInputStreamExample.bin byte per byte and prints the content to the console.
 */
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
