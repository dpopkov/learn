package learn.dsai.ch05.iterators;

import learn.dsai.ch05.doubly.DoublyLinkedList;

import java.util.Scanner;

public class ListIteratorApp {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        ListIterator it1 = list.getIterator();

        it1.insertAfter(20);
        it1.insertAfter(40);
        it1.insertAfter(80);
        it1.insertBefore(60);

        Scanner in = new Scanner(System.in);
        boolean inLoop = true;
        while (inLoop) {
            System.out.print("Enter first letter of show, reset");
            System.out.print(", next, get, before, after, delete, quit: ");
            String choice = in.nextLine();
            long value;
            switch (choice) {
                case "s":
                    list.displayForward();
                    break;
                case "r":
                    it1.reset();
                    break;
                case "n":
                    if (!list.isEmpty() && !it1.atEnd()) {
                        it1.nextLink();
                    } else {
                        System.out.println("Can't go to next link.");
                    }
                    break;
                case "g":
                    if (!list.isEmpty()) {
                        value = it1.getCurrent().data;
                        System.out.println("Returned " + value);
                    } else {
                        System.out.println("List is empty");
                    }
                    break;
                case "b":
                    it1.insertBefore(getValue(in));
                    break;
                case "a":
                    it1.insertAfter(getValue(in));
                    break;
                case "d":
                    if (!list.isEmpty()) {
                        value = it1.deleteCurrent();
                        System.out.println("Deleted " + value);
                    } else {
                        System.out.println("Can't delete.");
                    }
                    break;
                case "q":
                    inLoop = false;
                    break;
                default:
                    System.out.println("Invalid entry");
                    break;
            }
        }
    }

    private static long getValue(Scanner in) {
        System.out.print("Enter value to insert: ");
        long value = in.nextLong();
        in.nextLine();
        return value;
    }
}
