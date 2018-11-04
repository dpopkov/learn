package learn.ijpds.tools;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ArrayToolsTest {

    @Test
    public void testWithoutAtStart() {
        int[] a = {1, 2, 3};
        int[] b = ArrayTools.without(a, 0);
        int[] expected = {2, 3};
        assertThat(b, is(expected));
    }

    @Test
    public void testWithoutInTheMiddle() {
        int[] a = {1, 2, 3};
        int[] b = ArrayTools.without(a, 1);
        int[] expected = {1, 3};
        assertThat(b, is(expected));
    }

    @Test
    public void testWithoutAtEnd() {
        int[] a = {1, 2, 3};
        int[] b = ArrayTools.without(a, 2);
        int[] expected = {1, 2};
        assertThat(b, is(expected));
    }

    @Test
    public void testInsertAtStart() {
        int[] a = {2, 3};
        int[] b = ArrayTools.insertAtStart(a, 1);
        int[] expected = {1, 2, 3};
        assertThat(b, is(expected));
    }
}
