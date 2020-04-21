package learn.ijpds2nd.ch07arrays.exer;

import org.junit.Test;

import static org.junit.Assert.*;

@SuppressWarnings("SpellCheckingInspection")
public class E0734SortCharactersTest {

    @Test
    public void testSort() {
        String s = "cbagfe";
        String r = E0734SortCharacters.sort(s);
        assertEquals("abcefg", r);
    }
}
