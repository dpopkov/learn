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
 * Sends a request to the time server at time.nist.gov.
 * It then receives a UDP datagram containing the number of seconds since midnight, January 1, 1900.<br>
 *
 * The time protocol encodes the time as an unsigned big-endian 4-byte int.
 * Java doesn't have any such data type. The buffer class is used in a tricky way.
 * Before receiving the data, four zeros put are in the buffer's first four positions.
 * Then the next four bytes are received from the server. A total of eight bytes, which is the desired value,
 * can then be read as a signed long using getLong().
 */
public class UdpTimeClient {
    public static void main(String[] args) {
        try (DatagramChannel channel = DatagramChannel.open()) {
            // port 0 selects any available port
            SocketAddress address = new InetSocketAddress(0);
            DatagramSocket socket = channel.socket();
            socket.setSoTimeout(5000);
            socket.bind(address);
            SocketAddress server = new InetSocketAddress("time.nist.gov", 37);
            ByteBuffer buffer = ByteBuffer.allocate(8192);
            // time protocol always uses big-endian order
            buffer.order(ByteOrder.BIG_ENDIAN);
            // Must pus at least one byte of data in the buffer;
            // it doesn't matter what it is.
            buffer.put((byte) 64);
            buffer.flip();
            System.out.println("Sending request to " + server);
            channel.send(buffer, server);
            buffer.clear();
            // Pad 4 zero bytes and then receive 4 bytes of an unsigned integer.
            buffer.put((byte) 0).put((byte) 0).put((byte) 0).put((byte) 0);
            channel.receive(buffer);
            buffer.flip();
            System.out.println("Received response from " + server);
            long secondsSince1900 = buffer.getLong();
            /* The time protocol sets the epoch at 1900;
            the java.util.Date class at 1970.
            This number converts between them. */
            long diffBetweenEpochs = 2208988800L;
            long secondsSince1970 = secondsSince1900 - diffBetweenEpochs;
            long msSince1970 = secondsSince1970 * 1000;
            Date time = new Date(msSince1970);
            System.out.println("time = " + time);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
