package learn.ijpds2nd.ch05loops;

import java.util.Scanner;

/* Listing 5.3 */
public class GuessNumberOneTime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int magic = (int) (101 * Math.random());
        System.out.println("Guess a magic number between 0 and 100 inclusive");
        int guess = -1;
        while (guess != magic) {
            System.out.print("Enter your guess: ");
            guess = in.nextInt();
            if (guess < magic) {
                System.out.println("Your guess is too low");
            } else if (guess > magic){
                System.out.println("Your guess is too high");
            } else {
                System.out.println("Yes the number is " + magic);
            }
        }
    }
}
