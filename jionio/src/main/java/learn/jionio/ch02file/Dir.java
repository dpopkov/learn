package learn.jionio.ch02file;

import java.io.File;
import java.io.FilenameFilter;

public class Dir {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java Dir dirPath extension");
            return;
        }
        File file = new File(args[0]);
        FilenameFilter filter = (dir, name) -> name.endsWith(args[1]);
        String[] names = file.list(filter);
        if (names != null) {
            for (String name : names) {
                System.out.println(name);
            }
        }
    }
}
