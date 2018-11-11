package learn.core1.ch09collections.views;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UnmodifiableDemo {
    public static void main(String[] args) {
        String[] a = {"one", "two", "three"};
        List<String> wrapper = Arrays.asList(a);
        List<String> list = new ArrayList<>(wrapper);
        List<String> unmodifiable = Collections.unmodifiableList(list);
        try {
            tryToModify(unmodifiable);
        } catch (UnsupportedOperationException e) {
            System.out.println("Attempt to modify an unmodifiable list");
        }
        System.out.println(unmodifiable);
    }

    private static void tryToModify(List<String> list) {
        list.set(list.size() - 1, "new last value");
    }


}
