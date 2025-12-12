// Client.java
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

class Client {
  public static void main(String[] args) {
    try { // Missing try-with-resources
      Socket socket = new Socket("localhost", 1234);
      Reader in = new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8);
      // Missing BufferedReader
      Writer out = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
      // Missing BufferedWriter

      out.write("Salut server, ça va ?"); // Missing EOF character
      out.flush();

      System.out.println(in.readLine());

      out.close();
      in.close();
    } catch (IOException e) {
      System.err.println("[Client] IO exception: " + e);
    }
  }
}
