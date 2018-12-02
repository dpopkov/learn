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
}