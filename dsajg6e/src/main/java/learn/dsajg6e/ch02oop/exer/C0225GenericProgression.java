package learn.dsajg6e.ch02oop.exer;

/**
 * Base generic class for all progressions.<br>
 */
public abstract class C0225GenericProgression<T> {
    protected T current;

    public C0225GenericProgression(T current) {
        this.current = current;
    }

    /**
     * Returns the next value of the progression, implicitly advancing the value each time.
     */
    public T nextValue() {
        T answer = current;
        advance();
        return answer;
    }

    /**
     * Advanced the current value to the next value of the progression.<br>
     * This method must be overridden by specialized subclasses in order
     * to alter the progression of numbers.
     */
    protected abstract void advance();

    /** Prints the next n values of the progression. */
    public void print(int n) {
        System.out.print(nextValue());
        for (int j = 1; j < n; j++) {
            System.out.print(" ");
            System.out.print(nextValue());
        }
        System.out.println();
    }
}
