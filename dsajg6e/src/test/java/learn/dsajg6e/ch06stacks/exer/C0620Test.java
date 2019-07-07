package learn.dsajg6e.ch06stacks.exer;

import learn.dsajg6e.ch06stacks.LinkedStack;
import learn.dsajg6e.ch06stacks.Stack;
import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class C0620Test {

    @Test
    public void testPushBelow() {
        Stack<Integer> tmp = new LinkedStack<>();
        tmp.push(1);
        tmp.push(2);
        tmp.push(3);
        Stack<Integer> dest = new LinkedStack<>();
        dest.push(4);
        dest.push(5);
        Stack<Integer> source = new LinkedStack<>();
        source.push(6);
        source.push(7);
        source.push(8);
        source.push(9);
        new C0620().pushBelow(source, dest, tmp);
        assertStack(dest, 6, 7, 8, 9, 4, 5);
        assertStack(tmp, 1, 2, 3);
        assertTrue(source.isEmpty());
    }

    private void assertStack(Stack<Integer> s, int... values) {
        for (int i = values.length - 1; i >= 0; i--) {
            assertThat(s.pop(), is(values[i]));
        }
    }
}
