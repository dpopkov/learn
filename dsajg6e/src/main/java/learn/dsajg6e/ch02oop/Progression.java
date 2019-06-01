package learn.dsajg6e.ch02oop;

/**
 * CF 2.2
 * Generates a simple progression.
 * (0, 1, 2, ...)
 */
public class Progression {
    protected long current;

    public Progression() {
        this(0);
    }
    public Progression(long current) {
        this.current = current;
    }

    /** Returns the next value of the progression, implicitly advancing the value each time. */
    public long nextValue() {
        long answer = current;
        advance();
        return answer;
    }

    /**
     * Advanced the current value to the next value of the progression.<br>
     * This method must be overridden by specialized subclasses in order
     * to alter the progression of numbers.
     */
    protected void advance() {
        current++;
    }

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
