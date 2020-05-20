package learn.ijpds2nd.ch08multiarrays.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class E0835LargestBlockTest {

    @Test
    public void whenTopLeftOneElementThenReturn001() {
        int[][] m = {
                {1, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        int[] r = E0835LargestBlock.findLargestBlock(m);
        int[] exp = {0, 0, 1};
        assertThat(r, is(exp));
    }

    @Test
    public void whenBottomRightOneElementThenReturn221() {
        int[][] m = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 1}
        };
        int[] r = E0835LargestBlock.findLargestBlock(m);
        int[] exp = {2, 2, 1};
        assertThat(r, is(exp));
    }

    @Test
    public void whenTopLeftTwoElementsThenReturn002() {
        int[][] m = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        int[] r = E0835LargestBlock.findLargestBlock(m);
        int[] exp = {0, 0, 2};
        assertThat(r, is(exp));
    }

    @Test
    public void whenTopLeftTwoElementsDifferentHeightThenReturn002() {
        int[][] m = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 1, 1}
        };
        int[] r = E0835LargestBlock.findLargestBlock(m);
        int[] exp = {0, 0, 2};
        assertThat(r, is(exp));
    }

    @Test
    public void whenCenteredElementsThenReturn112() {
        int[][] m = {
                {1, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };
        int[] r = E0835LargestBlock.findLargestBlock(m);
        int[] exp = {1, 1, 2};
        assertThat(r, is(exp));
    }

    @Test
    public void whenBigAtBottomRightThenReturn223() {
        int[][] m = {
                {1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 1}
        };
        int[] r = E0835LargestBlock.findLargestBlock(m);
        int[] exp = {2, 2, 3};
        assertThat(r, is(exp));
    }
}
