package learn.dsai.ch04.projects.p0405;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void testToString() {
        Customer c = new Customer(101, 22);
        assertThat(c.toString(), Is.is("{#101: 22}"));
    }
}