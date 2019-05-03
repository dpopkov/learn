package learn.javaio2e.ch15channels;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * Demonstrates usage of socket channel.
 */
public class HttpGrab {
    private static final String RN = "\r\n";

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage: java HttpGrab url filename");
            return;
        }
        URL u = new URL(args[0]);
        if (!u.getProtocol().equals("http")) {
            System.err.println("Sorry, " + u.getProtocol() + " is not supported");
            return;
        }
        String host = u.getHost();
        int port = u.getPort();
        String file = u.getFile();
        if (file == null || file.isEmpty()) {
            file = "/";
        }
        if (port <= 0) {
            port = 80;
        }
        SocketAddress remote = new InetSocketAddress(host, port);
        try (SocketChannel channel = SocketChannel.open(remote);
             FileOutputStream out = new FileOutputStream(args[1]);
             FileChannel localFile = out.getChannel()) {
            String request = "GET " + file + " HTTP/1.1" + RN
                    + "User Agent: HttpGrab" + RN
                    + "Accept: text/*" + RN
                    + "Connection: close" + RN
                    + "Host: " + host + RN
                    + RN;
            ByteBuffer header = ByteBuffer.wrap(request.getBytes(StandardCharsets.US_ASCII));
            channel.write(header);
            ByteBuffer buffer = ByteBuffer.allocate(8192);
            while (channel.read(buffer) != -1) {
                buffer.flip();
                localFile.write(buffer);
                buffer.clear();
            }
        }
    }
}
