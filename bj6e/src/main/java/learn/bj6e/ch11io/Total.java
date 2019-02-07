package learn.bj6e.ch11io;

import learn.bj6e.common.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

/**
 * Reads a file with numbers, and writes the number to another file,
 * followed by their total.
 */
public class Total {
    public static void main(String[] args) throws FileNotFoundException {
        var names = getNames();
        Scanner in = new Scanner(new File(names.getItem1()));
        PrintWriter out = new PrintWriter(names.getItem2());
        double total = 0.0;
        while (in.hasNextDouble()) {
            double v1 = in.nextDouble();
            total += v1;
            if (in.hasNextDouble()) {
                double v2 = in.nextDouble();
                total += v2;
                out.printf("%7.2f %7.2f%n", v1, v2);
            } else {
                out.printf("%15.2f%n", v1);
            }
        }
        out.printf("Total: %8.2f%n", total);
        in.close();
        out.close();
    }

    private static Pair<String> getNames() {
        Scanner console = new Scanner(System.in);
        console.useLocale(Locale.US);
        System.out.print("Input file name: ");
        String inputName = console.next();
        System.out.print("Output file name: ");
        String outputName = console.next();
        final String parent = "txt";
        return new Pair<>(parent + File.separator + inputName,
                parent + File.separator + outputName);
    }
}
