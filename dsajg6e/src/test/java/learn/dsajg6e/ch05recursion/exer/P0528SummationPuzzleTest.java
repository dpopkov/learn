package learn.dsajg6e.ch05recursion.exer;

import org.junit.Test;

import static learn.dsajg6e.ch05recursion.exer.P0528SummationPuzzle.*;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class P0528SummationPuzzleTest {

    @Test
    public void when1Plus1Then2() {
        String rst = solve("a + a = b");
        assertThat(rst, is("1 + 1 = 2"));
    }

    @Test
    public void when1Plus2Then3() {
        String rst = solve("a + b = c");
        assertThat(rst, is("1 + 2 = 3"));
    }

    @Test
    public void when11Plus23Then24() {
        String rst = solve("aa + bc = cd");
        assertThat(rst, is("11 + 23 = 34"));
    }
}
