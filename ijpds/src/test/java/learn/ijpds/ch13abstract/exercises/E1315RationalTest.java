package learn.ijpds.ch13abstract.exercises;

import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.core.Is.is;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

public class E1315RationalTest {
    private E1315Rational first = new E1315Rational(BigInteger.valueOf(3L), BigInteger.valueOf(454L));
    private E1315Rational second = new E1315Rational(BigInteger.valueOf(7L), BigInteger.valueOf(2389L));

    @Test
    public void add() {
        E1315Rational result = first.add(second);
        assertThat(result.toString(), is("10345/1084606"));
    }

    @Test
    public void subtract() {
        E1315Rational result = first.subtract(second);
        assertThat(result.toString(), is("3989/1084606"));
    }

    @Test
    public void multiply() {
        E1315Rational result = first.multiply(second);
        assertThat(result.toString(), is("21/1084606"));
    }

    @Test
    public void divide() {
        E1315Rational result = first.divide(second);
        assertThat(result.toString(), is("7167/3178"));
    }

    @Test
    public void testDoubleValue() {
        double result = second.doubleValue();
        assertThat(result, closeTo(0.0029300962745918793, 1e-14));
    }
}
