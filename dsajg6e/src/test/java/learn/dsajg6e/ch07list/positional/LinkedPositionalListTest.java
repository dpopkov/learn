package learn.dsajg6e.ch07list.positional;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class LinkedPositionalListTest {

    @Test
    public void canAddFirstElement() {
        PositionalList<Integer> list = new LinkedPositionalList<>();
        var p20 = list.addFirst(20);
        assertThat(list.first().getElement(), is(20));
        var p10 = list.addFirst(10);
        assertThat(list.first().getElement(), is(10));
        assertThat(list.size(), is(2));
        assertThat(list.before(p20).getElement(), is(10));
        assertThat(list.after(p10).getElement(), is(20));
    }

    @Test
    public void canAddLastElement() {
        PositionalList<Integer> list = new LinkedPositionalList<>();
        var p10 = list.addLast(10);
        assertThat(list.last().getElement(), is(10));
        var p20 = list.addLast(20);
        assertThat(list.last().getElement(), is(20));
        assertThat(list.size(), is(2));
        assertThat(list.before(p20).getElement(), is(10));
        assertThat(list.after(p10).getElement(), is(20));
    }

    @Test
    public void canAddBefore() {
        PositionalList<Integer> list = new LinkedPositionalList<>();
        var p20 = list.addLast(20);
        var p10 = list.addBefore(p20, 10);
        assertThat(list.after(p10).getElement(), is(20));
        assertThat(list.before(p20).getElement(), is(10));
    }

    @Test
    public void canAddAfter() {
        PositionalList<Integer> list = new LinkedPositionalList<>();
        var p10 = list.addFirst(10);
        var p20 = list.addAfter(p10, 20);
        assertThat(list.after(p10).getElement(), is(20));
        assertThat(list.before(p20).getElement(), is(10));
    }

    @Test
    public void canSetElements() {
        PositionalList<Integer> list = new LinkedPositionalList<>();
        var p10 = list.addFirst(10);
        var p20 = list.addAfter(p10, 20);
        Integer x = list.set(p10, 11);
        assertThat(x, is(10));
        assertThat(list.before(p20).getElement(), is(11));
    }

    @Test
    public void canRemoveElements() {
        PositionalList<Integer> list = new LinkedPositionalList<>();
        var p10 = list.addFirst(10);
        var p20 = list.addAfter(p10, 20);
        var p30 = list.addAfter(p20, 30);
        Integer removed = list.remove(p20);
        assertThat(removed, is(20));
        assertThat(list.after(p10).getElement(), is(30));
        assertThat(list.before(p30).getElement(), is(10));
        assertThat(list.size(), is(2));
        list.remove(p10);
        list.remove(p30);
        assertThat(list.isEmpty(), is(true));
    }

    @Test
    public void canIterate() {
        LinkedPositionalList<Integer> list = new LinkedPositionalList<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(10));
        assertThat(it.next(), is(20));
        it.remove();
        assertThat(it.next(), is(30));
        assertThat(it.hasNext(), is(false));
        assertThat(list.first().getElement(), is(10));
        assertThat(list.last().getElement(), is(30));
    }

    @Test
    public void canIteratePositions() {
        LinkedPositionalList<Integer> list = new LinkedPositionalList<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        Iterator<Position<Integer>> it = list.positions().iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getElement(), is(10));
        assertThat(it.next().getElement(), is(20));
        it.remove();
        assertThat(it.next().getElement(), is(30));
        assertThat(it.hasNext(), is(false));
        assertThat(list.first().getElement(), is(10));
        assertThat(list.last().getElement(), is(30));
    }

    @Test
    public void canFindIndexByPosition() {
        PositionalList<Integer> list = new LinkedPositionalList<>();
        Position<Integer> p10 = list.addLast(10);
        list.addLast(20);
        Position<Integer> p30 = list.addLast(30);
        assertThat(list.indexOf(p10), is(0));
        assertThat(list.indexOf(p30), is(2));
    }

    @Test
    public void canFindPositions() {
        PositionalList<Integer> list = new LinkedPositionalList<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        assertThat(list.findPosition(10).getElement(), is(10));
        assertThat(list.findPosition(30).getElement(), is(30));
    }

    /* R-7.14
     When using Position from other list then checking if a given position is
     actually a member of the relevant list is not done.
     Therefore, the result is wrong.*/
    @Test
    public void addingPositionFromOtherListChangesOtherListAndSizesIncorrectly() {
        PositionalList<Integer> list = new LinkedPositionalList<>();
        list.addLast(10);
        list.addLast(20);
        PositionalList<Integer> other = new LinkedPositionalList<>();
        Position<Integer> p = other.addLast(30);
        list.addAfter(p, 40);
        assertThat(list.size(), is(3));
        assertThat(other.size(), is(1));
        assertThat(other.last().getElement(), is(40));
    }
}
