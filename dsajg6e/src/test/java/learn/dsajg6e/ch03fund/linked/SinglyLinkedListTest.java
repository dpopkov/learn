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
}