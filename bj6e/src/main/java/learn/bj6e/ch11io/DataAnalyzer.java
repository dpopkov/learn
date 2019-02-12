package learn.bj6e.ch11io;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class is for demonstration of handling input errors.
 * It reads a file containing numbers and analyzes its contents.
 * If the file doesn't exist or contains strings that are not numbers,
 * an error message is displayed.
 */
public class DataAnalyzer {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DataSetReader reader = new DataSetReader();
        boolean reading = true;
        while (reading) {
            try {
                System.out.print("Please enter the file name: ");
                String filename = in.next();
                double[] data = reader.readFile(filename);
                double sum = 0;
                for (double d : data) {
                    sum += d;
                }
                System.out.println("The sum is " + sum);
                reading = false;
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (BadDataException e) {
                System.out.println("Bad data: " + e.getMessage());
            }
        }
    }
}
