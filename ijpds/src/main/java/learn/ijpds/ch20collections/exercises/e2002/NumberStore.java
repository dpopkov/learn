package learn.ijpds.ch20collections.exercises.e2002;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberStore {
    private final List<Integer> numbers = new ArrayList<>();

    public void add(int number) {
        numbers.add(number);
    }

    /**
     * Sorts in natural order.
     */
    public void sort() {
        numbers.sort(null);
    }

    public void shuffle() {
        Collections.shuffle(numbers);
    }

    public void reverse() {
        Collections.reverse(numbers);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
            if (i > 0) {
                builder.append(" ");
            }
            builder.append(numbers.get(i));
        }
        return builder.toString();
    }
}
