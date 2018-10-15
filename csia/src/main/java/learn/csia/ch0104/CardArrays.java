package learn.csia.ch0104;

import java.util.Arrays;

public class CardArrays {
    public static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
    public static final String[] RANKS = new String[13];
    static {
        for (int i = 0; i < 9; i++) {
            RANKS[i] = Integer.toString(i + 2);
        }
        RANKS[9] = "Jack";
        RANKS[10] = "Queen";
        RANKS[11] = "King";
        RANKS[12] = "Ace";
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(SUITS));
        System.out.println(Arrays.toString(RANKS));
    }
}
