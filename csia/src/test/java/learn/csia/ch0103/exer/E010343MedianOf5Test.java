package learn.csia.ch0103.exer;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class E010343MedianOf5Test {

    @Test
    public void median5() {
        E010343MedianOf5 m = new E010343MedianOf5();
        assertThat(m.median5(1, 2, 3, 4, 5), is(3));
    }

    @Test
    public void whenNotSorted() {
        E010343MedianOf5 m = new E010343MedianOf5();
        assertThat(m.median5(1, 1, 77, 9999, 2), is(2));
    }
}