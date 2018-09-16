package learn.ijpds.ch12exceptions.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteDataWithAutoClose {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("io/text/scores.txt");
        if (file.exists()) {
            System.out.println("File already exists");
            System.exit(1);
        }
        try (PrintWriter out = new PrintWriter(file)) {
            out.print("John T Smith ");
            out.println(90);
            out.print("Eric K Jones ");
            out.println(85);
        }
    }
}
