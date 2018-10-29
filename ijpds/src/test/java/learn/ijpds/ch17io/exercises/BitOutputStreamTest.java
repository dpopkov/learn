package learn.ijpds.ch17io.exercises;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BitOutputStreamTest {
    private ByteArrayOutputStream outBytes;
    private BitOutputStream output;

    @Before
    public void setUp() {
        outBytes = new ByteArrayOutputStream();
        output = new BitOutputStream(outBytes);
    }

    @Test
    public void whenCreateThenEmpty() throws IOException {
        output.close();
        byte[] bytes = outBytes.toByteArray();
        assertThat(bytes.length, is(0));
    }

    @Test
    public void whenWrite1Then1() throws IOException {
        output.writeBit('1');
        output.close();
        byte[] bytes = outBytes.toByteArray();
        assertThat(bytes.length, is(1));
        assertThat(bytes[0], is((byte) 1));
    }

    @Test
    public void whenWriteBits0101ThenResult5() throws IOException {
        output.writeBits("0101");
        output.close();
        byte[] bytes = outBytes.toByteArray();
        assertThat(bytes.length, is(1));
        assertThat(bytes[0], is((byte)5));
    }

    @Test
    public void writeBit10ThenResult2() throws IOException {
        output.writeBit('1');
        output.writeBit('0');
        output.close();
        byte[] bytes = outBytes.toByteArray();
        assertThat(bytes.length, is(1));
        assertThat(bytes[0], is((byte)2));
    }

    @Test
    public void write10000100100001001101() throws IOException {
        output.writeBits("10000100100001001101");
        output.close();
        byte[] bytes = outBytes.toByteArray();
        assertThat(bytes.length, is(3));
        // Result: 00001000_01001000_01001101
        assertThat(bytes[0], is((byte) 0b00001000));
        assertThat(bytes[1], is((byte) 0b01001000));
        assertThat(bytes[2], is((byte) 0b01001101));
    }
}
