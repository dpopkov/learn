package learn.javaio2e.ch15channels;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * Demonstrates usage of ServerSocketChannel using blocking mode of new I/O API.
 *
 * Usage of NIO for such a simple server is complete overkill.
 * There's enough constant overhead in setting up the buffers and channels that speedups
 * become apparent only for larger data sets, and likely then only if you're using non-blocking I/O.
 */
public class NewIoHelloServer {
    private static final int PORT = 2345;
    private static final int CONNECTION_LIMIT = 5;

    public static void main(String[] args) throws IOException {
        // 1. Open a ServerSocketChannel using the static open() method.
        // This channel is not yet connected to anything.
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        SocketAddress port = new InetSocketAddress(PORT);
        // 2. Retrieve the channel's ServerSocket using the socket() method.
        // and 3. Bind the ServerSocket to a port to start listening.
        serverChannel.socket().bind(port);
        final String serverInfo = "This is " + serverChannel.socket()
                + " on port " + serverChannel.socket().getLocalPort() + "\r\n";
        int count = 0;
        while (count < CONNECTION_LIMIT) {
            try {
                count++;
                // 4. Accept an incoming connection to get a socket channel
                SocketChannel clientChannel = serverChannel.accept();
                System.out.println("connection count: " + count);
                String response = makeResponse(clientChannel, serverInfo);
                byte[] data = response.getBytes(StandardCharsets.UTF_8);
                ByteBuffer buffer = ByteBuffer.wrap(data);
                // 5. Communicate over the SocketChannel
                while (buffer.hasRemaining()) {
                    clientChannel.write(buffer);
                }
                // 6. Close the SocketChannel
                clientChannel.close();
                // 7. Go to step 4.
            } catch (IOException e) {
                // This is an error on one connection. Maybe the client crashed.
                // Maybe it broke the connection prematurely. Whatever happened,
                // it's not worth shutting down the server for.
            }
        }
    }

    private static String makeResponse(SocketChannel channel, String serverInfo) {
        return "Hello "
                + channel.socket().getInetAddress() + " on port "
                + channel.socket().getPort() + "\r\n"
                + serverInfo + "\r\n";
    }
}
