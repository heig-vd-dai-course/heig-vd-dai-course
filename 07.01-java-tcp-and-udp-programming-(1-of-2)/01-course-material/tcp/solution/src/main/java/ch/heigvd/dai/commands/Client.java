package ch.heigvd.dai.commands;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Callable;
import picocli.CommandLine;

@CommandLine.Command(name = "client", description = "Start the client part of the network game.")
public class Client implements Callable<Integer> {
  public enum Message {
    GUESS,
    RESTART,
    HELP,
    QUIT,
  }

  // End of line character
  public static String END_OF_LINE = "\n";

  @CommandLine.Option(
      names = {"-H", "--host"},
      description = "Host to connect to.",
      required = true)
  private String host;

  @CommandLine.Option(
      names = {"-p", "--port"},
      description = "Port to use (default: ${DEFAULT-VALUE}).",
      defaultValue = "6433")
  protected int port;

  @Override
  public Integer call() {
    try (Socket socket = new Socket(host, port);
        Reader reader = new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        Writer writer = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
        BufferedWriter out = new BufferedWriter(writer)) {
      System.out.println("[Client] Connected to " + host + ":" + port);
      System.out.println();

      help();

      while (!socket.isClosed()) {
        System.out.print("> ");

        Reader inputReader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader bir = new BufferedReader(inputReader);
        String userInput = bir.readLine();

        try {
          String[] userInputParts = userInput.split(" ", 2);
          Message message = Message.valueOf(userInputParts[0].toUpperCase());

          String request = null;

          switch (message) {
            case GUESS -> {
              int number = Integer.parseInt(userInputParts[1]);

              request = Message.GUESS + " " + number + END_OF_LINE;
            }
            case RESTART -> {
              request = Message.RESTART + END_OF_LINE;
            }
            case QUIT -> {
              socket.close();
              continue;
            }
            case HELP -> help();
          }

          if (request != null) {
            out.write(request);
            out.flush();
          }
        } catch (Exception e) {
          System.out.println("Invalid command. Please try again.");
          continue;
        }

        String serverResponse = in.readLine();

        if (serverResponse == null) {
          socket.close();
          continue;
        }

        String[] serverResponseParts = serverResponse.split(" ", 2);

        Server.Message message = null;
        try {
          message = Server.Message.valueOf(serverResponseParts[0]);
        } catch (IllegalArgumentException e) {
          // Do nothing
        }

        switch (message) {
          case HIGHER -> System.out.println("The number is higher.");
          case LOWER -> System.out.println("The number is lower.");
          case CORRECT -> System.out.println("Congratulations! You guessed the number.");
          case OK -> System.out.println("Game restarted.");
          case ERROR -> {
            if (serverResponseParts.length < 2) {
              System.out.println("Invalid message. Please try again.");
              break;
            }

            String error = serverResponseParts[1];
            System.out.println("Error " + error);
          }
          case null, default ->
              System.out.println("Invalid/unknown command sent by server, ignore.");
        }
      }

      System.out.println("[Client] Closing connection and quitting...");
    } catch (Exception e) {
      System.out.println("[Client] Exception: " + e);
      return 1;
    }

    return 0;
  }

  private static void help() {
    System.out.println("Usage:");
    System.out.println("  " + Message.GUESS + " <number> - Submit the number you want to guess.");
    System.out.println("  " + Message.RESTART + " - Restart the game.");
    System.out.println("  " + Message.QUIT + " - Close the connection to the server.");
    System.out.println("  " + Message.HELP + " - Display this help message.");
  }
}
