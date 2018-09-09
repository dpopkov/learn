package learn.core1.ch06.anonymous;

import javax.swing.*;

public class AnonymousUsage {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock();
        clock.start(1_000, true);
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
