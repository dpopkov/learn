package learn.hfdp.ch03decorator;

public class Whip extends CondimentDecorator {
    public Whip(Beverage decorated) {
        super(decorated, "Whip", 0.10);
    }
}
