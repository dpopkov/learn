package learn.dsai.ch04.queues;

public interface Queue {
    boolean isFull();
    boolean isEmpty();
    void insert(long value);
    long remove();
    long peekFront();
    int size();
}
