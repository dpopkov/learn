package learn.ijpds.ch18recursion.exercises;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import static learn.ijpds.ch18recursion.exercises.E1811Permutations.permutations;

public class E1811PermutationsTest {
    @Test
    public void permutationsOfNone() {
        List<int[]> result = permutations(new int[] {});
        assertNotNull(result);
        assertThat(result.size(), is(0));
    }

    @Test
    public void permutationsOfOne() {
        List<int[]> result = permutations(new int[] {11});
        assertThat(result.size(), is(1));
        assertThat(result.get(0), is(new int[] {11}));
    }

    @Test
    public void permutationsOfTwo() {
        List<int[]> result = permutations(new int[] {1, 2});
        assertThat(result.size(), is(2));
        assertThat(result.get(0), is(new int[] {1, 2}));
        assertThat(result.get(1), is(new int[] {2, 1}));
    }

    @Test
    public void permutationsOfThree() {
        List<int[]> result = permutations(new int[] {1, 2, 3});
        assertThat(result.size(), is(6));
        assertThat(result.get(0), is(new int[] {1, 2, 3}));
        assertThat(result.get(1), is(new int[] {1, 3, 2}));
        assertThat(result.get(2), is(new int[] {2, 1, 3}));
        assertThat(result.get(3), is(new int[] {2, 3, 1}));
        assertThat(result.get(4), is(new int[] {3, 1, 2}));
        assertThat(result.get(5), is(new int[] {3, 2, 1}));
    }
}
