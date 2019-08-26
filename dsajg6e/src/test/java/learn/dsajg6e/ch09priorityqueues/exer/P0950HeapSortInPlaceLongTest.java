package learn.dsajg6e.ch09priorityqueues.exer;

import org.junit.Test;

import static org.junit.Assert.*;

public class P0950HeapSortInPlaceLongTest {

    @Test
    public void canSortLongValues() {
        long[] values = {3, 8, 2, 4, 1, 5, 7, 6};
        P0950HeapSortInPlaceLong sorter = new P0950HeapSortInPlaceLong(values);
        sorter.sort();
        long[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(expected, values);
    }
}
