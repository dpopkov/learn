package learn.dsai.ch09rbtrees;

import learn.dsai.ch08trees2.TreeStringBuilder;

import java.util.Arrays;
import java.util.Scanner;

public class RbTreeApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        RbTree<Integer> tree = new RbTree<>();
        Integer[] values = {50, 25, 75, 12, 37, 43, 30, 33, 87, 93, 97};
        Arrays.sort(values);    // demonstrates that the self-balanced tree does not degrade to linked list.
        final int cellWidth = 4;
        tree.add(values);
        TreeStringBuilder<Integer> builder = new TreeStringBuilder<>(cellWidth, true);
        int value;
        outerLoop: while (true) {
            System.out.print("Enter first letter of show, ");
            System.out.print("insert, find, delete, or traverse: ");
            String choice = in.nextLine();
            switch (choice) {
                case "s":
                    System.out.println(builder.build(tree.getRoot()));
                    break;
                case "i":
                    value = getInt("Enter value to insert: ", in);
                    tree.add(value);
                    break;
                /* Find is not implemented yet */
                /*case "f":
                    value = getInt("Enter value to find: ", in);
                    if (tree.find(value) != null) {
                        System.out.println("Found: " + value);
                    } else {
                        System.out.println("Could not find " + value);
                    }
                    break;*/
                /* Delete is not implemented yet */
                /*case "d":
                    value = getInt("Enter value to delete: ", in);
                    if (tree.delete(value)) {
                        System.out.println("Deleted: " + value);
                    } else {
                        System.out.println("Could not find " + value);
                    }
                    break;*/
                /* Traverse is not implemented yet */
                /*case "t":
                    System.out.println("Tree: " + tree.toString());
                    break;*/
                case "x":
                    System.out.println("Exiting.");
                    break outerLoop;
                default:
                    System.out.println("Invalid entry");
                    break;
            }
        }
    }

    private static int getInt(String prompt, Scanner in) {
        System.out.print(prompt);
        int value = in.nextInt();
        in.nextLine();
        return value;
    }
}

