package learn.ijpds.ch12exceptions.exercises;

import learn.csia.utils.CliAppArgs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E1211RemoveText {
    public static void main(String[] args) {
        CliAppArgs in = new CliAppArgs(args, "Enter string to remove", "Enter file name");
        String remove = in.nextString();
        String fileName = in.nextString();
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File " + fileName + " does not exist.");
            return;
        }
        try {
            removeString(remove, file);
            System.out.println(E1211RemoveText.class.getSimpleName() + ".main() finished");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void removeString(String remove, File file) throws FileNotFoundException {
        Scanner in = new Scanner(file);
        List<String> lines = new ArrayList<>();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            line = line.replaceAll(remove, "");
            lines.add(line);
        }
        in.close();
        PrintWriter out = new PrintWriter(file);
        for (String line : lines) {
            out.println(line);
        }
        out.close();
    }
}
