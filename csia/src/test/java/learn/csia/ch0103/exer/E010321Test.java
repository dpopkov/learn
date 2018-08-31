package learn.csia.ch0103.exer;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class E010321Test {
    @Test
    public void when5ThenBinary101() {
        E010321 e = new E010321();
        String result = e.convert(5, 2);
        assertThat(result, is("101"));
    }

    @Test
    public void when257ThenHex101() {
        E010321 e = new E010321();
        String result = e.convert(257, 16);
        assertThat(result, is("101"));
    }
}
