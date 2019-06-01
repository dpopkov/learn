package learn.dsajg6e.ch02oop;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class ArithmeticProgressionTest {

    @Test
    public void testAdvance() {
        ArithmeticProgression ap = new ArithmeticProgression(3, 2);
        assertThat(ap.nextValue(), is(3L));
        assertThat(ap.nextValue(), is(5L));
        assertThat(ap.nextValue(), is(7L));
    }
}