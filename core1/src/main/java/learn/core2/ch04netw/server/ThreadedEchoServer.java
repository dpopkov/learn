package learn.core2.ch04netw.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Implements a multithreaded server that listens to port 8189 and echoes back.
 */
public class ThreadedEchoServer {
    public static void main(String[] args) throws IOException {
        final int port = 8189;
        System.out.println("Listening on port " + port);
        try (ServerSocket s = new ServerSocket(port)) {
            int i = 1;
            final int limit = 5;
            while (i <= limit) {
                Socket incoming = s.accept();
                System.out.println("Spawning " + i);
                Runnable r = new SocketHandler(incoming, i);
                new Thread(r).start();
                i++;
            }
            System.out.printf("Reached a limit of %d connections.%n", limit);
        }
    }

    /**
     * Handles the client input for one server socket connection.
     */
    private static class SocketHandler implements Runnable {
        private final Socket socket;
        private final int id;

        public SocketHandler(Socket socket, int id) {
            this.socket = socket;
            this.id = id;
        }

        @Override
        public void run() {
            try (InputStream inputStream = socket.getInputStream();
                 OutputStream outputStream = socket.getOutputStream()
            ) {
                Scanner in = new Scanner(inputStream, StandardCharsets.UTF_8);
                PrintWriter out = new PrintWriter(
                        new OutputStreamWriter(outputStream, StandardCharsets.UTF_8), true);
                out.println("Hello! Enter BYE to exit.");
                boolean running = true;
                while (running && in.hasNextLine()) {
                    String line = in.nextLine();
                    System.out.printf("Received from #%02d: %s%n", id, line);
                    out.printf("#%02d-ECHO: %s%n", id, line);
                    if (line.trim().equals("BYE")) {
                        running = false;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
