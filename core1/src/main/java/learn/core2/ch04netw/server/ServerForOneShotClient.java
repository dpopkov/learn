package learn.core2.ch04netw.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Demonstrates half-closed connection.
 */
public class ServerForOneShotClient {
    public static void main(String[] args) throws IOException {
        final int port = 8189;
        int count = 1;
        try (ServerSocket s = new ServerSocket(port)) {
            System.out.println("Listening on port " + port);
            boolean running = true;
            while (running) {
                Socket incoming = s.accept();
                try (InputStream inputStream = incoming.getInputStream();
                     OutputStream outputStream = incoming.getOutputStream()) {
                    Scanner in = new Scanner(inputStream, StandardCharsets.UTF_8);
                    PrintWriter out = new PrintWriter(outputStream, true, StandardCharsets.UTF_8);
                    String command = in.nextLine();
                    System.out.println("Received command: " + command);
                    if ("SHUTDOWN".equals(command)) {
                        running = false;
                    } else if ("GET".equals(command)) {
                        out.println("<html>" + count + "</html>");
                        count++;
                    } else {
                        out.println("Bad command");
                    }
                }
            }
        }
    }
}
