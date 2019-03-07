package learn.ijpds.ch33netw.distributed;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HandleSession implements Runnable, TicTacToeConstants {
    private static final int SIGNAL_TO_START = 1;
    private static final int SIZE = 3;

    private final Socket player1;
    private final Socket player2;
    private final char[][] cell = new char[SIZE][SIZE];
    private DataInputStream fromPlayer1;
    private DataInputStream fromPlayer2;
    private DataOutputStream toPlayer1;
    private DataOutputStream toPlayer2;

    public HandleSession(Socket player1, Socket player2) {
        this.player1 = player1;
        this.player2 = player2;
        initCells();
    }

    private void initCells() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cell[i][j] = ' ';
            }
        }
    }

    @Override
    public void run() {
        try {
            initStreams();
            toPlayer1.writeInt(SIGNAL_TO_START);
            int row, column;
            while (true) {
                row = fromPlayer1.readInt();
                column = fromPlayer1.readInt();
                cell[row][column] = 'X';
                if (isWon('X')) {
                    sendToBoth(PLAYER1_WON);
                    sendMove(toPlayer2, row, column);
                    break;
                } else if (isFull()) {
                    sendToBoth(DRAW);
                    sendMove(toPlayer2, row, column);
                    break;
                } else {
                    sendToBoth(CONTINUE);
                    sendMove(toPlayer2, row, column);
                }
                row = fromPlayer2.readInt();
                column = fromPlayer2.readInt();
                cell[row][column] = 'O';
                if (isWon('O')) {
                    sendToBoth(PLAYER2_WON);
                    sendMove(toPlayer1, row, column);
                    break;
                } else {
                    toPlayer1.writeInt(CONTINUE);
                    sendMove(toPlayer1, row, column);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendToBoth(int signal) throws IOException {
        toPlayer1.writeInt(signal);
        toPlayer2.writeInt(signal);
    }

    private void initStreams() throws IOException {
        fromPlayer1 = new DataInputStream(player1.getInputStream());
        toPlayer1 = new DataOutputStream(player1.getOutputStream());
        fromPlayer2 = new DataInputStream(player2.getInputStream());
        toPlayer2 = new DataOutputStream(player2.getOutputStream());
    }

    private boolean isFull() {
        boolean full = true;
        outer:
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (cell[i][j] == ' ') {
                    full = false;
                    break outer;
                }
            }
        }
        return full;
    }

    /** Sends the move to other player. */
    private void sendMove(DataOutputStream out, int row, int column) throws IOException {
        out.writeInt(row);
        out.writeInt(column);
    }

    /** Determine if the player with the specified token wins. */
    private boolean isWon(char token) {
        boolean diagonal = true;
        for (int i = 0; i < SIZE; i++) {
            if (rowWins(i, token) || columnWins(i, token)) {
                return true;
            }
            if (cell[i][i] != token || cell[cell.length - i - 1][i] != token) {
                diagonal = false;
            }
        }
        return diagonal;
    }

    private boolean rowWins(int row, char token) {
        for (int i = 0; i < SIZE; i++) {
            if (cell[row][i] != token) {
                return false;
            }
        }
        return true;
    }

    private boolean columnWins(int column, char token) {
        for (int i = 0; i < SIZE; i++) {
            if (cell[i][column] != token) {
                return false;
            }
        }
        return true;
    }
}
