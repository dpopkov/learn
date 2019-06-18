package learn.dsajg6e.ch03fund.exer;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class P0336MatrixTest {

    @Test
    public void testAdd() {
        int[][] a = {{1, 2}, {3, 4}};
        int[][] b = {{1, -1}, {5, -6}};
        int[][] c = new P0336Matrix().add(a, b);
        int[][] expected = {{2, 1}, {8, -2}};
        assertThat(c, is(expected));
    }

    @Test
    public void testMultiply() {
        int[][] a = {{1, 2}, {3, 4}};
        int[][] b = {{2, -3}, {1, -5}};
        int[][] c = new P0336Matrix().multiply(a, b);
        int[][] expected = {{2, -6}, {3, -20}};
        assertThat(c, is(expected));
    }
}
