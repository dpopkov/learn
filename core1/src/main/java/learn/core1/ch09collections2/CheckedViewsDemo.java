package learn.core1.ch09collections2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CheckedViewsDemo {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<String> staff = new ArrayList<>(List.of("Alice", "Amy", "Bob", "Carl"));
        List rawList = staff;
        System.out.println("1) Inserting object of the wrong type");
        rawList.add(0, new Date());
        System.out.println("Inserting succeeds");
        try {
            String first = staff.get(0);
            System.out.println(first);
        } catch (ClassCastException e) {
            System.out.println("An attempt to get object of the wrong type!");
        }
        rawList = Collections.checkedList(staff, String.class);
        System.out.println("2) Inserting object of the wrong type");
        try {
            rawList.add(0, new Date());
        } catch (ClassCastException e) {
            System.out.println("This attempt to insert wrong type failed.");
        }
    }
}
