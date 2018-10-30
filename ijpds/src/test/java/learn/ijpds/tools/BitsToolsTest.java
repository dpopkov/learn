package learn.ijpds.tools;

import org.junit.Test;

import static learn.ijpds.tools.BitsTools.toBinary;
import static learn.ijpds.tools.BitsTools.toHex;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BitsToolsTest {

    @Test
    public void whenOneByteShiftRightBy1() {
        byte[] bytes = {7};
        byte[] expected = {3};
        BitsTools.shiftRight(bytes, 1);
        assertThat(bytes, is(expected));
    }

    @Test
    public void whenShiftRightBy1() {
        byte[] bytes = {1, 2, 3, 4};
        // 00000001_00000010_00000011_00000100
        // 00000000_10000001_00000001_10000010
        byte[] expected = {
                (byte) 0b00000000,
                (byte) 0b10000001,
                (byte) 0b00000001,
                (byte) 0b10000010
        };
        BitsTools.shiftRight(bytes, 1);
        assertThat(bytes, is(expected));
    }

    @Test
    public void whenShiftRightBy6() {
        byte[] bytes = {1, 2, 3, 4};
        // 00000001_00000010_00000011_00000100
        // 00000000_00000100_00001000_00001100
        byte[] expected = {
                (byte) 0b00000000,
                (byte) 0b00000100,
                (byte) 0b00001000,
                (byte) 0b00001100
        };
        BitsTools.shiftRight(bytes, 6);
        assertThat(bytes, is(expected));
    }

    @Test
    public void whenShiftRightBy7Length4() {
        byte[] bytes = {1, 2, 3, 4, 5};
        // 00000001_00000010_00000011_00000100
        // 00000000_00000010_00000100_00000110
        byte[] expected = {
                (byte) 0b00000000,
                (byte) 0b00000010,
                (byte) 0b00000100,
                (byte) 0b00000110,
                5
        };
        BitsTools.shiftRight(bytes, 7, 4);
        assertThat(bytes, is(expected));
    }

    /**
     * Tests masking negative bits appearing when shifting first element
     * because sometimes bytes converted to integers produce additional
     * 1-bits in left part.
     * For example:
     * byte b       b >>> 4
     * 10000000     11111000  <- because byte is converted to int before shifting
     */
    @Test
    public void whenShiftRightNegativeFirstElementThenNotSignedShifting() {
        byte[] bytes = {-128};
        BitsTools.shiftRight(bytes, 7);
        assertThat(bytes[0], is((byte)1));
    }

    @Test
    public void whenConvertByte5ThenGet101() {
        String expected = "00000101";
        assertThat(toBinary((byte)5), is(expected));
    }

    @Test
    public void whenConvertByteMinus128ThenGet10000000() {
        String expected = "10000000";
        assertThat(toBinary((byte)-128), is(expected));
    }

    @Test
    public void whenConvert255ToHexThenFF() {
        String expected = "FF";
        assertThat(toHex(255), is(expected));
    }

    @Test
    public void whenConvert13ToHexThen0D() {
        String expected = "0D";
        assertThat(toHex(13), is(expected));
    }
}
