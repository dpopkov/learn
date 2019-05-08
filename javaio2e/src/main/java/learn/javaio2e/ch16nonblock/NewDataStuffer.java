package learn.javaio2e.ch16nonblock;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NewDataStuffer {
    private static final byte[] data = new byte[255];

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) i;
        }
        ServerSocketChannel server = ServerSocketChannel.open();
        server.configureBlocking(false);
        server.socket().bind(new InetSocketAddress(9000));
        Selector selector = Selector.open();
        server.register(selector, SelectionKey.OP_ACCEPT);
        int count = 0;
        while (count < 5) {
            selector.select();
            Set<SelectionKey> readyKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = readyKeys.iterator();
            while (iterator.hasNext()) {
                count++;
                SelectionKey key = iterator.next();
                iterator.remove();
                try {
                    if (key.isAcceptable()) {
                        SocketChannel client = server.accept();
                        System.out.println("Accepted connection from " + client);
                        client.configureBlocking(false);
                        ByteBuffer source = ByteBuffer.wrap(data);
                        SelectionKey key2 = client.register(selector, SelectionKey.OP_WRITE);
                        key2.attach(source);
                    } else if (key.isWritable()) {
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer output = (ByteBuffer) key.attachment();
                        if (!output.hasRemaining()) {
                            output.rewind();
                        }
                        client.write(output);
                    }
                } catch (IOException ex) {
                    key.cancel();
                    try {
                        key.channel().close();
                    } catch (IOException cex) {
                        cex.printStackTrace();
                    }
                }
            }
        }
    }
}
