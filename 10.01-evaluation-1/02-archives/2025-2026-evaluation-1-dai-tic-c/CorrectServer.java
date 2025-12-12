// Server.java
import java.io.*;
import java.net.*;

class Server {
  public static void main(String args[]) {
    try (ServerSocket serverSocket = new ServerSocket(1234)) {
     while (!serverSocket.isClosed()) {
        try (Socket socket = serverSocket.accept();
            BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
            OutputStream fos = new FileOutputStream("file.bak.png");
            BufferedOutputStream bos = new BufferedOutputStream(fos); ) {
          int b;
          while ((b = in.read()) != -1) {
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
