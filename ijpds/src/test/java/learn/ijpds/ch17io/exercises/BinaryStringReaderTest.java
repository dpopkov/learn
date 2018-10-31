package learn.ijpds.ch17io.exercises;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BinaryStringReaderTest {

    @Test
    public void reading1() {
        BinaryStringReader reader = new BinaryStringReader();
        byte[] expected = {1};
        byte[] result = reader.read("1");
        assertThat(result, is(expected));
    }

    @Test
    public void reading0() {
        BinaryStringReader reader = new BinaryStringReader();
        byte[] expected = {0};
        byte[] result = reader.read("0");
        assertThat(result, is(expected));
    }

    @Test
    public void reading101() {
        BinaryStringReader reader = new BinaryStringReader();
        byte[] expected = {5};
        byte[] result = reader.read("101");
        assertThat(result, is(expected));
    }

    @Test
    public void readingTwoBytes() {
        BinaryStringReader reader = new BinaryStringReader();
        byte[] result = reader.read("11111111 00000101");
        byte[] expected = {(byte) 0b11111111, 5};
        assertThat(result, is(expected));
    }

    @Test
    public void readingTwoBytesNewLineAndTwoBytes() {
        BinaryStringReader reader = new BinaryStringReader();
        String input = "11111111 00000101" + System.lineSeparator() +
                       "00001101 00001001";
        byte[] result = reader.read(input);
        byte[] expected = {(byte) 0b11111111, 5, 13, 9};
        assertThat(result, is(expected));
    }
}
