package learn.ijpds2nd.ch05loops.exer;

import org.junit.Test;

import static org.junit.Assert.*;

public class PowerPyramidTest {

    private static final String NL = System.lineSeparator();

    @Test
    public void pyramid() {
        PowerPyramid pyramid = new PowerPyramid(5, 3);
        String actual = pyramid.build(2);
        String expected = ""
                + "         1" + NL
                + "    1    3    1" + NL;
        assertEquals(expected, actual);
    }
}
