package learn.ijpds2nd.ch10oop;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackOfIntegersTest {

    @Test
    public void testPushPeekPop() {
        StackOfIntegers stack = new StackOfIntegers(2);
        assertTrue(stack.isEmpty());
        stack.push(11);
        stack.push(22);
        stack.push(33);
        assertFalse(stack.isEmpty());
        assertEquals(33, stack.peek());
        assertEquals(3, stack.size());
        assertEquals(33, stack.pop());
        assertEquals(22, stack.pop());
        assertEquals(11, stack.pop());
        assertTrue(stack.isEmpty());
    }
}
