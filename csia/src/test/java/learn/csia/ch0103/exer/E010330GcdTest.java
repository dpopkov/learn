package learn.csia.ch0103.exer;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class E010330GcdTest {
    @Test
    public void when6and12Then6() {
        E010330Gcd e = new E010330Gcd();
        assertThat(e.gcd(6, 12), is(6));
    }

    @Test
    public void when8and12Then4() {
        E010330Gcd e = new E010330Gcd();
        assertThat(e.gcd(8, 12), is(4));
    }

}