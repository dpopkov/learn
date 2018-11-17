package learn.dsai.ch04.stacks;

import java.util.Scanner;

public class BracketsApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean finished = false;
        while (!finished) {
            System.out.print("Enter string containing delimiters: ");
            String input = in.nextLine();
            if (input.isEmpty()) {
                finished = true;
            } else {
                BracketChecker checker = new BracketChecker(input);
                checker.check();
            }
        }
    }
}
