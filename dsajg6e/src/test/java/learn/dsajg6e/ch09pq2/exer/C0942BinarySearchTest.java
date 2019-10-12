package learn.dsajg6e.ch09pq2.exer;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C0942BinarySearchTest {

    @Test
    public void testSearch() {
        Integer[] array = {3, 5, 7, 11, 17};
        C0942BinarySearch<Integer> bs = new C0942BinarySearch<>(array, Comparator.comparingInt(a -> a));
        assertThat(bs.search(7), is(2));
        assertThat(bs.search(3), is(0));
        assertThat(bs.search(17), is(4));
        assertThat(bs.search(37), is(-1));
        assertThat(bs.search(1), is(-1));
    }
}
