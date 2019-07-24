package learn.dsajg6e.ch07list.proj.p0760;

import org.junit.Test;

import java.util.Iterator;

import static learn.dsajg6e.ch07list.proj.p0760.Suit.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class CardHandTest {

    @Test
    public void canAddCard() {
        CardHand hand = new CardHand();
        hand.addCard(Rank.A, CLUBS);
        Iterator<Card> it = hand.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(new Card(Rank.A, CLUBS)));
    }

    @Test
    public void iteratesInOrderOfSuits() {
        CardHand hand = new CardHand();
        hand.addCard(Rank.A, SPADES);
        assertThat(hand.toString(), is("[(Ace of SPADES)]"));
        hand.addCard(Rank.A, DIAMONDS);
        assertThat(hand.toString(), is("[(Ace of SPADES), (Ace of DIAMONDS)]"));
        hand.addCard(Rank.A, HEARTS);
        assertThat(hand.toString(), is("[(Ace of HEARTS), (Ace of SPADES), (Ace of DIAMONDS)]"));
        hand.addCard(Rank.A, CLUBS);
        assertThat(hand.toString(), is("[(Ace of HEARTS), (Ace of CLUBS), (Ace of SPADES), (Ace of DIAMONDS)]"));
        hand.addCard(Rank.R2, DIAMONDS);
        assertThat(hand.toString(), is("[(Ace of HEARTS), (Ace of CLUBS), (Ace of SPADES), (2 of DIAMONDS), (Ace of DIAMONDS)]"));
    }

    @Test
    public void whenPlayThenReturnsSmallestCardOfTheSuit() {
        CardHand hand = new CardHand();
        hand.addCard(Rank.A, SPADES);
        hand.addCard(Rank.R2, SPADES);
        hand.addCard(Rank.Q, SPADES);
        Card card = hand.play(SPADES);
        assertThat(card, is(new Card(Rank.R2, SPADES)));
    }

    @Test
    public void whenPlayWithAbsentSuitThenReturnAnyCard() {
        CardHand hand = new CardHand();
        hand.addCard(Rank.A, SPADES);
        hand.addCard(Rank.R2, SPADES);
        Card card = hand.play(HEARTS);
        assertThat(card.getSuit(), is(not(HEARTS)));
    }

    @Test
    public void suitIteratorReturnsCardsOfOneSuit() {
        CardHand hand = new CardHand();
        hand.addCard(Rank.A, DIAMONDS);
        hand.addCard(Rank.A, SPADES);
        hand.addCard(Rank.R2, SPADES);
        hand.addCard(Rank.J, SPADES);
        hand.addCard(Rank.A, CLUBS);
        hand.addCard(Rank.R2, HEARTS);
        Iterator<Card> it = hand.suitIterator(SPADES);
        assertThat(it.next(), is(new Card(Rank.R2, SPADES)));
        assertThat(it.next(), is(new Card(Rank.J, SPADES)));
        assertThat(it.next(), is(new Card(Rank.A, SPADES)));
        assertThat(it.hasNext(), is(false));
    }
}
