package learn.javaio2e.fileviewer.filters;

import java.io.DataInputStream;
import java.io.IOException;

public class LongFilter  extends DataFilter {
    private static final int LONG_LENGTH = Long.toString(Long.MIN_VALUE).length();
    private static final String FORMAT = String.format("%%%dd", LONG_LENGTH);

    public LongFilter(DataInputStream in) {
        super(in, LONG_LENGTH + 1);
    }

    @Override
    protected void fill() throws IOException {
        long number = dataIn.readLong();
        numRead += Long.BYTES;
        String s = String.format(FORMAT, number);
        fillBuffer(s, Long.BYTES);
    }
}
