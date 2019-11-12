package learn.dsajg6e.ch10maps.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class C1059SimpleSetTest {

    @Test
    public void testRetainAll() {
        C1059SimpleSet<Integer> set1 = new C1059SimpleSet<>();
        set1.add(10);
        set1.add(20);
        set1.add(30);
        C1059SimpleSet<Integer> set2 = new C1059SimpleSet<>();
        set2.add(15);
        set2.add(20);
        set2.add(25);
        set1.retainAll(set2);
        assertThat(set1.size(), is(1));
        assertThat(set1.contains(20), is(true));
        assertThat(set1.contains(10), is(false));
        assertThat(set1.contains(30), is(false));
    }
}
