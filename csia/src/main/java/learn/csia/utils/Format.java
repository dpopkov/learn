package learn.csia.utils;

public class Format {
    /**
     * Formats quotient of numerator and denominator as percents.
     * @param numerator numerator (dividend)
     * @param denominator denominator (divider)
     * @return result of division as percents.
     */
    public static String percent(int numerator, int denominator) {
        return String.format("%.1f%%", (double) numerator / denominator * 100);
    }
}
