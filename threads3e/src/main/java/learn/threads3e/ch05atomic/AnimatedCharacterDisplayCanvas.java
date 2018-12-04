package learn.threads3e.ch05atomic;

import learn.threads3e.ch02.CharacterDisplayCanvas;
import learn.threads3e.ch02.CharacterEvent;
import learn.threads3e.ch02.CharacterListener;
import learn.threads3e.ch02.CharacterSource;

import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class AnimatedCharacterDisplayCanvas extends CharacterDisplayCanvas implements CharacterListener, Runnable {
    private AtomicBoolean done = new AtomicBoolean(true);
    private AtomicInteger curX = new AtomicInteger(0);
    private AtomicInteger tempChar = new AtomicInteger(0);
    private Thread timer;

    public AnimatedCharacterDisplayCanvas() {
        startAnimationThread();
    }

    public AnimatedCharacterDisplayCanvas(CharacterSource cs) {
        super(cs);
        startAnimationThread();
    }

    private void startAnimationThread() {
        if (timer == null) {
            timer = new Thread(this);
            timer.start();
        }
    }

    @Override
    public synchronized void newCharacter(CharacterEvent ce) {
        curX.set(0);
        tempChar.set(ce.getCharacter());
        repaint();
    }

    @SuppressWarnings("Duplicates")
    @Override
    protected synchronized void paintComponent(Graphics gc) {
        char[] localTmpChar = new char[1];
        localTmpChar[0] = (char) tempChar.get();
        int localCurX = curX.get();

        Dimension d = getSize();
        gc.clearRect(0, 0, d.width, d.height);
        if (localTmpChar[0] == 0) {
            return;
        }
        gc.drawChars(localTmpChar, 0, 1, localCurX, super.getFontHeight());
        curX.getAndIncrement();
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("curX = " + curX.get());    // shows that it never stops!
                Thread.sleep(100);
                if (!done.get()) {
                    repaint();
                }
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public void setDone(boolean done) {
        this.done.set(done);
    }
}
