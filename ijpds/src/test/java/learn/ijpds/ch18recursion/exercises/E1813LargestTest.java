package learn.ijpds.ch18recursion.exercises;

import org.junit.Test;

import static learn.ijpds.ch18recursion.exercises.E1813Largest.largest;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class E1813LargestTest {

    @Test
    public void whenInTheMiddle() {
        int[] a = {3, 2, 7, 1, 8, 9, 5, 4, 6};
        assertThat(largest(a), is(9));
    }

    @Test
    public void whenAtStart() {
        int[] a = {31, 2, 7, 1, 8, 9, 5, 4, 6};
        assertThat(largest(a), is(31));
    }

    @Test
    public void whenAtEnd() {
        int[] a = {31, 2, 7, 1, 8, 9, 5, 4, 69};
        assertThat(largest(a), is(69));
    }
}
