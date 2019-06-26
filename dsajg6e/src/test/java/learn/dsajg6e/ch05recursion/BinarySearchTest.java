package learn.dsajg6e.ch05recursion;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void testSearch() {
        int[] data = {2, 4, 5, 7, 8, 9, 12, 14, 17, 19, 22, 25, 27, 28, 33, 37};
        boolean result;
        result = BinarySearch.search(data, 22);
        assertThat(result, is(true));
        result = BinarySearch.search(data, 21);
        assertThat(result, is(false));
    }

    @Test
    public void testSearchIterative() {
        int[] data = {2, 4, 5, 7, 8, 9, 12, 14, 17, 19, 22, 25, 27, 28, 33, 37};
        boolean result;
        result = BinarySearch.searchIterative(data, 22);
        assertThat(result, is(true));
        result = BinarySearch.searchIterative(data, 21);
        assertThat(result, is(false));
    }
}
