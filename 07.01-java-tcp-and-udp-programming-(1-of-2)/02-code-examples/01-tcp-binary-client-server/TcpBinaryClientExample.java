import java.io.*;
import java.net.*;

class TcpBinaryClientExample {

  // Host to access
  private static final String HOST = "localhost";

  // Port to use
  private static final int PORT = 1234;

  // File size to generate
  private static final int SIZE_IN_BYTES = 1024 * 1024; // 1 MB

  // Name of the file to send
  private static final String FILENAME = "file-sent-by-client.bin";

  public static void main(String[] args) {
    System.out.println(
        "[Client] Generating file " + FILENAME + " of size " + SIZE_IN_BYTES + " bytes...");

    try (OutputStream fos = new FileOutputStream(FILENAME);
        BufferedOutputStream bos = new BufferedOutputStream(fos); ) {
      for (int i = 0; i < SIZE_IN_BYTES; i++) {
        bos.write(i);
      }
    } catch (IOException e) {
      System.out.println("[Client] IO exception: " + e);
    }

    System.out.println(
        "[Client] File " + FILENAME + " generated with size " + SIZE_IN_BYTES + " bytes");

    System.out.println("[Client] Connecting to " + HOST + ":" + PORT + "...");

    // Open input file and output socket
    try (InputStream fis = new FileInputStream(FILENAME);
        BufferedInputStream bis = new BufferedInputStream(fis);
        Socket socket = new Socket(HOST, PORT);
        BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream()); ) {
      System.out.println("[Client] Connected to " + HOST + ":" + PORT);
      System.out.println("[Client] Sending " + FILENAME + " to server " + HOST + ":" + PORT);

      // Read the file and write it to the socket (= send it to the server)
      int b;
      while ((b = bis.read()) != -1) {
        out.write(b);
      }

      out.flush();
      out.close();
      bis.close();

      System.out.println("[Client] File " + FILENAME + " sent to server " + HOST + ":" + PORT);
      System.out.println("[Client] Closing connection");
    } catch (IOException e) {
      System.out.println("[Client] IO exception: " + e);
    }
  }
}
