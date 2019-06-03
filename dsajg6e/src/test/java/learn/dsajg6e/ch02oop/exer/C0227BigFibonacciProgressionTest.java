package learn.dsajg6e.ch02oop.exer;

import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class C0227BigFibonacciProgressionTest {

    @Test
    public void testAdvance() {
        C0227BigFibonacciProgression p = new C0227BigFibonacciProgression();
        assertThat(p.nextValue(), is(BigInteger.ZERO));
        assertThat(p.nextValue(), is(BigInteger.ONE));
        assertThat(p.nextValue(), is(BigInteger.ONE));
        assertThat(p.nextValue(), is(BigInteger.TWO));
        assertThat(p.nextValue(), is(BigInteger.valueOf(3L)));
        assertThat(p.nextValue(), is(BigInteger.valueOf(5L)));
    }

    @Test
    public void testAdvanceWithParameterizedConstructor() {
        C0227BigFibonacciProgression p = new C0227BigFibonacciProgression(
                BigInteger.valueOf(1L), BigInteger.valueOf(3L)
        );
        assertThat(p.nextValue(), is(BigInteger.ONE));
        assertThat(p.nextValue(), is(BigInteger.valueOf(3L)));
        assertThat(p.nextValue(), is(BigInteger.valueOf(4L)));
        assertThat(p.nextValue(), is(BigInteger.valueOf(7L)));
        assertThat(p.nextValue(), is(BigInteger.valueOf(11L)));
    }
}
