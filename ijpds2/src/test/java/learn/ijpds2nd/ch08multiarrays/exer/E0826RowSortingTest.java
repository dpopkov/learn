package learn.ijpds2nd.ch08multiarrays.exer;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class E0826RowSortingTest {

    @Test
    public void testSortRows() {
        double[][] m = {
                {0.15, 0.875, 0.375, 0.225},
                {0.55, 0.005, 0.225, 0.015},
                {0.3, 0.12, 0.4, 0.008},
                {0.07, 0.021, 0.14, 0.2}
        };
        double[][] exp = {
                {0.15, 0.225, 0.375, 0.875},
                {0.005, 0.015, 0.225, 0.55},
                {0.008, 0.12, 0.3, 0.4},
                {0.021, 0.07, 0.14, 0.2,}
        };
        double[][] r = E0826RowSorting.sortRows(m);
        Assert.assertThat(r, is(exp));
    }
}
