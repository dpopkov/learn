package learn.core1.ch09collections.views;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CheckedViewDemo {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        List<String> safeStrings = Collections.checkedList(strings, String.class);
        safeStrings.add("First");
        safeStrings.add("Second");
        try {
            tryToAddWrongType(safeStrings);
        } catch (ClassCastException e) {
            System.out.println("Attempt to add object belonging to wrong type");
        }
        System.out.println("safeStrings = " + safeStrings);
    }

    @SuppressWarnings("unchecked")
    private static void tryToAddWrongType(List rawList) {
        rawList.add(new Date());
    }
}
