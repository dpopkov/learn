package learn.dsai.ch05.projects;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class P0504StackOnCircularTest {
    @Test
    public void testPushPop() {
        P0504StackOnCircular stack = new P0504StackOnCircular();
        stack.push(11);
        stack.push(22);
        stack.push(33);
        assertThat(stack.pop(), is(33L));
        assertThat(stack.pop(), is(22L));
        assertThat(stack.pop(), is(11L));
        assertThat(stack.isEmpty(), is(true));
    }
}
