package learn.javaio2e.ch06filter;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Truncates all data to the range of printable ASCII characters.
 */
public class PrintableInputStream extends FilterInputStream {
    protected PrintableInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int b = in.read();
        if (b == -1) {
            return -1;
        } else if (PrintableChar.is(b)) {
            return b;
        } else {
            return '?';
        }
    }

    @Override
    public int read(byte[] data, int off, int len) throws IOException {
        int result = in.read(data, off, len);
        if (result == -1) {
            return -1;
        }
        for (int i = off; i < off + result; i++) {
            if (!PrintableChar.is(data[i])) {
                data[i] = (byte) '?';
            }
        }
        return result;
    }
}
