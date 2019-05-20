package learn.javaio2e.ch20readerswriters;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Converts Unicode text to \\u-escaped ASCII.
 */
public class SourceWriter extends FilterWriter {
    protected SourceWriter(Writer out) {
        super(out);
    }

    @Override
    public void write(char[] text, int off, int len) throws IOException {
        for (int i = off; i < off + len; i++) {
            this.write(text[i]);
        }
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        for (int i = off; i < off + len; i++) {
            this.write(str.charAt(i));
        }
    }

    @Override
    public void write(int c) throws IOException {
        if (c == '\\') {
            out.write("\\u005C");
        } else if (c < 128) {
            out.write(c);
        } else {
            String s = Integer.toHexString(c);
            // Pad with leading zeros
            if (c < 256) {
                s = "00" + s;
            } else if (c < 4096) {
                s = "0" + s;
            }
            out.write("\\u");
            out.write(s);
        }
    }
}
