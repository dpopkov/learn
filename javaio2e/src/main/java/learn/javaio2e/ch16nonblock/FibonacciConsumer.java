package learn.javaio2e.ch16nonblock;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;

public class FibonacciConsumer extends Thread {
    private final ReadableByteChannel in;

    public FibonacciConsumer(ReadableByteChannel in) {
        this.in = in;
    }

    @Override
    public void run() {
        ByteBuffer lengthBuffer = ByteBuffer.allocate(4);
        try {
            while (lengthBuffer.hasRemaining()) {
                in.read(lengthBuffer);
            }
            lengthBuffer.flip();
            int howMany = lengthBuffer.getInt();
            lengthBuffer.clear();
            for (int i = 0; i < howMany; i++) {
                while (lengthBuffer.hasRemaining()) {
                    in.read(lengthBuffer);
                }
                lengthBuffer.flip();
                int length = lengthBuffer.getInt();
                lengthBuffer.clear();
                ByteBuffer data = ByteBuffer.allocate(length);
                while (data.hasRemaining()) {
                    in.read(data);
                }
                BigInteger result = new BigInteger(data.array());
                System.out.println(result);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
