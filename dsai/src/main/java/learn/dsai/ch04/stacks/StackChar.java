/* 4.2 */
package learn.dsai.ch04.stacks;

import java.util.StringJoiner;

public class StackChar {
    private final int maxSize;
    private final char[] stackArray;
    private int top;

    public StackChar(int size) {
        stackArray = new char[size];
        maxSize = size;
        top = -1;
    }

    public void push(char value) {
        stackArray[++top] = value;
    }

    public char pop() {
        return stackArray[top--];
    }

    public char peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i <= top; i++) {
            joiner.add(Character.toString(stackArray[i]));
        }
        return joiner.toString();
    }
}
