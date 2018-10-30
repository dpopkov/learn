package learn.ijpds.ch17io.exercises;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class E1718ViewBitsTest {

    @Test
    public void getBits255() {
        String expected = "11111111";
        assertThat(E1718ViewBits.getBits(255), is(expected));
    }

    @Test
    public void getBits5() {
        String expected = "00000101";
        assertThat(E1718ViewBits.getBits(5), is(expected));
    }
}