// Server.java
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

class Server {
  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket()) { // Missing port number
      while (!serverSocket.isClosed()) {
        try ( // Missing accept() call
            Reader reader = new InputStreamReader(socket.getInputStream()); // Missing charset
            BufferedReader in = new BufferedReader(reader);
            Writer writer =
                new OutputStreamWriter(socket.getOutputStream()); // Missing charset
            BufferedWriter out = new BufferedWriter(writer)) {
          System.out.println(in.readLine());

          out.write("Salut client, ça va bien, merci !" + "\n");
          // Missing flush()

          out.close();
          in.close();
        } catch (IOException e) {
          System.err.println("[Server] IO exception: " + e);
        }
      }
    } catch (IOException e) {
      System.err.println("[Server] IO exception: " + e);
    }
  }
}
