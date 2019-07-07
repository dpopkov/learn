package learn.dsajg6e.ch06stacks;

import learn.dsajg6e.ch06stacks.exer.C0624ScanInStack;
import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class ArrayStackTest {
    @SuppressWarnings("unchecked")
    @Test
    public void testClone() {
        ArrayStack<Integer> st1 = new ArrayStack<>();
        st1.push(10);
        st1.push(20);
        ArrayStack<Integer> st2 = (ArrayStack<Integer>) st1.clone();
        st1.pop();
        C0624ScanInStack<Integer> scanner = new C0624ScanInStack<>();
        assertThat(st2.size(), is(2));
        assertThat(scanner.findIn(st2, 10), is(true));
        assertThat(scanner.findIn(st2, 20), is(true));
        assertThat(st2.top(), is(20));
    }
}
