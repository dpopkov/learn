package learn.javaio2e.ch20readerswriters;

import java.io.*;

/**
 * Prints all the BMP characters.
 * Loops through every non-surrogate, defined character in the Basic Multilingual Plane (BMP)
 * and writes each one into the file given on the command line,
 * using the specified character encoding. If no character encoding is specified,
 * the platform's default encoding is used. If no file is specified, System.out is used.
 */
public class UnicodeBmpTable {
    public static void main(String[] args) throws IOException {
        // Use platform default with a fallback to Latin-1 if necessary
        String encoding = System.getProperty("file.encoding", "ISO-8859-1");
        String lineSeparator = System.getProperty("line.separator", "\r\n");
        OutputStream target = System.out;
        if (args.length > 0) {
            System.out.println("Writing to " + args[0]);
            target = new BufferedOutputStream(new FileOutputStream(args[0]));
        }
        if (args.length > 1) {
            encoding = args[1];
        }
        System.out.println("Using encoding " + encoding);
        OutputStreamWriter out;
        try {
            out = new OutputStreamWriter(target, encoding);
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Using platform default encoding.");
            out = new OutputStreamWriter(target);
        }
        try {
            for (int i = Character.MIN_VALUE; i <= Character.MAX_VALUE; i++) {
                // Skip undefined code points; these are not characters
                if (!Character.isDefined(i)) {
                    continue;
                }
                char c = (char) i;
                // Surrogates are not full characters so skip them
                if (Character.isHighSurrogate(c) || Character.isLowSurrogate(c)) {
                    continue;
                }
                out.write(i + ":\t" + c + lineSeparator);
            }
        } finally {
            out.close();
        }
    }
}
