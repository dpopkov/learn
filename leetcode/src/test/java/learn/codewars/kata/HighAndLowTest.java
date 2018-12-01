package learn.codewars.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class HighAndLowTest {

    @Test
    public void testProcess() {
        String result = HighAndLow.process("8 3 -5 42 -1 0 0 -9 4 7 4 -4");
        assertEquals("42 -9", result);
    }
}