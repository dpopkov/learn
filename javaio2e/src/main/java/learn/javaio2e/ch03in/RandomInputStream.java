package learn.javaio2e.ch03in;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

/**
 * Provides random bytes.
 */
public class RandomInputStream extends InputStream {
    private final Random generator = new Random();
    private boolean closed = false;

    @Override
    public int read() throws IOException {
        checkOpen();
        return generator.nextInt(256);
    }

    @Override
    public int read(byte[] data, int off, int length) throws IOException {
        checkOpen();
        byte[] temp = new byte[length];
        generator.nextBytes(temp);
        System.arraycopy(temp, 0, data, off, length);
        return length;
    }

    @Override
    public int read(byte[] data) throws IOException {
        checkOpen();
        generator.nextBytes(data);
        return data.length;
    }

    @Override
    public long skip(long bytesToSkip) throws IOException {
        checkOpen();
        return bytesToSkip;
    }

    @Override
    public int available() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void close() {
        closed = true;
    }

    private void checkOpen() throws IOException {
        if (closed) {
            throw new IOException("Input stream closed");
        }
    }
}
