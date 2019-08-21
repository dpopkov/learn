package learn.dsajg6e.ch09priorityqueues.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class C0925StackOnPQTest {

    @Test
    public void implementsLifo() {
        C0925StackOnPQ<Integer> stack = new C0925StackOnPQ<>();
        stack.push(10);
        stack.push(20);
        assertThat(stack.size(), is(2));
        assertThat(stack.pop(), is(20));
        assertThat(stack.pop(), is(10));
        assertThat(stack.isEmpty(), is(true));
    }
}
