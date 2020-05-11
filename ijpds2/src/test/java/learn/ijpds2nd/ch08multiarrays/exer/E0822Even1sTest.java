package learn.ijpds2nd.ch08multiarrays.exer;

import org.junit.Test;

import static org.junit.Assert.*;

public class E0822Even1sTest {

    @Test
    public void testHasEvenNumberFalse() {
        int[][] a = {{1, 0}, {0, 1}};
        boolean r = E0822Even1s.hasEvenNumber(a);
        assertFalse(r);
    }

    @Test
    public void testHasEvenNumberTrue() {
        int[][] a = {{1, 1}, {1, 1}};
        boolean r = E0822Even1s.hasEvenNumber(a);
        assertTrue(r);
    }
}
