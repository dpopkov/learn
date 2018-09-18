package learn.hfdp.ch03decorator;

public class SizeDecorator extends BeverageDecorator {
    private Size size;

    public SizeDecorator(Beverage decorated, String description, Size size) {
        super(decorated, description);
        this.size = size;
    }

    @Override
    public double cost() {
        return getDecorated().cost() * size.getCostMultiplier();
    }
}
