import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.nio.charset.StandardCharsets;

/**
 * This class implements a multicast receiver that listens for messages on a multicast group.
 *
 * <p>A multicast receiver is a program that listens for messages on a multicast group. It joins the
 * multicast group and waits for messages to arrive. When a message arrives, the receiver processes
 * it and prints it to the console.
 *
 * <p>The socket must be bound to a network interface. This is done by calling the `joinGroup`
 * method. The network interface must be specified as a string. To get the network interface, use
 * the `ip` command on Unix systems or the `ipconfig` command on Windows systems.
 */
public class UdpMulticastReceiverExample {
  // Multicast address on which the receiver listens for messages
  private static final String MULTICAST_ADDRESS = "239.0.0.0";

  // Port on which the receiver listens for messages
  private static final int PORT = 4446;

  // Network interface on which the receiver listens for messages - CHANGE THIS
  private static final String NETWORK_INTERFACE = "CHANGE_THIS";

  public static void main(String[] args) {
    try (MulticastSocket socket = new MulticastSocket(PORT)) {
      // Join the multicast group
      InetSocketAddress multicastGroup = new InetSocketAddress(MULTICAST_ADDRESS, PORT);
      NetworkInterface networkInterface = NetworkInterface.getByName(NETWORK_INTERFACE);
      socket.joinGroup(multicastGroup, networkInterface);

      System.out.println(
          "[Receiver] Listening for multicast messages on address "
              + MULTICAST_ADDRESS
              + ", "
              + "network interface "
              + NETWORK_INTERFACE
              + " and port "
              + PORT
              + "...");

      while (!socket.isClosed()) {
        // Create a buffer for the incoming message
        byte[] buffer = new byte[1024];

        // Create a packet for the incoming message
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        // Receive the packet - this is a blocking call
        socket.receive(packet);

        // Transform the message into a string
        String emitterMessage =
            new String(
                packet.getData(), packet.getOffset(), packet.getLength(), StandardCharsets.UTF_8);

        // Print the message
        System.out.println("[Receiver] Received message: " + emitterMessage);
      }

      // Quit the multicast group
      socket.leaveGroup(multicastGroup, networkInterface);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
