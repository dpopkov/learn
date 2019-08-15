package learn.core2.ch03xml.xpath;

import javax.swing.*;
import java.awt.*;

/**
 * Evaluates XPath expressions.
 */
public class XPathTester {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new XPathFrame();
            frame.setTitle("XPathTester");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
