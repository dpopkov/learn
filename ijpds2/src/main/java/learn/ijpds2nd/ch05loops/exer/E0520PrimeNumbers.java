package learn.ijpds2nd.ch05loops.exer;

public class E0520PrimeNumbers {
    public static void main(String[] args) {
        final int NUMBER_OF_PRIMES_PER_LINE = 8;
        int count = 0;
        int number = 2;
        System.out.println("The prime numbers between 2 and 1200");
        while (number <= 1200) {
            boolean isPrime = true;
            for (int divisor = 2; divisor <= number / 2; divisor++) {
                if (number % divisor == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.printf("%5d", number);
                count++;
                if (count % NUMBER_OF_PRIMES_PER_LINE == 0) {
                    System.out.println();
                }
            }
            number++;
        }
    }
}
