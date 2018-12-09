package learn.dsai.ch07advsort.projects;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class P0704ArraySelectionTest {

    @Test
    public void testFindNthLargest() {
        long[] values = {5, 4, 3, 2, 1};
        P0704ArraySelection arr = new P0704ArraySelection(values.length);
        arr.insert(values);
        long value = arr.findNthLargest(1);
        assertThat(value, is(5L));
        value = arr.findNthLargest(2);
        assertThat(value, is(4L));
        value = arr.findNthLargest(3);
        assertThat(value, is(3L));
    }

    @Test
    public void testFindNthSmallest() {
        long[] values = {5, 4, 3, 2, 1};
        P0704ArraySelection arr = new P0704ArraySelection(values.length);
        arr.insert(values);
        long value = arr.findNthSmallest(1);
        assertThat(value, is(1L));
        value = arr.findNthSmallest(2);
        assertThat(value, is(2L));
        value = arr.findNthSmallest(3);
        assertThat(value, is(3L));
    }
}
