package ch.heigvd.dai.commands;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.concurrent.Callable;
import picocli.CommandLine;

@CommandLine.Command(
    name = "emitter",
    description =
        "Start the emitter part of the network application using the fire-and-forget messaging pattern.")
public class Emitter implements Callable<Integer> {
  public enum Message {
    TEMP,
  }

  // Lower bound for the random number
  private static final double LOWER_BOUND = 18.0;

  // Upper bound for the random temperature
  private static final double UPPER_BOUND = 23.0;

  // The temperature of the room
  private double temperature;

  @CommandLine.Option(
      names = {"-M", "--multicast-address"},
      description = "Multicast address to use (default: ${DEFAULT-VALUE}).",
      defaultValue = "230.1.2.3")
  protected String multicastAddress;

  @CommandLine.Option(
      names = {"-P", "--port"},
      description = "Port to use (default: ${DEFAULT-VALUE}).",
      defaultValue = "7337")
  protected int port;

  @CommandLine.Option(
      names = {"-F", "--frequency"},
      description =
          "Frequency of sending the message (in milliseconds) (default: ${DEFAULT-VALUE}).",
      defaultValue = "5000")
  protected int frequency;

  @CommandLine.Option(
      names = {"-N", "--name"},
      description = "The room name.",
      required = true)
  protected String name;

  @Override
  public Integer call() {
    System.out.println("[Emitter] Sending multicast messages...");

    while (true) {
      // Generate a random temperature
      generateRandomTemperature();

      String messageWithTemperature = Message.TEMP + " " + name + " " + temperature;

      try (DatagramSocket socket = new DatagramSocket()) {
        InetAddress multicastAddress = InetAddress.getByName(this.multicastAddress);

        byte[] buffer = messageWithTemperature.getBytes(StandardCharsets.UTF_8);

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, multicastAddress, port);

        socket.send(packet);

        System.out.println("[Emitter] Message sent: " + messageWithTemperature);

        Thread.sleep(frequency);
      } catch (Exception e) {
        System.err.println("[Emitter] An error occurred: " + e.getMessage());
      }
    }
  }

  private void generateRandomTemperature() {
    Random rand = new Random();
    temperature = rand.nextDouble(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
  }
}
