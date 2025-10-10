import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

class TcpReplClientExample {

  private static final String HOST = "localhost";
  private static final int PORT = 1234;
  public static String END_OF_LINE = "\n";

  // Constants for messages
  public enum ClientCommand {
    HELLO,
    HELLO_WITHOUT_NAME,
    INVALID,
    HELP,
    QUIT
  }

  public enum ServerCommand {
    HI,
    INVALID
  }

  public static void main(String[] args) {
    System.out.println("[Client] Connecting to " + HOST + ":" + PORT + "...");

    try (Socket socket = new Socket(HOST, PORT);
        Reader reader = new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        Writer writer = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
        BufferedWriter out = new BufferedWriter(writer);
        Reader systemInReader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader bsir = new BufferedReader(systemInReader)) {
      System.out.println("[Client] Connected to " + HOST + ":" + PORT);
      System.out.println();

      // Display help message
      help();

      // Run REPL until user quits
      while (!socket.isClosed()) {
        // Display prompt
        System.out.print("> ");

        // Read user input
        String userInput = bsir.readLine();

        try {
          // Split user input to parse command (also known as message)
          String[] userInputParts = userInput.split(" ", 2);
          ClientCommand command = ClientCommand.valueOf(userInputParts[0].toUpperCase());

          // Prepare request
          String request = null;

          switch (command) {
            case HELLO -> {
              String name = userInputParts[1];

              request = ClientCommand.HELLO + " " + name;
            }
            case HELLO_WITHOUT_NAME -> {
              request = ClientCommand.HELLO.name();
            }
            case INVALID -> {
              request = ClientCommand.INVALID.name();
            }
            case QUIT -> {
              socket.close();
              continue;
            }
            case HELP -> help();
          }

          if (request != null) {
            // Send request to server
            out.write(request + END_OF_LINE);
            out.flush();
          }
        } catch (Exception e) {
          System.out.println("Invalid command. Please try again.");
          continue;
        }

        // Read response from server and parse it
        String serverResponse = in.readLine();

        // If serverResponse is null, the server has disconnected
        if (serverResponse == null) {
          socket.close();
          continue;
        }

        // Split response to parse message (also known as command)
        String[] serverResponseParts = serverResponse.split(" ", 2);

        ServerCommand message = null;
        try {
          message = ServerCommand.valueOf(serverResponseParts[0]);
        } catch (IllegalArgumentException e) {
          // Do nothing
        }

        // Handle response from server
        switch (message) {
          case HI -> {
            // As we know from the server implementation, the message is always the second part
            String helloMessage = serverResponseParts[1];
            System.out.println(helloMessage);
          }

          case INVALID -> {
            if (serverResponseParts.length < 2) {
              System.out.println("Invalid message. Please try again.");
              break;
            }

            String invalidMessage = serverResponseParts[1];
            System.out.println(invalidMessage);
          }
          case null, default ->
              System.out.println("Invalid/unknown command sent by server, ignore.");
        }
      }

      System.out.println("[Client] Closing connection and quitting...");
    } catch (Exception e) {
      System.out.println("[Client] Exception: " + e);
    }
  }

  private static void help() {
    System.out.println("Usage:");
    System.out.println("  " + ClientCommand.HELLO + " <your name> - Say hello with a name.");
    System.out.println("  " + ClientCommand.HELLO_WITHOUT_NAME + " - Say hello without a name.");
    System.out.println("  " + ClientCommand.INVALID + " - Send an invalid command to the server.");
    System.out.println("  " + ClientCommand.QUIT + " - Close the connection to the server.");
    System.out.println("  " + ClientCommand.HELP + " - Display this help message.");
  }
}
