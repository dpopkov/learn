package learn.jionio.ch12fs;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

/**
 * Outputting the Names of Default File System-Supported File Attribute Views.
 */
public class FAVDemo {
    public static void main(String[] args) {
        FileSystem fs = FileSystems.getDefault();
        for (String view : fs.supportedFileAttributeViews()) {
            System.out.println(view);
        }
    }
}
