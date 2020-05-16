package learn.ijpds2nd.ch08multiarrays.exer;

import org.junit.Test;

import static org.junit.Assert.*;

public class E0825MarkovMatrixTest {

    @Test
    public void testIsMarkovMatrixTrue() {
        double[][] m = {
                {0.15, 0.875, 0.375},
                {0.55, 0.005, 0.225},
                {0.3, 0.12, 0.4}
        };
        boolean r = E0825MarkovMatrix.isMarkovMatrix(m);
        assertTrue(r);
    }

    @Test
    public void testIsMarkovMatrixFalse() {
        double[][] m = {
                {0.95, -0.875, 0.375},
                {0.65, 0.005, 0.225},
                {0.3, 0.22, -0.4}
        };
        boolean r = E0825MarkovMatrix.isMarkovMatrix(m);
        assertFalse(r);
    }
}
