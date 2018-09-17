/* Listing 12.16 */
package learn.ijpds.ch12exceptions.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReplaceText {
    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: java ReplaceText sourceFile targetFile oldStr newStr");
            System.exit(1);
        }
        File sourceFile = new File(args[0]);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + args[0] + " does not exist");
            System.exit(2);
        }
        File targetFile = new File(args[1]);
        if (targetFile.exists()) {
            System.out.println("Target file " + args[1] + " already exists");
            System.exit(3);
        }
        String oldString = args[2];
        String newString = args[3];

        try (Scanner in = new Scanner(sourceFile);
             PrintWriter out = new PrintWriter(targetFile)
        ) {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                line = line.replaceAll(oldString, newString);
                out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
