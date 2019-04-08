package learn.javaio2e.ch05net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Tries to make an HTTP Get request.
 */
public class SocketHttpGet {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java SocketHttpGet url");
            return;
        }
        URL url = new URL(args[0]);
        if (!url.getProtocol().equals("http")) {
            System.err.println("Sorry, " + url.getProtocol() + " is not supported");
            return;
        }
        String host = url.getHost();
        int port = url.getPort();
        String file = url.getFile();
        file = (file == null) ? "/" : file;
        port = (port <= 0) ? 80 : port;
        Socket socket = null;
        try {
            socket = new Socket(host, port);
            String request = buildHttpRequest(host, file);
            byte[] requestBytes = request.getBytes(StandardCharsets.US_ASCII);
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();
            out.write(requestBytes);
            out.flush();
            int c;
            while ((c = in.read()) != -1) {
                System.out.write(c);
            }
        } finally {
            if (socket != null && socket.isConnected()) {
                socket.close();
                System.out.println("Socket closed.");
            }
        }
    }

    private static String buildHttpRequest(String host, String file) {
        final String rn = "\r\n";
        return "GET " + file + " HTTP/1.1" + rn
                + "User-Agent: " + SocketHttpGet.class.getSimpleName() + rn
                + "Accept: text/*" + rn
                + "Host: " + host + rn
                + rn;
    }
}
