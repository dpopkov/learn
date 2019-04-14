package learn.javaio2e.fileviewer.filters;

import java.io.DataInputStream;
import java.io.IOException;

public abstract class DataFilter extends DumpFilter {
    protected DataInputStream dataIn;

    protected DataFilter(DataInputStream in, int ratio) {
        super(in, ratio);
        dataIn = in;
    }

    @Override
    public int available() throws IOException {
        return (buf.length - index) + in.available();
    }
}
