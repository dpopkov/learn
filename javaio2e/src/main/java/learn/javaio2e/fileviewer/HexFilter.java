package learn.javaio2e.fileviewer;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class HexFilter extends DumpFilter {
    private static final int BREAK_AFTER = 24;
    private static final int RATIO = 3;

    protected HexFilter(InputStream in) {
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
        String hex = Integer.toHexString(datum) + " ";
        if (datum < 16) {
            hex = '0' + hex;
        }
        numRead = fillBuffer(hex, BREAK_AFTER);
    }
}
