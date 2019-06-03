package learn.dsajg6e.ch02oop.exer;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class C0225LongArithmeticProgressionTest {

    @Test
    public void testAdvance() {
        C0225LongArithmeticProgression p = new C0225LongArithmeticProgression(1L, 2L);
        assertThat(p.nextValue(), is(1L));
        assertThat(p.nextValue(), is(3L));
        assertThat(p.nextValue(), is(5L));
    }
}
