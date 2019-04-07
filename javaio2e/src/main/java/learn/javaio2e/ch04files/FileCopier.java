package learn.javaio2e.ch04files;

import learn.javaio2e.ch03in.StreamCopier;

import java.io.*;

public class FileCopier {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java FileCopier source dest");
            return;
        }
        try {
            copy(args[0], args[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copy(String from, String to) throws IOException {
        try (InputStream in = new BufferedInputStream(new FileInputStream(from));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(to))) {
            StreamCopier.copy(in, out);
        }
    }
}
