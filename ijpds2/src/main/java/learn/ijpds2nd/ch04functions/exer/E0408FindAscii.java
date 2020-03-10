package learn.ijpds2nd.ch04functions.exer;

import java.util.Scanner;

public class E0408FindAscii {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char ch = in.nextLine().charAt(0);
        System.out.printf("The ASCII code for character %c is %d%n", ch, (int)ch);
    }
}
