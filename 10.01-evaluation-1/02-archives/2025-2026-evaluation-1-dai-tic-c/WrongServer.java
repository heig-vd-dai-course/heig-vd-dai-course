// Server.java
import java.io.*;
import java.net.*;

class Server {
  public static void main(String args[]) {
    try (ServerSocket serverSocket = new ServerSocket(); // Missing port number ) {
      while (!serverSocket.isClosed()) {
        try { // Missing try-with-resources
          // Missing accept() call
          BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
          OutputStream fos = new FileOutputStream("file.bak.png");
          BufferedOutputStream bos = new BufferedOutputStream(fos);

          int b;
          while ((b = in.readLine()) != -1) { // Wrong method to read data
            bos.write(b);
          }

          in.close();
          bos.flush();
          bos.close();
        } catch (IOException e) {
          System.err.println("[Server] IO exception: " + e);
        }
      }
    } catch (IOException e) {
      System.err.println("[Server] IO exception: " + e);
    }
  }
}
