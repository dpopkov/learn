package learn.ijpds2nd.ch03select.exer;

import java.util.Random;

public class E0324PickCard {

    private enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES;

        @Override
        public String toString() {
            return capitalizeFirstChar(super.toString());
        }
    }

    private enum Rank {
        ACE, R2, R3, R4, R5, R6, R7, R8, R9, R10, JACK, QUEEN, KING;

        @Override
        public String toString() {
            if (this == ACE || this == JACK || this == QUEEN || this == KING) {
                return capitalizeFirstChar(super.toString());
            }
            return Integer.toString(this.ordinal() + 1);
        }
    }

    private static String capitalizeFirstChar(String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }

    private static class Card {
        private final Rank rank;
        private final Suit suit;

        public Card(Rank rank, Suit suit) {
            this.rank = rank;
            this.suit = suit;
        }

        @Override
        public String toString() {
            return rank + " of " + suit;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        Rank rank = Rank.values()[random.nextInt(Rank.values().length)];
        Suit suit = Suit.values()[random.nextInt(Suit.values().length)];
        Card card = new Card(rank, suit);
        System.out.println("The card you picked is " + card);
    }
}
