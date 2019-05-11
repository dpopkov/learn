package learn.javaio2e.ch17files;

import java.io.File;

/**
 * Lists the total, free, and usable space on the partition that contains
 * the current working directory.
 */
public class CwdSpace {
    private static final int MEGABYTE = 1024 * 1024;

    public static void main(String[] args) {
        File cwd = new File(".");
        System.out.println("Total space on current partition: " + cwd.getTotalSpace() / MEGABYTE + " MB");
        System.out.println("Free space on current partition: " + cwd.getFreeSpace() / MEGABYTE + " MB");
        System.out.println("Usable space on current partition: " + cwd.getUsableSpace() / MEGABYTE + " MB");
    }
}
