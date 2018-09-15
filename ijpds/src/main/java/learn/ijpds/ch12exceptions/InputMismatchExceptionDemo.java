/* Listing 12.5 */
package learn.ijpds.ch12exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMismatchExceptionDemo {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continueInput = true;
        do {
            try {
                System.out.print("Enter an integer: ");
                int n = in.nextInt();
                System.out.println("The number entered is " + n);
                continueInput = false;
            } catch (InputMismatchException ex) {
                System.out.println("Try again. (Incorrect input: an integer is required)");
                discardCurrentInput();
            }
        } while (continueInput);
    }

    private static void discardCurrentInput() {
        in.nextLine();
    }
}
