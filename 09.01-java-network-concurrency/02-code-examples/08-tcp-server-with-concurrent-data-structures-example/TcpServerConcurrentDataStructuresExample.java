import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class TcpServerConcurrentDataStructuresExample {

  private static final int PORT = 1234;
  private static final int SERVER_ID = (int) (Math.random() * 1000000);
  private static final String TEXTUAL_DATA = "👋 from Server " + SERVER_ID;

  // Total number of clients connected so far
  private static final AtomicInteger totalNumberOfClients = new AtomicInteger(0);

  // Clients last connection time
  private static final ConcurrentMap<String, Date> clientConnections = new ConcurrentHashMap<>();
  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(PORT);
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor(); ) {
      System.out.println("[Server " + SERVER_ID + "] starting with id " + SERVER_ID);
      System.out.println("[Server " + SERVER_ID + "] listening on port " + PORT);

      while (!serverSocket.isClosed()) {
        Socket clientSocket = serverSocket.accept();
        executor.submit(new ClientHandler(clientSocket));
      }
    } catch (IOException e) {
      System.out.println("[Server " + SERVER_ID + "] exception: " + e);
    }
  }

  static class ClientHandler implements Runnable {

    private final Socket socket;

    public ClientHandler(Socket socket) {
      this.socket = socket;
    }

    @Override
    public void run() {
      try (socket; // This allows to use try-with-resources with the socket
          BufferedReader in =
              new BufferedReader(
                  new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
          BufferedWriter out =
              new BufferedWriter(
                  new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8))) {

        String clientHostname = socket.getInetAddress().getHostName();
        int clientPort = socket.getPort();

        System.out.println(
            "[Server "
                + SERVER_ID
                + "] new client connected from "
                + clientHostname
                + ":"
                + clientPort);

        // Increment client number
        int currentNumberOfClients = totalNumberOfClients.incrementAndGet();

        // Display stats
        System.out.println(
            "[Server " + SERVER_ID + "] total clients connected so far: " + currentNumberOfClients);

        System.out.println(
            "[Server "
                + SERVER_ID
                + "] last time this client connected: "
                + clientConnections.get(clientHostname));

        // Log client connection time
        Date clientConnectionTime = new Date();
        clientConnections.put(clientHostname, clientConnectionTime);

        System.out.println(
            "[Server " + SERVER_ID + "] received textual data from client: " + in.readLine());

        try {
          System.out.println(
              "[Server " + SERVER_ID + "] sleeping for 10 seconds to simulate a long operation");
          Thread.sleep(10000);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }

        System.out.println(
            "[Server " + SERVER_ID + "] sending response to client: " + TEXTUAL_DATA);

        out.write(TEXTUAL_DATA + "\n");
        out.flush();

        System.out.println("[Server " + SERVER_ID + "] closing connection");
      } catch (IOException e) {
        System.out.println("[Server " + SERVER_ID + "] exception: " + e);
      }
    }
  }
}
