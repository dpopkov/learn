package learn.dsajg6e.ch02oop;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class FibonacciProgressionTest {
    @Test
    public void testAdvance() {
        FibonacciProgression fp = new FibonacciProgression();
        assertThat(fp.nextValue(), is(0L));
        assertThat(fp.nextValue(), is(1L));
        assertThat(fp.nextValue(), is(1L));
        assertThat(fp.nextValue(), is(2L));
        assertThat(fp.nextValue(), is(3L));
    }
}