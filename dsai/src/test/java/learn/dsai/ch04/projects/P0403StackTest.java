package learn.dsai.ch04.projects;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

public class P0403StackTest {

    @Test
    public void test() {
        P0403Stack stack = new P0403Stack();
        stack.push(11);
        stack.push(22);
        assertThat(stack.pop(), Is.is(22L));
        assertThat(stack.pop(), Is.is(11L));
    }
}
