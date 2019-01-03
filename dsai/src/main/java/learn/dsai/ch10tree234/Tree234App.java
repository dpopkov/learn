package learn.dsai.ch10tree234;

import java.util.Scanner;

public class Tree234App {
    public static void main(String[] args) {
        Tree234 tree = new Tree234();
        tree.insert(50L, 40L, 60L, 30L, 70L);

        Scanner in = new Scanner(System.in);
        long value;
        boolean inWhile = true;
        while (inWhile) {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, or find: ");
            String choice = in.nextLine();
            switch(choice) {
                case "s":
                    tree.display();
                    break;
                case "i":
                    value = getLong(in, "Enter value to insert: ");
                    tree.insert(value);
                    break;
                case "f":
                    value = getLong(in, "Enter value to find: ");
                    int found = tree.find(value);
                    if (found != -1) {
                        System.out.println("Found at index " + found);
                    } else {
                        System.out.println("Could not find " + value);
                    }
                    break;
                case "x":
                    inWhile = false;
                    break;
                default:
                    System.out.println("Invalid entry");
                    break;
            }
        }
    }

    private static long getLong(Scanner in, String prompt) {
        System.out.print(prompt);
        long value = in.nextLong();
        in.nextLine();
        return value;
    }
}
