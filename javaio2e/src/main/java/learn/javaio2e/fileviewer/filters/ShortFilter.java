package learn.javaio2e.fileviewer.filters;

import java.io.DataInputStream;
import java.io.IOException;

public class ShortFilter extends DataFilter {
    private static final int SHORT_LENGTH = Short.toString(Short.MIN_VALUE).length();
    private static final String FORMAT = String.format("%%%dd", SHORT_LENGTH);

    public ShortFilter(DataInputStream in) {
        super(in, SHORT_LENGTH + 1);
    }

    @Override
    protected void fill() throws IOException {
        short n = dataIn.readShort();
        numRead += Short.BYTES;
        String s = String.format(FORMAT, n);
        fillBuffer(s, Short.BYTES);
    }
}
