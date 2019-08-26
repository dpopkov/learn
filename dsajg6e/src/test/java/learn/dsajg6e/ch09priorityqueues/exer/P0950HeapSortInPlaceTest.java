package learn.dsajg6e.ch09priorityqueues.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class P0950HeapSortInPlaceTest {

    @Test
    public void canSort() {
        Long[] values = {2L, 8L, 5L, 7L, 4L, 3L, 6L, 1L};
        P0950HeapSortInPlace<Long> sorter = new P0950HeapSortInPlace<>(values);
        sorter.sort();
        Long[] expected = {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L};
        assertThat(values, is(expected));
    }
}
