package learn.ijpds.ch12exceptions.exercises;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class E1206HexToDecTest {
    @Test
    public void testUpperLetters() {
        String hex = "AB8C";
        int decimal = new E1206HexToDec().hexToDecimal(hex);
        assertThat(decimal, is(43916));
    }

    @Test
    public void testLowerLetters() {
        String hex = "af71";
        int decimal = new E1206HexToDec().hexToDecimal(hex);
        assertThat(decimal, is(44913));
    }

    @Test(expected = java.lang.NumberFormatException.class)
    public void whenNotHexadecimalThenException() {
        String hex = "g71";
        new E1206HexToDec().hexToDecimal(hex);
    }
}