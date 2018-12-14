package learn.dsai.ch11ht;

import java.util.Scanner;

public class HashTableApplication {
    private final HashTableLong table;

    public HashTableApplication(HashTableLong table, int initialNumber) {
        this.table = table;
        initialize(initialNumber);
    }

    private void initialize(int initialNumber) {
        for (int i = 0; i < initialNumber; i++) {
            table.insert((long) (Math.random() * 100));
        }
    }

    public void run(Scanner in) {
        KeyLong item;
        long key;
        boolean done = false;
        while (!done) {
            System.out.print("Enter first letter of show, insert, delete, find or 'x' to exit: ");
            String choice = in.nextLine();
            switch (choice) {
                case "s":
                    System.out.println(table);
                    break;
                case "i":
                    key = getKey(in, "Enter key value to insert: ");
                    table.insert(key);
                    break;
                case "d":
                    key = getKey(in, "Enter key value to delete: ");
                    table.delete(key);
                    break;
                case "f":
                    key = getKey(in, "Enter key value to find: ");
                    item = table.find(key);
                    if (item != null) {
                        System.out.println("Found: " + item);
                    } else {
                        System.out.println("Could not find " + key);
                    }
                    break;
                case "x":
                    done = true;
                    break;
                default:
                    System.out.println("Invalid entry");
                    break;
            }
        }
    }

    private static long getKey(Scanner in, String prompt) {
        System.out.print(prompt);
        long key = in.nextLong();
        in.skip("\\s");
        return key;
    }
}
