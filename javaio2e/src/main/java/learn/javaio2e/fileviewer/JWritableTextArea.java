package learn.javaio2e.fileviewer;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Revised version of {@link learn.javaio2e.ch02out.JStreamedTextArea} that contains
 * an underlying {@code Writer} rather than an {@code InputStream}.
 */
public class JWritableTextArea extends JTextArea {
    private Writer writer = new BufferedWriter(new TextAreaWriter());

    public JWritableTextArea() {
        this("", 0, 0);
    }

    public JWritableTextArea(int rows, int columns) {
        this("", rows, columns);
    }

    public JWritableTextArea(String text, int rows, int columns) {
        super(text, rows, columns);
        setFont(new Font("Monospaced", Font.PLAIN, 12));
        setEditable(false);
    }

    public Writer getWriter() {
        return writer;
    }

    public void reset() {
        this.setText("");
        writer = new BufferedWriter(new TextAreaWriter());
    }

    private class TextAreaWriter extends Writer {
        private boolean closed = false;

        @Override
        public void write(char[] text, int off, int len) throws IOException {
            if (closed) {
                throw new IOException("Write to closed stream");
            }
            JWritableTextArea.this.append(new String(text, off, len));
        }

        @Override
        public void flush() { }

        @Override
        public void close() {
            closed = true;
        }
    }
}
