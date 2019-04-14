package learn.javaio2e.fileviewer.filters;

import learn.javaio2e.ch08data.LittleEndianInputStream;

import java.io.IOException;

public abstract class LittleEndianFilter extends DumpFilter {
    private final LittleEndianInputStream lin;

    protected LittleEndianFilter(LittleEndianInputStream in, int ratio) {
        super(in, ratio);
        this.lin = in;
    }

    @Override
    public int available() throws IOException {
        return (buf.length - index) + lin.available();
    }
}
