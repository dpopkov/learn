package learn.dsajg6e.ch03fund;

/**
 * CF 3.1
 */
public class GameEntry {
    private final String name;
    private final int score;

    public GameEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "('" + name + '\'' + ", " + score + ')';
    }
}
