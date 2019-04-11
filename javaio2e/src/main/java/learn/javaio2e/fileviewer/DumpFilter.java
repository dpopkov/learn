package learn.javaio2e.fileviewer;

import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * This filter has a buffer which holds the string interpretation of each byte as an array of bytes.
 * The {@code read()} method returns bytes from this array as long as possible, then the abstract
 * {@code fill()} method is invoked to read from the underlying stream and place data in the buffer.
 * By changing how the {@code fill()} method translates the bytes it reads into the bytes in the buffer,
 * you can change how the data is interpreted.
 */
public abstract class DumpFilter extends FilterInputStream {
    /** Array of unsigned bytes. */
    protected int[] buf;
    protected int index;
    /** Number of bytes read in the stream. */
    protected int numRead = 0;

    /**
     * This constructor must be used in extending classes.
     * @param in filtered input stream
     * @param ratio number of bytes of output per byte of input
     */
    protected DumpFilter(InputStream in, int ratio) {
        super(in);
        buf = new int[ratio];
        index = buf.length; // first read() must invoke fill()
    }

    @Override
    public int read() throws IOException {
        int result;
        if (index < buf.length) {
            result = buf[index++];
        } else {
            try {
                this.fill();
                result = buf[0];
                index = 1;
            } catch (EOFException ex) {
                return -1;
            }
        }
        return result;
    }

    protected abstract void fill() throws IOException;

    /**
     * Fills buffer with bytes received from byte of the current byte string representation.
     * @param byteStr string representation of the current byte
     * @param breakAfter number of bytes after which new line is inserted
     * @return updated number of bytes read in the stream if line break is inserted
     */
    protected int fillBuffer(String byteStr, int breakAfter) {
        for (int i = 0; i < byteStr.length(); i++) {
            buf[i] = byteStr.charAt(i);
        }
        int lastByte;
        if (numRead < breakAfter) {
            lastByte = ' ';
        } else {
            lastByte = '\n';
            numRead = 0;
        }
        buf[buf.length - 1] = lastByte;
        return numRead;
    }

    @Override
    public int read(byte[] data, int off, int len) throws IOException {
        if (data == null) {
            throw new NullPointerException();
        }
        if ((off < 0) || (off > data.length) || (len < 0) || (off + len > data.length) || (off + len < 0)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (len == 0) {
            return 0;
        }
        int datum = read();
        if (datum == -1) {
            return -1;
        }
        data[off] = (byte) datum;
        int bytesRead;
        for (bytesRead = 1; bytesRead < len; bytesRead++) {
            datum = read();
            if (datum == -1) {
                break;
            }
            data[off + bytesRead] = (byte) datum;
        }
        return bytesRead;
    }

    @Override
    public int available() throws IOException {
        return buf.length - index;
    }

    @Override
    public long skip(long bytesToSkip) throws IOException {
        long skipped;
        for (skipped = 0; skipped < bytesToSkip; skipped++) {
            int c = read();
            if (c == -1) {
                break;
            }
        }
        return skipped;
    }

    @Override
    public void mark(int readLimit) {
    }

    @Override
    public synchronized void reset() throws IOException {
        throw new IOException("marking not supported");
    }

    @Override
    public boolean markSupported() {
        return false;
    }
}
