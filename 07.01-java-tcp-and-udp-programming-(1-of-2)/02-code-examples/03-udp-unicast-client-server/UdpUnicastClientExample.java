import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

/**
 * This class implements a unicast client that sends a request to a server.
 *
 * <p>A unicast client is a program that sends a request to a server. It
 * creates a datagram socket and sends a request to a server on a specific host and port. The
 * request is sent as a datagram packet.
 */
public class UdpUnicastClientExample {

  // Host to access
  private static final String HOST = "localhost";

  // Port to use
  private static final int PORT = 4445;

  // Message to send to the server
  private static final String MESSAGE = "Hello, I'm the client! 🦇";

  public static void main(String[] args) {
    System.out.println("[Client] Sending request...");

    try (DatagramSocket socket = new DatagramSocket()) {
      // Get the server address
      InetAddress serverAddress = InetAddress.getByName(HOST);

      // Transform the message into a byte array - always specify the encoding
      byte[] buffer = MESSAGE.getBytes(StandardCharsets.UTF_8);

      // Create a packet with the message, the server address and the port
      DatagramPacket packet = new DatagramPacket(buffer, buffer.length, serverAddress, PORT);

      // Send the packet
      socket.send(packet);

      System.out.println("[Client] Request sent: " + MESSAGE);
    } catch (Exception e) {
      System.err.println("[Client] An error occurred: " + e.getMessage());
    }

    System.out.println("[Client] Quitting...");
  }
}
