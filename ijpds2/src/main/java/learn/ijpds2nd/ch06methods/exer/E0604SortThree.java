package learn.ijpds2nd.ch06methods.exer;

import java.util.Scanner;

public class E0604SortThree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter 3 numbers: ");
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        displaySortedNumbers(n1, n2, n3);
    }

    private static void displaySortedNumbers(int n1, int n2, int n3) {
        int tmp;
        if (n1 > n2) {
            tmp = n1;
            n1 = n2;
            n2 = tmp;
        }
        if (n2 > n3) {
            tmp = n2;
            n2 = n3;
            n3 = tmp;
        }
        if (n1 > n2) {
            tmp = n1;
            n1 = n2;
            n2 = tmp;
        }
        System.out.println(n1 + " " + n2 + " " + n3);
    }
}
