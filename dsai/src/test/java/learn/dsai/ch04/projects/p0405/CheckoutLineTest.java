package learn.dsai.ch04.projects.p0405;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckoutLineTest {

    @Test
    public void testAdd() {
        CheckoutLine line = new CheckoutLine();
        line.add(new Customer(11, 2));
        line.add(new Customer(12, 5));
        assertThat(line.toString(), Is.is("[{#11: 2}, {#12: 5}]"));
    }

    @Test
    public void testTick() {
        CheckoutLine line = new CheckoutLine();
        line.add(new Customer(11, 2));
        line.add(new Customer(12, 1));
        assertThat(line.toString(), Is.is("[{#11: 2}, {#12: 1}]"));
        line.tick();
        assertThat(line.toString(), Is.is("[{#11: 1}, {#12: 1}]"));
        line.tick();
        assertThat(line.toString(), Is.is("[{#12: 1}]"));
        line.tick();
        assertThat(line.toString(), Is.is("[]"));
    }
}