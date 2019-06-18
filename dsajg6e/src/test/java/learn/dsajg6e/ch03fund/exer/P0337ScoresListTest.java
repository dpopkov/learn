package learn.dsajg6e.ch03fund.exer;

import learn.dsajg6e.ch03fund.GameEntry;
import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class P0337ScoresListTest {
    @Test
    public void testAdd() {
        P0337ScoresList list = new P0337ScoresList();
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
    public void testRemove() {
        P0337ScoresList list = new P0337ScoresList();
        GameEntry a = new GameEntry("a", 10);
        list.add(a);
        GameEntry b = new GameEntry("b", 20);
        list.add(b);
        GameEntry c = new GameEntry("c", 30);
        list.add(c);
        GameEntry d = new GameEntry("d", 5);
        list.add(d);
        GameEntry e = new GameEntry("e", 15);
        list.add(e);
        assertThat(list.toString(), is("[('c', 30), ('b', 20), ('e', 15), ('a', 10), ('d', 5)]"));
        list.remove(c);
        assertThat(list.toString(), is("[('b', 20), ('e', 15), ('a', 10), ('d', 5)]"));
        list.remove(d);
        assertThat(list.toString(), is("[('b', 20), ('e', 15), ('a', 10)]"));
        list.remove(e);
        assertThat(list.toString(), is("[('b', 20), ('a', 10)]"));
        list.remove(a);
        list.remove(b);
        assertThat(list.toString(), is("[]"));
        boolean r = list.remove(a);
        assertFalse(r);
    }
}
