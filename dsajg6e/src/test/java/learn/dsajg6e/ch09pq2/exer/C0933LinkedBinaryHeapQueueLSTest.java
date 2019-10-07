package learn.dsajg6e.ch09pq2.exer;

import learn.dsajg6e.ch09priorityqueues.exer.TestUtils;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class C0933LinkedBinaryHeapQueueLSTest {

    @Test
    public void testInsertRemoveOne() {
        var queue = new C0933LinkedBinaryHeapQueueLS<Integer, String>();
        queue.insert(10, "ten");
        assertThat(queue.min().getKey(), is(10));
        assertThat(queue.removeMin().getKey(), is(10));
        assertThat(queue.isEmpty(), is(true));
    }

    @Test
    public void testInsertRemoveThree() {
        var queue = new C0933LinkedBinaryHeapQueueLS<Integer, String>();
        queue.insert(20, "twenty");
        queue.insert(10, "ten");
        queue.insert(30, "thirty");
        assertThat(queue.removeMin().getKey(), is(10));
        assertThat(queue.removeMin().getKey(), is(20));
        assertThat(queue.removeMin().getKey(), is(30));
        assertThat(queue.isEmpty(), is(true));
    }

    @Test
    public void testInsertRemoveMany() {
        var queue = new C0933LinkedBinaryHeapQueueLS<Integer, String>();
        final int size = 32;
        var keys = TestUtils.prepareNonRandomShuffledNumbers(size);
        TestUtils.fillQueueWithKeys(queue, keys);
        for (int i = 0; i < size; i++) {
            assertThat(queue.removeMin().getKey(), is(i));
        }
        assertThat(queue.isEmpty(), is(true));
    }
}
