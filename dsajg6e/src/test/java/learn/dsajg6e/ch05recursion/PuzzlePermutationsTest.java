package learn.dsajg6e.ch05recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class PuzzlePermutationsTest {

    @Test
    public void testRemove() {
        char[] arr = {'a', 'b', 'c'};
        char[] result, expected;

        result = PuzzlePermutations.remove(arr, 1);
        expected = new char[] {'a', 'c'};
        assertThat(result, is(expected));

        result = PuzzlePermutations.remove(arr, 0);
        expected = new char[] {'b', 'c'};
        assertThat(result, is(expected));

        result = PuzzlePermutations.remove(arr, 2);
        expected = new char[] {'a', 'b'};
        assertThat(result, is(expected));
    }

    @Test
    public void testSolve() {
        List<String> output = new ArrayList<>();
        char[] universe = {'a', 'b', 'c'};
        PuzzlePermutations.solve(3, "", universe, output);
        List<String> expected = List.of(
                "abc",
                "acb",
                "bac",
                "bca",
                "cab",
                "cba"
        );
        assertThat(output, is(expected));
    }
}
