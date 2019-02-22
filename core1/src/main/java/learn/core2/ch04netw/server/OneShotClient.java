package learn.core2.ch04netw.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Demonstrates one-shot connection.
 */
public class OneShotClient {
    public static void main(String[] args) throws IOException {
        final String host = "127.0.0.1";
        final int port = 8189;
        try (Socket socket = new Socket(host, port)) {
            Scanner in = new Scanner(socket.getInputStream(), StandardCharsets.UTF_8);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true, StandardCharsets.UTF_8);
            out.print("GET");
            out.flush();
            socket.shutdownOutput();
            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.printf("RECEIVED: %s%n", line);
            }
        }
    }
}
