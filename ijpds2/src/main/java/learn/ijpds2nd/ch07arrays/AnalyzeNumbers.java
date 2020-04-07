package learn.ijpds2nd.ch07arrays;

import java.util.Scanner;

/* Listing 7.1 */
public class AnalyzeNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        int n = in.nextInt();
        double[] numbers = new double[n];
        double sum = 0;

        System.out.print("Enter the numbers: ");
        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextDouble();
            sum += numbers[i];
        }
        double average = sum / n;
        int count = 0;
        for (double d : numbers) {
            if (d > average) {
                count++;
            }
        }
        System.out.println("Average is " + average);
        System.out.println("Number of elements above the average is " + count);
    }
}
