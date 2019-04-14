package learn.javaio2e.fileviewer.filters;

import java.io.DataInputStream;
import java.io.IOException;

public class IntFilter extends DataFilter {
    private static final int INT_LENGTH = Integer.toString(Integer.MIN_VALUE).length();
    private static final String FORMAT = String.format("%%%dd", INT_LENGTH);

    public IntFilter(DataInputStream in) {
        super(in, INT_LENGTH + 1);
    }

    @Override
    protected void fill() throws IOException {
        int number = dataIn.readInt();
        numRead += Integer.BYTES;
        String s = String.format(FORMAT, number);
        fillBuffer(s, Integer.BYTES);
    }
}
