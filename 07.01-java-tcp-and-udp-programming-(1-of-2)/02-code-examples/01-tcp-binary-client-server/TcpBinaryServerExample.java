import java.io.*;
import java.net.*;

class TcpBinaryServerExample {

  // Port to listen to
  private static final int PORT = 1234;

  // Name of the file to save
  private static final String FILENAME = "file-received-from-client.bin";

  public static void main(String args[]) {
    try (ServerSocket serverSocket = new ServerSocket(PORT)) {
      System.out.println("[Server] Listening on port " + PORT);

      // Infinite loop to accept client connections
      while (!serverSocket.isClosed()) {
        // Open output file and input socket
        // The `serverSocket.accept()` method blocks until a client connects
        try (OutputStream fos = new FileOutputStream(FILENAME);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            Socket socket = serverSocket.accept();
            BufferedInputStream in = new BufferedInputStream(socket.getInputStream()); ) {
          System.out.println(
              "[Server] New client connected from "
                  + socket.getInetAddress().getHostAddress()
                  + ":"
                  + socket.getPort());

          System.out.println("[Server] Receiving binary data from client...");

          int b;
          while ((b = in.read()) != -1) {
            bos.write(b);
          }

          in.close();
          bos.close();

          System.out.println("[Server] Binary data saved in '" + FILENAME + "'");
          System.out.println("[Server] Closing connection");
        } catch (IOException e) {
          System.out.println("[Server] IO exception: " + e);
        }
      }
    } catch (IOException e) {
      System.out.println("[Server] IO exception: " + e);
    }
  }
}
