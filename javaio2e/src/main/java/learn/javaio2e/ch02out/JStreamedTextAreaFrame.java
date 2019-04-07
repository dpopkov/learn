package learn.javaio2e.ch02out;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Demonstrates usage of {@link JStreamedTextArea}.
 */
public class JStreamedTextAreaFrame extends JFrame {
    private final JStreamedTextArea streamedTextArea = new JStreamedTextArea("Hello\n");

    public JStreamedTextAreaFrame() throws HeadlessException {
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("JStreamedTextAreaFrame");
        setSize(400, 300);
        getContentPane().add(new JScrollPane(streamedTextArea));
        setVisible(true);
    }

    public void println(String message) {
        try {
            streamedTextArea.getOutputStream().write(message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JStreamedTextAreaFrame frame = new JStreamedTextAreaFrame();
            frame.println("JStreamedTextAreaFrame is created\n");
            frame.println("This message is written to OutputStream\n");
        });
    }
}
