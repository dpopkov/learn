package learn.ijpds.ch17io.exercises;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class HexPrinterTest {

    @Test
    public void whenPrintFF01() throws IOException {
        StringBuilder result = new StringBuilder();
        HexPrinter printer = new HexPrinter(result::append, 8);
        InputStream input = new ByteArrayInputStream(new byte[] {(byte) 0xFF, 1});
        printer.print(input);
        assertThat(result.toString(), Is.is("FF 01 "));
    }
}