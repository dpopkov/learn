package learn.hackerrank.java.days30.d25;

import learn.hackerrank.utils.InputStreamBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class PrimesTest {
    private static final String NL = System.lineSeparator();

    private PrintStream savedOut;
    private final ByteArrayOutputStream buffer = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        savedOut = System.out;
        System.setOut(new PrintStream(buffer));
    }

    @After
    public void restoreOut() {
        System.setOut(savedOut);
    }

    @Test
    public void testMain() {
        InputStreamBuilder builder = new InputStreamBuilder();
        builder.append(new int[]{3, 12, 5, 7});
        System.setIn(builder.getInputStream());

        Primes.main(null);
        assertThat(buffer.toString(), is(
                "Not prime" + NL
                        + "Prime" + NL
                        + "Prime" + NL
        ));
    }

    @Test
    public void whenIsPrimeThenTrue() {
        assertThat(Solution.isPrime(2), is(true));
        assertThat(Solution.isPrime(3), is(true));
        assertThat(Solution.isPrime(5), is(true));
    }

    @Test
    public void whenIsNotPrimeThenFalse() {
        assertThat(Solution.isPrime(4), is(false));
        assertThat(Solution.isPrime(9), is(false));
        assertThat(Solution.isPrime(51), is(false));
    }
}
