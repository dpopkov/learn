package learn.threads3e.ch02;

import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AnimatedCharacterDisplayCanvas extends CharacterDisplayCanvas implements CharacterListener, Runnable {
    private boolean done = false;
    private int curX = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private Thread timer;

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
        try {
            lock.lock();
            while (true) {
                try {
                    if (done) {
                        condition.await();
                    } else {
                        repaint();
                        condition.await(100, TimeUnit.MILLISECONDS);
                    }
                } catch (InterruptedException e) {
                    return;
                }
            }
        } finally {
            lock.unlock();
        }
    }

    @SuppressWarnings("Duplicates")
    public void setDone(boolean done) {
        try {
            lock.lock();
            this.done = done;
            if (timer == null) {
                timer = new Thread(this);
                timer.start();
            }
            if (!this.done) {
                condition.signal();
            }
        } finally {
            lock.unlock();
        }
    }
}
