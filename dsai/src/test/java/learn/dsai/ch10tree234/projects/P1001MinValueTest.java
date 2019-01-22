package learn.dsai.ch10tree234.projects;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class P1001MinValueTest {

    @Test
    public void testMinValue() {
        P1001MinValue tree = new P1001MinValue();
        tree.insert(50L);
        assertThat(tree.minValue(), is(50L));
        tree.insert(40L);
        assertThat(tree.minValue(), is(40L));
        tree.insert(70L);
        tree.insert(60L);
        tree.insert(30L);
        tree.insert(80L);
        assertThat(tree.minValue(), is(30L));
    }
}