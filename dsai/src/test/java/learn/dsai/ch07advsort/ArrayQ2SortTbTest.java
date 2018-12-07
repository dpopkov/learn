package learn.dsai.ch07advsort;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class ArrayQ2SortTbTest {

    @Test
    public void testManualSort() {
        ArrayQ2SortTb arr = new ArrayQ2SortTb(3);
        long[] values = {3, 2, 1};
        arr.insert(values);
        arr.manualSort(0, 2);
        long[] expected = {1, 2, 3};
        assertThat(arr.getValues(), is(expected));
    }

    @Test
    public void testSort() {
        ArrayQ2SortTb arr = new ArrayQ2SortTb(9);
        long[] values = {3, 4, 2, 5, 8, 9, 1, 6, 7};
        arr.insert(values);
        arr.sort();
        long[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertThat(arr.getValues(), is(expected));
    }
}
