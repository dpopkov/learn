package learn.dsajg6e.ch09pq2.exer;

public interface LongPriorityQueue {
    void insert(long key);
    long min();
    long removeMin();
    int size();
    boolean isEmpty();

    interface LongBiPredicate {
        boolean test(long a, long b);
    }

    LongBiPredicate MINIMUM_ORIENTED = (a, b) -> a <= b;
    LongBiPredicate MAXIMUM_ORIENTED = (a, b) -> a >= b;
}
