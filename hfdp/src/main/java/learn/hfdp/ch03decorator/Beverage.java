package learn.hfdp.ch03decorator;

public abstract class Beverage {
    private String description;

    public Beverage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract double cost();

    @Override
    public String toString() {
        return String.format("%s $%.2f", getDescription(), cost());
    }
}
