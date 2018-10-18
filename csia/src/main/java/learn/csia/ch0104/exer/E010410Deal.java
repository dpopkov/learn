/* 1.4.10 */
package learn.csia.ch0104.exer;

import learn.csia.ch0104.CardArrays;
import learn.csia.utils.CliAppArgs;

import java.util.Arrays;

/**
 * Takes an integer command-line argument n and prints n poker hands (five card each) from
 * a shuffled deck.
 */
public class E010410Deal {
    public static void main(String[] args) {
        CliAppArgs cli = new CliAppArgs(args, "Number of hands");
        int numHands = cli.nextInt();
        String[] deck = CardArrays.makeDeck();
        CardArrays.shuffle(deck);
        int last = deck.length - 1;
        for (int i = 0; i < numHands; i++) {
            Hand hand = new Hand();
            for (int j = 0; j < Hand.SIZE; j++) {
                hand.add(deck[last--]);
            }
            System.out.println(hand);
        }
    }

    private static class Hand {
        public static final int SIZE = 5;

        private String[] cards = new String[SIZE];
        private int index;

        public void add(String card) {
            cards[index++] = card;
        }

        @Override
        public String toString() {
            return Arrays.toString(cards);
        }
    }
}
