package learn.ijpds2nd.ch08multiarrays.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class E0823FindFlippedCellTest {

    @Test
    public void testFindFlippedCell() {
        int[][] m = {
                {1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 0, 0},
                {0, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1}
        };
        int[] r = E0823FindFlippedCell.findFlippedCell(m);
        int[] e = {0, 1};
        assertThat(r, is(e));
    }
}
