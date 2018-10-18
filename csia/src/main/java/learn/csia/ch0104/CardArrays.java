package learn.csia.ch0104;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CardArrays {
    public static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
    public static final String[] RANKS = new String[13];
    public static final String[] DECK = new String[SUITS.length * RANKS.length];
    static {
        for (int i = 0; i < 9; i++) {
            RANKS[i] = Integer.toString(i + 2);
        }
        RANKS[9] = "Jack";
        RANKS[10] = "Queen";
        RANKS[11] = "King";
        RANKS[12] = "Ace";
        for (int i = 0; i < RANKS.length; i++) {
            for (int j = 0; j < SUITS.length; j++) {
                DECK[i * SUITS.length + j] = RANKS[i] + " of " + SUITS[j];
            }
        }
    }

    public static String[] makeDeck() {
        return Arrays.copyOf(DECK, DECK.length);
    }

    public static void shuffle(String[] cards) {
        for (int i = 0; i < cards.length - 1; i++) {
            int r = i + (int)(Math.random() * (cards.length - i));
            String t = cards[i];
            cards[i] = cards[r];
            cards[r] = t;
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> stats = new HashMap<>();
        for (int i = 0; i < 100000; i++) {
            String[] a = {"a", "b", "c"};
            shuffle(a);
            String s = a[0] + a[1] + a[2];
            if (stats.containsKey(s)) {
                stats.put(s, stats.get(s) + 1);
            } else {
                stats.put(s, 1);
            }
        }
        System.out.println(stats);
    }
}
