package learn.hfdp.ch03decorator;

public class MediumSize extends SizeDecorator {
    public MediumSize(Beverage decorated) {
        super(decorated, "medium", Size.MEDIUM);
    }
}
