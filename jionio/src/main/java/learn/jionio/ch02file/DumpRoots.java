package learn.jionio.ch02file;

import java.io.File;

/**
 * Dumps Available File System Roots to Standard Output.
 */
public class DumpRoots {
    public static void main(String[] args) {
        File[] roots = File.listRoots();
        for (File root : roots) {
            System.out.println(root);
        }
    }
}
