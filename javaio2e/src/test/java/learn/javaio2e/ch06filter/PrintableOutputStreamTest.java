package learn.javaio2e.ch06filter;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class PrintableOutputStreamTest {

    @Test
    public void testWrite() throws IOException {
        String text = "abc\u001F12";
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        OutputStream out = new PrintableOutputStream(buffer);
        out.write(text.getBytes());
        assertThat(buffer.toString(), is("abc?12"));
    }
}