package learn.csia.ch0103.exer;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class E010327FactorsTest {
    @Test
    public void when8Then2() {
        E010327Factors e = new E010327Factors();
        List<Long> result = e.getFactors(8);
        List<Long> expected = Arrays.asList(2L);
        assertThat(result, is(expected));
    }

    @Test
    public void when56Then27() {
        E010327Factors e = new E010327Factors();
        List<Long> result = e.getFactors(56);
        List<Long> expected = Arrays.asList(2L, 7L);
        assertThat(result, is(expected));
    }

    @Test
    public void whenHasDuplicateFactorsThenReturnsUnique() {
        E010327Factors e = new E010327Factors();
        List<Long> result = e.getFactors(3757208);
        List<Long> expected = Arrays.asList(2L, 7L, 13L, 397L);
        assertThat(result, is(expected));
    }
}