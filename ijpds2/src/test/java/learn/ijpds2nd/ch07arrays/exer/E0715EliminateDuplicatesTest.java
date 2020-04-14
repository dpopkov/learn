package learn.ijpds2nd.ch07arrays.exer;

import org.junit.Test;

import static learn.ijpds2nd.ch07arrays.exer.E0715EliminateDuplicates.removeDupes;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class E0715EliminateDuplicatesTest {

    @Test
    public void testRemoveDupes() {
        int[] array = {1, 2, 2, 1, 3, 2, 4, 3};
        int[] result = removeDupes(array);
        int[] expected = {1, 2, 3, 4};
        assertThat(result, is(expected));
    }
}
