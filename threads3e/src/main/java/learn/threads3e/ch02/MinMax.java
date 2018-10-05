package learn.threads3e.ch02;

/**
 * Represents a pair of range numbers: minimum and maximum value.
 */
public class MinMax {
    private final int minValue;
    private final int maxValue;

    public MinMax(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }
}
