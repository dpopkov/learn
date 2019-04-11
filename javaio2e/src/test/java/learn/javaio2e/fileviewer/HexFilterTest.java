package learn.javaio2e.fileviewer;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class HexFilterTest {

    @Test
    public void testFill() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("a".getBytes());
        byte[] expected = "61 ".getBytes();
        InputStream hf = new HexFilter(in);
        assertEquals(expected[0], hf.read());
        assertEquals(expected[1], hf.read());
        assertEquals(expected[2], hf.read());
    }
}