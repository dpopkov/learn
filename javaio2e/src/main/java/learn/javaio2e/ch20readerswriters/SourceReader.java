package learn.javaio2e.ch20readerswriters;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Reads a \\u-escaped file and converts it to pure Unicode.
 */
public class SourceReader extends FilterReader {
    private int buffer = -1;
    private boolean endOfStream = false;

    protected SourceReader(Reader in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        if (this.buffer != -1) {
            int c = this.buffer;
            this.buffer = -1;
            return c;
        }
        int c = in.read();
        if (c != '\\') {
            return c;
        }
        int next = in.read();
        if (next != 'u') {  // This is not a Unicode escape
            this.buffer = next;
            return c;
        }
        /*
        Read next 4 hex digits.
        If the next four digits do not make a valid hex digit
        this is not a valid .java file.
         */
        String hex = String.valueOf((char) in.read()) +
                (char) in.read() +
                (char) in.read() +
                (char) in.read();
        try {
            return Integer.parseInt(hex, 16);
        } catch (NumberFormatException ex) {
            throw new IOException("Bad Unicode escape: \\u" + hex, ex);
        }
    }

    @Override
    public int read(char[] text, int off, int len) throws IOException {
        if (endOfStream) {
            return -1;
        }
        int numRead = 0;
        for (int i = off; i < off + len; i++) {
            int temp = this.read();
            if (temp == -1) {
                endOfStream = true;
                break;
            }
            text[i] = (char) temp;
            numRead++;
        }
        return numRead;
    }

    @Override
    public long skip(long n) throws IOException {
        char[] c = new char[(int) n];
        return this.read(c);
    }
}
