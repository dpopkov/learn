package learn.jionio.ch02file;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Demonstrates usage of temporary files.
 */
public class TempFileDemo {
    public static void main(String[] args) throws IOException {
        System.out.println("java.io.tmpdir = " + System.getProperty("java.io.tmpdir"));
        File temp = File.createTempFile("text", ".txt");
        System.out.println("Created: " + temp);
        temp.deleteOnExit();
        Scanner in = new Scanner(System.in);
        System.out.print("Press Enter to continue...");
        in.nextLine();
        System.out.println("Finished.");
    }
}
