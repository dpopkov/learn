package learn.javaio2e.ch05net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Listens for incoming connection and answers with the client's address and port and its own.
 */
public class HelloServer {
    private static final String RN = "\r\n";

    public static void main(String[] args) throws IOException {
        final int port = 8189;
        ServerSocket ss = new ServerSocket(port);
        System.out.printf("Started listening on %s on port %d...%n",
                ss.getInetAddress().getHostName(), ss.getLocalPort());
        int count = 0;
        while (count < 10) {
            try {
                Socket s = ss.accept();
                count++;
                String response = "Hello " + s.getInetAddress() + " on port " + s.getPort() + RN
                        + "This is " + s.getLocalAddress() + " on port " + s.getLocalPort() + RN;
                OutputStream out = s.getOutputStream();
                out.write(response.getBytes(StandardCharsets.US_ASCII));
                out.flush();
                s.close();
            } catch (IOException ex) {
                System.err.println("Error on one connection.");
                ex.printStackTrace();
            }
        }
    }
}
