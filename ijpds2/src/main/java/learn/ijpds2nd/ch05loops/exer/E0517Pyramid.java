package learn.ijpds2nd.ch05loops.exer;

import java.util.Scanner;

public class E0517Pyramid {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an integer from 1 to 15: ");
        int n = in.nextInt();
        for (int r = n; r >= 1; r--) {
            for (int c = r; c >= 1; c--) {
                System.out.print(c + " ");
            }
            for (int c = 2; c <= r; c++) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
