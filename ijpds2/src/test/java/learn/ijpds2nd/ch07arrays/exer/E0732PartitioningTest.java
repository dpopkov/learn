package learn.ijpds2nd.ch07arrays.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class E0732PartitioningTest {

    @Test
    public void testPartition() {
        int[] a = {3, 1, 5, 0};
        int[] e = {0, 1, 3, 5};
        int idx = E0732Partitioning.partition(a);
        assertEquals(2, idx);
        assertThat(a, is(e));
    }
}
