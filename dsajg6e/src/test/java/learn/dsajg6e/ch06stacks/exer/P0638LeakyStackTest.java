package learn.dsajg6e.ch06stacks.exer;

import learn.dsajg6e.ch06stacks.Stack;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class P0638LeakyStackTest {

    @Test
    public void implementsLifoOrder() {
        Stack<Integer> stack = new P0638LeakyStack<>(2);
        stack.push(10);
        assertThat(stack.top(), is(10));
        stack.push(20);
        assertThat(stack.top(), is(20));
        assertThat(stack.size(), is(2));
        assertThat(stack.pop(), is(20));
        assertThat(stack.top(), is(10));
        assertThat(stack.isEmpty(), is(false));
        assertThat(stack.pop(), is(10));
        assertThat(stack.isEmpty(), is(true));
    }

    @Test
    public void whenPushOverCapacityThenBottomElementLeaks() {
        Stack<Integer> stack = new P0638LeakyStack<>(2);
        stack.push(10);
        stack.push(20);
        assertThat(stack.top(), is(20));
        stack.push(30);
        assertThat(stack.top(), is(30));
        assertThat(stack.size(), is(2));
        stack.push(40);
        assertThat(stack.top(), is(40));
        stack.push(50);
        assertThat(stack.top(), is(50));
        assertThat(stack.size(), is(2));
        assertThat(stack.pop(), is(50));
        assertThat(stack.pop(), is(40));
        assertThat(stack.isEmpty(), is(true));
    }
}
