package learn.threads3e.ch03synch;

import learn.threads3e.ch02.CharacterEvent;
import learn.threads3e.ch02.CharacterListener;
import learn.threads3e.ch02.CharacterSource;

import javax.swing.*;

public class ScoreLabel extends JLabel implements CharacterListener {
    private static final int TYPED_CORRECTLY = -1;

    private volatile int score = 0;
    private int charBuffer = TYPED_CORRECTLY;
    private CharacterSource generator = null, typist = null;

    public ScoreLabel(CharacterSource generator, CharacterSource typist) {
        this.generator = generator;
        this.typist = typist;
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

    public synchronized void resetGenerator(CharacterSource newGenerator) {
        if (generator != null) {
            generator.removeCharacterListener(this);
        }
        generator = newGenerator;
        if (generator != null) {
            generator.addCharacterListener(this);
        }
    }

    public synchronized void resetTypist(CharacterSource newTypist) {
        if (typist != null) {
            typist.removeCharacterListener(this);
        }
        typist = newTypist;
        if (typist != null) {
            typist.addCharacterListener(this);
        }
    }

    public synchronized void resetScore() {
        score = 0;
        charBuffer = TYPED_CORRECTLY;
        setScore();
    }

    private void setScore() {
        /* This method will be explained later in chapter 7. */
        SwingUtilities.invokeLater(() -> setText(Integer.toString(score)));
    }

    @Override
    public synchronized void newCharacter(CharacterEvent ce) {
        if (ce.getSource() == generator) {
            /* If previous character not typed correctly. */
            if (charBuffer != TYPED_CORRECTLY) {
                score--;
                setScore();
            }
            charBuffer = ce.getCharacter();
        } else {
            /* If character does not match. */
            if (charBuffer != ce.getCharacter()) {
                score--;
            } else {
                score++;
                charBuffer = TYPED_CORRECTLY;
            }
            setScore();
        }
    }
}
