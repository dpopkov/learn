package learn.dsajg6e.ch02oop.exer;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class C0226SquareRootProgressionTest {

    @Test
    public void testAdvance() {
        C0226SquareRootProgression p = new C0226SquareRootProgression(16.0);
        assertThat(p.nextValue(), is(16.0));
        assertThat(p.nextValue(), is(4.0));
        assertThat(p.nextValue(), is(2.0));
    }
}