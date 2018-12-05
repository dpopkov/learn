package learn.dsai.tools;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
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
}