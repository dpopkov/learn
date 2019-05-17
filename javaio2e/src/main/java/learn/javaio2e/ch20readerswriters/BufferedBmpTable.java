package learn.javaio2e.ch20readerswriters;

import java.io.*;

/**
 * Version of {@link UnicodeBmpTable} that uses a {@link BufferedWriter} to increase efficiency
 * and handle platform-dependent line separators.<br>
 * {@link BufferedWriter} is internally synchronized. Each call to one of its methods is atomic.
 * If two threads try to write onto the same BufferedWriter at the same time, one of them blocks.
 * This prevents the threads from corrupting the data. However, this synchronization has a performance cost,
 * even when only one thread has access to the writer.
 */
public class BufferedBmpTable {
    public static void main(String[] args) throws IOException {
        // Use platform default with a fallback to Latin-1 if necessary
        String encoding = System.getProperty("file.encoding", "ISO-8859-1");
        OutputStream target = System.out;
        if (args.length > 0) {
            target = new BufferedOutputStream(new FileOutputStream(args[0]));
        }
        if (args.length > 1) {
            encoding = args[1];
        }
        BufferedWriter out;
        try {
            out = new BufferedWriter(new OutputStreamWriter(target, encoding));
            System.out.println("Using encoding " + encoding);
        } catch (UnsupportedEncodingException ex) {
            System.err.println(ex.getMessage());
            out = new BufferedWriter(new OutputStreamWriter(target));
            System.out.println("Using platform default encoding");
        }
        try {
            for (int i = Character.MIN_VALUE; i <= Character.MAX_VALUE; i++) {
                if (!Character.isDefined(i)) {
                    continue;
                }
                char c = (char) i;
                if (Character.isHighSurrogate(c) || Character.isLowSurrogate(c)) {
                    continue;
                }
                out.write(i + ":\t" + c);
                out.newLine();
            }
        } finally {
            out.close();
        }
    }
}
