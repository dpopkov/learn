package learn.dsajg6e.ch01primer.exer;

import learn.dsajg6e.tools.Input;

public class C0119DivideBy2 {
    public static void main(String[] args) {
        int x = Input.nextInt("Enter positive integer greater than 2: ");
        int c = countDivisionsBy2(x);
        System.out.println("c = " + c);
    }

    /**
     * Calculates the number of times one must repeatedly divide the number by 2
     * before getting a value less than 2.
     * @param x the number
     * @return number of divisions
     */
    private static int countDivisionsBy2(int x) {
        int count = 0;
        while (x >= 2) {
            x /= 2;
            count++;
        }
        return count;
    }
}
