package learn.javaio2e.fileviewer.filters;

import learn.javaio2e.ch03in.StreamCopier;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

import static org.junit.Assert.*;

public class IntFilterTest {

    @Test
    public void testFill() throws IOException {
        int[] numbers = {Integer.MIN_VALUE, 42};
        byte[] bytes = numToBytes(numbers);
        IntFilter filter = new IntFilter(new DataInputStream(new ByteArrayInputStream(bytes)));
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        StreamCopier.copy(filter, buffer);
        String expected = ""
                + "-2147483648\n"
                + "         42\n";
        assertThat(buffer.toString(), Is.is(expected));
    }

    private byte[] numToBytes(int[] numbers) {
        byte[] bytes = new byte[numbers.length * Integer.BYTES];
        for (int i = 0, j = 0; i < numbers.length; i++, j += Integer.BYTES) {
            int n = numbers[i];
            bytes[j] = (byte) (n >>> 24);
            bytes[j + 1] = (byte) (n >>> 16);
            bytes[j + 2] = (byte) (n >>> 8);
            bytes[j + 3] = (byte) n;
        }
        return bytes;
    }
}
