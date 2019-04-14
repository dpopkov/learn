package learn.javaio2e.fileviewer.filters;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class DecimalFilterTest {

    @Test
    public void testFill() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("aJ".getBytes());
        byte[] expected = "097 074 ".getBytes();
        InputStream df = new DecimalFilter(in);
        assertBytes(expected, df);
    }

    private void assertBytes(byte[] expected, InputStream in) throws IOException {
        for (byte b : expected) {
            assertEquals(b, in.read());
        }
    }
}