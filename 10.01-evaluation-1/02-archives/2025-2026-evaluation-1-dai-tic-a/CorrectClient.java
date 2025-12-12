// Client.java
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

class Client {
  public static void main(String[] args) {
    try (Socket socket = new Socket("localhost", 1234);
        Reader reader = new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        Writer writer = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
        BufferedWriter out = new BufferedWriter(writer); ) {

      out.write("Salut server, ça va ?" + "\n");
      out.flush();

      System.out.println(in.readLine());

      out.close();
      in.close();
    } catch (IOException e) {
      System.err.println("[Client] IO exception: " + e);
    }
  }
}
