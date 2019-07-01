package learn.dsajg6e.ch05recursion.exer;

import org.junit.Test;

import static learn.dsajg6e.ch05recursion.exer.C0525ReverseLinkedList.*;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class C0525ReverseLinkedListTest {

    @Test
    public void testReverseOne() {
        Node list = new Node(10);
        list = reverse(list);
        assertThat(listToString(list), is("[(10)]"));
    }

    @Test
    public void testReverseTwo() {
        Node second = new Node(20);
        Node list = new Node(10, second);
        list = reverse(list);
        assertThat(listToString(list), is("[(20), (10)]"));
    }

    @Test
    public void testReverseThree() {
        Node third = new Node(30);
        Node second = new Node(20, third);
        Node list = new Node(10, second);
        assertThat(listToString(list), is("[(10), (20), (30)]"));
        list = reverse(list);
        assertThat(listToString(list), is("[(30), (20), (10)]"));
    }
}
