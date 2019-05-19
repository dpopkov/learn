package learn.javaio2e.ch20readerswriters;

import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import static org.junit.Assert.*;

public class SourceReaderTest {

    @Test
    public void testRead() throws IOException {
        SourceReader sr = new SourceReader(new StringReader("a"));
        char ch = (char) sr.read();
        assertEquals('a', ch);
    }

    @Test
    public void testReadEscaped() throws IOException {
        SourceReader sr = new SourceReader(new StringReader("\\n"));
        char ch = (char) sr.read();
        assertEquals('\\', ch);
        ch = (char) sr.read();
        assertEquals('n', ch);
    }

    @Test
    public void testReadUnicode() throws IOException {
        SourceReader sr = new SourceReader(new StringReader("\\u09EF"));
        char ch = (char) sr.read();
        assertEquals('৯', ch);  // unicode char 09EF
    }

    @Test
    public void testReadEndOfStream() throws IOException {
        SourceReader sr = new SourceReader(new StringReader(""));
        char[] buf = new char[1];
        int n = sr.read(buf, 0, buf.length);
        assertEquals(0, n);
        n = sr.read(buf, 0, buf.length);
        assertEquals(-1, n);
    }
}