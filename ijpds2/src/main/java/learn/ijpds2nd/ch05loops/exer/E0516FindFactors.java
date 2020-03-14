package learn.ijpds2nd.ch05loops.exer;

import java.util.Scanner;

public class E0516FindFactors {
    public static void main(String[] args) {
        System.out.print("Enter number: ");
        printFactors(new Scanner(System.in).nextInt());
    }

    private static void printFactors(int number) {
        int factor = 2;
        do {
            while (number != 0 && number % factor == 0) {
                System.out.print(factor + " ");
                number /= factor;
            }
            factor++;
        } while (number != 1);
        System.out.println();
    }
}
