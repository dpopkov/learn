package learn.dsajg6e.ch02oop;

/**
 * CF 2.3
 */
public class ArithmeticProgression extends Progression {
    protected final long increment;

    public ArithmeticProgression() {
        this(0, 1);
    }

    public ArithmeticProgression(long stepSize) {
        super(0);
        this.increment = stepSize;
    }

    public ArithmeticProgression(long start, long stepSize) {
        super(start);
        this.increment = stepSize;
    }

    /**
     * Advanced the current value to the next value of the progression.<br>
     * This method must be overridden by specialized subclasses in order
     * to alter the progression of numbers.
     */
    @Override
    protected void advance() {
        current += increment;
    }
}
