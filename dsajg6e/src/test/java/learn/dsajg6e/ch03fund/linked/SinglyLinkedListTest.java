package learn.dsajg6e.ch03fund.linked;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class SinglyLinkedListTest {
    @Test
    public void testEquals() {
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
        assertThat(list1.equals(list2), is(true));
        list1.addFirst(1);
        assertThat(list1.equals(list2), is(false));
        list2.addFirst(1);
        assertThat(list1.equals(list2), is(true));
    }

    @Test
    public void testClone() throws CloneNotSupportedException {
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
        list1.addLast(1);
        list1.addLast(2);
        @SuppressWarnings("unchecked")
        SinglyLinkedList<Integer> list2 = (SinglyLinkedList<Integer>) list1.clone();
        assertThat(list1.equals(list2), is(true));
    }

    @Test
    public void testRotate() {
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        assertThat(list1.first(), is(1));
        assertThat(list1.last(), is(3));
        assertThat(list1.toString(), is("[1, 2, 3]"));
        list1.rotate();
        assertThat(list1.first(), is(2));
        assertThat(list1.last(), is(1));
        assertThat(list1.toString(), is("[2, 3, 1]"));
        list1.rotate();
        assertThat(list1.first(), is(3));
        assertThat(list1.last(), is(2));
        assertThat(list1.toString(), is("[3, 1, 2]"));
    }
}
