package learn.dsajg6e.ch03fund.exer;

import java.util.Random;

public class C0323Forrest {
    /** Number of meetings for every i-th player. */
    private final Player[] players;

    public C0323Forrest(int numPlayers) {
        players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new Player(i, numPlayers);
        }
    }

    boolean meet(Player p0, Player p1) {
        if (p0 == p1) {
            return false;
        }
        p0.meet(p1);
        p1.meet(p0);
        return p0.isWinner() || p1.isWinner();
    }

    void startMeetings() {
        Random rnd = new Random();
        boolean haveWinner = false;
        while (!haveWinner) {
            int i0 = rnd.nextInt(this.players.length);
            int i1 = rnd.nextInt(this.players.length);
            Player p0 = players[i0];
            Player p1 = players[i1];
            haveWinner = meet(p0, p1);
            if (haveWinner) {
                if (p0.isWinner()) {
                    System.out.println("The winner is " + p0);
                } else if (p1.isWinner()) {
                    System.out.println("The winner is " + p1);
                }
            }
        }
    }

    public static void main(String[] args) {
        C0323Forrest forrest = new C0323Forrest(1000);
        forrest.startMeetings();
    }

    private static class Player {
        private final int id;
        private final boolean[] meetById;
        private int numMeetings;

        Player(int id, int numPlayers) {
            this.id = id;
            meetById = new boolean[numPlayers];
        }

        boolean isWinner() {
            return numMeetings == meetById.length - 1;
        }

        void meet(Player other) {
            if (other == this) {
                return;
            }
            if (!meetById[other.id]) {
                meetById[other.id] = true;
                numMeetings++;
            }
        }

        @Override
        public String toString() {
            return "Player{id=" + id + ", numMeetings=" + numMeetings + '}';
        }
    }
}
