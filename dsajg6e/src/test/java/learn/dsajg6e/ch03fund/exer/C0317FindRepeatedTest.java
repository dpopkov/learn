package learn.dsajg6e.ch03fund.exer;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class C0317FindRepeatedTest {

    @Test
    public void testFindRepeated() {
        int[] a1 = {1, 3, 5, 1, 7};
        int i1 = C0317FindRepeated.findRepeated(a1);
        assertThat(i1, is(3));
        int[] a2 = {1, 3, 5, 2, 7};
        int i2 = C0317FindRepeated.findRepeated(a2);
        assertThat(i2, is(-1));
    }
}