package learn.javaio2e.ch21format;

import java.text.NumberFormat;
import java.util.Locale;

public class MinimumWage {
    public static void main(String[] args) {
        NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(Locale.US);
        double minimumWage = 5.15;
        System.out.println("The minimum wage is " + dollarFormat.format(minimumWage));
        System.out.println("A worker earning minimum wage and working for forty");
        System.out.println("hours a week, 52 weeks a year, would yearn "
                + dollarFormat.format(40 * 52 * minimumWage));
    }
}
