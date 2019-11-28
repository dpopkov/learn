package learn.dsajg6e.ch12sortselect;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class QuickSortInPlaceTest {

    @Test
    public void testQuickSort() {
        Integer[] numbers = {3, 1, 4, 5, 2, 6, 8, 9, 7};
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        QuickSortInPlace.quickSort(numbers, Comparator.naturalOrder(), 0, numbers.length - 1);
        assertThat(numbers, is(expected));
    }
}
