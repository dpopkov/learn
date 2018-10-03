package learn.ijpds.ch20collections.exercises;

import java.util.Scanner;

public class E2008Lottery {
    public static void main(String[] args) {
        int lottery = (int) (Math.random() * 900) + 100;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your lottery pick (3 digits): ");
        String guessStr = input.nextLine();
        int guess = Integer.parseInt(guessStr);
        int guess1 = guess / 100;
        int guess2 = guess / 10 % 10;
        int guess3 = guess % 10;
        System.out.println("The lottery number is " + lottery);
        if (guess == lottery) {
            System.out.println("Exact match: you win $12,000");
        } else {
            DigitsMatcher matcher = new DigitsMatcher(lottery);
            if (matcher.allDigitsMatch(guess1, guess2, guess3)) {
                System.out.println("Match all digits: you win $5,000");
            } else if (matcher.allDigitsMatch(guess1, guess2)
                    || matcher.allDigitsMatch(guess1, guess3)
                    || matcher.allDigitsMatch(guess2, guess3) ) {
                System.out.println("Match two digits: you win $4,000");
            } else if (matcher.digitMatch(guess1)
                        || matcher.digitMatch(guess2)
                        || matcher.digitMatch(guess3) ) {
                    System.out.println("Match one digit: you win $2,000");
            } else {
                System.out.println("Sorry, no match.");
            }
        }
    }
}
