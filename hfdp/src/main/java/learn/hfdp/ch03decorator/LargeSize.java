package learn.hfdp.ch03decorator;

public class LargeSize extends SizeDecorator {
    public LargeSize(Beverage decorated) {
        super(decorated, "large", Size.LARGE);
    }
}
