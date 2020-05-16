package learn.ijpds2nd.ch08multiarrays.exer;

import org.junit.Test;

import static org.junit.Assert.*;

public class E0828StrictlyIdenticalTest {

    @Test
    public void testEquals() {
        int[][] m1 = {{51, 22, 25}, {6, 1, 4}, {24, 54, 6}};
        int[][] m2 = {{51, 22, 25}, {6, 1, 4}, {24, 54, 6}};
        boolean r = E0828StrictlyIdentical.equals(m1, m2);
        assertTrue(r);

        int[][] m3 = {{51, 25, 25}, {6, 1, 4}, {24, 54, 6}};
        r = E0828StrictlyIdentical.equals(m1, m3);
        assertFalse(r);
    }
}
