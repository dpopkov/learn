package learn.dsajg6e.ch06stacks.exer;

import learn.dsajg6e.ch06stacks.LinkedStack;
import learn.dsajg6e.ch06stacks.Stack;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C0632MoveBelowTest {

    @Test
    public void whenMoveBelowThenMovedElementsAreBelowTarget() {
        Stack<Integer> dest = new LinkedStack<>();
        dest.push(1);
        dest.push(2);
        dest.push(3);
        Stack<Integer> source = new LinkedStack<>();
        source.push(4);
        source.push(5);
        C0632MoveBelow.moveBelow(dest, source);
        assertThat(dest.pop(), is(3));
        assertThat(dest.pop(), is(2));
        assertThat(dest.pop(), is(1));
        assertThat(dest.pop(), is(5));
        assertThat(dest.pop(), is(4));
    }
}
