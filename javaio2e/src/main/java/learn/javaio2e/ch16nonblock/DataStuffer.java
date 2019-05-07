package learn.javaio2e.ch16nonblock;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server implemented with classic I/O.
 * It accepts a connection and then sends a continuous stream of bytes.
 */
public class DataStuffer {
    private static final byte[] data = new byte[256];

    public static void main(String[] args) throws IOException {
        final int port = 9000;
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) i;
        }
        ServerSocket server = new ServerSocket(port);
        int count = 0;
        while (count < 5) {
            Socket socket = server.accept();
            count++;
            System.out.println("connection #" + count);
            Thread stuffer = new StuffThread(socket);
            stuffer.start();
        }
    }

    private static class StuffThread extends Thread {
        private final Socket socket;

        public StuffThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                OutputStream out = new BufferedOutputStream(socket.getOutputStream());
                while (!socket.isClosed()) {
                    out.write(data);
                }
            } catch (IOException ex) {
                if (!socket.isClosed()) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
