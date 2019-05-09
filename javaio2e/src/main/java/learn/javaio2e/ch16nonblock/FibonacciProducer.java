package learn.javaio2e.ch16nonblock;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public class FibonacciProducer extends Thread {
    private final WritableByteChannel out;
    private final int howMany;

    public FibonacciProducer(WritableByteChannel out, int howMany) {
        this.out = out;
        this.howMany = howMany;
    }

    @Override
    public void run() {
        BigInteger low = BigInteger.ONE;
        BigInteger high = BigInteger.ONE;
        try {
            ByteBuffer buffer = ByteBuffer.allocate(4);
            buffer.putInt(howMany);
            buffer.flip();
            while (buffer.hasRemaining()) {
                out.write(buffer);
            }
            for (int i = 0; i < howMany; i++) {
                byte[] data = low.toByteArray();
                // These numbers can become arbitrary large, and they grow
                // exponentially so no fixed size buffer will suffice.
                buffer = ByteBuffer.allocate(4 + data.length);
                buffer.putInt(data.length);
                buffer.put(data);
                buffer.flip();
                while (buffer.hasRemaining()) {
                    out.write(buffer);
                }
                // find the next number in the series
                BigInteger temp = high;
                high = high.add(low);
                low = temp;
            }
            out.close();
            System.out.println("Closed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
