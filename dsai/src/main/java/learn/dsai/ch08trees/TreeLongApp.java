package learn.dsai.ch08trees;

import java.util.Scanner;

public class TreeLongApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeLong tree = new TreeLong();
        long[] values = {50, 25, 75, 12, 37, 43, 30, 33, 87, 93, 97};
        tree.insert(values);
        long value;
        NodeLong node;
        outerLoop: while (true) {
            System.out.print("Enter first letter of show, ");
            System.out.print("insert, find, delete, or traverse: ");
            String choice = in.nextLine();
            switch (choice) {
                case "s":
                    System.out.println(tree.buildForDisplay());
                    break;
                case "i":
                    System.out.print("Enter value to insert: ");
                    value = getLong(in);
                    tree.insert(value);
                    break;
                case "f":
                    System.out.print("Enter value to find: ");
                    value = getLong(in);
                    node = tree.find(value);
                    if (node != null) {
                        System.out.println("Found: " + node);
                    } else {
                        System.out.println("Could not find " + value);
                    }
                    break;
                case "d":
                    System.out.print("Enter value to delete: ");
                    value = getLong(in);
                    node = tree.find(value);
                    if (node != null) {
                        System.out.println("Deleted: " + node);
                    } else {
                        System.out.println("Could not find " + value);
                    }
                    break;
                case "t":
                    System.out.println("Tree: " + tree.toString());
                    break;
                case "x":
                    System.out.println("Exiting.");
                    break outerLoop;
                default:
                    System.out.println("Invalid entry");
                    break;
            }
        }
    }

    private static long getLong(Scanner in) {
        long value = in.nextLong();
        in.skip("\\s");
        return value;
    }
}
