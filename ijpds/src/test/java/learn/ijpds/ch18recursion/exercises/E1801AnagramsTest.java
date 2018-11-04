package learn.ijpds.ch18recursion.exercises;

import org.junit.Test;

import static org.junit.Assert.*;

public class E1801AnagramsTest {

    @Test
    public void whenAnagrams() {
        String a = "word";
        String b = "drwo";
        assertTrue(E1801Anagrams.anagrams(a, b));
    }

    @Test
    public void whenNotAnagrams() {
        String a = "word";
        String b = "drowo";
        assertFalse(E1801Anagrams.anagrams(a, b));
    }
}