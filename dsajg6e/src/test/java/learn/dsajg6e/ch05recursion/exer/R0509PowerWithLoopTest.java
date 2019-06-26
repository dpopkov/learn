package learn.dsajg6e.ch05recursion.exer;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class R0509PowerWithLoopTest {

    @Test
    public void testPow() {
        assertThat(R0509PowerWithLoop.pow(2, 0), is(1));
        assertThat(R0509PowerWithLoop.pow(2, 1), is(2));
        assertThat(R0509PowerWithLoop.pow(2, 3), is(8));
        assertThat(R0509PowerWithLoop.pow(2, 7), is(128));
    }
}
