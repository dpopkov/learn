package learn.dsajg6e.ch07list.proj.p0760;

import learn.dsajg6e.ch07list.positional.LinkedPositionalList;
import learn.dsajg6e.ch07list.positional.Position;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Supports a person arranging a group of cards in his hand.
 */
public class CardHand {
    private final LinkedPositionalList<Card> list = new LinkedPositionalList<>();
    private final EnumMap<Suit, Position<Card>> positions = new EnumMap<>(Suit.class);

    public CardHand() {
        positions.put(Suit.HEARTS, null);
        positions.put(Suit.CLUBS, null);
        positions.put(Suit.SPADES, null);
        positions.put(Suit.DIAMONDS, null);
    }

    /**
     * Add a new cards to the hand.
     */
    public void addCard(Rank rank, Suit suit) {
        Card card = new Card(rank, suit);
        Position<Card> firstOfSuite = positions.get(suit);
        Position<Card> p = firstOfSuite != null ? firstOfSuite : list.first();
        while (p != null && p.getElement().compareTo(card) < 0) {
            p = list.after(p);
        }
        Position<Card> inserted;
        if (p == null) {
            inserted = list.addLast(card);
        } else {
            inserted = list.addBefore(p, card);
        }
        if (suitPositionShouldBeUpdated(firstOfSuite, inserted)) {
            positions.put(suit, inserted);
        }
    }

    private boolean suitPositionShouldBeUpdated(Position<Card> firstOfSuite, Position<Card> inserted) {
        return firstOfSuite == null || inserted.getElement().compareTo(firstOfSuite.getElement()) < 0;
    }

    /**
     * Remove and return a card of the suit from the players hand.
     * If there is no card of the suit, then remove and return an arbitrary
     * card from the hand
     *
     * @param suit suit of card
     * @return removed card
     */
    public Card play(Suit suit) {
        Position<Card> pos = positions.get(suit);
        if (pos == null) {
            return anyCard();
        }
        Card card = pos.getElement();
        Position<Card> next = list.after(pos);
        if (next.getElement().sameSuit(card)) {
            positions.put(suit, next);
        } else {
            positions.put(suit, null);
        }
        list.remove(pos);
        return card;
    }

    private Card anyCard() {
        int index = (int) (Math.random() * list.size());
        Position<Card> pos = traverseTo(index);
        return pos.getElement();
    }

    private Position<Card> traverseTo(int idx) {
        Position<Card> pos = list.first();
        for (int i = 0; i < idx; i++) {
            pos = list.after(pos);
        }
        return pos;
    }

    /**
     * Returns an iterator of all cards currently in the hand.
     */
    public Iterator<Card> iterator() {
        return list.iterator();
    }

    /**
     * Returns an iterator for all cards of the suit that are currently in the hand.
     */
    public Iterator<Card> suitIterator(Suit suit) {
        return new CardSuitIterator(suit);
    }

    private class CardSuitIterator implements Iterator<Card> {
        private Position<Card> current;

        public CardSuitIterator(Suit suit) {
            current = positions.get(suit);
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Card next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Card card = current.getElement();
            current = list.after(current);
            if (current != null && !current.getElement().sameSuit(card)) {
                current = null;
            }
            return card;
        }
    }


    @Override
    public String toString() {
        return list.toString();
    }
}
