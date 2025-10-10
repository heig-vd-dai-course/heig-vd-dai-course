import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

/**
 * This class implements a multicast emitter that sends messages to a multicast group.
 *
 * <p>A multicast emitter is a program that sends messages to a multicast group. It creates a
 * datagram socket and sends message to the group. The messages are sent to a multicast
 * address and a port. The messages are printed to the console.
 *
 * <p>The multicast address must be in the range `239.0.0.0` to `239.255.255.255`. This range is
 * reserved for multicast communication. The port must be in the range `1024` to `65535`. This range
 * is reserved for user applications.
 */
public class UdpMulticastEmitterExample {
  // Multicast address on which the emitter sends messages
  private static final String MULTICAST_ADDRESS = "239.0.0.0";

  // Port on which the emitter sends messages
  private static final int PORT = 4446;

  // Message to send
  private static final String MESSAGE = "Hello, multicast listeners! 🎃";

  public static void main(String[] args) {
    System.out.println("[Emitter] Sending multicast messages...");

    // Create a datagram socket
    try (DatagramSocket socket = new DatagramSocket()) {
      // Get the multicast address
      InetAddress multicastAddress = InetAddress.getByName(MULTICAST_ADDRESS);

      // Transform the message into a byte array - always specify the encoding
      byte[] buffer = MESSAGE.getBytes(StandardCharsets.UTF_8);

      // Create a packet with the message, the multicast address and the port
      DatagramPacket packet = new DatagramPacket(buffer, buffer.length, multicastAddress, PORT);

      // Send the packet
      socket.send(packet);

      // Print the message
      System.out.println("[Emitter] Message sent: " + MESSAGE);
    } catch (Exception e) {
      System.err.println("[Emitter] An error occurred: " + e.getMessage());
    }
  }
}
