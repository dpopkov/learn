package learn.dsai.ch11ht.linear;

import learn.dsai.ch11ht.DataItem;

import java.util.Scanner;

public class HashTableApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter capacity of hash table: ");
        int capacity = in.nextInt();
        System.out.print("Enter initial number of items: ");
        int n = in.nextInt();
        in.skip("\\s");
        HashTable table = new HashTable(capacity);
        long key;
        for (int i = 0; i < n; i++) {
            key = (long) (Math.random() * 100);
            table.insert(new DataItem(key));
        }

        DataItem item;
        boolean done = false;
        while (!done) {
            System.out.print("Enter first letter of show, insert, delete, find or 'x' to exit: ");
            String choice = in.nextLine();
            switch (choice) {
                case "s":
                    table.display();
                    break;
                case "i":
                    key = getKey(in, "Enter key value to insert: ");
                    table.insert(new DataItem(key));
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
