package learn.core1.ch07.logging;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

/**
 * A handler for displaying log records in a window.
 */
public class WindowHandler extends StreamHandler {
    private JFrame frame;

    public WindowHandler() {
        this.frame = new JFrame();
        final JTextArea output = new JTextArea();
        output.setEditable(false);
        frame.setSize(500, 200);
        frame.add(new JScrollPane(output));
        frame.setFocusableWindowState(false);
        frame.setVisible(true);
        this.setOutputStream(new OutputStream() {
            @Override
            public void write(int b) { }

            @Override
            public void write(byte[] bytes, int off, int len) {
                output.append(new String(bytes, off, len));
            }
        });
    }

    @Override
    public void publish(LogRecord record) {
        if (!frame.isVisible()) return;
        super.publish(record);
        flush();
    }
}
