package learn.javaio2e.fileviewer;

import learn.javaio2e.ch02out.JStreamedTextArea;
import learn.javaio2e.ch03in.StreamCopier;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Provides a window in which you can view the contents of a URL.
 * It assumes that those contents are ASCII text.
 */
public class UrlViewer extends JFrame {
    private final JTextField tfUrl = new JTextField();
    private final JStreamedTextArea taDisplay = new JStreamedTextArea(40, 72);

    public UrlViewer() {
        super("URL Viewer");
        setLocation(50, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initGuiComponents();
        pack();
    }

    private void initGuiComponents() {
        JScrollPane centerPane = new JScrollPane(taDisplay);
        JPanel southPane = new JPanel();
        JButton btLoad = new JButton("Load");
        southPane.add(btLoad);
        getContentPane().add(BorderLayout.NORTH, tfUrl);
        getContentPane().add(BorderLayout.CENTER, centerPane);
        getContentPane().add(BorderLayout.SOUTH, southPane);
        tfUrl.addActionListener(e -> readUrlContent());
        btLoad.addActionListener(e -> readUrlContent());
    }

    private void readUrlContent() {
        try {
            URL url = new URL(tfUrl.getText());
            try (InputStream in = url.openStream()) {
                taDisplay.setText("");
                StreamCopier.copy(in, taDisplay.getOutputStream());
            }
        } catch (MalformedURLException e) {
            taDisplay.setText("Invalid URL: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final UrlViewer viewer = new UrlViewer();
        SwingUtilities.invokeLater(() -> viewer.setVisible(true));
    }
}
