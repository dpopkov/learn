package learn.dsajg6e.ch10maps;

import learn.dsajg6e.ch09pq2.Entry;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class CostPerformanceDatabaseTest {

    @Test
    public void whenAddLessExpensive() {
        CostPerformanceDatabase db = new CostPerformanceDatabase();
        db.add(20, 100);
        db.add(20, 90);

        Entry<Integer, Integer> best = db.best(20);
        assertThat(best.getKey(), is(20));
        assertThat(best.getValue(), is(100));

        db.add(10, 100);
        best = db.best(20);
        assertThat(best.getKey(), is(10));
        assertThat(best.getValue(), is(100));
    }
}
