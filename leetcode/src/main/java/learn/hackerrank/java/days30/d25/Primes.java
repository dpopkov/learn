package learn.hackerrank.java.days30.d25;

import java.util.*;

public class Primes {
    public static void main(String[] args) {
        Solution.main(args);
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n-- > 0) {
            int x = in.nextInt();
            System.out.println(isPrime(x) ? "Prime" : "Not prime");
        }
    }

    static boolean isPrime(int x) {
        if (x <= 1) {
            return false;
        }
        int b = (int) Math.sqrt(x);
        for (int i = 2; i <= b; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}