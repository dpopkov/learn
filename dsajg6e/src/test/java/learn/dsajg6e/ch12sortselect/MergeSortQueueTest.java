package learn.dsajg6e.ch12sortselect;

import learn.dsajg6e.ch06stacks.LinkedQueue;
import learn.dsajg6e.ch06stacks.Queue;
import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class MergeSortQueueTest {

    @Test
    public void testMergeSort() {
        Queue<Integer> queue = LinkedQueue.from(20, 30, 10, 50, 40, 70, 60);
        Queue<Integer> expected = LinkedQueue.from(70, 60, 50, 40, 30, 20, 10);
        MergeSortQueue.mergeSort(queue, Comparator.reverseOrder());
        assertThat(queue, is(expected));
    }
}
