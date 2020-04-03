package learn.ijpds2nd.ch06methods.exer;

public class E0626PalindromicPrimes {
    public static void main(String[] args) {
        int count = 0;
        int i = 2;
        while (count < 120) {
            if (isPrime(i) && isPalindrome(i)) {
                System.out.print(i + " ");
                count++;
                if (count % 10 == 0) {
                    System.out.println();
                }
            }
            i++;
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

    private static boolean isPalindrome(int n) {
        return n == reverse(n);
    }

    private static int reverse(int n) {
        int r = 0;
        while (n != 0) {
            int d = n % 10;
            n /= 10;
            r = r * 10 + d;
        }
        return r;
    }
}
