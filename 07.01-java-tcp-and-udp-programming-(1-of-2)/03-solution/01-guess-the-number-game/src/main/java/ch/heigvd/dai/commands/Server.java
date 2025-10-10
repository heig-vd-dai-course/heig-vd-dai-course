package ch.heigvd.dai.commands;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.concurrent.Callable;
import picocli.CommandLine;

@CommandLine.Command(name = "server", description = "Start the server part of the network game.")
public class Server implements Callable<Integer> {
  public enum Message {
    HIGHER,
    LOWER,
    CORRECT,
    OK,
    ERROR,
  }

  // Upper bound for the random number
  private static final int UPPER_BOUND = 100;

  // Lower bound for the random number
  private static final int LOWER_BOUND = 0;

  // End of line character
  public static String END_OF_LINE = "\n";

  // The number to guess
  private int numberToGuess;

  @CommandLine.Option(
      names = {"-p", "--port"},
      description = "Port to use (default: ${DEFAULT-VALUE}).",
      defaultValue = "6433")
  protected int port;

  @Override
  public Integer call() {
    try (ServerSocket serverSocket = new ServerSocket(port)) {
      System.out.println("[SERVER] Listening on port " + port);

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

          // Generate random number
          generateRandomNumber();

          // Set game in progress
          boolean gameInProgress = true;

          System.out.println("[Server] The number to guess is: " + numberToGuess);

          while (!socket.isClosed()) {
            String clientRequest = in.readLine();

            if (clientRequest == null) {
              socket.close();
              continue;
            }

            String[] clientRequestParts = clientRequest.split(" ", 2);

            Client.Message message = null;
            try {
              message = Client.Message.valueOf(clientRequestParts[0]);
            } catch (Exception e) {
              // Do nothing
            }

            String response;

            switch (message) {
              case GUESS -> {
                if (clientRequestParts.length < 2) {
                  response = Message.ERROR + " 2: the guess is not a number" + END_OF_LINE;
                  break;
                }

                try {
                  int number = Integer.parseInt(clientRequestParts[1]);

                  if (number < LOWER_BOUND || number > UPPER_BOUND) {
                    response =
                        Message.ERROR + " 1: the number is not between the bounds" + END_OF_LINE;
                  } else if (number < numberToGuess) {
                    response = Message.HIGHER + END_OF_LINE;
                  } else if (number > numberToGuess) {
                    response = Message.LOWER + END_OF_LINE;
                  } else {
                    response = Message.CORRECT + END_OF_LINE;

                    // Set game in progress
                    gameInProgress = false;
                  }
                } catch (NumberFormatException e) {
                  response = Message.ERROR + " 2: the guess is not a number" + END_OF_LINE;
                }
              }
              case RESTART -> {
                if (gameInProgress) {
                  response =
                      Message.ERROR + " 1: a guessing game is already in session" + END_OF_LINE;
                } else {
                  generateRandomNumber();

                  System.out.println("[Server] The number to guess is: " + numberToGuess);

                  response = Message.OK + END_OF_LINE;
                }
              }
              case null, default -> {
                response = Message.ERROR + " -1: invalid message" + END_OF_LINE;
              }
            }

            out.write(response);
            out.flush();
          }

          System.out.println("[Server] Closing connection");
        } catch (IOException e) {
          System.out.println("[Server] IO exception: " + e);
          return 1;
        }
      }
    } catch (IOException e) {
      System.out.println("[Server] IO exception: " + e);
      return 1;
    }

    return 0;
  }

  private void generateRandomNumber() {
    Random rand = new Random();
    numberToGuess = rand.nextInt(UPPER_BOUND - LOWER_BOUND) + LOWER_BOUND;
  }
}
