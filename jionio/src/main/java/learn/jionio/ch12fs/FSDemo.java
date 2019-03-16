package learn.jionio.ch12fs;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Accessing a File Store and Outputting File Store Details.
 */
public class FSDemo {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java FSDemo path");
            return;
        }
        FileStore fs = Files.getFileStore(Paths.get(args[0]));
        System.out.println("FileStore " + fs);
        System.out.println("fs.getTotalSpace() = " + fs.getTotalSpace());
        System.out.println("fs.getUnallocatedSpace() = " + fs.getUnallocatedSpace());
        System.out.println("fs.getUsableSpace() = " + fs.getUsableSpace());
        System.out.println("fs.isReadOnly() = " + fs.isReadOnly());
        System.out.println("fs.name() = " + fs.name());
        System.out.println("fs.type() = " + fs.type());
    }
}
