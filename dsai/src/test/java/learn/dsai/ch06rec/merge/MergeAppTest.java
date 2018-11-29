package learn.dsai.ch06rec.merge;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class MergeAppTest {

    @Test
    public void testMergeArraysWithEqualSize() {
        int[] a = {1, 3};
        int[] b = {2, 4};
        int[] result = MergeApp.merge(a, a.length, b, b.length);
        int[] expected = {1, 2, 3, 4};
        assertThat(result, is(expected));
    }

    @Test
    public void testMergeWhenFirstIsLonger() {
        int[] a = {1, 3, 7};
        int[] b = {2};
        int[] result = MergeApp.merge(a, a.length, b, b.length);
        int[] expected = {1, 2, 3, 7};
        assertThat(result, is(expected));
    }

    @Test
    public void testMergeWhenSecondIsLonger() {
        int[] a = {7};
        int[] b = {2, 4, 8};
        int[] result = MergeApp.merge(a, a.length, b, b.length);
        int[] expected = {2, 4, 7, 8};
        assertThat(result, is(expected));
    }
}
