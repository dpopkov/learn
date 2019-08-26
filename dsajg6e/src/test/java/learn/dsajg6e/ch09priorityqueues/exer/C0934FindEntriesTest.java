package learn.dsajg6e.ch09priorityqueues.exer;

import learn.dsajg6e.ch09priorityqueues.PQEntry;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C0934FindEntriesTest {

    @Test
    public void canFindBefore() {
        C0934FindEntries<Integer, String> queue = new C0934FindEntries<>();
        queue.insert(10);
        queue.insert(30);
        queue.insert(5);
        assertThat(queue.findBefore(20), is(List.of(
                new PQEntry<>(5, null),
                new PQEntry<>(10, null)
        )));
    }
}
