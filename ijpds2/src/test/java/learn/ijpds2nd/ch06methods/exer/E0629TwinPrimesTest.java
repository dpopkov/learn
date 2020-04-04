package learn.ijpds2nd.ch06methods.exer;

import org.junit.Test;

import static learn.ijpds2nd.ch06methods.exer.E0629TwinPrimes.Twins;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class E0629TwinPrimesTest {

    @Test
    public void testNextTwinPrimes() {
        Twins tw0 = new Twins(3, 5);
        E0629TwinPrimes gen = new E0629TwinPrimes(tw0);
        Twins actual = gen.nextTwinPrimes();
        assertThat(actual, is(Twins.of(5, 7)));
        actual = gen.nextTwinPrimes();
        assertThat(actual, is(Twins.of(11, 13)));
        actual = gen.nextTwinPrimes();
        assertThat(actual, is(Twins.of(17, 19)));
    }
}
