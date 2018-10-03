package learn.ijpds.ch20collections.exercises;

import org.junit.Test;

import static org.junit.Assert.*;

public class DigitsMatcherTest {

    @Test
    public void digitMatch() {
        DigitsMatcher matcher = new DigitsMatcher(123);
        assertTrue(matcher.digitMatch(1));
        assertTrue(matcher.digitMatch(2));
        assertTrue(matcher.digitMatch(3));
        assertFalse(matcher.digitMatch(4));
    }

    @Test
    public void twoDigitsMatch() {
        DigitsMatcher matcher = new DigitsMatcher(123);
        assertTrue(matcher.twoDigitsMatch(1, 2));
        assertTrue(matcher.twoDigitsMatch(1, 3));
        assertTrue(matcher.twoDigitsMatch(2, 3));
        assertFalse(matcher.twoDigitsMatch(2, 4));
        assertFalse(matcher.twoDigitsMatch(4, 3));
    }

    @Test
    public void allDigitsMatch() {
        DigitsMatcher matcher = new DigitsMatcher(1234);
        assertTrue(matcher.allDigitsMatch(4, 1, 2, 3));
        assertTrue(matcher.allDigitsMatch(1, 3, 2));
        assertTrue(matcher.allDigitsMatch(2, 3));
        assertFalse(matcher.allDigitsMatch(5));
        assertFalse(matcher.allDigitsMatch(4, 7));
    }
}