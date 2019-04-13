package learn.javaio2e.fileviewer.filters;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class DecimalFilter extends DumpFilter {
    private static final int BREAK_AFTER = 15;
    /** Number of bytes of output per byte of input. */
    private static final int RATIO = 4;

    public DecimalFilter(InputStream in) {
        super(in, RATIO);
    }

    @Override
    protected void fill() throws IOException {
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
