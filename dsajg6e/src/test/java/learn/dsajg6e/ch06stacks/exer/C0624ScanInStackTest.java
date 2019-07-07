package learn.dsajg6e.ch06stacks.exer;

import learn.dsajg6e.ch06stacks.LinkedStack;
import learn.dsajg6e.ch06stacks.Stack;
import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class C0624ScanInStackTest {

    @Test
    public void whenStackContainsElementThenTrue() {
        Stack<Integer> stack = LinkedStack.of(1, 2, 3);
        C0624ScanInStack<Integer> scanner = new C0624ScanInStack<>();
        assertThat(stack.top(), is(3));
        boolean rst = scanner.findIn(stack, 2);
        assertThat(rst, is(true));
        assertThat(stack.size(), is(3));
        assertThat(stack.top(), is(3));
    }

    @Test
    public void whenStackDoesNotContainElementThenFalse() {
        Stack<Integer> stack = LinkedStack.of(1, 2, 3);
        C0624ScanInStack<Integer> scanner = new C0624ScanInStack<>();
        boolean rst = scanner.findIn(stack, 22);
        assertThat(rst, is(false));
        assertThat(stack.size(), is(3));
        assertThat(stack.top(), is(3));
    }
}
