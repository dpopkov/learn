package learn.dsajg6e.ch09pq2.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C0928SortedArrayPriorityQueueTest {

    @Test
    public void testInsertRemove() {
        var queue = new C0928SortedArrayPriorityQueue<Integer, String>(3);
        queue.insert(20, "twenty");
        queue.insert(10, "ten");
        queue.insert(30, "thirty");
        assertThat(queue.removeMin().getKey(), is(10));
        assertThat(queue.removeMin().getKey(), is(20));
        assertThat(queue.removeMin().getKey(), is(30));
        assertThat(queue.isEmpty(), is(true));
    }
}
