package learn.leetcode.arrays;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ThreeSumTest {
    @Test
    public void testThreeSum() {
        ThreeSum ts = new ThreeSum();
        int[] numbers = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = ts.threeSum(numbers);
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(-1, 0, 1),
                Arrays.asList(-1, -1, 2)
        );
        assertThat(result, is(expected));
    }

    @Test
    public void whenZerosThenZeros() {
        ThreeSum ts = new ThreeSum();
        int[] numbers = new int[3000];
        List<List<Integer>> result = ts.threeSum(numbers);
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0, 0, 0)
        );
        assertThat(result, is(expected));
    }
}
