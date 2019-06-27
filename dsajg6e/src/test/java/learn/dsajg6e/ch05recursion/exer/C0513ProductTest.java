package learn.dsajg6e.ch05recursion.exer;

import org.junit.Test;

import static learn.dsajg6e.ch05recursion.exer.C0513Product.*;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class C0513ProductTest {

    @Test
    public void testProduct() {
        assertThat(product(5, 1), is(5));
        assertThat(product(5, 2), is(10));
        assertThat(product(5, 3), is(15));
    }
}
