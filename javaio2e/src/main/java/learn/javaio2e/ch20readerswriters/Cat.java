package learn.javaio2e.ch20readerswriters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reads all files named on the command line and copies them to System.out.
 */
public class Cat {
    public static void main(String[] args) {
        String line;
        for (String fileName : args) {
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
