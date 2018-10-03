package learn.ijpds.ch20collections.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DigitsMatcher {
    private List<Integer> digits;

    public DigitsMatcher(int number) {
        digits = new ArrayList<>();
        while (number > 0) {
            digits.add(number % 10);
            number /= 10;
        }
        digits.sort(null);
    }

    public boolean digitMatch(int digit) {
        return digits.contains(digit);
    }

    public boolean twoDigitsMatch(int a, int b) {
        List<Integer> two = Arrays.asList(a, b);
        two.sort(null);
        return digits.containsAll(two);
    }

    public boolean allDigitsMatch(Integer... v) {
        List<Integer> others = Arrays.asList(v);
        others.sort(null);
        return digits.containsAll(others);
    }
}
