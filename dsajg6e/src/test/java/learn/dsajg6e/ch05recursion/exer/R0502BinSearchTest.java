package learn.dsajg6e.ch05recursion.exer;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class R0502BinSearchTest {

    @Test
    public void testSearchReturnsIndexOfTheTarget() {
        int[] data = {1, 3, 4, 6, 7, 9};
        int idx;
        idx = R0502BinSearch.search(data, 4);
        assertThat(idx, is(2));
        idx = R0502BinSearch.search(data, 3);
        assertThat(idx, is(1));
        idx = R0502BinSearch.search(data, 8);
        assertThat(idx, is(-1));
    }
}
