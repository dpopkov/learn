package learn.dsai.ch06rec.merge;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class MergeSortTest {

    @Test
    public void testMerge() {
        long[] values = {2, 4, 3, 5};
        long[] work = new long[values.length];
        MergeSort ms = new MergeSort(values);
        ms.merge(work, 0, 2, 3);
        long[] expected = {2, 3, 4, 5};
        assertThat(work, is(expected));
    }

    @Test
    public void testMergeNotFromStart() {
        long[] values = {-2, -1, 2, 4, 6, 3, 5};
        long[] work = new long[values.length];
        MergeSort ms = new MergeSort(values);
        ms.merge(work, 2, 5, 6);
        long[] expected = {0, 0, 2, 3, 4, 5, 6};
        assertThat(work, is(expected));
    }

    @Test
    public void testSort() {
        long[] values = {3, 8, 2, 7, 4, 5, 9, 1, 6};
        MergeSort ms = new MergeSort(values);
        ms.sort();
        long[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertThat(values, is(expected));
    }
}