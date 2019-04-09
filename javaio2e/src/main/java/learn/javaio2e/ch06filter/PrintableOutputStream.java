package learn.javaio2e.ch06filter;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Truncates all data to the range of printable ASCII chars,
 * plus tab, linefeed and carriage return.<br>
 * Among other things, this class provides a quick and dirty way
 * to read ASCII string literals embedded in a .class or .exe file.
 */
public class PrintableOutputStream extends FilterOutputStream {
    public PrintableOutputStream(OutputStream out) {
        super(out);
    }

    @Override
    public void write(int b) throws IOException {
        if (PrintableChar.is(b)) {
            out.write(b);
        } else {
            out.write('?');
        }
    }

    @Override
    public void write(byte[] data, int off, int len) throws IOException {
        for (int i = off; i < off + len; i++) {
            write(data[i]);
        }
    }
}
