package learn.hfdp.ch03decorator;

public abstract class BeverageDecorator extends Beverage {
    private Beverage decorated;

    public BeverageDecorator(Beverage decorated, String description) {
        super(description);
        this.decorated = decorated;
    }

    public Beverage getDecorated() {
        return decorated;
    }

    @Override
    public abstract double cost();

    @Override
    public String getDescription() {
        return decorated.getDescription() + ", " + super.getDescription();
    }
}
