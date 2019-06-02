package learn.dsajg6e.ch02oop.progressions;

/**
 * CF 2.5
 */
public class FibonacciProgression extends AbstractProgression {
    private long previous;

    public FibonacciProgression() {
        this(0, 1);
    }

    public FibonacciProgression(long first, long second) {
        super(first);
        previous = second - first;
    }

    /**
     * Advanced the current value to the next value of the progression.<br>
     * This method must be overridden by specialized subclasses in order
     * to alter the progression of numbers.
     */
    @Override
    protected void advance() {
        long nextCurrent = previous + current;
        previous = current;
        current = nextCurrent;
    }
}
