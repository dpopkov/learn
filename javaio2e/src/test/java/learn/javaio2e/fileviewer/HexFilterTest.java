package learn.javaio2e.fileviewer;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class HexFilterTest {

    @Test
    public void testFill() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("aJ".getBytes());
        byte[] expected = "61 4A ".getBytes();
        InputStream hf = new HexFilter(in);
        assertBytes(expected, hf);
    }

    private void assertBytes(byte[] expected, InputStream in) throws IOException {
        for (byte b : expected) {
            int n = in.read();
            assertEquals(b, n);
        }
    }
}