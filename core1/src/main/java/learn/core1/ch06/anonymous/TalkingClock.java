package learn.core1.ch06.anonymous;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

public class TalkingClock {
    public void start(int interval, boolean beep) {
        //noinspection Convert2Lambda
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("At the tone, the time is " + LocalTime.now());
                if (beep) {
                    System.out.println("beep...");
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        };
/*
        // Using lambda instead of anonymous class:
        listener = event -> {
            System.out.println(LocalTime.now());
            if (beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        };
*/
        Timer timer = new Timer(interval, listener);
        timer.start();
    }
}
