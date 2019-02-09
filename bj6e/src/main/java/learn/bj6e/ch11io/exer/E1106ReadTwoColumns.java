package learn.bj6e.ch11io.exer;

import learn.bj6e.common.CmdTools;

import java.io.*;
import java.util.Optional;
import java.util.Scanner;

/**
 * Reads a file containing two columns of floating-point numbers.
 * Prompts the user for the file name. Prints the average of each column.
 */
public class E1106ReadTwoColumns {
    public static void main(String[] args) {
        String filename = null;
        Optional<String> selected = CmdTools.getFileName(args);
        if (selected.isPresent()) {
            filename = selected.get();
        } else {
            System.out.println("Failed to get a filename");
            System.exit(-1);
        }
        try (InputStream in = new BufferedInputStream(new FileInputStream(filename))) {
            Scanner sc = new Scanner(in);
            double totalCol1 = 0;
            int count1 = 0;
            double totalCol2 = 0;
            int count2 = 0;
            while (sc.hasNextLine()) {
                if (sc.hasNextDouble()) {
                    double d1 = sc.nextDouble();
                    totalCol1 += d1;
                    count1++;
                }
                if (sc.hasNextDouble()) {
                    double d2 = sc.nextDouble();
                    totalCol2 += d2;
                    count2++;
                }
                if (sc.hasNextLine()) {
                    sc.nextLine();
                }
            }
            System.out.printf("Average of column1: %.2f%n", (totalCol1 / count1));
            System.out.printf("Average of column2: %.2f%n", (totalCol2 / count2));
        } catch (IOException e) {
            System.out.println("I/O error: " + e);
        }
    }
}
