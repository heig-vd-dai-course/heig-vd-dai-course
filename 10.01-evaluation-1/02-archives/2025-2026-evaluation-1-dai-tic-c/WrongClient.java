// Client.java
import java.io.*;
import java.net.*;

class Client {
  public static void main(String[] args) {
    try (InputStream fis = new FileInputStream("file.png", StandardCharsets.UTF_8); // Charset added while not needed
        // Missing BufferedInputStream
        Socket socket = new Socket("localhost", 1234);
        OutputStream out = socket.getOutputStream(); // Missing BufferedOutputStream ) {
      int b;
      while ((b = bis.read()) != 0) { // Wrong EOF number
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
