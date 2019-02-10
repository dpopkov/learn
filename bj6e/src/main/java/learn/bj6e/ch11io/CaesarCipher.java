package learn.bj6e.ch11io;

import java.io.*;

/**
 * Encrypts a file using the Caesar cipher.
 */
public class CaesarCipher {
    private static final int DEFAULT_KEY = 3;

    public static void main(String[] args) throws IOException {
        int key = DEFAULT_KEY;
        String inFile = "";
        String outFile = "";
        int files = 0;
        for (String arg : args) {
            if (arg.charAt(0) == '-') {
                char option = arg.charAt(1);
                if (option == 'd') {
                    key = -key;
                } else {
                    usage();
                    return;
                }
            } else {
                files++;
                if (files == 1) {
                    inFile = arg;
                } else if (files == 2) {
                    outFile = arg;
                }
            }
        }
        if (files != 2) {
            usage();
            return;
        }

        try (BufferedReader in = new BufferedReader(new FileReader(inFile));
             PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outFile)))) {
            int from;
            while ((from = in.read()) != -1) {
                char to = encrypt((char) from, key);
                out.print(to);
            }
        }
    }

    static char encrypt(char ch, int key) {
        int base;
        if ('A' <= ch && ch <= 'Z') {
            base = 'A';
        } else if ('a' <= ch && ch <= 'z') {
            base = 'a';
        } else {
            return ch; // not a letter
        }
        int offset = ch - base + key;
        final int LETTERS = 26;
        if (offset >= LETTERS) {
            offset = offset - LETTERS;
        } else if (offset < 0) {
            offset = offset + LETTERS;
        }
        return (char) (base + offset);
    }

    private static void usage() {
        System.out.println("Usage: java " + CaesarCipher.class.getName() + " [-d] infile outfile");
    }
}
