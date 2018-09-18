package learn.hfdp.ch03decorator;

public abstract class CondimentDecorator extends BeverageDecorator {
    private double condimentCost;

    public CondimentDecorator(Beverage decorated, String description, double condimentCost) {
        super(decorated, description);
        this.condimentCost = condimentCost;
    }

    @Override
    public double cost() {
        return getDecorated().cost() + this.condimentCost;
    }
}
