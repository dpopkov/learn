/* 18.7 */
package learn.ijpds.ch18recursion;

import learn.csia.utils.CliAppArgs;

import java.io.File;

public class DirectorySize {
    public static void main(String[] args) {
        CliAppArgs cli = new CliAppArgs(args, "Enter a directory or a file");
        String path = cli.nextString();
        long size = getSize(new File(path));
        System.out.println("size = " + size + " bytes");
    }

    private static long getSize(File file) {
        long size = 0;
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; files != null && i < files.length; i++) {
                size += getSize(files[i]);
            }
        } else {
            size += file.length();
        }
        return size;
    }
}
