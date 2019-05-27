package learn.dsajg6e.ch01primer;

/**
 * CF 1.2: a simple counter, which can be queried, incremented, and reset.
 */
public class Counter {
    private int count;

    public Counter() {
        this(0);
    }

    public Counter(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void increment() {
        count++;
    }

    public void increment(int delta) {
        count += delta;
    }

    public void reset() {
        count = 0;
    }

    @Override
    public String toString() {
        return "Counter{count=" + count + '}';
    }
}
