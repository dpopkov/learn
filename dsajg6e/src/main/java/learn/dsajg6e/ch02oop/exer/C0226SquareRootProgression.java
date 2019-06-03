package learn.dsajg6e.ch02oop.exer;

/**
 * C-2.26
 * Progression for which each value is the square root of the previous value.
 */
public class C0226SquareRootProgression extends C0225GenericProgression<Double> {
    public C0226SquareRootProgression() {
        this(65_536.0);
    }

    public C0226SquareRootProgression(Double start) {
        super(start);
    }

    /**
     * Advanced the current value to the next value of the progression.<br>
     * This method must be overridden by specialized subclasses in order
     * to alter the progression of numbers.
     */
    @Override
    protected void advance() {
        current = Math.sqrt(current);
    }

    public static void main(String[] args) {
        C0226SquareRootProgression p = new C0226SquareRootProgression();
        p.print(10);
    }
}
