package learn.ijpds.ch18recursion.exercises;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import static learn.ijpds.ch18recursion.exercises.E1804Combinations.combinations;

public class E1804CombinationsTest {

    @Test
    public void testCombinations() {
        assertThat(combinations(3, 0), is(1));
        assertThat(combinations(3, 3), is(1));
        assertThat(combinations(3, 2), is(3));
    }
}
