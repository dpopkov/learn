package learn.dsajg6e.ch02oop.exer;

import learn.dsajg6e.ch02oop.progressions.AbstractProgression;

/**
 * C-2.24
 * Each value in this progression is the absolute value of the difference
 * between the previous two values.
 */
public class C0224DiffProgression extends AbstractProgression {
    private long second;

    public C0224DiffProgression() {
        this(2, 200);
    }

    public C0224DiffProgression(long first, long second) {
        super(first);
        this.second = second;
    }
    /**
     * Advanced the current value to the next value of the progression.<br>
     * This method must be overridden by specialized subclasses in order
     * to alter the progression of numbers.
     */
    @Override
    protected void advance() {
        long next = Math.abs(current - second);
        current = second;
        second = next;
    }

    public static void main(String[] args) {
        C0224DiffProgression p = new C0224DiffProgression();
        p.print(20);
    }
}
