package learn.dsajg6e.tools;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Encapsulates buffer that receives data sent to {@code System.out}.
 * Accumulated output is returned by {@link #toString()} method.
 * Use try-with-resources to perform auto-closing.
 */
public class SystemOutBuffer implements AutoCloseable {
    private final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    private final PrintStream saved;

    public SystemOutBuffer() {
        saved = System.out;
        System.setOut(new PrintStream(buffer));
    }

    @Override
    public String toString() {
        return buffer.toString();
    }

    @Override
    public void close() {
        System.setOut(saved);
    }
}
