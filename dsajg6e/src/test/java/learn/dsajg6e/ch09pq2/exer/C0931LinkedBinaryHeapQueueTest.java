package learn.dsajg6e.ch09pq2.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class C0931LinkedBinaryHeapQueueTest {

    @Test
    public void testInsertRemoveOne() {
        var queue = new C0931LinkedBinaryHeapQueue<Integer, String>();
        queue.insert(10, "ten");
        assertThat(queue.min().getKey(), is(10));
        assertThat(queue.removeMin().getKey(), is(10));
        assertThat(queue.isEmpty(), is(true));
    }

    @Test
    public void testInsertRemoveTwo() {
        var queue = new C0931LinkedBinaryHeapQueue<Integer, String>();
        queue.insert(10, "ten");
        queue.insert(20, "two");
        assertThat(queue.min().getKey(), is(10));
        assertThat(queue.removeMin().getKey(), is(10));
        assertThat(queue.removeMin().getKey(), is(20));
        assertThat(queue.isEmpty(), is(true));
    }

    @Test
    public void testInsertRemoveTwoReversed() {
        var queue = new C0931LinkedBinaryHeapQueue<Integer, String>();
        queue.insert(20, "two");
        queue.insert(10, "ten");
        assertThat(queue.min().getKey(), is(10));
        assertThat(queue.removeMin().getKey(), is(10));
        assertThat(queue.removeMin().getKey(), is(20));
        assertThat(queue.isEmpty(), is(true));
    }

    @Test
    public void testInsertRemoveThree() {
        var queue = new C0931LinkedBinaryHeapQueue<Integer, String>();
        queue.insert(20, "twenty");
        queue.insert(10, "ten");
        queue.insert(30, "thirty");
        assertThat(queue.removeMin().getKey(), is(10));
        assertThat(queue.removeMin().getKey(), is(20));
        assertThat(queue.removeMin().getKey(), is(30));
        assertThat(queue.isEmpty(), is(true));
    }

    @Test
    public void testInsertRemoveFour() {
        var queue = new C0931LinkedBinaryHeapQueue<Integer, String>();
        queue.insert(20, "twenty");
        queue.insert(40, "forty");
        queue.insert(10, "ten");
        queue.insert(30, "thirty");
        assertThat(queue.removeMin().getKey(), is(10));
        assertThat(queue.removeMin().getKey(), is(20));
        assertThat(queue.removeMin().getKey(), is(30));
        assertThat(queue.removeMin().getKey(), is(40));
        assertThat(queue.isEmpty(), is(true));
    }

    @Test
    public void testInsertRemoveMany() {
        var queue = new C0931LinkedBinaryHeapQueue<Integer, String>();
        final int size = 16;
        var data = prepareData(size);
        fillQueue(queue, data);
        for (int i = 0; i < size; i++) {
            assertThat(queue.removeMin().getKey(), is(i));
        }
        assertThat(queue.isEmpty(), is(true));
    }

    private void fillQueue(C0931LinkedBinaryHeapQueue<Integer, String> queue, List<Integer> numbers) {
        for (Integer n : numbers) {
            queue.insert(n, null);
        }
    }

    @SuppressWarnings("SameParameterValue")
    private static List<Integer> prepareData(int size) {
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        Collections.shuffle(list, new Random(3));
        return list;
    }
}
