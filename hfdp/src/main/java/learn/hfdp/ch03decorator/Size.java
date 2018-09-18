package learn.hfdp.ch03decorator;

public enum Size {
    SMALL(0.7), MEDIUM(1.0), LARGE(1.33);

    double costMultiplier;

    Size(double costMultiplier) {
        this.costMultiplier = costMultiplier;
    }

    public double getCostMultiplier() {
        return costMultiplier;
    }
}
