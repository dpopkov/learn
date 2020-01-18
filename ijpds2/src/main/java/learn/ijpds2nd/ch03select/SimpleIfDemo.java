package learn.ijpds2nd.ch03select;

/* Listing 3.2 */

import java.util.Scanner;

public class SimpleIfDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = in.nextInt();
        if (number % 5 == 0) {
            System.out.println("Hi Five");
        }
        if (number % 2 == 0) {
            System.out.println("Hi Even");
        }
    }
}
