package learn.dsajg6e.ch05recursion.exer;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class C0523ContainsSumTest {

    @Test
    public void whenDoesNotContainSum() {
        int[] a = {1, 3, 5};
        int[] rst = C0523ContainsSum.containsSumOfTwo(a);
        assertThat(rst[0], is(-1));
    }

    @Test
    public void when1Plus2Then3() {
        int[] a = {1, 2, 3};
        int[] rst = C0523ContainsSum.containsSumOfTwo(a);
        assertThat(rst[0], is(0));
        assertThat(rst[1], is(1));
        assertThat(rst[2], is(2));
    }

    @Test
    public void when2Plus2Then4() {
        int[] a = {2, 2, 3, 4};
        int[] rst = C0523ContainsSum.containsSumOfTwo(a);
        assertThat(rst[0], is(0));
        assertThat(rst[1], is(1));
        assertThat(rst[2], is(3));
    }
}
