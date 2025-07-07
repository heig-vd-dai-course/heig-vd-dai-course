package ch.heigvd.dai.commands;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import picocli.CommandLine;

@CommandLine.Command(
    name = "receiver",
    description =
        "Start the receiver part of the network application using the fire-and-forget messaging pattern for the emitters and the request-reply messaging pattern for the operators.")
public class Receiver implements Callable<Integer> {
  public enum Message {
    TEMP,
    ERROR,
  }

  // The rooms with their temperature
  protected Map<String, Double> roomsTemperature = new ConcurrentHashMap<>();

  @CommandLine.Option(
      names = {"-M", "--multicast-address"},
      description = "Multicast address to use for the emitters (default: ${DEFAULT-VALUE}).",
      defaultValue = "230.1.2.3")
  protected String emittersMulticastAddress;

  @CommandLine.Option(
      names = {"-E", "--emitters-port"},
      description = "Port to use for the emitters (default: ${DEFAULT-VALUE}).",
      defaultValue = "7337")
  protected int emittersPort;

  @CommandLine.Option(
      names = {"-O", "--operators-port"},
      description = "Port to use for the operators (default: ${DEFAULT-VALUE}).",
      defaultValue = "1732")
  protected int operatorsPort;

  @CommandLine.Option(
      names = {"-I", "--network-interface"},
      description = "Network interface to use",
      required = true)
  protected String networkInterface;

  /**
   * This method will be called when the receiver is started.
   *
   * <p>It will start two workers, one for the emitters and one for the operators. This allows the
   * receiver to handle both aspects of the network application at the same time.
   *
   * <p>Each worker will be started in its own thread and can have access to the roomsTemperature
   * map that follows all the best practices for concurrent access.
   *
   * @return 0 if the receiver was started successfully, 1 otherwise.
   */
  @Override
  public Integer call() {
    try (ExecutorService executorService = Executors.newFixedThreadPool(2); ) {
      executorService.submit(this::emittersWorker);
      executorService.submit(this::operatorsWorker);
    } catch (Exception e) {
      System.out.println("[Receiver] Exception: " + e);

      return 1;
    }

    return 0;
  }

  /**
   * This method will take care of the emitters part of the receiver using the fire-and-forget
   * messaging pattern.
   */
  public Integer emittersWorker() {
    try (MulticastSocket socket = new MulticastSocket(emittersPort)) {
      InetAddress multicastAddress = InetAddress.getByName(emittersMulticastAddress);
      InetSocketAddress multicastGroup = new InetSocketAddress(multicastAddress, emittersPort);
      NetworkInterface netInterface = NetworkInterface.getByName(networkInterface);
      socket.joinGroup(multicastGroup, netInterface);

      System.out.println(
          "[Receiver] Listening for multicast messages on address "
              + emittersMulticastAddress
              + ", "
              + "network interface "
              + networkInterface
              + " and port "
              + emittersPort
              + "...");

      while (!socket.isClosed()) {
        byte[] buffer = new byte[1024];

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        socket.receive(packet);

        String emitterMessage =
            new String(
                packet.getData(), packet.getOffset(), packet.getLength(), StandardCharsets.UTF_8);

        System.out.println("[Receiver] Message received: " + emitterMessage);

        String[] emitterMessageParts = emitterMessage.split(" ", 2);

        Emitter.Message message = null;
        try {
          message = Emitter.Message.valueOf(emitterMessageParts[0]);
        } catch (Exception e) {
          // Do nothing
        }

        switch (message) {
          case TEMP -> {
            if (emitterMessageParts.length < 2) {
              System.out.println("[Receiver] Invalid message, ignoring...");
              break;
            }

            try {
              // Extract the room name and the temperature
              //
              // As we know from the application protocol, the room name and temperature are
              // separated
              // by a space
              String[] roomNameAndTemperature = emitterMessageParts[1].split(" ");

              if (roomNameAndTemperature.length < 2) {
                System.out.println("[Receiver] Invalid message, ignoring...");
                break;
              }

              String roomName = roomNameAndTemperature[0];
              Double temperature = Double.parseDouble(roomNameAndTemperature[1]);

              roomsTemperature.put(roomName, temperature);
            } catch (NumberFormatException e) {
              System.out.println("[Receiver] Invalid message, ignoring...");
            }
          }
          case null, default -> System.out.println("[Receiver] Invalid message, ignoring...");
        }
      }

      socket.leaveGroup(multicastGroup, netInterface);
    } catch (Exception e) {
      System.out.println("[Receiver] Exception: " + e);
    }

    return 0;
  }

  /**
   * This method will take care of the operators part of the receiver using the request-reply
   * messaging pattern.
   */
  public Integer operatorsWorker() {
    try (DatagramSocket socket = new DatagramSocket(operatorsPort)) {
      System.out.println(
          "[Receiver] Listening for unicast messages on port " + operatorsPort + "...");

      while (!socket.isClosed()) {
        byte[] requestBuffer = new byte[1024];

        DatagramPacket requestPacket = new DatagramPacket(requestBuffer, requestBuffer.length);

        socket.receive(requestPacket);

        String request =
            new String(
                requestPacket.getData(),
                requestPacket.getOffset(),
                requestPacket.getLength(),
                StandardCharsets.UTF_8);

        System.out.println("[Receiver] Request received: " + request);

        String[] operatorRequestParts = request.split(" ", 2);

        Operator.Message message = null;
        try {
          message = Operator.Message.valueOf(operatorRequestParts[0]);
        } catch (Exception e) {
          // Do nothing
        }

        String response;

        switch (message) {
          case REQ_TEMP -> {
            if (operatorRequestParts.length < 2) {
              response = Message.ERROR + " -1: invalid message";
              break;
            }

            String roomId = operatorRequestParts[1].trim();

            Double temperature = roomsTemperature.get(roomId);

            if (temperature != null) {
              response = Message.TEMP + " " + temperature;
            } else {
              response = Message.ERROR + " 1: the room was not found";
            }
          }
          case null, default -> {
            response = Message.ERROR + " -1: invalid message";
          }
        }

        byte[] responseBuffer = response.getBytes(StandardCharsets.UTF_8);
        DatagramPacket responsePacket =
            new DatagramPacket(
                responseBuffer,
                responseBuffer.length,
                requestPacket.getAddress(),
                requestPacket.getPort());

        socket.send(responsePacket);
      }
    } catch (IOException e) {
      System.err.println("[Receiver] An error occurred: " + e.getMessage());
    }

    return 0;
  }
}
