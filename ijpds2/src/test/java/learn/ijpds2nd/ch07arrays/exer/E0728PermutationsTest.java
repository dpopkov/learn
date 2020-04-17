package learn.ijpds2nd.ch07arrays.exer;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class E0728PermutationsTest {

    private static final String NL = System.lineSeparator();

    private ByteArrayOutputStream buffer;
    private PrintStream saved;

    @Before
    public void setup() {
        buffer = new ByteArrayOutputStream();
        PrintStream saved = System.out;
        System.setOut(new PrintStream(buffer));
    }

    @Test
    public void when1ElementThenPrintsOne() {
        int[] a = {11};
        E0728Permutations.printPermutations(a);
        assertResult("11", "");
    }

    @Test
    public void when2ElementsThenPrintsPermutations() {
        int[] a = {1, 2};
        E0728Permutations.printPermutations(a);
        assertResult("1 2", "2 1", "");
    }

    @Test
    public void when3ElementsThenPrintsPermutations() {
        int[] a = {1, 2, 3};
        E0728Permutations.printPermutations(a);
        assertResult("1 2 3", "2 1 3", "3 1 2", "1 3 2", "2 3 1", "3 2 1", "");
    }

    private void assertResult(String... expected) {
        System.setOut(saved);
        String result = buffer.toString();
        assertThat(result, is(String.join(NL, expected)));
    }
}
