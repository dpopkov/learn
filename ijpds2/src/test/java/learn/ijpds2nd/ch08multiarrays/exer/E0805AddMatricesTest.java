package learn.ijpds2nd.ch08multiarrays.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class E0805AddMatricesTest {

    @Test
    public void testAddMatrices() {
        double[][] a = {{1, 2}, {3, 4}};
        double[][] b = {{0, 2}, {4, 1}};
        double[][] r = E0805AddMatrices.addMatrices(a, b);
        double[][] e = {{1, 4}, {7, 5}};
        assertThat(r, is(e));
    }
}
