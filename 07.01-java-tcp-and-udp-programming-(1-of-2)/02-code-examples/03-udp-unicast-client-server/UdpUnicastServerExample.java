import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * This class implements a unicast server that listens for requests.
 *
 * <p>A unicast server is a program that listens for requests on a specific port. It creates a
 * datagram socket and waits for requests to arrive. When a request arrives, the server processes it
 * and displays the request.
 */
public class UdpUnicastServerExample {

  // Port to listen to
  private static final int PORT = 4445;

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
      }
    } catch (Exception e) {
      System.err.println("[Server] An error occurred: " + e.getMessage());
    }
  }
}
