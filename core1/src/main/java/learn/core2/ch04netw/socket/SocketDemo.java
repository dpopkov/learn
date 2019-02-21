package learn.core2.ch04netw.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Makes a socket connection to the atomic clock in Boulder, Colorado, and prints
 * the time that the server sends.
 */
public class SocketDemo {
    public static void main(String[] args) throws IOException {
        final String host = "time-a.nist.gov";
        final int port = 13;
        System.out.printf("Connecting to port %d on host '%s' ...%n", port, host);
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), 10_000);
            System.out.println(socket.isConnected() ? "Is connected" : "Is not connected");
            Scanner in = new Scanner(socket.getInputStream(), StandardCharsets.UTF_8);
            while (in.hasNextLine()) {
                System.out.println("Received:");
                String line = in.nextLine();
                System.out.println(line);
            }
        }
        System.out.println("Program finished.");
    }
}
