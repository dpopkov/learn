package learn.csia.ch0103.exer;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

public class E010322Test {
    @Test
    public void when2Then10() {
        E010322 e = new E010322();
        assertThat(e.numberToString1(2), Is.is("10"));
        assertThat(e.numberToString2(2), Is.is("10"));
    }

    @Test
    public void when3Then11() {
        E010322 e = new E010322();
        assertThat(e.numberToString1(3), Is.is("11"));
        assertThat(e.numberToString2(3), Is.is("11"));
    }

    @Test
    public void when5Then101() {
        E010322 e = new E010322();
        assertThat(e.numberToString1(5), Is.is("101"));
        assertThat(e.numberToString2(5), Is.is("101"));
    }
}