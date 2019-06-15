package learn.dsajg6e.ch03fund.exer;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class C0327SwapNodesTest {
    @Test
    public void testSwap1and3() {
        var list = makeFrom(1, 2, 3, 4, 5);
        assertList(list, 1, 2, 3, 4, 5);
        list.swap(list.getNode(1), list.getNode(3));
        assertList(list, 1, 4, 3, 2, 5);
    }

    @Test
    public void testSwap1and2() {
        var list = makeFrom(1, 2, 3, 4);
        assertList(list, 1, 2, 3, 4);
        list.swap(list.getNode(1), list.getNode(2));
        assertList(list, 1, 3, 2, 4);
    }

    @Test
    public void testSwapFirst() {
        var list = makeFrom(1, 2, 3, 4);
        assertList(list, 1, 2, 3, 4);
        list.swap(list.getNode(0), list.getNode(2));
        assertList(list, 3, 2, 1, 4);
    }

    @Test
    public void testSwapLast() {
        var list = makeFrom(1, 2, 3, 4);
        assertList(list, 1, 2, 3, 4);
        list.swap(list.getNode(1), list.getNode(3));
        assertList(list, 1, 4, 3, 2);
        assertThat(list.last(), is(2));
    }

    @Test
    public void testSwapFirstAndLast() {
        var list = makeFrom(1, 2, 3, 4);
        assertList(list, 1, 2, 3, 4);
        list.swap(list.getNode(0), list.getNode(3));
        assertList(list, 4, 2, 3, 1);
        assertThat(list.first(), is(4));
        assertThat(list.last(), is(1));
    }

    @Test
    public void testSwapTwo() {
        var list = makeFrom(1, 2);
        assertList(list, 1, 2);
        list.swap(list.getNode(0), list.getNode(1));
        assertList(list, 2, 1);
        assertThat(list.first(), is(2));
        assertThat(list.last(), is(1));
    }

    private static C0327SwapNodes<Integer> makeFrom(Integer... values) {
        C0327SwapNodes<Integer> list = new C0327SwapNodes<>();
        for (Integer v : values) {
            list.addLast(v);
        }
        return list;
    }

    private static void assertList(C0327SwapNodes<Integer> list, Integer... values) {
        for (int i = 0; i < values.length; i++) {
            assertThat(list.get(i), is(values[i]));
        }
    }
}