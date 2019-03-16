package learn.jionio.ch12fs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class BFAVDemo {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java BFAVDemo path");
            return;
        }
        Path p = Paths.get(args[0]);
        BasicFileAttributes bfa = Files.readAttributes(p, BasicFileAttributes.class);
        System.out.println("bfa.creationTime() = " + bfa.creationTime());
        System.out.println("bfa.fileKey() = " + bfa.fileKey());
        System.out.println("bfa.isDirectory() = " + bfa.isDirectory());
        System.out.println("bfa.isOther() = " + bfa.isOther());
        System.out.println("bfa.isRegularFile() = " + bfa.isRegularFile());
        System.out.println("bfa.isSymbolicLink() = " + bfa.isSymbolicLink());
        System.out.println("bfa.lastAccessTime() = " + bfa.lastAccessTime());
        System.out.println("bfa.lastModifiedTime() = " + bfa.lastModifiedTime());
        System.out.println("bfa.size() = " + bfa.size());
    }
}
