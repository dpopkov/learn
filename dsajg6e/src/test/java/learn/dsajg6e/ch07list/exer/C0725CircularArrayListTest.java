package learn.dsajg6e.ch07list.exer;

import learn.dsajg6e.ch07list.List;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C0725CircularArrayListTest {

    @Test
    public void canAddAndGetElements() {
        List<Integer> list = new C0725CircularArrayList<>(3);
        list.add(10);
        list.add(20);
        assertThat(list.toString(), is("[10, 20]"));
        list.add(1, 15);
        assertThat(list.toString(), is("[10, 15, 20]"));
    }

    @Test
    public void whenAddToFrontThenElementIsAdded() {
        List<Integer> list = new C0725CircularArrayList<>(2);
        list.add(0, 20);
        list.add(0, 10);
        assertThat(list.toString(), is("[10, 20]"));
    }

    @Test
    public void whenAddToFrontAndBackThenElementIsAdded() {
        List<Integer> list = new C0725CircularArrayList<>(3);
        list.add(0, 20);
        list.add(0, 10);
        list.add(30);
        assertThat(list.toString(), is("[10, 20, 30]"));
    }

    @Test
    public void whenAddToFrontAndInsertInTheMiddleThenElementsAreAdded() {
        List<Integer> list = new C0725CircularArrayList<>(3);
        list.add(0, 20);
        list.add(0, 10);
        list.add(1, 15);
        assertThat(list.toString(), is("[10, 15, 20]"));
    }

    @Test
    public void canRemoveAtFront() {
        List<Integer> list = new C0725CircularArrayList<>(3);
        list.add(20);
        list.add(0, 10);
        list.add(30);
        assertThat(list.toString(), is("[10, 20, 30]"));
        Integer r;
        r = list.remove(0);
        assertThat(r, is(10));
        assertThat(list.toString(), is("[20, 30]"));
        r = list.remove(0);
        assertThat(r, is(20));
        assertThat(list.toString(), is("[30]"));
        r = list.remove(0);
        assertThat(r, is(30));
        assertThat(list.isEmpty(), is(true));
    }

    @Test
    public void canRemoveInTheMiddle() {
        List<Integer> list = new C0725CircularArrayList<>(4);
        list.add(20);
        list.add(0, 10);
        list.add(30);
        list.add(40);
        assertThat(list.toString(), is("[10, 20, 30, 40]"));
        Integer r;
        r = list.remove(2);
        assertThat(r, is(30));
        assertThat(list.toString(), is("[10, 20, 40]"));
        r = list.remove(1);
        assertThat(r, is(20));
        assertThat(list.toString(), is("[10, 40]"));
    }

    @Test
    public void canRemoveLast() {
        List<Integer> list = new C0725CircularArrayList<>(4);
        list.add(20);
        list.add(0, 10);
        list.add(30);
        list.add(40);
        Integer r;
        r = list.remove(3);
        assertThat(r, is(40));
        assertThat(list.toString(), is("[10, 20, 30]"));
        r = list.remove(2);
        assertThat(r, is(30));
        assertThat(list.toString(), is("[10, 20]"));
        r = list.remove(1);
        assertThat(r, is(20));
        assertThat(list.toString(), is("[10]"));
        r = list.remove(0);
        assertThat(r, is(10));
        assertThat(list.isEmpty(), is(true));
    }
}
