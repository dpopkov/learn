package learn.ijpds2nd.ch07arrays.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class E0731MergeSortedArraysTest {

    @Test
    public void testMerge() {
        int[] a = {1, 3, 5};
        int[] b = {2, 4};
        int[] r = E0731MergeSortedArrays.merge(a, b);
        int[] exp = {1, 2, 3, 4, 5};
        assertThat(r, is(exp));
    }
}
