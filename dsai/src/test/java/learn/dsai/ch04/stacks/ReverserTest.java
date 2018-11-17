package learn.dsai.ch04.stacks;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverserTest {

    @SuppressWarnings("SpellCheckingInspection")
    @Test
    public void testReverse() {
        Reverser r = new Reverser("Polymorphism");
        assertThat(r.reverse(), Is.is("msihpromyloP"));
    }
}
