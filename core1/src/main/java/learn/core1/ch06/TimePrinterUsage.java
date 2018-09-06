package learn.core1.ch06;

import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.event.ActionListener;

public class TimePrinterUsage {
    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(5_000, listener);
        t.start();
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
