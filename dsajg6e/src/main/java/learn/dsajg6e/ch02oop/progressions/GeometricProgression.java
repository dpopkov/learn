package learn.dsajg6e.ch02oop.progressions;

/**
 * CF 2.4
 */
public class GeometricProgression extends AbstractProgression {
    /** Fixed multiplier. */
    protected final long base;

    public GeometricProgression(long start, long base) {
        super(start);
        this.base = base;
    }

    /**
     * Advanced the current value to the next value of the progression.<br>
     * This method must be overridden by specialized subclasses in order
     * to alter the progression of numbers.
     */
    @Override
    protected void advance() {
        current *= base;
    }
}
