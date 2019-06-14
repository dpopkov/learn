package learn.dsajg6e.ch03fund.exer;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

public class C0325ConcatenatingListTest {

    @Test
    public void testConcatenate() {
        C0325ConcatenatingList<Integer> list0 = new C0325ConcatenatingList<>();
        add(list0, 1, 2);
        C0325ConcatenatingList<Integer> list1 = new C0325ConcatenatingList<>();
        add(list1, 3, 4);
        C0325ConcatenatingList<Integer> result = list0.concatenate(list1);
        C0325ConcatenatingList<Integer> expected = new C0325ConcatenatingList<>();
        add(expected, 1, 2, 3, 4);
        assertThat(result, Is.is(expected));
    }

    private static void add(C0325ConcatenatingList<Integer> list, Integer... numbers) {
        for (Integer i : numbers) {
            list.addLast(i);
        }
    }
}
