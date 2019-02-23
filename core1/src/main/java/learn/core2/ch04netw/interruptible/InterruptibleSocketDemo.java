package learn.core2.ch04netw.interruptible;

import javax.swing.*;
import java.awt.*;

/**
 * Demonstrates how to interrupt a socket channel.
 */
public class InterruptibleSocketDemo {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new InterruptibleSocketFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
