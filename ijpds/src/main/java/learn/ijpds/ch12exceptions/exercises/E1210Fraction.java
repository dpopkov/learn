package learn.ijpds.ch12exceptions.exercises;

@SuppressWarnings("unused")
public class E1210Fraction {
    private final int numerator;
    private final int denominator;

    public E1210Fraction(int numerator, int denominator) throws NullDenominatorException {
        this.numerator = numerator;
        if (denominator == 0) {
            throw new NullDenominatorException();
        }
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
}
