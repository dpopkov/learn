package learn.dsajg6e.ch03fund.exer;

import learn.dsajg6e.ch03fund.GameEntry;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class P0338ScoresDoubleListTest {
    @Test
    public void testAdd() {
        P0338ScoresDoubleList list = new P0338ScoresDoubleList();
        list.add(new GameEntry("a", 10));
        list.add(new GameEntry("b", 20));
        assertThat(list.toString(), is("[('b', 20), ('a', 10)]"));
        list.add(new GameEntry("c", 30));
        assertThat(list.toString(), is("[('c', 30), ('b', 20), ('a', 10)]"));
        list.add(new GameEntry("d", 5));
        assertThat(list.toString(), is("[('c', 30), ('b', 20), ('a', 10), ('d', 5)]"));
        list.add(new GameEntry("e", 15));
        assertThat(list.toString(), is("[('c', 30), ('b', 20), ('e', 15), ('a', 10), ('d', 5)]"));
    }

    @Test
    public void testAddNoMoreThanLimit() {
        P0338ScoresDoubleList list = new P0338ScoresDoubleList(2);
        list.add(new GameEntry("b", 20));
        list.add(new GameEntry("c", 25));
        list.add(new GameEntry("a", 10));
        list.add(new GameEntry("d", 30));
        assertThat(list.size(), is(2));
        assertThat(list.toString(), is("[('d', 30), ('c', 25)]"));
    }

    @Test
    public void testRemove() {
        P0338ScoresDoubleList list = new P0338ScoresDoubleList();
        list.add(new GameEntry("a", 10));
        list.add(new GameEntry("b", 20));
        list.add(new GameEntry("c", 30));
        list.add(new GameEntry("d", 5));
        list.add(new GameEntry("e", 15));
        assertThat(list.toString(), is("[('c', 30), ('b', 20), ('e', 15), ('a', 10), ('d', 5)]"));
        list.remove(0);
        assertThat(list.toString(), is("[('b', 20), ('e', 15), ('a', 10), ('d', 5)]"));
        list.remove(3);
        assertThat(list.toString(), is("[('b', 20), ('e', 15), ('a', 10)]"));
        list.remove(1);
        assertThat(list.toString(), is("[('b', 20), ('a', 10)]"));
        list.remove(1);
        list.remove(0);
        assertThat(list.toString(), is("[]"));
    }
}
