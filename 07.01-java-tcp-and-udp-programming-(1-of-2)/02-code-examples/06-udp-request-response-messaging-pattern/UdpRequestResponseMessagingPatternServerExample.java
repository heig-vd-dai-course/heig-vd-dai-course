import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * This class implements a unicast server that listens for requests and sends responses.
 *
 * <p>A unicast server is a program that listens for requests on a specific port. It creates a
 * datagram socket and waits for requests to arrive. When a request arrives, the server processes it
 * and sends a response back to the client. The response is sent as a datagram packet.
 */
public class UdpRequestResponseMessagingPatternServerExample {

  // Port to listen to
  private static final int PORT = 4445;

  // Message to send to the client
  private static final String MESSAGE = "Hello, client! I'm the server. 👻";

  public static void main(String[] args) {
    try (DatagramSocket socket = new DatagramSocket(PORT)) {
      System.out.println("[Server] Listening for unicast messages on port " + PORT + "...");

      while (!socket.isClosed()) {
        // Create a buffer for the incoming request
        byte[] requestBuffer = new byte[1024];

        // Create a packet for the incoming request
        DatagramPacket requestPacket = new DatagramPacket(requestBuffer, requestBuffer.length);

        // Receive the packet - this is a blocking call
        socket.receive(requestPacket);

        // Transform the request into a string
        String request =
            new String(
                requestPacket.getData(),
                requestPacket.getOffset(),
                requestPacket.getLength(),
                StandardCharsets.UTF_8);

        System.out.println("[Server] Request received (at " + new Date() + "): " + request);

        // Transform the message into a byte array - always specify the encoding
        byte[] responseBuffer = MESSAGE.getBytes(StandardCharsets.UTF_8);

        // Create a packet with the message, the client address and the client port
        DatagramPacket responsePacket =
            new DatagramPacket(
                responseBuffer,
                responseBuffer.length,
                requestPacket.getAddress(),
                requestPacket.getPort());

        // Send the packet
        socket.send(responsePacket);

        System.out.println("[Server] Response sent (at " + new Date() + "): " + MESSAGE);
      }
    } catch (Exception e) {
      System.err.println("[Server] An error occurred: " + e.getMessage());
    }
  }
}
