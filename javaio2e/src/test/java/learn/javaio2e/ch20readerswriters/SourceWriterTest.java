package learn.javaio2e.ch20readerswriters;

import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class SourceWriterTest {

    @Test
    public void testWriteBackslash() throws IOException {
        StringWriter w = new StringWriter();
        SourceWriter sw = new SourceWriter(w);
        sw.write('\\');
        assertThat(w.toString(), is("\\u005C"));
    }

    @Test
    public void testWriteAscii() throws IOException {
        StringWriter w = new StringWriter();
        SourceWriter sw = new SourceWriter(w);
        sw.write('a');
        assertThat(w.toString(), is("a"));
    }

    @Test
    public void testWriteUnicode() throws IOException {
        StringWriter w = new StringWriter();
        SourceWriter sw = new SourceWriter(w);
        sw.write(0x011E);
        assertThat(w.toString(), is("\\u011e"));
    }
}
