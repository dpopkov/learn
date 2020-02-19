package learn.ijpds2nd.ch03select.exer;

import org.junit.Test;

import static org.junit.Assert.*;

public class E0328TwoRectanglesTest {

    @Test
    public void testOverlappingRectangles() {
        String rst1 = E0328TwoRectangles.overlappingRectangles(
                2.5, 4, 2.5, 43,
                1.5, 5, 0.5, 3);
        assertEquals("r2 is inside r1", rst1);
        String rst2 = E0328TwoRectangles.overlappingRectangles(
                1, 2, 3, 5.5,
                3, 4, 4.5, 5);
        assertEquals("r2 overlaps r1", rst2);
        String rst3 = E0328TwoRectangles.overlappingRectangles(
                1, 2, 3, 3,
                40, 45, 3, 2);
        assertEquals("r2 does not overlap r1", rst3);
    }
}
