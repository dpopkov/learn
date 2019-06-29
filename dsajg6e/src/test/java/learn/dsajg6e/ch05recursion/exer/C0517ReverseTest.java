package learn.dsajg6e.ch05recursion.exer;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class C0517ReverseTest {

    @Test
    public void testReverse() {
        assertThat(C0517Reverse.reverse("pots&pans"), is("snap&stop"));
    }
}
