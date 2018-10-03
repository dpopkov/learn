package learn.ijpds.ch03selections.exercises;

import java.util.Scanner;

public class E0115Lottery {
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
            if (digitsMatch(lottery, guess1, guess3, guess2)
                    || digitsMatch(lottery, guess2, guess1, guess3)
                    || digitsMatch(lottery, guess2, guess3, guess1)
                    || digitsMatch(lottery, guess3, guess1, guess2)
                    || digitsMatch(lottery, guess3, guess2, guess1)) {
                System.out.println("Match all digits: you win $5,000");
            } else if (oneDigitMatches(lottery, guess1)
                    || oneDigitMatches(lottery, guess2)
                    || oneDigitMatches(lottery, guess3) ) {
                System.out.println("Match one digit: you win $2,000");
            } else {
                System.out.println("Sorry, no match.");
            }
        }
    }

    private static boolean oneDigitMatches(int number, int d) {
        return number % 10 == d
                || number / 10 % 10 == d
                || number / 100 == d;
    }

    private static boolean digitsMatch(int number, int d1, int d2, int d3) {
        return number == d1 * 100 + d2 * 10 + d3;
    }
}
