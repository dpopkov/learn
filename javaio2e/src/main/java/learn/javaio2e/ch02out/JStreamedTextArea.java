package learn.javaio2e.ch02out;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;

/**
 * This component can be connected to an output stream. As data is written onto the stream,
 * it is appended to the text area in the default character set.
 * (This isn't ideal. Since text areas contain text, a writer would be a better source for this data).
 * The actual output stream is contained in an inner class inside the {@code JStreamedTextArea} class.
 * Client programmers access this output stream via {@code getOutputStream()} method.
 */
public class JStreamedTextArea extends JTextArea {
    private final OutputStream theOutput = new TextAreaOutputStream();

    public JStreamedTextArea() {
        this("", 0, 0);
    }

    public JStreamedTextArea(String text) {
        this(text, 0, 0);
    }

    public JStreamedTextArea(int rows, int columns) {
        this("", rows, columns);
    }

    public JStreamedTextArea(String text, int rows, int columns) {
        super(text, rows, columns);
        setEditable(false);
    }

    public OutputStream getOutputStream() {
        return theOutput;
    }

    public void reset() {
        super.setText("");
    }

    private class TextAreaOutputStream extends OutputStream {
        private boolean closed = false;

        @Override
        public void write(int b) throws IOException {
            checkOpen();
            b &= 0x000000FF;
            append(String.valueOf((char) b));
        }

        @Override
        public void write(byte[] data, int off, int len) throws IOException {
            checkOpen();
            append(new String(data, off, len));
        }

        @Override
        public void close() {
            closed = true;
        }

        private void checkOpen() throws IOException {
            if (closed) {
                throw new IOException("Write to closed stream");
            }
        }
    }
}
