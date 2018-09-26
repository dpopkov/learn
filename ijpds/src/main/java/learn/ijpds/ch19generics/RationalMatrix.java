package learn.ijpds.ch19generics;

import learn.ijpds.ch13abstract.Rational;

public class RationalMatrix extends GenericMatrix<Rational> {
    @Override
    protected Rational add(Rational o1, Rational o2) {
        return o1.add(o2);
    }

    @Override
    protected Rational multiply(Rational o1, Rational o2) {
        return o1.multiply(o2);
    }

    @Override
    protected Rational zero() {
        return Rational.ZERO;
    }
}
