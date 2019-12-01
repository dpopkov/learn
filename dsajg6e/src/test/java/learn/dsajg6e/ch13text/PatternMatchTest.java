package learn.dsajg6e.ch13text;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class PatternMatchTest {

    @Test
    public void testFindBrute() {
        char[] text = "every starting index".toCharArray();
        assertFind(text, "bcd", -1);
        assertFind(text, "very", 1);
        assertFind(text, "abc", -1);
        assertFind(text, "ting", 10);
        assertFind(text, "every", 0);
        assertFind(text, "ex", 18);
    }

    private void assertFind(char[] text, String pattern, int expectedIdx) {
        int idx = PatternMatch.findBrute(text, pattern.toCharArray());
        assertThat(idx, is(expectedIdx));
    }
}
