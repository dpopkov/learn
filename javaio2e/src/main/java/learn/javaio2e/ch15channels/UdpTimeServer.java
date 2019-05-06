package learn.javaio2e.ch15channels;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.DatagramChannel;
import java.util.Date;

public class UdpTimeServer {
    private static final int DEFAULT_PORT = 37;

    public static void main(String[] args) throws IOException {
        int port = DEFAULT_PORT;
        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
                if (port <= 0 || port > 65535) {
                    port = DEFAULT_PORT;
                }
            } catch (NumberFormatException nfe) {
                printUsage();
                return;
            }
        }
        ByteBuffer in = ByteBuffer.allocate(8192);
        ByteBuffer out = ByteBuffer.allocate(8);
        out.order(ByteOrder.BIG_ENDIAN);
        SocketAddress address = new InetSocketAddress(port);
        DatagramChannel channel = DatagramChannel.open();
        DatagramSocket socket = channel.socket();
        socket.bind(address);
        System.out.println("bound to " + address);
        int count = 0;
        while (count < 5) {
            try {
                in.clear();
                count++;
                SocketAddress client = channel.receive(in);
                System.out.println("connection #" + count + ": " + client);
                long secondsSince1900 = getTime();
                out.clear();
                out.putLong(secondsSince1900);
                out.flip();
                // skip over the first four bytes to make this an unsigned int
                out.position(4);
                channel.send(out, client);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private static long getTime() {
        long differenceBetweenEpochs = 2208988800L;
        Date now = new Date( );
        long secondsSince1970 = now.getTime( ) / 1000;
        return secondsSince1970 + differenceBetweenEpochs;
    }

    private static void printUsage() {
        System.out.println("Usage: java " + UdpTimeServer.class.getName() + " port-number");
    }
}
