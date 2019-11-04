package learn.dsajg6e.ch10maps.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C1049FindKthSmallestKeyTest {

    @Test
    public void canFind0th() {
        Integer[] s = {2, 3};
        Integer[] t = {1, 4};
        int k = new C1049FindKthSmallestKey<Integer>().findKthSmallestKey(s, t, 0);
        assertThat(k, is(1));
    }

    @Test
    public void canFind1st() {
        Integer[] s = {2, 3};
        Integer[] t = {1, 4};
        int k = new C1049FindKthSmallestKey<Integer>().findKthSmallestKey(s, t, 1);
        assertThat(k, is(2));
    }

    @Test
    public void canFind3rd() {
        Integer[] s = {2, 3};
        Integer[] t = {1, 4};
        int k = new C1049FindKthSmallestKey<Integer>().findKthSmallestKey(s, t, 3);
        assertThat(k, is(4));
    }
}
