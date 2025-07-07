import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * This program demonstrates how to read a binary file using a buffer. It reads the file by first
 * creating a FileInputStream and then wrapping it with a BufferedInputStream. The Buffered input
 * stream reads the file by filling a buffer with bytes and then returning the bytes from the
 * buffer. When the buffer is empty, the BufferedInputStream reads more bytes from the
 * FileInputStream.
 */
class BinaryBufferReadFileExample {

  public static void main(String[] args) throws IOException {
    InputStream fis = new FileInputStream("binary-file.bin");
    BufferedInputStream bis = new BufferedInputStream(fis);

    // -1 indicates the end of the file
    int b;
    while ((b = bis.read()) != -1) {
      System.out.print(b);
    }

    // Closing the BufferedInputStream automatically closes the FileInputStream
    bis.close();
  }
}
