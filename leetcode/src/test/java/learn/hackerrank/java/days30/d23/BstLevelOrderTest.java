package learn.hackerrank.java.days30.d23;

import learn.hackerrank.utils.InputStreamBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class BstLevelOrderTest {
    private PrintStream savedOut;
    private final ByteArrayOutputStream buffer = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        savedOut = System.out;
        System.setOut(new PrintStream(buffer));
    }

    @After
    public void restoreOut() {
        System.setOut(savedOut);
    }

    @Test
    public void testMain() {
        InputStreamBuilder builder = new InputStreamBuilder();
        builder.append(new int[]{6, 3, 5, 4, 7, 2, 1});
        System.setIn(builder.getInputStream());

        BstLevelOrder.main(null);
        assertThat(buffer.toString(), is("3 2 5 1 4 7 "));
    }
}
