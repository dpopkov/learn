package learn.dsajg6e.ch05recursion.exer;

import learn.dsajg6e.tools.ArrayTools;
import org.junit.Test;

import java.util.function.IntPredicate;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class C0521PartitioningTest {

    @Test
    public void testPartitionLengthEven() {
        int[] a = {3, 1};
        C0521Partitioning.partition(a, 2);
        int[] exp = {1, 3};
        assertThat(a, is(exp));
    }

    @Test
    public void testPartitionLengthOdd() {
        int[] a = {3, 4, 1};
        C0521Partitioning.partition(a, 2);
        int[] exp = {1, 4, 3};
        assertThat(a, is(exp));
    }

    @Test
    public void testPartitionOnLongSequence() {
        int[] a = {7, 3, 4, 6, 1, 5, 2, 8};
        C0521Partitioning.partition(a, 5);
        int[][] split = ArrayTools.split(a, 4);
        int[] head = split[0];
        int[] tail = split[1];
        assertArray(head, x -> x < 5);
        assertArray(tail, x -> x >= 5);
    }

    private static void assertArray(int[] a, IntPredicate predicate) {
        for (int i : a) {
            assertThat(i + " should pass", predicate.test(i), is(true));
        }
    }
}
