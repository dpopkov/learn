package learn.dsajg6e.ch03fund;

/**
 * CF 3.2
 */
public class ScoreBoard {
    private int numEntries;
    private final GameEntry[] board;

    public ScoreBoard(int capacity) {
        board = new GameEntry[capacity];
    }

    public int size() {
        return numEntries;
    }

    public void add(GameEntry entry) {
        int newScore = entry.getScore();
        int i;
        for (i = numEntries - 1; i >= 0 && board[i].getScore() < newScore; i--) {
            if (i + 1 < board.length) {
                board[i + 1] = board[i];
            }
        }
        int target = i + 1;
        if (target < board.length) {
            board[target] = entry;
            numEntries = Math.min(numEntries + 1, board.length);
        }
    }

    public void add(GameEntry... entries) {
        for (GameEntry e : entries) {
            add(e);
        }
    }


    public GameEntry get(int i) {
        return board[i];
    }

    @SuppressWarnings("ManualArrayCopy")
    public GameEntry remove(int i) {
        if (i < 0 || i >= numEntries) {
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
        GameEntry entry = board[i];
        for (int j = i; j < numEntries - 1; j++) {
            board[j] = board[j + 1];
        }
        board[numEntries - 1] = null;
        numEntries--;
        return entry;
    }
}
