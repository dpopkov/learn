package learn.csia.ch0103.exer;

import learn.csia.utils.NumberArgs;

/**
 * 1.3.10 Write a program that takes an integer command-line argument n, uses
 * Math.random() to print n uniform random values between 0 and 1, and then
 * prints their average value.
 */
public class E010310 {
    public static void main(String[] args) {
        int n = new NumberArgs(args, "Number of values").nextInt();
        double sum = 0.0, randomValue;
        for (int i = 0; i < n; i++) {
            randomValue = Math.random();
            System.out.println(randomValue);
            sum += randomValue;
        }
        double average = sum / n;
        System.out.println("Avarage = " + average);
    }
}
