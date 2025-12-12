// Client.java
import java.io.*;
import java.net.*;

class Client {
  public static void main(String[] args) {
    try (InputStream fis = new FileInputStream("file.png");
        BufferedInputStream bis = new BufferedInputStream(fis);
        Socket socket = new Socket("localhost", 1234);
        BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream()); ) {
      int b;
      while ((b = bis.read()) != -1) {
        out.write(b);
      }

      out.flush();
      out.close();
      bis.close();
    } catch (IOException e) {
      System.err.println("[Client] IO exception: " + e);
    }
  }
}
