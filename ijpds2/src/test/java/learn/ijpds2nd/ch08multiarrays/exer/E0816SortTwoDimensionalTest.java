package learn.ijpds2nd.ch08multiarrays.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class E0816SortTwoDimensionalTest {

    @Test
    public void testSort() {
        int[][] m = {{4, 2}, {1, 7}, {4, 5}, {1, 2}, {1, 1}, {4, 1}};
        int[][] e = {{4, 5}, {4, 2}, {4, 1}, {1, 7}, {1, 2}, {1, 1}};
        E0816SortTwoDimensional.sort(m);
        assertThat(m, is(e));
    }
}
