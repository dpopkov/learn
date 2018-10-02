package learn.threads3e.ch02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SwingTypeTester extends JFrame implements CharacterSource {
    private final CharacterEventHandler handler = new CharacterEventHandler();
    private final CharacterDisplayCanvas displayCanvas = new CharacterDisplayCanvas();
    private final CharacterDisplayCanvas feedbackCanvas = new CharacterDisplayCanvas(this);
    private RandomCharacterGenerator producer;

    private SwingTypeTester() throws HeadlessException {
        initComponents();
    }

    private void initComponents() {
        add(displayCanvas, BorderLayout.NORTH);
        add(feedbackCanvas, BorderLayout.CENTER);
        JPanel p = new JPanel();
        final JButton startButton = new JButton("Start");
        p.add(startButton);
        final JButton quitButton = new JButton("Quit");
        p.add(quitButton);
        add(p, BorderLayout.SOUTH);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                quit();
            }
        });
        feedbackCanvas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if (c != KeyEvent.CHAR_UNDEFINED) {
                    newCharacter(c);
                }
            }
        });
        startButton.addActionListener(e -> {
            producer = new RandomCharacterGenerator();
            displayCanvas.setCharacterSource(producer);
            producer.start();
            startButton.setEnabled(false);
            feedbackCanvas.setEnabled(true);
            feedbackCanvas.requestFocus();
        });
        quitButton.addActionListener(e -> quit());
        pack();
    }

    /* CharacterSource methods */
    @Override
    public void addCharacterListener(CharacterListener listener) {
        handler.addCharacterListener(listener);
    }

    @Override
    public void removeCharacterListener(CharacterListener listener) {
        handler.removeCharacterListener(listener);
    }

    @Override
    public void nextCharacter() {
        throw new IllegalStateException("We don't produce on demand");
    }

    /* Private methods */
    private void newCharacter(int c) {
        handler.fireNewCharacter(this, c);
    }

    private void quit() {
        System.exit(0);
    }

    /* Entry point main method */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SwingTypeTester().setVisible(true));
    }
}
