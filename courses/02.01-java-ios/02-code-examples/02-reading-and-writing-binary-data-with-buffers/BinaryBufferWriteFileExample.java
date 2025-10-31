import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * This program demonstrates how to write a binary file using a buffer. It writes the file by first
 * creating a FileOutputStream and then wrapping it with a BufferedOutputStream. The Buffered output
 * stream writes the file by filling a buffer with bytes and then flushing the bytes from the
 * buffer. When the buffer is full, the BufferedOutputStream writes the bytes to the
 * FileOutputStream.
 */
class BinaryBufferWriteFileExample {

  public static void main(String[] args) throws IOException {
    OutputStream fos = new FileOutputStream("binary-file.bin");
    BufferedOutputStream bos = new BufferedOutputStream(fos);

    for (int i = 0; i < 256; i++) {
      bos.write(i);
    }

    // Flush the buffer to write the remaining bytes
    bos.flush();
    bos.close();
  }
}
