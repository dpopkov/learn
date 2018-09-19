package learn.ijpds.ch12exceptions.exercises;

import learn.csia.utils.CliAppArgs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E1212Reformat {
    public static void main(String[] args) {
        CliAppArgs in = new CliAppArgs(args, "Enter source file name");
        String sourceName = in.nextString();
        File file = new File(sourceName);
        if (!file.exists()) {
            System.out.println("File " + sourceName + " does not exist.");
            return;
        }
        try {
            reformat(file);
            System.out.println(E1212Reformat.class.getSimpleName() + ".main() finished.");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void reformat(File file) throws FileNotFoundException {
        Scanner in = new Scanner(file);
        List<String> lines = new ArrayList<>();
        String startCurlyBrace = "^\\s*\\{[^{]*$";
        while (in.hasNextLine()) {
            String current = in.nextLine();
            if (current.matches(startCurlyBrace)) {
                if (lines.size() > 0) {
                    int last = lines.size() - 1;
                    String lastLine = lines.get(last);
                    lastLine += " {";
                    lines.set(last, lastLine);
                }
            } else {
                lines.add(current);
            }
        }
        in.close();
        PrintWriter out = new PrintWriter(file);
        for (String line : lines) {
            out.println(line);
        }
        out.close();
    }
}
