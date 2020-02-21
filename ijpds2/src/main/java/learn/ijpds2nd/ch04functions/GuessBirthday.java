package learn.ijpds2nd.ch04functions;

import java.util.Scanner;

/**
 * Listing 4.3
 */
public class GuessBirthday {
    public static void main(String[] args) {
        String set1 = " 1 3 5 7\n"
                + " 9 11 13 15\n"
                + "17 19 21 23\n"
                + "25 27 29 31";
        String set2 = " 2 3 6 7\n"
                + "10 11 14 15\n"
                + "18 19 22 23\n"
                + "26 27 30 31";
        String set3 = " 4 5 6 7\n"
                + "12 13 14 15\n"
                + "20 21 22 23\n"
                + "28 29 30 31";
        String set4 = " 8 9 10 11\n"
                + "12 13 14 15\n"
                + "24 25 26 27\n"
                + "28 29 30 31";
        String set5 = "16 17 18 19\n"
                + "20 21 22 23\n"
                + "24 26 26 27\n"
                + "28 29 30 31";
        int day = 0;
        Scanner in = new Scanner(System.in);
        if (prompt(set1, "Set1", in)) {
            day += 1;
        }
        if (prompt(set2, "Set2", in)) {
            day += 2;
        }
        if (prompt(set3, "Set3", in)) {
            day += 4;
        }
        if (prompt(set4, "Set4", in)) {
            day += 8;
        }
        if (prompt(set5, "Set5", in)) {
            day += 16;
        }
        System.out.println("Your birthday is " + day + "!");
    }

    private static boolean prompt(String set, String name, Scanner in) {
        System.out.println("Is you birthday in " + name + "?");
        System.out.println(set);
        System.out.print("Enter 0 for No and 1 for Yes: ");
        return in.nextInt() == 1;
    }
}
