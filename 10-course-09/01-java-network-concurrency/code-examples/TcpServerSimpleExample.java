import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

class TcpServerSimpleExample {

  private static final int PORT = 1234;
  private static final int SERVER_ID = (int) (Math.random() * 1000000);
  private static final String TEXTUAL_DATA = "👋 from Server " + SERVER_ID;

  public static void main(String args[]) {
    try (ServerSocket serverSocket = new ServerSocket(PORT)) {
      System.out.println("[Server " + SERVER_ID + "] starting with id " + SERVER_ID);
      System.out.println("[Server " + SERVER_ID + "] listening on port " + PORT);

      while (!serverSocket.isClosed()) {
        try (Socket socket = serverSocket.accept();
            BufferedReader in =
                new BufferedReader(
                    new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            BufferedWriter out =
                new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8))) {
          System.out.println(
              "[Server "
                  + SERVER_ID
                  + "] new client connected from "
                  + socket.getInetAddress().getHostAddress()
                  + ":"
                  + socket.getPort());

          System.out.println(
              "[Server " + SERVER_ID + "] received textual data from client: " + in.readLine());

          System.out.println(
              "[Server " + SERVER_ID + "] sending response to client: " + TEXTUAL_DATA);

          out.write(TEXTUAL_DATA + "\n");
          out.flush();

          System.out.println("[Server " + SERVER_ID + "] closing connection");
        } catch (IOException e) {
          System.out.println("[Server " + SERVER_ID + "] exception: " + e);
        }
      }
    } catch (IOException e) {
      System.out.println("[Server " + SERVER_ID + "] exception: " + e);
    }
  }
}
