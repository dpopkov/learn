package learn.ijpds2nd.ch04functions;

import java.util.Scanner;

/**
 * Listing 4.2
 * Prompts to enter two cities and displays them in alphabetical order.
 */
public class OrderTwoCities {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the first city: ");
        String city1 = in.nextLine();
        System.out.print("Enter the second city: ");
        String city2 = in.nextLine();
        if (city1.compareTo(city2) < 0) {
            System.out.println("The cities in alphabetical order are " + city1 + " " + city2);
        } else {
            System.out.println("The cities in alphabetical order are " + city2 + " " + city1);
        }
    }
}
