package learn.dsajg6e.ch05recursion.exer;

import org.junit.Test;

import static learn.dsajg6e.ch05recursion.exer.C0519VowelsConsonants.*;
import static org.junit.Assert.*;

public class C0519VowelsConsonantsTest {

    @Test
    public void testMoreVowels() {
        assertTrue(moreVowels("a"));
        assertFalse(moreVowels("b"));
        assertFalse(moreVowels("ab"));
        assertTrue(moreVowels("abe"));
        assertFalse(moreVowels("abc"));
    }
}
