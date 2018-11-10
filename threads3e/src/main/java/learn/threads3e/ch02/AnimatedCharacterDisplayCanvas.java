package learn.threads3e.ch02;

import java.awt.*;

public class AnimatedCharacterDisplayCanvas extends CharacterDisplayCanvas implements CharacterListener, Runnable {
    private volatile boolean done = false;
    private int curX = 0;

    public AnimatedCharacterDisplayCanvas() {
    }

    public AnimatedCharacterDisplayCanvas(CharacterSource cs) {
        super(cs);
    }

    @Override
    public synchronized void newCharacter(CharacterEvent ce) {
        curX = 0;
        super.newCharacter(ce);
    }

    @Override
    protected synchronized void paintComponent(Graphics gc) {
        Dimension d = getSize();
        gc.clearRect(0, 0, d.width, d.height);
        if (super.charBufferEmpty()) {
            return;
        }
        gc.drawChars(super.getCharBuffer(), 0, 1, curX++, super.getFontHeight());
    }

    @Override
    public void run() {
        while (!done) {
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}