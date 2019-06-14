package learn.dsajg6e.ch03fund.exer;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

public class C0326ConcatenatingListTest {

    @Test
    public void testConcatenate() {
        var list0 = new C0326ConcatenatingList<Integer>();
        list0.addLast(1);
        list0.addLast(2);
        var list1 = new C0326ConcatenatingList<Integer>();
        list1.addLast(3);
        list1.addLast(4);
        var result = list0.concatenate(list1);
        var expected = new C0326ConcatenatingList<Integer>();
        expected.addLast(1);
        expected.addLast(2);
        expected.addLast(3);
        expected.addLast(4);
        assertThat(equals(result, expected), Is.is(true));
    }

    private static boolean equals(C0326ConcatenatingList<Integer> a, C0326ConcatenatingList<Integer> b) {
        if (a.size() != b.size()) {
            return false;
        }
        Integer i0, i1;
        for (int i = 0; i < a.size(); i++) {
            i0 = a.removeFirst();
            i1 = b.removeFirst();
            if (!i0.equals(i1)) {
                return false;
            }
        }
        return true;
    }
}
