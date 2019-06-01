package learn.dsajg6e.ch02oop;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class GeometricProgressionTest {
    @Test
    public void testAdvance() {
        GeometricProgression gp = new GeometricProgression(1, 3);
        assertThat(gp.nextValue(), is(1L));
        assertThat(gp.nextValue(), is(3L));
        assertThat(gp.nextValue(), is(9L));
    }
}