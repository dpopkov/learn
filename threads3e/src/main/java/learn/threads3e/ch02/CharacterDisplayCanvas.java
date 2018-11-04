package learn.threads3e.ch02;

import javax.swing.*;
import java.awt.*;

public class CharacterDisplayCanvas extends JComponent implements CharacterListener {
    private final FontMetrics fm;
    /** Buffer for the painted character. */
    private final char[] tmpChar = new char[1];
    private final int fontHeight;

    public CharacterDisplayCanvas() {
        setFont(new Font("Monospaced", Font.BOLD, 18));
        fm = Toolkit.getDefaultToolkit().getFontMetrics(getFont());
        fontHeight = fm.getHeight();
    }

    public CharacterDisplayCanvas(CharacterSource cs) {
        this();
        setCharacterSource(cs);
    }

    /**
     * Registers itself to be notified when a character from source is available.
     */
    public void setCharacterSource(CharacterSource cs) {
        cs.addCharacterListener(this);
    }

    @Override
    public synchronized void newCharacter(CharacterEvent ce) {
        tmpChar[0] = (char) ce.getCharacter();
        repaint();
    }

    @Override
    public Dimension preferredSize() {
        return new Dimension(fm.getMaxAscent() + 10, fm.getMaxAscent() + 10);
    }

    @Override
    protected synchronized void paintComponent(Graphics gc) {
        Dimension d = getSize();
        gc.clearRect(0, 0, d.width, d.height);
        if (tmpChar[0] == 0) {
            return;
        }
        int charWidth = fm.charWidth((int) tmpChar[0]);
        gc.drawChars(tmpChar, 0, 1, (d.width - charWidth) / 2, fontHeight);
    }
}
