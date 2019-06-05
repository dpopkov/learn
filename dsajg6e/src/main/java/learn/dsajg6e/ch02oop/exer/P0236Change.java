package learn.dsajg6e.ch02oop.exer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * P-2.36
 * Takes two numbers as input, one that is a monetary amount charged and the other
 * that is a monetary amount given.
 * Returns the number of each kind of bill and coin to give back as change for the difference
 * between the amount given and the amount charged.
 *
 * Coins and their values in dollars:
 * cent 0.01    c
 * dime 0.10    d
 * nickel 0.05  n
 * quarter 0.25 q
 * dollar 1.00  $
 */
public class P0236Change {
    private static final Pattern COIN_PATTERN = Pattern.compile("(\\d+)([cndq$])");

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter amount charged: ");
        String chargedStr = in.nextLine();
        System.out.print("Enter amount given: ");
        String givenStr = in.nextLine();
        Map<Coin, Integer> coinsCharged = parse(chargedStr);
        Map<Coin, Integer> coinsGiven = parse(givenStr);
        int chargedSum = calculate(coinsCharged);
        int givenSum = calculate(coinsGiven);
        int change = givenSum - chargedSum;
        Map<Coin, Integer> changeCoins = generate(change);
        changeCoins.forEach((k, v) -> System.out.printf("%s : %d%n", k, v));
    }

    /** Generates map of coins using the specified amount of cents. */
    static Map<Coin, Integer> generate(int sum) {
        Map<Coin, Integer> result = new HashMap<>();
        Coin[] descending = Coin.getValuesDescending();
        for (Coin c : descending) {
            int v = c.value;
            if (v <= sum) {
                int n = sum / v;
                result.merge(c, n, (old, newValue) -> old + n);
                sum -= n * v;
            }
        }
        return result;
    }

    /** Calculates the total value of coins in cents. */
    static int calculate(Map<Coin, Integer> coins) {
        int sum = 0;
        for (Map.Entry<Coin, Integer> entry : coins.entrySet()) {
            sum += entry.getKey().value * entry.getValue();
        }
        return sum;
    }

    static Map<Coin, Integer> parse(String s) {
        Map<Coin, Integer> coins = new HashMap<>();
        Matcher matcher = COIN_PATTERN.matcher(s);
        while (matcher.find()) {
            int coinAmount = Integer.parseInt(matcher.group(1));
            Coin coin = Coin.parse(matcher.group(2).charAt(0));
            coins.merge(coin, coinAmount, (old, newValue) -> old + coinAmount);
        }
        return coins;
    }

    enum Coin {
        CENT(1, 'c'),
        NICKEL(5, 'n'),
        DIME(10, 'd'),
        QUARTER(25, 'q'),
        DOLLAR(100, '$');

        /** Value of the coin in cents. */
        protected final int value;
        protected final char symbol;

        Coin(int value, char symbol) {
            this.value = value;
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return Character.toString(symbol);
        }

        private static Coin[] descending;

        public static Coin[] getValuesDescending() {
            if (descending == null) {
                descending = valuesDescending();
            }
            return descending;
        }

        private static Coin[] valuesDescending() {
            Coin[] va = values();
            Coin[] values = new Coin[va.length];
            System.arraycopy(va, 0, values, 0, va.length);
            Arrays.sort(values, (c0, c1) -> Integer.compare(c1.value, c0.value));
            return values;
        }

        public static Coin parse(char ch) {
            switch (ch) {
                case 'c': return Coin.CENT;
                case 'n': return Coin.NICKEL;
                case 'd': return Coin.DIME;
                case 'q': return Coin.QUARTER;
                case '$': return Coin.DOLLAR;
                default:
                    throw new IllegalArgumentException("This is not a coin symbol: " + ch);
            }
        }
    }
}
