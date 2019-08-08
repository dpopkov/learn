package learn.core2.ch03xml.dom;

import javax.swing.*;
import java.awt.*;

public class TreeViewer {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new DomTreeFrame("TreeViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
