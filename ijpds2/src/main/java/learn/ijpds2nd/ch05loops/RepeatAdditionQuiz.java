package learn.ijpds2nd.ch05loops;

import java.util.Scanner;

/* Listing 5.1 */
public class RepeatAdditionQuiz {
    public static void main(String[] args) {
        int n1 = (int) (Math.random() * 100);
        int n2 = (int) (Math.random() * 100);
        Scanner in = new Scanner(System.in);
        System.out.print("What is " + n1 + " + " + n2 + "? ");
        int answer = in.nextInt();
        while (n1 + n2 != answer) {
            System.out.println("Wrong answer. Try again.");
            System.out.print("What is " + n1 + " + " + n2 + "? ");
            answer = in.nextInt();
        }
        System.out.println("You got it!");
    }
}
