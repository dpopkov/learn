package learn.hackerrank.java.days30.d24;

import learn.hackerrank.utils.InputStreamBuilder;
import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class RemoveDupesTest {
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
        builder.append(new int[]{6, 1, 2, 2, 3, 3, 4});
        System.setIn(builder.getInputStream());

        RemoveDupes.main(null);
        assertThat(buffer.toString(), Is.is("1 2 3 4 "));
    }

    @Test
    public void testMain2() {
        InputStreamBuilder builder = new InputStreamBuilder();
        builder.append(new int[]{0});
        System.setIn(builder.getInputStream());

        RemoveDupes.main(null);
        assertThat(buffer.toString(), Is.is(""));
    }

    @Test
    public void testMain3() {
        InputStreamBuilder builder = new InputStreamBuilder();
        builder.append(new int[]{3, 1, 2, 2});
        System.setIn(builder.getInputStream());

        RemoveDupes.main(null);
        assertThat(buffer.toString(), Is.is("1 2 "));
    }

    @Test
    public void testMain4() {
        InputStreamBuilder builder = new InputStreamBuilder();
        builder.append(new int[]{3, 2, 3, 2});
        System.setIn(builder.getInputStream());

        RemoveDupes.main(null);
        assertThat(buffer.toString(), Is.is("2 3 "));
    }

    @Test
    public void testMain5() {
        InputStreamBuilder builder = new InputStreamBuilder();
        builder.append(new int[]{5, 1, 2, 3, 2, 3});
        System.setIn(builder.getInputStream());

        RemoveDupes.main(null);
        assertThat(buffer.toString(), Is.is("1 2 3 "));
    }
}
