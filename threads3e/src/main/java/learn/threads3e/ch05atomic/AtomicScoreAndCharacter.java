package learn.threads3e.ch05atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicScoreAndCharacter {
    public class ScoreAndCharacter {
        private final int score;
        private final int char2type;

        public ScoreAndCharacter(int score, int char2type) {
            this.score = score;
            this.char2type = char2type;
        }

        public int getScore() {
            return score;
        }

        public int getCharacter() {
            return char2type;
        }
    }

    private AtomicReference<ScoreAndCharacter> value;

    public AtomicScoreAndCharacter() {
        this(0, -1);
    }

    public AtomicScoreAndCharacter(int initScore, int initChar) {
        value = new AtomicReference<>(new ScoreAndCharacter(initScore, initChar));
    }

    public int getScore() {
        return value.get().getScore();
    }

    public int getCharacter() {
        return value.get().getCharacter();
    }

    public void set(int newScore, int newChar) {
        value.set(new ScoreAndCharacter(newScore, newChar));
    }

    public void setScore(int newScore) {
        ScoreAndCharacter origVal, newVal;
        do {
            origVal = value.get();
            newVal = new ScoreAndCharacter(newScore, origVal.getCharacter());
        } while (!value.compareAndSet(origVal, newVal));
    }

    public void setCharacter(int newCharacter) {
        ScoreAndCharacter origVal, newVal;
        do {
            origVal = value.get();
            newVal = new ScoreAndCharacter(origVal.getScore(), newCharacter);
        } while(!value.compareAndSet(origVal, newVal));
    }

    /**
     * Sets the new character to by typed while penalizing the user if the previous
     * character has not been typed correctly.
     * @param newCharacter new generated character
     */
    public void setCharacterUpdateScore(int newCharacter) {
        ScoreAndCharacter origVal, newVal;
        int score;
        do {
            origVal = value.get();
            score = origVal.getScore();
            score = (origVal.getCharacter() == -1) ? score : score - 1;
            newVal = new ScoreAndCharacter(score, newCharacter);
        } while (!value.compareAndSet(origVal, newVal));
    }

    /**
     * Compares the typed character with the current generated character.
     * If they match, the character is set to a non-character value,
     * and the score is incremented.
     * If they do not match, the score is decremented.
     * @param typedChar typed character
     * @return true if match, false otherwise
     */
    public boolean processCharacter(int typedChar) {
        ScoreAndCharacter origVal, newVal;
        int origScore, origCharacter;
        boolean retValue;
        do {
            origVal = value.get();
            origScore = origVal.getScore();
            origCharacter = origVal.getCharacter();
            if (typedChar == origCharacter) {
                origCharacter = -1;
                origScore++;
                retValue = true;
            } else {
                origScore--;
                retValue = false;
            }
            newVal = new ScoreAndCharacter(origScore, origCharacter);
        } while (!value.compareAndSet(origVal, newVal));
        return retValue;
    }
}
