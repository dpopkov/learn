package learn.dsajg6e.ch02oop.exer;

import java.math.BigInteger;

public class C0227BigFibonacciProgression extends C0225GenericProgression<BigInteger> {
    private BigInteger second;

    public C0227BigFibonacciProgression() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    public C0227BigFibonacciProgression(BigInteger first, BigInteger second) {
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
        BigInteger next = current.add(second);
        current = second;
        second = next;
    }
}
