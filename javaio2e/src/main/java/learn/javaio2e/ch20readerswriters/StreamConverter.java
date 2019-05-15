package learn.javaio2e.ch20readerswriters;

import java.io.*;

public class StreamConverter {
    public static void main(String[] args) throws IOException {
        if (args.length < 4) {
            System.err.println("Usage: java " + StreamConverter.class.getName()
                    + " infileEncoding outfileEncoding infile outfile");
            return;
        }
        File infile = new File(args[2]);
        File outfile = new File(args[3]);
        if (outfile.exists() && infile.getCanonicalPath().equals(outfile.getCanonicalPath())) {
            System.err.println("Can't convert file in place");
            return;
        }
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(infile), args[0]);
             OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(outfile), args[1])) {
            while (true) {
                int c = isr.read();
                if (c == -1) {
                    break;
                }
                osw.write(c);
            }
        }
    }
}
