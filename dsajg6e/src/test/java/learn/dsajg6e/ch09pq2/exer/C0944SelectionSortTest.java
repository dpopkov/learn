package learn.dsajg6e.ch09pq2.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C0944SelectionSortTest {

    @Test
    public void testSort() {
        long[] values = {3, 5, 4, 2, 7, 1, 6};
        new C0944SelectionSort().sort(values);
        long[] expected = {1, 2, 3, 4, 5, 6, 7};
        assertThat(values, is(expected));
    }
}
