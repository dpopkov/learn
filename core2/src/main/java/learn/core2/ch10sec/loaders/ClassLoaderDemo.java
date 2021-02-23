package learn.core2.ch10sec.loaders;

import javax.swing.*;
import java.awt.*;

/**
 * This program demonstrates a custom class loader that decrypts class files.
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ClassLoaderFrame frame = new ClassLoaderFrame();
            frame.setTitle("ClassLoaderTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
