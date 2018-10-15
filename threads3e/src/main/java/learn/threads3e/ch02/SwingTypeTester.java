package learn.threads3e.ch02;

import learn.csia.utils.CliAppArgs;

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
    private final MinMax minMaxPause;

    private SwingTypeTester(MinMax minMaxPause) throws HeadlessException {
        this.minMaxPause = minMaxPause;
        initComponents();
    }

    private void initComponents() {
        add(displayCanvas, BorderLayout.NORTH);
        add(feedbackCanvas, BorderLayout.CENTER);
        JPanel p = new JPanel();
        final JButton startButton = new JButton("Start");
        p.add(startButton);
        final JButton stopSlowButton = new JButton("Stop Slow");
        p.add(stopSlowButton);
        final JButton stopButton = new JButton("Stop Quick");
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
            producer = new RandomCharacterGenerator(minMaxPause);
            displayCanvas.setCharacterSource(producer);
            producer.start();
            startButton.setEnabled(false);
            stopSlowButton.setEnabled(true);
            stopButton.setEnabled(true);
            feedbackCanvas.setEnabled(true);
            feedbackCanvas.requestFocus();
        });
        stopSlowButton.addActionListener(e -> {
            producer.setDone();
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
            stopSlowButton.setEnabled(false);
            feedbackCanvas.setEnabled(false);
        });
        stopButton.addActionListener(e -> {
            producer.interrupt();
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
            stopSlowButton.setEnabled(false);
            feedbackCanvas.setEnabled(false);
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
        CliAppArgs cli = new CliAppArgs(args, "Minimum pause milliseconds", "Maximum pause milliseconds");
        int minPause = cli.nextInt();
        int maxPause = cli.nextInt();
        SwingUtilities.invokeLater(() -> new SwingTypeTester(new MinMax(minPause, maxPause)).setVisible(true));
    }
}
