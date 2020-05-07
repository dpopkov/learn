package learn.ijpds2nd.ch08multiarrays.exer;

import learn.ijpds2nd.tools.ConsoleInput;

public class E0811NineHeadsAndTails {
    public static void main(String[] args) {
        ConsoleInput in = new ConsoleInput();
        int number = in.getInt("Enter a number between 0 and 511: ");
        String result = representAsHeadsAndTails(number);
        System.out.println(result);
    }

    private static String representAsHeadsAndTails(int n) {
        if (n < 0 || n > 511) {
            throw new IllegalArgumentException("Illegal value: " + n);
        }
        StringBuilder sb = new StringBuilder();
        int mask = 0b100000000;
        for (int i = 1; i <= 9; i++) {
            char symbol = (n & mask) == mask ? 'H' : 'T';
            mask >>>= 1;
            sb.append(symbol).append(" ");
            if (i % 3 == 0) {
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
