package learn.dsajg6e.ch12sortselect;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class MergeSortArrayTest {

    @Test
    public void canMergeArraysOfEqualLength() {
        Integer[] result = produceMergedResult(
                new Integer[]{3, 5, 8},
                new Integer[]{4, 6, 7}
        );
        Integer[] expected = {3, 4, 5, 6, 7, 8};
        assertThat(result, is(expected));
    }

    @Test
    public void canMergeArraysShortAndLong() {
        Integer[] result = produceMergedResult(
                new Integer[]{8},
                new Integer[]{4, 6, 7}
        );
        Integer[] expected = {4, 6, 7, 8};
        assertThat(result, is(expected));
    }

    @Test
    public void canMergeArraysLongAndShort() {
        Integer[] result = produceMergedResult(
                new Integer[]{3, 5, 8},
                new Integer[]{7}
        );
        Integer[] expected = {3, 5, 7, 8};
        assertThat(result, is(expected));
    }

    private Integer[] produceMergedResult(Integer[] s1, Integer[] s2) {
        Integer[] s = new Integer[s1.length + s2.length];
        MergeSortArray.merge(s1, s2, s, Comparator.naturalOrder());
        return s;
    }

    @Test
    public void testMergeSort() {
        Integer[] array = {3, 4, 1, 5, 2, 7, 9, 8, 6};
        MergeSortArray.mergeSort(array, Comparator.reverseOrder());
        Integer[] expected = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        assertThat(array, is(expected));
    }
}
