package learn.javaio2e.ch02out;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Mimics the behavior of /dev/null on Unix operating systems.
 * Data written into a null output stream is lost.
 */
public class NullOutputStream extends OutputStream {
    private boolean closed = false;

    @Override
    public void write(int b) throws IOException {
        if (closed) {
            throw new IOException("Write to closed stream");
        }
    }

    @Override
    public void write(byte[] data, int off, int len) throws IOException {
        if (data == null) {
            throw new NullPointerException("data is null");
        }
        if (closed) {
            throw new IOException("Write to closed stream");
        }
    }

    @Override
    public void close() {
        closed = true;
    }

    public static void main(String[] args) {
        System.out.println("Using NullOutputStream");
        OutputStream out = new NullOutputStream();
        PrintStream ps = new PrintStream(out);
        System.setOut(ps);
        System.setErr(ps);
        System.out.println("This message will not be seen");
    }
}
