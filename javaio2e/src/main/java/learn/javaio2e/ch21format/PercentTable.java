package learn.javaio2e.ch21format;

import java.text.NumberFormat;
import java.util.Locale;

public class PercentTable {
    public static void main(String[] args) {
        NumberFormat percent = NumberFormat.getPercentInstance(Locale.US);
        percent.setMaximumFractionDigits(2);
        for (double d = 0.0; d <= 1.0; d += 0.005) {
            System.out.println(percent.format(d));
        }
    }
}
