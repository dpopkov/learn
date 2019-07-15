package learn.dsajg6e.ch07list.exer;

import learn.dsajg6e.ch07list.positional.Position;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class R0715RemovingQueueTest {

    @Test
    public void whenEnqueueElementsThenCanRemoveTheseElementsFromTheQueue() {
        R0715RemovingQueue<Integer> queue = new R0715RemovingQueue<>();
        queue.enqueue(10);
        Position<Integer> p20 = queue.enqueueWithPosition(20);
        queue.enqueue(30);
        queue.remove(p20);
        assertThat(queue.dequeue(), is(10));
        assertThat(queue.dequeue(), is(30));
        assertThat(queue.isEmpty(), is(true));
    }
}
