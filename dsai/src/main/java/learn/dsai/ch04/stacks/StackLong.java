/* 4.1 */
package learn.dsai.ch04.stacks;

public class StackLong {
    private final int maxSize;
    private final long[] stackArray;
    private int top;

    public StackLong(int size) {
        stackArray = new long[size];
        maxSize = size;
        top = -1;
    }

    public void push(long value) {
        stackArray[++top] = value;
    }

    public long pop() {
        return stackArray[top--];
    }

    public long peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }
}
