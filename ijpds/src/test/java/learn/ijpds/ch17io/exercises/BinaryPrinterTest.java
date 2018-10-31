package learn.ijpds.ch17io.exercises;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BinaryPrinterTest {
    private StringBuilder result = new StringBuilder();

    @Test
    public void print() throws IOException {
        byte[] bytes = {0b1111, 0b0101, 0b0001, (byte)0b11111111};
        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
        BinaryPrinter printer = new BinaryPrinter(s -> result.append(s), 8);
        printer.print(byteStream);
        String expected = "00001111 00000101 00000001 11111111 ";
        assertThat(result.toString(), is(expected));
    }
}
