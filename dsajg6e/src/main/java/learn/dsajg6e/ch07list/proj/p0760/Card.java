package learn.dsajg6e.ch07list.proj.p0760;

import java.util.Objects;

public class Card implements Comparable<Card> {
    private final Suit suit;
    private final Rank rank;

    public Card(Rank rank, Suit suit) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public boolean sameSuit(Card other) {
        return suit == other.suit;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Card card = (Card) other;
        return suit == card.suit && rank == card.rank;
    }

    @Override
    public String toString() {
        return "(" + rank + " of " + suit + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }

    @Override
    public int compareTo(Card o) {
        int rst = this.suit.compareTo(o.suit);
        return (rst != 0) ? rst : this.rank.compareTo(o.rank);
    }
}
