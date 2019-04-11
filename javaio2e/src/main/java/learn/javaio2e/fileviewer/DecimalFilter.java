package learn.javaio2e.fileviewer;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class DecimalFilter extends DumpFilter {
    private static final int BREAK_AFTER = 15;
    /** Number of bytes of output per byte of input. */
    private static final int RATIO = 4;

    protected DecimalFilter(InputStream in) {
        super(in);
    }

    @Override
    protected void fill() throws IOException {
        buf = new int[RATIO];
        int datum = in.read();
        numRead++;
        if (datum == -1) {
            throw new EOFException();
        }
        String dec = String.format("%03d", datum);
        numRead = fillBuffer(dec, BREAK_AFTER);
    }

    @Override
    public int available() throws IOException {
        return (buf.length - index) + RATIO * in.available();
    }
}
