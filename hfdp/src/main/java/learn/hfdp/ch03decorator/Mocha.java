package learn.hfdp.ch03decorator;

public class Mocha extends CondimentDecorator {
    public Mocha(Beverage decorated) {
        super(decorated, "Mocha", 0.20);
    }
}
