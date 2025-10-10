import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * This class implements a broadcast receiver that listens for requests.
 *
 * <p>A broadcast receiver is a program that listens for requests on a specific port. It creates a
 * datagram socket and waits for requests to arrive. When a request arrives, the receiver processes it
 * and displays the request.
 */
public class UdpBroadcastReceiverExample {

  // Port to listen to
  private static final int PORT = 4445;

  public static void main(String[] args) {
    try (DatagramSocket socket = new DatagramSocket(PORT)) {
      System.out.println("[Receiver] Listening for broadcast messages on port " + PORT + "...");

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

        System.out.println("[Receiver] Request received (at " + new Date() + "): " + request);
      }
    } catch (Exception e) {
      System.err.println("[Receiver] An error occurred: " + e.getMessage());
    }
  }
}
