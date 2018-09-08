package learn.core1.ch06.local;

import javax.swing.JOptionPane;

public class TalkingClockMain {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock();
        clock.start(2_000, true);
        JOptionPane.showMessageDialog(null, "Close app?");
        System.exit(0);
    }
}
