package learn.dsajg6e.ch01primer.exer;

import org.junit.Test;

import static learn.dsajg6e.ch01primer.exer.P0127Calculator.*;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class P0127CalculatorTest {

    @Test
    public void testCalculate() {
        assertThat(calculate(3, '+', 2), is(5));
        assertThat(calculate(3, '-', 2), is(1));
        assertThat(calculate(3, '*', 2), is(6));
        assertThat(calculate(7, '/', 2), is(3));
    }
}