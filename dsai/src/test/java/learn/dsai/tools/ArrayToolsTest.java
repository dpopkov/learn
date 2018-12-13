package learn.dsai.tools;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.*;
import static org.junit.Assert.*;

public class ArrayToolsTest {

    @Test
    public void whenToStringEmptyLongs() {
        long[] a = {};
        String expected = "[]";
        String result = ArrayTools.toString(a, a.length);
        assertThat(result, is(expected));
    }

    @Test
    public void whenToString2Longs() {
        long[] a = {1, 2};
        String expected = "[1, 2]";
        String result = ArrayTools.toString(a, a.length);
        assertThat(result, is(expected));
    }

    @Test
    public void testIsPartitioned() {
        long[] values = {5, 4, 3, 8, 7, 6};
        boolean result = ArrayTools.isPartitioned(values, 3);
        assertThat(result, is(true));
        values = new long[] {6, 4, 3, 8, 7, 5};
        result = ArrayTools.isPartitioned(values, 3);
        assertThat(result, is(false));
    }

    @Test
    public void testContainSameElements() {
        long[] a1 = {1, 2, 3, 4, 5, 6, 7, 8};
        long[] a2 = {1, 3, 2, 4, 6, 5, 8, 7};
        assertTrue(ArrayTools.containSameElements(a1, a2));
        long[] a3 = {11, 3, 2, 4, 6, 5, 8, 7};
        assertFalse(ArrayTools.containSameElements(a3, a1));
    }

    @Test
    public void testShuffle() {
        long[] values = {1, 2, 3, 4, 5, 6, 7, 8};
        long[] saved = Arrays.copyOf(values, values.length);
        ArrayTools.shuffle(values);
        assertTrue(ArrayTools.containSameElements(values, saved));
        assertThat(values, is(not(saved)));
    }
}
