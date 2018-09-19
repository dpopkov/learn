package learn.ijpds.ch06methods;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Hex2DecTest {
    @Test
    public void testUpperLetters() {
        String hex = "AB8C";
        int decimal = Hex2Dec.hexToDecimal(hex);
        assertThat(decimal, is(43916));
    }

    @Test
    public void testLowerLetters() {
        String hex = "af71";
        int decimal = Hex2Dec.hexToDecimal(hex);
        assertThat(decimal, is(44913));
    }
}