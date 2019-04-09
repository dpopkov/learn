package learn.javaio2e.ch06filter;

import java.io.*;

/**
 * Extracts ASCII strings from a file.
 */
public class StringExtractor {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            printUsage();
            return;
        }
        OutputStream out = null;
        try (InputStream in = new BufferedInputStream(new FileInputStream(args[0]))) {
            out = (args.length >= 2)
                    ? new BufferedOutputStream(new FileOutputStream(args[1]))
                    : System.out;
            PrintableOutputStream printable = new PrintableOutputStream(out);
            int c;
            while ((c = in.read()) != -1) {
                printable.write(c);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Cannot find file: " + args[0]);
            printUsage();
        } finally {
            if (out != null && out != System.out) {
                out.close();
            }
        }
    }

    private static void printUsage() {
        System.err.println("Usage: java StringExtractor file [outfile]");
    }
}
