package learn.javaio2e.fileviewer.filters;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class HexFilter extends DumpFilter {
    private static final int BREAK_AFTER = 24;
    private static final int RATIO = 3;

    public HexFilter(InputStream in) {
        super(in, RATIO);
    }

    @Override
    protected void fill() throws IOException {
        int datum = in.read();
        numRead++;
        if (datum == -1) {
            throw new EOFException();
        }
        String hex = String.format("%02X", datum);
        numRead = fillBuffer(hex, BREAK_AFTER);
    }
}
