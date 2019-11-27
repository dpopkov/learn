package learn.dsajg6e.ch12sortselect;

import learn.dsajg6e.ch06stacks.LinkedQueue;
import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class QuickSortQueueTest {

    @Test
    public void testQuickSort() {
        LinkedQueue<Integer> sequence = LinkedQueue.from(3, 4, 1, 5, 2, 7, 9, 8, 6);
        QuickSortQueue.quickSort(sequence, Comparator.reverseOrder());
        LinkedQueue<Integer> expected = LinkedQueue.from(9, 8, 7, 6, 5, 4, 3, 2, 1);
        assertThat(sequence, is(expected));
    }
}
