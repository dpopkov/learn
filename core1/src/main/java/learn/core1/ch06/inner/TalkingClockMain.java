package learn.core1.ch06.inner;

import javax.swing.*;

/**
 * Demonstrates use of inner classes.
 */
public class TalkingClockMain {
    public static void main(String[] args) {
        startClock();
        keepRunningUntilOk();
    }

    private static void startClock() {
        TalkingClock clock = new TalkingClock(1_000, true);
        clock.start();
    }

    private static void keepRunningUntilOk() {
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
