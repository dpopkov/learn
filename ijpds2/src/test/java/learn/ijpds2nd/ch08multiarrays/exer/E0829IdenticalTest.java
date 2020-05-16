package learn.ijpds2nd.ch08multiarrays.exer;

import org.junit.Test;

import static org.junit.Assert.*;

public class E0829IdenticalTest {

    @Test
    public void testEquals() {
        int[][] m1 = {{51, 25, 22}, {6, 1, 4}, {24, 54, 6}};
        int[][] m2 = {{51, 22, 25}, {6, 1, 4}, {24, 54, 6}};
        int[][] m3 = {{51, 22, 5}, {6, 1, 4}, {24, 54, 6}};
        boolean r = E0829Identical.equals(m1, m2);
        assertTrue(r);
        r = E0829Identical.equals(m1, m3);
        assertFalse(r);
    }
}
