package learn.csia.ch0103.exer;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

public class E010336CountingPrimesTest {
    @Test
    public void whenUpTo20Then8() {
        E010336CountingPrimes e = new E010336CountingPrimes();
        int result = e.countPrimesUpTo(20); // 20 -> 2 3 5 7 11 13 17 19
        assertThat(result, Is.is(8));
    }
}