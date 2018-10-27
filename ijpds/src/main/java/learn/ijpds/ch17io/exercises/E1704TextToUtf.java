package learn.ijpds.ch17io.exercises;

import java.io.*;
import java.util.Scanner;

public class E1704TextToUtf {
    public static void main(String[] args) throws IOException {
        final String path = "io/text/reformat.txt";
        final String pathOut = path.replaceAll("\\.txt$", ".utf.txt");
        try (
                Scanner input = new Scanner(new BufferedInputStream(new FileInputStream(path)));
                DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(pathOut)))
        ) {
            StringBuilder builder = new StringBuilder();
            while (input.hasNextLine()) {
                builder.setLength(0);
                builder.append(input.nextLine());
                builder.append(System.lineSeparator());
                output.writeUTF(builder.toString());
            }
        }
    }
}
