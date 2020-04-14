package learn.ijpds2nd.ch07arrays.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class E0718BubbleSortTest {

    @Test
    public void testBubbleSort() {
        int[] a = {3, 2, 1, 7, 5, 4, 9, 6, 8};
        new E0718BubbleSort().bubbleSort(a);
        int[] exp = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertThat(a, is(exp));
    }

    @Test
    public void testRandomValues() {
        int[] array = createRandomArray(1, 9);
        new E0718BubbleSort().bubbleSort(array);
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertThat(array, is(expected));
    }

    @SuppressWarnings("SameParameterValue")
    private int[] createRandomArray(int start, int end) {
        int size = end - start + 1;
        int[] a = new int[size];
        for (int i = 0; i < a.length; i++) {
            a[i] = start + i;
        }
        shuffle(a);
        return a;
    }

    private void shuffle(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int j = (int) (Math.random() * a.length);
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }
}
