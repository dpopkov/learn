package learn.core1.ch06.local;

import java.util.Arrays;
import java.util.Date;

public class UpdatingLocalVars {
    public static void main(String[] args) {
        int[] counter = new int[1];
        Date[] dates = new Date[100];
        for (int i = 0; i < dates.length; i++) {
            dates[i] = new Date() {
                public int compareTo(Date other) {
                    counter[0]++;
                    return super.compareTo(other);
                }
            };
        }
        Arrays.sort(dates);
        System.out.println(counter[0] + " comparisons.");
    }
}
