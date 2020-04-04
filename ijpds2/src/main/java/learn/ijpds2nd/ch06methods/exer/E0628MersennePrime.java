package learn.ijpds2nd.ch06methods.exer;

public class E0628MersennePrime {
    public static void main(String[] args) {
        for (int p = 2; p <= 31; p++) {
            int mp = mersennePrime(p);
            boolean prime = isPrime(mp);
            System.out.printf("%2d         %12d      %s%n", p, mp, prime ? "Mersenne prime" : "");
        }
    }

    private static int mersennePrime(int p) {
        return (2 << (p - 1)) - 1;
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
