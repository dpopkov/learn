package learn.dsai.ch07advsort;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ArrayQ2SortTest {

    @Test
    public void testSort() {
        ArrayQ2Sort arr = new ArrayQ2Sort(10);
        long[] values = {3, 5, 1, 9, 2, 7, 4, 6, 0, 8};
        arr.insert(values);
        arr.sort();
        long[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertThat(arr.getValues(), is(expected));
    }
}
