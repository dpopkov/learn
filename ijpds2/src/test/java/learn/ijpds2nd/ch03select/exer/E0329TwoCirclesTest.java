package learn.ijpds2nd.ch03select.exer;

import org.junit.Test;

import static learn.ijpds2nd.ch03select.exer.E0329TwoCircles.*;
import static org.junit.Assert.*;

public class E0329TwoCirclesTest {

    @Test
    public void testCheckCircles() {
        Placing rst1 = checkCircles(0.5, 5.1, 13, 1, 1.7, 4.5);
        assertSame(Placing.INSIDE, rst1);
        Placing rst2 = checkCircles(3.4, 5.7, 5.5, 6.7, 3.5, 3);
        assertSame(Placing.OVERLAP, rst2);
        Placing rst3 = checkCircles(3.4, 5.5, 1, 5.5, 7.2, 1);
        assertSame(Placing.DO_NOT_OVERLAP, rst3);
    }
}
