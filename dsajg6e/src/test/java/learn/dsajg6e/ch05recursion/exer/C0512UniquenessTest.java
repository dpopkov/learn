package learn.dsajg6e.ch05recursion.exer;

import org.junit.Test;

import static learn.dsajg6e.ch05recursion.exer.C0512Uniqueness.*;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class C0512UniquenessTest {

    @Test
    public void testUnique() {
        assertThat(unique(new int[]{1}), is(true));
        assertThat(unique(new int[]{1, 2}), is(true));
        assertThat(unique(new int[]{1, 2, 2}), is(false));
        assertThat(unique(new int[]{1, 2, 3, 2}), is(false));
        assertThat(unique(new int[]{1, 2, 3, 4}), is(true));
        assertThat(unique(new int[]{1, 2, 3, 1}), is(false));
        assertThat(unique(new int[]{1, 2, 3, 2}), is(false));
        assertThat(unique(new int[]{1, 2, 3, 3}), is(false));
    }
}
