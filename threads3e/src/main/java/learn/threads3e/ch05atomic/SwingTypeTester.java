package learn.threads3e.ch05atomic;

import learn.threads3e.ch02.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SwingTypeTester extends JFrame implements CharacterSource {
    private final CharacterEventHandler handler = new CharacterEventHandler();
    private final AnimatedCharacterDisplayCanvas displayCanvas = new AnimatedCharacterDisplayCanvas();
    private final CharacterDisplayCanvas feedbackCanvas = new CharacterDisplayCanvas(this);
    private RandomCharacterGenerator producer;
    private final MinMax minMaxPause;
    private final JButton startButton = new JButton("Start");
    private final JButton stopButton = new JButton("Stop");
    private ScoreLabel scoreLabel;

    private SwingTypeTester(MinMax minMaxPause) throws HeadlessException {
        this.minMaxPause = minMaxPause;
        initComponents();
    }

    private void initComponents() {
        producer = new RandomCharacterGenerator(minMaxPause);
        displayCanvas.setCharacterSource(producer);
        producer.setDone(true);
        producer.start();
        add(displayCanvas, BorderLayout.NORTH);
        add(feedbackCanvas, BorderLayout.CENTER);
        JPanel p = new JPanel();
        scoreLabel = new ScoreLabel(producer, this);
        scoreLabel.setText("  ");
        p.add(scoreLabel);
        p.add(startButton);
        p.add(stopButton);
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
            displayCanvas.setDone(false);
            producer.setDone(false);
            scoreLabel.resetScore();
            disableStart();
        });
        stopButton.addActionListener(e -> {
            producer.setDone(true);
            displayCanvas.setDone(true);
            enableStart();
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

    private void disableStart() {
        startButton.setEnabled(false);
        stopButton.setEnabled(true);
        feedbackCanvas.setEnabled(true);
        feedbackCanvas.requestFocus();
    }

    private void enableStart() {
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
        feedbackCanvas.setEnabled(false);
    }

    private void quit() {
        System.exit(0);
    }

    /* Entry point main method */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java " + SwingTypeTester.class.getName() + " minPause maxPause");
            System.exit(1);
        }
        int minPause = Integer.parseInt(args[0]);
        int maxPause = Integer.parseInt(args[1]);
        SwingUtilities.invokeLater(() -> new SwingTypeTester(new MinMax(minPause, maxPause)).setVisible(true));
    }
}
