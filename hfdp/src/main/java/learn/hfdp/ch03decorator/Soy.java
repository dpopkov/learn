package learn.hfdp.ch03decorator;

public class Soy extends CondimentDecorator {
    public Soy(Beverage decorated) {
        super(decorated, "Soy", 0.15);
    }
}
