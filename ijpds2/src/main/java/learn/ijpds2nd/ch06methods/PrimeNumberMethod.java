package learn.ijpds2nd.ch06methods;

import java.util.function.IntPredicate;

/* Listing 6.7 */
@SuppressWarnings("SameParameterValue")
public class PrimeNumberMethod {
    public static void main(String[] args) {
        System.out.printf("The first %d prime numbers are%n", 50);
        printNumbers(50, 10, PrimeNumberMethod::isPrime);
    }

    private static void printNumbers(int numNumbers, int perLine, IntPredicate filter) {
        int count = 0;
        int number = 2;
        while (count < numNumbers) {
            if (filter.test(number)) {
                System.out.printf("%4d", number);
                count++;
                if (count % perLine == 0) {
                    System.out.println();
                }
            }
            number++;
        }
    }

    private static boolean isPrime(int number) {
        boolean prime = true;
        for (int divisor = 2; divisor <= number / 2; divisor++) {
            if (number % divisor == 0) {
                prime = false;
                break;
            }
        }
        return prime;
    }
}
