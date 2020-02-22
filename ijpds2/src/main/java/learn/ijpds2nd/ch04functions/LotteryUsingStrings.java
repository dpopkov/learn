package learn.ijpds2nd.ch04functions;

import java.util.Scanner;

/** Listing 4.5 */
public class LotteryUsingStrings {
    public static void main(String[] args) {
        String lottery = "" + randomDigit() + randomDigit();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your lottery pick (two digits): ");
        String guess = in.nextLine();
        char digit1 = lottery.charAt(0);
        char digit2 = lottery.charAt(1);
        char guess1 = guess.charAt(0);
        char guess2 = guess.charAt(1);

        System.out.println("The lottery number is " + lottery);
        if (guess.equals(lottery)) {
            System.out.println("Exact match: you win $10,000");
        } else if (guess1 == digit2 && guess2 == digit1) {
            System.out.println("Match all digits: you win $3,000");
        } else if (guess1 == digit1 || guess1 == digit2 || guess2 == digit1 || guess2 == digit2) {
            System.out.println("Match one digit: you win $1,000");
        } else {
            System.out.println("Sorry, no match");
        }
    }

    private static int randomDigit() {
        return (int) (Math.random() * 10);
    }
}
