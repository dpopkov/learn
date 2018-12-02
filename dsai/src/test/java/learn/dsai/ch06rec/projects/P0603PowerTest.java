package learn.dsai.ch06rec.projects;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class P0603PowerTest {

    @Test
    public void testPow4() {
        P0603Power p = new P0603Power();
        assertThat(p.pow(2, 4), is(16));
        assertThat(p.getCallCount(), is(2));
    }

    @Test
    public void testPow5() {
        P0603Power p = new P0603Power();
        assertThat(p.pow(2, 5), is(32));
        assertThat(p.getCallCount(), is(3));
    }
}
