package learn.dsajg6e.ch09pq2.exer;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class C0941OnesComparatorTest {

    @Test
    public void testCompare() {
        C0941OnesComparator comp = new C0941OnesComparator();
        assertThat(comp.compare(3, 6), Matchers.is(0));
        assertThat(comp.compare(3, 7), Matchers.is(-1));
        assertThat(comp.compare(15, 7), Matchers.is(1));
    }
}
