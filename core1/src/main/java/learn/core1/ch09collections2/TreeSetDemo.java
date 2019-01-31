package learn.core1.ch09collections2;

import learn.core1.ch09collections.Item;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        SortedSet<Item> byNumber = new TreeSet<>();
        byNumber.add(new Item("Toaster", 1234));
        byNumber.add(new Item("Widget", 4562));
        byNumber.add(new Item("Modem", 9912));
        display("Compare by part number:", byNumber);
        Comparator<Item> descriptionComparator = Comparator.comparing(Item::getDescription);
        NavigableSet<Item> byDescription = new TreeSet<>(descriptionComparator);
        byDescription.addAll(byNumber);
        display("Compare by part description:", byDescription);
    }

    private static void display(String title, SortedSet<Item> parts) {
        System.out.println(title);
        System.out.println(parts);
    }
}
