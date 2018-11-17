package learn.dsai.ch04.stacks;

import java.util.Scanner;

public class ReverseApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = in.nextLine();
        Reverser reverser = new Reverser(input);
        String output = reverser.reverse();
        System.out.println("Reversed: " + output);
    }
}
