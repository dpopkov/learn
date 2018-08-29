package learn.leetcode.arrays;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class TwoSumTest {
    @Test
    public void testTwoSumBruteForce() {
        TwoSum ts = new TwoSum();
        int[] numbers = {2, 7, 11, 15};
        int[] result = ts.twoSumBruteForce(numbers, 9);
        assertThat(result[0], is(0));
        assertThat(result[1], is(1));
    }

    @Test
    public void testTwoSumTwoPass() {
        TwoSum ts = new TwoSum();
        int[] numbers = {2, 7, 11, 15};
        int[] result = ts.twoSumTwoPass(numbers, 9);
        assertThat(result[0], is(0));
        assertThat(result[1], is(1));
    }
}
