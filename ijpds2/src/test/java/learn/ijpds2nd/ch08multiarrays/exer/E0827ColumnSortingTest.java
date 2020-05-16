package learn.ijpds2nd.ch08multiarrays.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class E0827ColumnSortingTest {

    @Test
    public void testSortColumns() {
        double[][] m = {
                {0.15, 0.875, 0.375, 0.225},
                {0.55, 0.005, 0.225, 0.015},
                {0.3,  0.12,  0.4,   0.008},
                {0.07, 0.021, 0.14,  0.2}
        };
        double[][] exp = {
                {0.07, 0.005, 0.14,  0.008},
                {0.15, 0.021, 0.225, 0.015},
                {0.3,  0.12,  0.375, 0.2},
                {0.55, 0.875, 0.4,   0.225}
        };
        double[][] r = E0827ColumnSorting.sortColumns(m);
        assertThat(r, is(exp));
    }
}
