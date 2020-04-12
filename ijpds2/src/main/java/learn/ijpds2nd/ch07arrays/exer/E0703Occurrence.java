package learn.ijpds2nd.ch07arrays.exer;

import java.util.Scanner;

public class E0703Occurrence {
    public static void main(String[] args) {
        int[] counts = new int[51];
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the integers between 1 and 50: ");
        int i;
        while (true) {
            i = in.nextInt();
            if (i == 0) {
                break;
            }
            counts[i]++;
        }
        for (int j = 1; j < counts.length; j++) {
            if (counts[j] != 0) {
                System.out.printf("%d occurs %d time%s%n", j, counts[j], counts[j] > 1 ? "s" : "");
            }
        }
    }
}
