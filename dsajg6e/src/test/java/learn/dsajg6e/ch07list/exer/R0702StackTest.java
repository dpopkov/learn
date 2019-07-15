package learn.dsajg6e.ch07list.exer;

import learn.dsajg6e.ch06stacks.Stack;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class R0702StackTest {

    @Test
    public void whenPushPopThenImplementsLifoOrder() {
        Stack<Integer> stack = new R0702Stack<>();
        stack.push(10);
        assertThat(stack.top(), is(10));
        stack.push(20);
        assertThat(stack.top(), is(20));
        assertThat(stack.size(), is(2));
        assertThat(stack.pop(), is(20));
        assertThat(stack.pop(), is(10));
        assertThat(stack.isEmpty(), is(true));
    }
}
