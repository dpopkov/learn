package learn.core2.ch04netw.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Implements a simple server that listens to port 8189 and echoes back all client input.
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {
        final int port = 8189;
        try (ServerSocket s = new ServerSocket(port)) {
            System.out.println("Listening on port " + port);
            try (Socket incoming = s.accept()) {
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();
                try (Scanner in = new Scanner(inStream, StandardCharsets.UTF_8)) {
                    PrintWriter out = new PrintWriter(
                            new OutputStreamWriter(outStream, StandardCharsets.UTF_8), true);
                    out.println("Hello! Enter BYE to exit.");
                    boolean running = true;
                    while (running && in.hasNextLine()) {
                        String line = in.nextLine();
                        System.out.println("RECEIVED: " + line);
                        out.println("Echo: " + line);
                        if ("BYE".equals(line.trim())) {
                            running = false;
                        }
                    }
                }
            }
            System.out.println("Close server socket.");
        }
    }
}
