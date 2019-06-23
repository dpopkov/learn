package learn.dsajg6e.ch05recursion;

import java.io.File;

public class DiskUsage {
    public static void main(String[] args) {
        File wd = new File(".");
        diskUsage(wd, true);
    }

    public static long diskUsage(File root, boolean verbose) {
        long total = root.length();
        if (root.isDirectory()) {
            File[] entries = root.listFiles();
            if (entries != null) {
                for (File f : entries) {
                    total += diskUsage(f, verbose);
                }
            }
        }
        if (verbose) {
            System.out.println(total + "\t" + root);
        }
        return total;
    }
}
