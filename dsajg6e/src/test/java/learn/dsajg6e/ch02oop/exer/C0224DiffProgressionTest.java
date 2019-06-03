package learn.dsajg6e.ch02oop.exer;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class C0224DiffProgressionTest {

    @Test
    public void advance() {
        C0224DiffProgression p = new C0224DiffProgression(3, 1);
        assertThat(p.nextValue(), is(3L));
        assertThat(p.nextValue(), is(1L));
        assertThat(p.nextValue(), is(2L));
        assertThat(p.nextValue(), is(1L));
        assertThat(p.nextValue(), is(1L));
        assertThat(p.nextValue(), is(0L));
    }
}