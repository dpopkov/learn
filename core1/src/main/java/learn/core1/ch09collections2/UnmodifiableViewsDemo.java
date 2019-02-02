package learn.core1.ch09collections2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnmodifiableViewsDemo {
    @SuppressWarnings("Java9CollectionFactory")
    public static void main(String[] args) {
        List<String> staff = new ArrayList<>();
        staff.add("Alice");
        staff.add("Amy");
        staff.add("Bob");
        staff.add("Carl");
        lookAt(Collections.unmodifiableList(staff));
    }

    private static void lookAt(List<String> list) {
        list.forEach(System.out::println);
        try {
            list.set(0, "This update will fail");
        } catch (UnsupportedOperationException e) {
            System.out.println("An attempt to modify an unmodifiable list");
        }
    }
}
