package learn.dsai.ch06rec;

public class StackT<T> {
    private T[] array;
    private int top;

    @SuppressWarnings("unchecked")
    public StackT(int capacity) {
        array = (T[]) new Object[capacity];
        top = -1;
    }

    public void push(T element) {
        array[++top] = element;
    }

    public T pop() {
        return array[top--];
    }

    public T peek() {
        return array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
