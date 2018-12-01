package learn.codewars.kata;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

/*
In this little assignment you are given a string of space separated numbers,
and have to return the highest and lowest number.
 */
public class HighAndLow {
    public static String process2(String numbers) {
        IntSummaryStatistics stat = Arrays.stream(numbers.split(" "))
                .mapToInt(Integer::parseInt).summaryStatistics();
        return stat.getMax() + " " + stat.getMin();
    }

    public static String process(String numbers) {
        String[] tokens = numbers.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (String t : tokens) {
            int value = Integer.parseInt(t);
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
        }
        return max + " " + min;
    }
}
