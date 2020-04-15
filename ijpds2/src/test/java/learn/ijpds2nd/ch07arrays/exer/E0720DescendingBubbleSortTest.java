package learn.ijpds2nd.ch07arrays.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class E0720DescendingBubbleSortTest {

    @Test
    public void testBubbleSort() {
        int[] a = {3, 4, 1, 2, 5, 9, 8, 6, 7};
        int[] expected = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        new E0720DescendingBubbleSort().bubbleSort(a);
        assertThat(a, is(expected));
    }
}
