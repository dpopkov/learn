package learn.ijpds2nd.ch06methods.exer;

import java.util.Scanner;

public class E0631CreditCardNumberValidation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a credit card number as a long integer: ");
        long ccn = in.nextLong();
        boolean valid = new E0631CreditCardNumberValidator().isValid(ccn);
        System.out.printf("%d is %s%n", ccn, valid ? "valid" : "not valid");
    }
}
