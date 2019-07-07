package learn.dsajg6e.ch06stacks.exer;

import learn.dsajg6e.ch06stacks.Stack;
import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class C0625StackOnQueueTest {
    @Test
    public void whenPushOneThenPopOne() {
        Stack<Integer> stack = new C0625StackOnQueue<>();
        stack.push(1);
        assertThat(stack.size(), is(1));
        assertThat(stack.top(), is(1));
        assertThat(stack.pop(), is(1));
        assertThat(stack.size(), is(0));
    }

    @Test
    public void whenPushOneTwoThenPopTwoOne() {
        Stack<Integer> stack = new C0625StackOnQueue<>();
        stack.push(1);
        stack.push(2);
        assertThat(stack.isEmpty(), is(false));
        assertThat(stack.top(), is(2));
        assertThat(stack.pop(), is(2));
        assertThat(stack.top(), is(1));
        assertThat(stack.pop(), is(1));
        assertThat(stack.isEmpty(), is(true));
    }
}
