package learn.dsai.ch07advsort.projects;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class P0703ArrayMedianTest {

    @Test
    public void testMedian() {
        long[] values = {3, 1, 2, 7, 8, 4, 6, 5};
        P0703ArrayMedian arr = new P0703ArrayMedian(values.length);
        arr.insert(values);
        int median = arr.median();
        assertThat(median, is(4));
    }

    @Test
    public void testMedianWhenLastIsMaximum() {
        long[] values = {3, 1, 2, 7, 8, 9, 4, 6, 5, 10};
        P0703ArrayMedian arr = new P0703ArrayMedian(values.length);
        arr.insert(values);
        int median = arr.median();
        assertThat(median, is(5));
    }
}
