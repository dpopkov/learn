package learn.jionio.ch02file;

import java.io.File;
import java.io.IOException;

/**
 * Obtains Abstract Path information
 */
public class PathInfo {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java PathInfo path");
            return;
        }
        File file = new File(args[0]);
        System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());
        System.out.println("file.getCanonicalPath() = " + file.getCanonicalPath());
        System.out.println("file.getName() = " + file.getName());
        System.out.println("file.getParent() = " + file.getParent());
        System.out.println("file.getPath() = " + file.getPath());
    }
}
