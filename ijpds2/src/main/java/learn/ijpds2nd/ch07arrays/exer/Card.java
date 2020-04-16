package learn.ijpds2nd.ch07arrays.exer;

public class Card {
    enum Suit {
        SPADES, HEARS, DIAMONDS, CLUBS
    }

    enum Rank {
        ACE, R2, R3, R4, R5, R6, R7, R8, R9, R10, JACK, QUEEN, KING
    }

    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return formatRank(rank) + " of " + capitalizeUpperCase(suit.toString());
    }

    public static Card[] generateDeck() {
        Suit[] suits = Suit.values();
        Rank[] ranks = Rank.values();
        Card[] cards = new Card[suits.length * ranks.length];
        int i = 0;
        for (Suit suit : suits) {
            for (Rank rank : ranks) {
                cards[i++] = new Card(suit, rank);
            }
        }
        return cards;
    }

    private String formatRank(Rank rank) {
        String s = rank.toString();
        if (s.startsWith("R")) {
            s = s.substring(1);
        } else {
            s = capitalizeUpperCase(s);
        }
        return s;
    }

    private String capitalizeUpperCase(String s) {
        return s.substring(0, 1) + s.toLowerCase().substring(1);
    }

    public static void main(String[] args) {
        Card[] deck = generateDeck();
        for (Card card : deck) {
            System.out.println(card);
        }
    }
}
