package learn.dsai.ch06rec.projects;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static learn.dsai.ch06rec.projects.P0605Combinations.*;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class P0605CombinationsTest {

    @Test
    public void testCombinationsOfOne() {
        char[] group = {'A', 'B'};
        List<String> result = combinations(group, 0, 1);
        assertThat(result, is(Arrays.asList("A", "B")));
    }

    @Test
    public void testCombinationsOfAll() {
        char[] group = {'A', 'B'};
        List<String> result = combinations(group, 0, 2);
        assertThat(result, is(Collections.singletonList("AB")));
    }

    @Test
    public void testCombinationsOfGroupOf3() {
        char[] group = {'A', 'B', 'C'};
        List<String> result = combinations(group, 0, 2);
        assertThat(result, is(Arrays.asList("AB", "AC", "BC")));
    }

    @Test
    public void testCombinationsOfGroupOf4() {
        char[] group = {'A', 'B', 'C', 'D'};
        assertThat(combinations(group, 0, 2), is(Arrays.asList("AB", "AC", "AD", "BC", "BD", "CD")));
        assertThat(combinations(group, 0, 3), is(Arrays.asList("ABC", "ABD", "ACD", "BCD")));
    }
}
