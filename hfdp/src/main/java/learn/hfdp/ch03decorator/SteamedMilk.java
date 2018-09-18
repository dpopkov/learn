package learn.hfdp.ch03decorator;

public class SteamedMilk extends CondimentDecorator {
    public SteamedMilk(Beverage decorated) {
        super(decorated, "Steamed Milk", 0.10);
    }
}
