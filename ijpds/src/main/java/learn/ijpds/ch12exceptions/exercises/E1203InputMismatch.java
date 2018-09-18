package learn.ijpds.ch12exceptions.exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

public class E1203InputMismatch {
    public static void main(String[] args) {
        String[] months = {"January", "February", "March", "April",
                "May", "June", "July", "August", "September", "October",
                "November", "December"};
        int[] dom = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number between 1 and 12: ");
        try {
            int n = in.nextInt();
            String month = months[n - 1];
            int days = dom[n - 1];
            System.out.printf("There are %d days in %s%n", days, month);
        } catch (InputMismatchException ex) {
            System.out.println("An integer is expected.");
        }
    }
}
