package learn.dsai.ch06rec;

import java.util.Scanner;

public class BinarySearchApp {
    public static void main(String[] args) {
        OrdArray arr = new OrdArray(100);
        arr.insert(72); // insert items
        arr.insert(90);
        arr.insert(45);
        arr.insert(126);
        arr.insert(54);
        arr.insert(99);
        arr.insert(144);
        arr.insert(27);
        arr.insert(135);
        arr.insert(81);
        arr.insert(18);
        arr.insert(108);
        arr.insert(9);
        arr.insert(117);
        arr.insert(63);
        arr.insert(36);
        System.out.println(arr);

        Scanner in = new Scanner(System.in);
        System.out.print("Enter key: ");
        long key = in.nextLong();
        int idx = arr.indexOf(key);
        if (idx < 0) {
            System.out.println("Can't find " + key);
            System.out.println("It may be inserted at index " + -(idx + 1));
        } else {
            System.out.printf("Found %d at %d%n", key, idx);
        }
    }
}
