package learn.ijpds.ch19generics.exercises;

import learn.ijpds.ch13abstract.exercises.Complex;

@SuppressWarnings("unused")
public class E1911ComplexMatrix extends ObjectMatrix<Complex> {
    @Override
    protected Complex add(Complex o1, Complex o2) {
        return o1.add(o2);
    }

    @Override
    protected Complex multiply(Complex o1, Complex o2) {
        return o1.multiply(o2);
    }

    @Override
    protected Complex zero() {
        return Complex.ZERO;
    }
}
