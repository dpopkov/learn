package learn.javaio2e.ch06filter;

import javax.swing.*;
import java.io.*;

public class MySimpleSlowInputStream extends FilterInputStream {
    private final long delay;

    public MySimpleSlowInputStream(InputStream in) {
        this(in, 10L);
    }

    public MySimpleSlowInputStream(InputStream in, long delay) {
        super(in);
        this.delay = delay;
    }

    @Override
    public int read() throws IOException {
        int b = in.read();
        if (b == -1) {
            return b;
        } else {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return b;
        }
    }

    @Override
    public int read(byte[] data, int off, int len) throws IOException {
        int result = in.read(data, off, len);
        if (result == -1) {
            return result;
        } else {
            try {
                Thread.sleep(delay * result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        try (InputStream in = new MySimpleSlowInputStream(
                new BufferedInputStream(new FileInputStream("pom.xml")))) {
            ProgressMonitorInputStream monitoredInput = new ProgressMonitorInputStream(
                    null, "Too slow", in);
            int ch;
            while ((ch = monitoredInput.read()) != -1) {
                System.out.write(ch);
            }
        } catch (InterruptedIOException iex) {
            System.err.println();
            System.err.println("Input was interrupted.");
        }
    }
}
