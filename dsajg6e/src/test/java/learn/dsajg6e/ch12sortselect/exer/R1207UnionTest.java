package learn.dsajg6e.ch12sortselect.exer;

import org.junit.Test;

import java.util.List;
import java.util.TreeSet;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class R1207UnionTest {

    @Test
    public void testUnion() {
        TreeSet<Integer> s1 = new TreeSet<>(List.of(10, 20, 30));
        TreeSet<Integer> s2 = new TreeSet<>(List.of(15, 20, 35));
        List<Integer> list = new R1207Union<Integer>().union(s1.iterator(), s2.iterator());
        List<Integer> expected = List.of(10, 15, 20, 30, 35);
        assertThat(list, is(expected));
    }
}
