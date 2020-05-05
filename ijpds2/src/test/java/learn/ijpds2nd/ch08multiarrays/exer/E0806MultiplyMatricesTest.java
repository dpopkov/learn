package learn.ijpds2nd.ch08multiarrays.exer;

import learn.ijpds2nd.tools.ArrayUtils;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class E0806MultiplyMatricesTest {

    @Test
    public void testMultiplyMatrices() {
        double[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] b = {{0, 2, 4}, {1, 4.5, 2.2}, {1.1, 4.3, 5.2}};
        double[][] r = E0806MultiplyMatrices.multiplyMatrices(a, b);
        double[][] e = {{5.3, 23.9, 24}, {11.6, 56.3, 58.2}, {17.9, 88.7, 92.4}};
        assertTrue(ArrayUtils.equals(r, e, 1e-13));
    }
}
