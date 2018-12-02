package learn.dsai.ch06rec.projects;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class P0601MultiplyTest {

    @Test
    public void testMultiply() {
        P0601Multiply m = new P0601Multiply();
        assertThat(m.multiply(1, 1), is(1));
        assertThat(m.multiply(2, 1), is(2));
        assertThat(m.multiply(2, 3), is(6));
    }
}
