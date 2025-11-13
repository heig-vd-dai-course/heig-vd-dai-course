import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

class TcpClientExample {

  private static final String HOST = "localhost";
  private static final int PORT = 1234;
  private static final int CLIENT_ID = (int) (Math.random() * 1000000);
  private static final String TEXTUAL_DATA = "👋 from Client " + CLIENT_ID;

  public static void main(String args[]) {
    System.out.println("[Client " + CLIENT_ID + "] starting with id " + CLIENT_ID);
    System.out.println("[Client " + CLIENT_ID + "] connecting to " + HOST + ":" + PORT);

    try (Socket socket = new Socket(HOST, PORT);
        BufferedReader in =
            new BufferedReader(
                new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
        BufferedWriter out =
            new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8)); ) {
      System.out.println("[Client " + CLIENT_ID + "] connected to " + HOST + ":" + PORT);
      System.out.println(
          "[Client "
              + CLIENT_ID
              + "] sending textual data to server "
              + HOST
              + ":"
              + PORT
              + ": "
              + TEXTUAL_DATA);

      out.write(TEXTUAL_DATA + "\n");
      out.flush();

      System.out.println("[Client " + CLIENT_ID + "] response from server: " + in.readLine());

      System.out.println("[Client " + CLIENT_ID + "] closing connection");
    } catch (IOException e) {
      System.out.println("[Client " + CLIENT_ID + "] exception: " + e);
    }
  }
}
