package learn.ijpds2nd.ch07arrays.exer;

import learn.ijpds2nd.tools.ArrayUtils;

import java.util.EnumSet;

public class E0724CardPicker {
    public static void main(String[] args) {
        Card[] deck = Card.generateDeck();
        ArrayUtils.shuffle(deck);
        int numPicks = numberOfPicksToGetFromEachSuit(deck);
        for (int i = 0; i < numPicks; i++) {
            System.out.println(deck[i]);
        }
        System.out.println("Number of picks: " + numPicks);
    }

    private static int numberOfPicksToGetFromEachSuit(Card[] deck) {
        int count = 0;
        EnumSet<Card.Suit> suits = EnumSet.noneOf(Card.Suit.class);
        int numSuits = Card.Suit.values().length;
        while (count < deck.length) {
            Card card = deck[count++];
            suits.add(card.getSuit());
            if (suits.size() == numSuits) {
                break;
            }
        }
        return count;
    }
}
