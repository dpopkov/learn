package learn.ijpds.ch17io.exercises;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class E1719ViewHexTest {

    @Test
    public void getHex255() {
        String expected = "FF";
        assertThat(E1719ViewHex.getHex(255), is(expected));
    }

    @Test
    public void getHex13() {
        String expected = "0D";
        assertThat(E1719ViewHex.getHex(13), is(expected));
    }
}
