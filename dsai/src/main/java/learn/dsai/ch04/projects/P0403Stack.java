package learn.dsai.ch04.projects;

public class P0403Stack {
    private final P0402Deque deque = new P0402Deque();

    public void push(long value) {
        deque.insert(value);
    }

    public long pop() {
        return deque.removeRight();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public boolean isFull() {
        return deque.isFull();
    }

    @Override
    public String toString() {
        return deque.toString();
    }
}
