package learn.hfdp.ch03decorator;

public class SmallSize extends SizeDecorator {
    public SmallSize(Beverage decorated) {
        super(decorated, "small", Size.SMALL);
    }
}
