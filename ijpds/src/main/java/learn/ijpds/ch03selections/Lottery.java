package learn.ijpds.ch03selections;

import java.util.Scanner;

public class Lottery {
    public static void main(String[] args) {
        int lottery = (int) (Math.random() * 100);
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your lottery pick (two digits): ");
        int guess = input.nextInt();
        int lottery1 = lottery / 10;
        int lottery2 = lottery % 10;
        int guess1 = guess / 10;
        int guess2 = guess % 10;
        System.out.println("The lottery number is " + lottery);
        if (guess == lottery) {
            System.out.println("Exact match: you win $10,000");
        } else if (guess2 == lottery1 && guess1 == lottery2) {
            System.out.println("Match all digits: you win $3,000");
        } else if (guess1 == lottery1 || guess1 == lottery2 || guess2 == lottery1 || guess2 == lottery2) {
            System.out.println("Match one digit: you win $1,000");
        } else {
            System.out.println("Sorry, no match.");
        }
    }
}
