package learn.javaio2e.ch03in;

import java.io.IOException;

/**
 * Reads data from System.in and prints the numeric value of each byte read on the console.
 * Print Ctrl+z to finish input in command line (not IDE).
 */
public class StreamPrinter {
    public static void main(String[] args) {
        try {
            while (true) {
                int datum = System.in.read();
                if (datum == -1) {
                    break;
                }
                System.out.println(datum);
            }
        } catch (IOException e) {
            System.err.println("Couldn't read from System.in");
        }
    }
}
