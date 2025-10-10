import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

/**
 * This class implements a broadcast emitter that sends a request to a broadcast address.
 *
 * <p>A broadcast emitter is a program that sends a request to a broadcast address. It
 * creates a datagram socket and sends a request to a broadcast address on a specific port. The
 * request is sent as a datagram packet.
 */
public class UdpBroadcastEmitterExample {

  // Network to broadcast to - you might need to change this depending on your network
  private static final String BROADCAST_ADDRESS = "172.25.255.255";

  // Port to use
  private static final int PORT = 4445;

  // Message to send to the server
  private static final String MESSAGE = "Hello, I'm broadcasting! 🧛";

  public static void main(String[] args) {
    System.out.println("[Emitter] Sending request...");

    try (DatagramSocket socket = new DatagramSocket()) {
      // Enable the broadcast option
      socket.setBroadcast(true);

      // Get the server address
      InetAddress serverAddress = InetAddress.getByName(BROADCAST_ADDRESS);

      // Transform the message into a byte array - always specify the encoding
      byte[] buffer = MESSAGE.getBytes(StandardCharsets.UTF_8);

      // Create a packet with the message, the server address and the port
      DatagramPacket packet = new DatagramPacket(buffer, buffer.length, serverAddress, PORT);

      // Send the packet
      socket.send(packet);

      System.out.println("[Emitter] Request sent: " + MESSAGE);
    } catch (Exception e) {
      System.err.println("[Emitter] An error occurred: " + e.getMessage());
    }

    System.out.println("[Emitter] Quitting...");
  }
}
