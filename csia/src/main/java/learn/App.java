package learn;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(Paths.get("myfile.txt"), "UTF-8");
        while (in.hasNextLine()) {
            System.out.println(in.nextLine());
        }
        /*File file = new File(".");
        System.out.println(file.getCanonicalPath());*/
    }

}
