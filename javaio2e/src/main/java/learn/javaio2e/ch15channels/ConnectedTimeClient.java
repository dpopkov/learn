package learn.javaio2e.ch15channels;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.DatagramChannel;
import java.util.Date;

/**
 * Demonstrates the UDP time client that first connects to the server.
 * It sends a packet to the server using the write() method and gets the result back using the read() method.
 */
public class ConnectedTimeClient {
    public static void main(String[] args) throws IOException {
        DatagramChannel channel = DatagramChannel.open();
        SocketAddress address = new InetSocketAddress(0);
        DatagramSocket socket = channel.socket();
        socket.bind(address);
        SocketAddress server = new InetSocketAddress("time-a.nist.gov", 37);
        channel.connect(server);
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.order(ByteOrder.BIG_ENDIAN);
        // send a byte of data to the server
        buffer.put((byte) 0);
        buffer.flip();
        channel.write(buffer);
        // get the buffer ready to receive data
        buffer.clear();
        // fill the first four bytes with zeros
        buffer.putInt(0);
        channel.read(buffer);
        buffer.flip();
        // convert seconds since 1900 to a java.util.Date
        long secondsSince1900 = buffer.getLong();
        final long differenceBetweenEpochs = 2208988800L;
        long secondsSince1970 = secondsSince1900 - differenceBetweenEpochs;
        long msSince1970 = secondsSince1970 * 1000;
        Date time = new Date(msSince1970);
        System.out.println(time);
    }
}
