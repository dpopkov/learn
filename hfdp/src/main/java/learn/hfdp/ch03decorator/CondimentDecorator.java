package learn.hfdp.ch03decorator;

public abstract class CondimentDecorator extends Beverage {
    private Beverage decorated;
    private double condimentCost;

    public CondimentDecorator(Beverage decorated, String description, double condimentCost) {
        super(description);
        this.decorated = decorated;
        this.condimentCost = condimentCost;
    }

    @Override
    public double cost() {
        return decorated.cost() + this.condimentCost;
    }

    @Override
    public String getDescription() {
        return decorated.getDescription() + ", " + super.getDescription();
    }
}
