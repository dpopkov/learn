package learn.javaio2e.ch20readerswriters;

import java.io.IOException;
import java.io.Writer;

/**
 * Unsynchronized version of {@link java.io.BufferedWriter}.<br>
 * This version can increase speed by 30-50%, though exact performance gains
 * are likely to vary from one VM to the next.
 */
@SuppressWarnings("unused")
public class UnsynchronizedBufferedWriter extends Writer {
    private final static int CAPACITY = 8192;
    private char[] buffer = new char[CAPACITY];
    private int position = 0;
    private Writer out;
    private boolean closed = false;

    public UnsynchronizedBufferedWriter(Writer out) {
        this.out = out;
    }

    @Override
    public void write(char[] text, int offset, int length) throws IOException {
        checkClosed();
        while (length > 0) {
            int n = Math.min(CAPACITY - position, length);
            System.arraycopy(text, offset, buffer, position, n);
            position += n;
            offset += n;
            length -= n;
            if (position >= CAPACITY) {
                flushInternal();
            }
        }
    }

    @Override
    public void write(String str) throws IOException {
        write(str, 0, str.length());
    }

    @Override
    public void write(String str, int offset, int length) throws IOException {
        checkClosed();
        while (length > 0) {
            int n = Math.min(CAPACITY - position, length);
            str.getChars(offset, offset + n, buffer, position);
            position += n;
            offset += n;
            length -= n;
            if (position >= CAPACITY) {
                flushInternal();
            }
        }
    }

    @Override
    public void write(int c) throws IOException {
        checkClosed();
        if (position >= CAPACITY) {
            flushInternal();
        }
        buffer[position] = (char) c;
        position++;
    }

    @Override
    public void flush() throws IOException {
        flushInternal();
        out.flush();
    }

    @Override
    public void close() throws IOException {
        this.flush();
        out.close();
        closed = true;
    }

    private void checkClosed() throws IOException {
        if (closed) {
            throw new IOException("Writer is closed");
        }
    }

    private void flushInternal() throws IOException {
        if (position != 0) {
            out.write(buffer, 0, position);
            position = 0;
        }
    }
}
