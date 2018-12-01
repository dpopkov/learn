package learn.codewars.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShortestWordTest {

    @Test
    public void testFindShort() {
        assertEquals(3, ShortestWord.findShort("bitcoin take over the world maybe who knows perhaps"));
        assertEquals(3, ShortestWord.findShort("turns out random test cases are easier than writing out basic ones"));
    }
}
