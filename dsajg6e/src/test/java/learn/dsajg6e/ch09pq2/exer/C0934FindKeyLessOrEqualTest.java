package learn.dsajg6e.ch09pq2.exer;

import learn.dsajg6e.ch09priorityqueues.exer.TestUtils;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C0934FindKeyLessOrEqualTest {

    @Test
    public void testKeysLessOrEqualTo() {
        var queue = new C0934FindKeyLessOrEqual<Integer, String>();
        List<Integer> keys = TestUtils.prepareNonRandomShuffledNumbers(16);
        TestUtils.fillQueueWithKeys(queue, keys);
        List<Integer> result = queue.keysLessOrEqualTo(5);
        assertThat(result.size(), is(6));
        assertThat(result, containsInAnyOrder(0, 1, 2, 3, 4, 5));
    }
}
