package ch.heigvd.dai.commands;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Callable;
import picocli.CommandLine;

@CommandLine.Command(
    name = "operator",
    description =
        "Start the operator part of the network application using the request-reply messaging pattern.")
public class Operator implements Callable<Integer> {
  public enum Message {
    REQ_TEMP,
    HELP,
    QUIT,
  }

  @CommandLine.Option(
      names = {"-H", "--host"},
      description = "Host to connect to.",
      required = true)
  protected String host;

  @CommandLine.Option(
      names = {"-p", "--port"},
      description = "Port to use (default: ${DEFAULT-VALUE}).",
      defaultValue = "1732")
  protected int port;

  @Override
  public Integer call() {
    System.out.println("[CLIENT] Sending request...");

    help();

    try (DatagramSocket socket = new DatagramSocket()) {
      InetAddress serverAddress = InetAddress.getByName(host);

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
            case REQ_TEMP -> {
              String room = userInputParts[1];

              request = Message.REQ_TEMP + " " + room;
            }
            case HELP -> help();
            case QUIT -> {
              socket.close();
              continue;
            }
          }

          if (request != null) {
            byte[] buffer = request.getBytes(StandardCharsets.UTF_8);

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, serverAddress, port);

            socket.send(packet);

            System.out.println("[Operator] Request sent: " + request);
          }
        } catch (Exception e) {
          System.out.println("Invalid command. Please try again.");
        }

        byte[] responseBuffer = new byte[1024];

        DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);

        socket.receive(responsePacket);

        String response =
            new String(
                responsePacket.getData(),
                responsePacket.getOffset(),
                responsePacket.getLength(),
                StandardCharsets.UTF_8);

        String[] responseParts = response.split(" ", 2);

        Receiver.Message message = null;
        try {
          message = Receiver.Message.valueOf(responseParts[0]);
        } catch (IllegalArgumentException e) {
          // Do nothing
        }

        switch (message) {
          case TEMP -> {
            double roomTemperature = Double.parseDouble(responseParts[1]);

            System.out.println("The temperature of the room is " + roomTemperature);
          }
          case ERROR -> {
            if (responseParts.length < 2) {
              System.out.println("Invalid message, please try again");
              break;
            }

            System.out.println("Error " + responseParts[1]);
          }
          case null, default ->
              System.out.println("Invalid/unknown command sent by receiver, ignore.");
        }
      }
    } catch (Exception e) {
      System.err.println("[Operator] An error occurred: " + e.getMessage());
      return 1;
    }

    System.out.println("[Operator] Quitting...");
    return 0;
  }

  private static void help() {
    System.out.println("Usage:");
    System.out.println("  " + Message.REQ_TEMP + " <room> - Request the temperature of a room.");
    System.out.println("  " + Message.QUIT + " - Quit the application.");
    System.out.println("  " + Message.HELP + " - Display this help message.");
  }
}
