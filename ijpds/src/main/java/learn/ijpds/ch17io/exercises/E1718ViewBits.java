/*
17.18 (739)
View bits.
 */
package learn.ijpds.ch17io.exercises;

import java.io.*;

public class E1718ViewBits {
    @SuppressWarnings("SameParameterValue")
    private static void printFileAsBinary(File file, int bytesPerLine) throws IOException {
        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(file))) {
            BinaryPrinter printer = new BinaryPrinter(System.out::print, bytesPerLine);
            printer.print(input);
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java " + E1718ViewBits.class.getName() + " source_file");
            System.exit(1);
        }
        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("File does not exist: " + file.getAbsolutePath());
            System.exit(2);
        }
        printFileAsBinary(file, 8);
    }
}
