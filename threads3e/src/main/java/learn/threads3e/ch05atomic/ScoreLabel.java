package learn.threads3e.ch05atomic;

import learn.threads3e.ch02.CharacterEvent;
import learn.threads3e.ch02.CharacterListener;
import learn.threads3e.ch02.CharacterSource;

import javax.swing.*;
import java.util.concurrent.atomic.AtomicReference;

public class ScoreLabel extends JLabel implements CharacterListener {
    private static final int TYPED_CORRECTLY = -1;

    private AtomicScoreAndCharacter scoreChar = new AtomicScoreAndCharacter();
    private AtomicReference<CharacterSource> generator;
    private AtomicReference<CharacterSource> typist;

    public ScoreLabel(CharacterSource generator, CharacterSource typist) {
        this.generator = new AtomicReference<>(generator);
        this.typist = new AtomicReference<>(typist);
        if (generator != null) {
            generator.addCharacterListener(this);
        }
        if (typist != null) {
            typist.addCharacterListener(this);
        }
    }

    public ScoreLabel() {
        this(null, null);
    }

    @SuppressWarnings("Duplicates")
    public void resetGenerator(CharacterSource newGenerator) {
        if (newGenerator != null) {
            newGenerator.addCharacterListener(this);
        }
        CharacterSource oldGenerator = generator.getAndSet(newGenerator);
        if (oldGenerator != null) {
            oldGenerator.removeCharacterListener(this);
        }
    }

    @SuppressWarnings("Duplicates")
    public void resetTypist(CharacterSource newTypist) {
        if (newTypist != null) {
            newTypist.addCharacterListener(this);
        }
        CharacterSource oldTypist = typist.getAndSet(newTypist);
        if (oldTypist != null) {
            oldTypist.removeCharacterListener(this);
        }
    }

    public void resetScore() {
        scoreChar.set(0, TYPED_CORRECTLY);
        setScore();
    }

    private void setScore() {
        /* This method will be explained later in chapter 7. */
        SwingUtilities.invokeLater(() -> setText(Integer.toString(scoreChar.getScore())));
    }

    @Override
    public void newCharacter(CharacterEvent ce) {
        /* If previous character not typed correctly: 1-point penalty. */
        if (ce.getSource() == generator.get()) {
            scoreChar.setCharacterUpdateScore(ce.getCharacter());
        }
        /* If character does not match: 1-point penalty. */
        else if (ce.getSource() == typist.get()) {
            scoreChar.processCharacter(ce.getCharacter());
        }
        setScore();
    }
}
