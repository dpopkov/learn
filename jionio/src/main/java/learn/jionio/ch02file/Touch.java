package learn.jionio.ch02file;

import java.io.File;

/**
 * Sets a file's or directory's timestamp to the current time.
 */
public class Touch {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Touch");
            return;
        }
        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.printf("%s does not exist.%n", file);
        } else {
            System.out.printf("Last modified time: %d%n", file.lastModified());
            long time = System.currentTimeMillis();
            boolean rst = file.setLastModified(time);
            if (rst) {
                System.out.println("Set new last modified time.");
                System.out.printf("Last modified time: %d%n", file.lastModified());
            } else {
                System.out.println("Failed to set last modified time.");
            }
        }
    }
}
