package learn.javaio2e.fileviewer;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class DecimalFilterTest {

    @Test
    public void testFill() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("a".getBytes());
        byte[] expected = "097 ".getBytes();
        InputStream df = new DecimalFilter(in);
        assertEquals(expected[0], df.read());
        assertEquals(expected[1], df.read());
        assertEquals(expected[2], df.read());
        assertEquals(expected[3], df.read());
    }
}