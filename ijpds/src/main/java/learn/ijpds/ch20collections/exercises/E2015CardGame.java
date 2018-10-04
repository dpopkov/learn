/*
20.15
Game: the 24-point card game.
Use cards 1(Ace),2..10,11(Jack),12(Queen),13(King)
 */
package learn.ijpds.ch20collections.exercises;

import java.util.*;

public class E2015CardGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        do {
            Deque<Integer> deck = makeDeck();
            List<Integer> four = new ArrayList<>();
            four.add(deck.pop());
            four.add(deck.pop());
            four.add(deck.pop());
            four.add(deck.pop());
            System.out.println("Four cards: " + four);
            Solver solver = new Solver(four);
            String solution = solver.findSolution(24);
            System.out.println(solution);
            System.out.print("Continue? (y/n): ");
        } while (in.nextLine().equals("y"));
    }

    private static Deque<Integer> makeDeck() {
        List<Integer> cards = makeCards();
        Collections.shuffle(cards);
        return new ArrayDeque<>(cards);
    }

    private static List<Integer> makeCards() {
        ArrayList<Integer> cards = new ArrayList<>(13);
        for (int i = 1; i < 14; i++) {
            cards.add(i);
        }
        return cards;
    }
}
