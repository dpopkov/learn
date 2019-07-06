package learn.dsajg6e.ch06stacks.exer;

import learn.dsajg6e.ch06stacks.ArrayStack;
import learn.dsajg6e.ch06stacks.Stack;
import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class C0617ReverseTest {

    @Test
    public void whenTransferThenElementsMoveToTarget() {
        Stack<Integer> source = new ArrayStack<>(3);
        Stack<Integer> target = new ArrayStack<>(3);
        source.push(10);
        source.push(20);
        source.push(30);
        C0617Reverse.transfer(source, target);
        assertThat(target.pop(), is(10));
        assertThat(target.pop(), is(20));
        assertThat(target.pop(), is(30));
    }

    @Test
    public void whenReverseStackThenElementsPopInReversedOrder() {
        Stack<Integer> stack = new ArrayStack<>(3);
        stack.push(10);
        stack.push(20);
        C0617Reverse.reverse(stack);
        assertThat(stack.pop(), is(10));
        assertThat(stack.pop(), is(20));
    }
}
