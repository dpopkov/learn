package learn.dsajg6e.ch02oop;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class ProgressionTest {

    @Test
    public void testNextValue() {
        Progression p = new Progression();
        assertThat(p.nextValue(), is(0L));
        assertThat(p.nextValue(), is(1L));
        assertThat(p.nextValue(), is(2L));
    }
}