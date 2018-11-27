package learn.dsai.ch05.projects;

import java.util.Scanner;

/* For 20 people and 7th person the number of count off is 4. */
public class P0505JosephusProblem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of people: ");
        int n = in.nextInt();
        System.out.print("Enter number for count off: ");
        int countOff = in.nextInt();
        P0503CircularList list = new P0503CircularList();
        for (int i = 1; i <= n; i++) {
            list.insert(i);
            list.step();
        }
        list.step();

        System.out.println(list.toString());
        while (list.getSize() > 1) {
            move(list, countOff - 1);   // delete next after current
            long deleted = list.delete();
            list.step();    // count from next person after deleted
            System.out.println("Deleted: " + deleted);
            System.out.println(list.toString());
        }
        System.out.println("Only one left: " + list.getCurrent());
    }

    private static void move(P0503CircularList list, int numSteps) {
        for (int i = 0; i < numSteps; i++) {
            list.step();
        }
    }
}
