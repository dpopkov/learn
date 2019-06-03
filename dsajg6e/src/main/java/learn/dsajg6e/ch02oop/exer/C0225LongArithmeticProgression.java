package learn.dsajg6e.ch02oop.exer;

public class C0225LongArithmeticProgression extends C0225GenericProgression<Long> {
    private final Long step;

    public C0225LongArithmeticProgression() {
        this(0L, 1L);
    }

    public C0225LongArithmeticProgression(Long current, Long step) {
        super(current);
        this.step = step;
    }

    /**
     * Advanced the current value to the next value of the progression.<br>
     * This method must be overridden by specialized subclasses in order
     * to alter the progression of numbers.
     */
    @Override
    protected void advance() {
        current += step;
    }

    public static void main(String[] args) {
        C0225LongArithmeticProgression p = new C0225LongArithmeticProgression();
        p.print(10);
    }
}
