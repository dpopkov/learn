package learn.dsajg6e.ch09pq2.exer;

import org.junit.Test;

import static org.junit.Assert.*;

public class P0950HeapSortInPlaceTest {

    @Test
    public void testSort() {
        long[] values = {3, 5, 1, 7, 2, 4, 6};
        P0950HeapSortInPlace sorter = new P0950HeapSortInPlace();
        sorter.sort(values);
        long[] expected = {1, 2, 3, 4, 5, 6, 7};
        assertArrayEquals(expected, values);
    }

    @Test
    public void testSortNotInPlace() {
        long[] values = {3, 5, 1, 7, 2, -1, 4, 8, 6};
        P0950HeapSortInPlace sorter = new P0950HeapSortInPlace();
        sorter.sortNotInPlace(values);
        long[] expected = {-1, 1, 2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(expected, values);
    }
}
