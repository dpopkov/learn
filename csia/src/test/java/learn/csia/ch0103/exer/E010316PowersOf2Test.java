package learn.csia.ch0103.exer;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class E010316PowersOf2Test {
    @Test
    public void when17ThenUpTo16() {
        E010316PowersOf2 to16 = new E010316PowersOf2();
        List<Integer> expected = Arrays.asList(1, 2, 4, 8, 16);
        List<Integer> result = to16.getPowers(17);
        assertThat(result, is(expected));
    }

    @Test
    public void when16ThenUpTo16() {
        E010316PowersOf2 to16 = new E010316PowersOf2();
        List<Integer> expected = Arrays.asList(1, 2, 4, 8, 16);
        List<Integer> result = to16.getPowers(16);
        assertThat(result, is(expected));
    }

    @Test
    public void when31ThenUpTo16() {
        E010316PowersOf2 to16 = new E010316PowersOf2();
        List<Integer> expected = Arrays.asList(1, 2, 4, 8, 16);
        List<Integer> result = to16.getPowers(31);
        assertThat(result, is(expected));
    }
}
