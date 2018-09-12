package learn.core1.ch07.logging;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Image viewer program that logs various events.
 */
public class LoggingImageViewer {
    private static final String PACKAGE = "learn.core1.ch07.logging";

    public static void main(String[] args) {
        if (System.getProperty("java.util.logging.config.class") == null
                && System.getProperty("java.util.logging.config.file") == null) {
            try {
                Logger.getLogger(PACKAGE).setLevel(Level.ALL);
                final int LOG_ROTATION_COUNT = 10;
                Handler handler = new FileHandler("%h/LoggingImageViewer.log", 0, LOG_ROTATION_COUNT);
                Logger.getLogger(PACKAGE).addHandler(handler);
            } catch (IOException e) {
                Logger.getLogger(PACKAGE).log(Level.SEVERE, "Can't create log file handler", e);
            }
        }
        EventQueue.invokeLater(() -> {
            Handler windowHandler = new WindowHandler();
            windowHandler.setLevel(Level.ALL);
            Logger.getLogger(PACKAGE).addHandler(windowHandler);
            JFrame frame = new ImageViewerFrame();
            Logger.getLogger(PACKAGE).fine("Showing frame");
            frame.setVisible(true);
        });
    }
}
