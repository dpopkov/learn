package learn.dsajg6e.ch05recursion.exer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*
Implement a recursive method with calling signature find(path, filename) that
reports all entries of the file system rooted at the given path having the given file
name.
 */
public class P0527FindInPath {
    static List<File> find(File path, String filename) {
        List<File> output = new ArrayList<>();
        find(path, filename, output);
        return output;
    }

    private static void find(File path, String filename, List<File> output) {
        if (!path.isDirectory()) {
            return;
        }
        File[] files = path.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.getName().equals(filename)) {
                    output.add(f);
                }
                if (f.isDirectory()) {
                    find(f, filename, output);
                }
            }
        }
    }

    public static void main(String[] args) {
        String path = ".";
        String filename = P0527FindInPath.class.getSimpleName() + ".java";
        if (args.length > 0) {
            path = args[0];
        }
        if (args.length > 1) {
            filename = args[1];
        }
        List<File> found = find(new File(path), filename);
        for (File f : found) {
            System.out.println(f.getAbsolutePath());
        }
    }
}
