import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

class TcpReplServerExample {

  private static final int PORT = 1234;
  public static String END_OF_LINE = "\n";

  // Constants for messages
  public enum ClientCommand {
    HELLO,
  }

  public enum ServerCommand {
    HI,
    INVALID
  }

  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(PORT)) {
      System.out.println("[Server] Listening on port " + PORT);

      while (!serverSocket.isClosed()) {
        try (Socket socket = serverSocket.accept();
            Reader reader = new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8);
            BufferedReader in = new BufferedReader(reader);
            Writer writer =
                new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
            BufferedWriter out = new BufferedWriter(writer)) {
          System.out.println(
              "[Server] New client connected from "
                  + socket.getInetAddress().getHostAddress()
                  + ":"
                  + socket.getPort());

          // Run REPL until client disconnects
          while (!socket.isClosed()) {
            // Read response from client
            String clientRequest = in.readLine();

            // If clientRequest is null, the client has disconnected
            // The server can close the connection and wait for a new client
            if (clientRequest == null) {
              socket.close();
              continue;
            }

            // Split user input to parse command (also known as message)
            String[] clientRequestParts = clientRequest.split(" ", 2);

            ClientCommand command = null;
            try {
              command = ClientCommand.valueOf(clientRequestParts[0]);
            } catch (Exception e) {
              // Do nothing
            }

            // Prepare response
            String response = null;

            // Handle request from client
            switch (command) {
              case HELLO -> {
                if (clientRequestParts.length < 2) {
                  System.out.println(
                      "[Server] " + command + " command received without <name> parameter. Replying with "
                          + ServerCommand.INVALID
                          + ".");
                  response = ServerCommand.INVALID + " Missing <name> parameter. Please try again.";
                  break;
                }

                String name = clientRequestParts[1];

                System.out.println("[Server] Received HELLO command with name: " + name);
                System.out.println("[Server] Replying with HI command");

                response = ServerCommand.HI + " Hi, " + name + "!";
              }
              case null, default -> {
                System.out.println(
                    "[Server] Unknown command sent by client, reply with "
                        + ServerCommand.INVALID
                        + ".");
                response = ServerCommand.INVALID + " Unknown command. Please try again.";
              }
            }

            // Send response to client
            out.write(response + END_OF_LINE);
            out.flush();
          }

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
