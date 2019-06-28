package learn.dsajg6e.ch05recursion.exer;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static learn.dsajg6e.ch05recursion.exer.C0515Subsets.subsets;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class C0515SubsetsTest {

    @Test
    public void testSubsets() {
        assertSet(new char[]{'a'}, List.of("a"));
        assertSet(new char[]{'a', 'b'}, List.of("a", "b", "ab"));
        assertSet(new char[]{'a', 'b', 'c'}, List.of("a", "b", "c", "ab", "ac", "bc", "abc"));
    }

    private static void assertSet(char[] chars, List<String> subsets) {
        List<String> result = subsets(chars);
        Set<String> resultSet = new HashSet<>(result);
        Set<String> expectedSet = new HashSet<>(subsets);
        assertThat(resultSet, is(expectedSet));
    }
}
