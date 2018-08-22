package learn;

import java.util.Arrays;

public class Tmp {
    public static void main(String[] args) {
        int[] smallPrimes = {2, 3, 5, 7};
        System.out.println(Arrays.toString(smallPrimes));
        int[] luckyNumbers = smallPrimes;
        luckyNumbers[2] = 55;
        System.out.println(Arrays.toString(smallPrimes));

        int[] copiedLuckyNumbers = Arrays.copyOf(luckyNumbers, luckyNumbers.length);
        copiedLuckyNumbers[3] = 77;
        System.out.println(Arrays.toString(copiedLuckyNumbers));
        System.out.println(Arrays.toString(luckyNumbers));

        int[] luckyNumbers2 = Arrays.copyOf(luckyNumbers, luckyNumbers.length * 2);
        System.out.println(Arrays.toString(luckyNumbers2));
    }

    public String foo() {
        return "foo";
    }
}
