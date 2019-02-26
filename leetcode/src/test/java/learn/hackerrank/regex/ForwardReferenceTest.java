package learn.hackerrank.regex;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

@SuppressWarnings("SpellCheckingInspection")
@RunWith(Parameterized.class)
public class ForwardReferenceTest {
    private static final String NL = System.lineSeparator();

    private InputStream savedIn;
    private PrintStream savedOut;
    private final ByteArrayOutputStream buffer = new ByteArrayOutputStream();

    @SuppressWarnings("DefaultAnnotationParam")
    @Parameterized.Parameter(value = 0)
    public String testedString;
    @Parameterized.Parameter(value = 1)
    public boolean expectedResult;

    @Parameterized.Parameters(name = "{index}: find({0}) = {1}")
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"tac", true},
                {"tactactic", true},
                {"tactactictactic", true},
                {"tactactictactictictac", false},
                {"tactictac", false},
                {"tictac", false},
                {"atac", false}
        });
    }

    @Before
    public void setup() {
        savedIn = System.in;
        savedOut = System.out;
        System.setOut(new PrintStream(buffer));
    }

    @Test
    public void testSolutionMain() {
        String input = testedString + NL;
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Solution.main(null);
        assertThat(buffer.toString(), is(expectedResult + NL));
    }

    @After
    public void restoreSystemStreams() {
        System.setIn(savedIn);
        System.setOut(savedOut);
    }

    /*@Test
    public void testSolutionMain() {
        String input = "tactactic" + NL;
        byte[] bytes = input.getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);

        System.setIn(inputStream);
        Solution.main(null);

        System.setIn(savedIn);
        System.setOut(savedOut);
        assertThat(buffer.toString(), is("true" + NL));
    }

    @Test
    public void testSolutionMain2() {
        String input = "tactactictactic" + NL;
        byte[] bytes = input.getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);

        System.setIn(inputStream);
        Solution.main(null);

        System.setIn(savedIn);
        System.setOut(savedOut);
        assertThat(buffer.toString(), is("true" + NL));
    }

    @Test
    public void testSolutionMain3() {
        String input = "tactactictactictictac" + NL;
        byte[] bytes = input.getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);

        System.setIn(inputStream);
        Solution.main(null);

        System.setIn(savedIn);
        System.setOut(savedOut);
        assertThat(buffer.toString(), is("false" + NL));
    }

    @Test
    public void testSolutionMain4() {
        String input = "tactictac" + NL;
        byte[] bytes = input.getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);

        System.setIn(inputStream);
        Solution.main(null);

        System.setIn(savedIn);
        System.setOut(savedOut);
        assertThat(buffer.toString(), is("false" + NL));
    }*/
}
