package learn.dsajg6e.ch09pq2.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C0925StackTest {

    @Test
    public void testPushPop() {
        var stack = new C0925Stack<Integer>();
        stack.push(10);
        stack.push(30);
        stack.push(20);
        assertThat(stack.pop(), is(20));
        assertThat(stack.pop(), is(30));
        assertThat(stack.pop(), is(10));
        assertThat(stack.isEmpty(), is(true));
    }
}
