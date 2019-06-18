package learn.dsajg6e.ch03fund;

import java.util.Objects;

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

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "('" + name + '\'' + ", " + score + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameEntry gameEntry = (GameEntry) o;
        return score == gameEntry.score && Objects.equals(name, gameEntry.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}
