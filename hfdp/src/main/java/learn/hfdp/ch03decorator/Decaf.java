package learn.hfdp.ch03decorator;

public class Decaf extends Beverage {
    public Decaf() {
        super("Decaf");
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
