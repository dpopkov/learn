package learn.dsajg6e.ch01primer.exer;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class C0120DifferentTest {

    @Test
    public void testAllDifferent() {
        float[] a = {-1.1F, 0.12F, 2.45F};
        boolean result = C0120Different.allDifferent(a, 0.001F);
        assertThat(result, is(true));
    }

    @Test
    public void testNotAllDifferent() {
        float[] a = {-1.1F, 0.12F, 2.45F, 0.121F};
        boolean result = C0120Different.allDifferent(a, 0.01F);
        assertThat(result, is(false));
    }
}