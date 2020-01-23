package learn.ijpds2nd.ch03select.exer;

import java.util.Scanner;

public class E0310Multiplication {

    public static final int BASE = 1000;

    public static void main(String[] args) {
        int number1 = (int) (Math.random() * BASE);
        int number2 = (int) (Math.random() * BASE);
        System.out.print("What is " + number1 + " * " + number2 + "? ");
        Scanner in = new Scanner(System.in);
        int answer = in.nextInt();
        if (number1 * number2 == answer) {
            System.out.println("You are correct!");
        } else {
            System.out.println("Your answer is wrong.");
            System.out.println(number1 + " * " + number2 + " should be " + (number1 * number2));
        }
    }
}
