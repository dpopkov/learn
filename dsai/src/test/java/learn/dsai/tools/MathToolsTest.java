package learn.dsai.tools;

import org.junit.Test;

import static org.junit.Assert.*;

public class MathToolsTest {

    @Test
    public void testLog2OfPowerOf2() {
        assertEquals(0, MathTools.log2OfPowerOf2(1));
        assertEquals(1, MathTools.log2OfPowerOf2(2));
        assertEquals(2, MathTools.log2OfPowerOf2(4));
    }

    @Test
    public void testPow() {
        assertEquals(1, MathTools.pow(42, 0));
        assertEquals(42, MathTools.pow(42, 1));
        assertEquals(4, MathTools.pow(2, 2));
        assertEquals(8, MathTools.pow(2, 3));
        assertEquals(16, MathTools.pow(2, 4));
        assertEquals(32, MathTools.pow(2, 5));
    }
}
