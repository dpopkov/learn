package learn.javaio2e.ch21format;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 * Demonstrates parsing with NumberFormat.
 */
public class RootFinder {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            NumberFormat nf = NumberFormat.getInstance();
            while (true) {
                System.out.print("Enter a number (-1 to quit): ");
                Number input;
                String s = br.readLine();
                try {
                    input = nf.parse(s);
                } catch (ParseException ex) {
                    System.out.println(s + " is not a number I understand.");
                    continue;
                }
                double d = input.doubleValue();
                if (d < 0) {
                    break;
                }
                double root = Math.sqrt(d);
                System.out.println("The square root of " + s + " is " + root);
            }
        }  catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
