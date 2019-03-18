package learn.jionio.ch12fs;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Visiting a File Tree and Reporting Last Modified Times and Sizes.
 */
public class FTWDemo {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java FTWDemo path");
            return;
        }
        Files.walkFileTree(Paths.get(args[0]), new DoNothingVisitor());
    }

    private static class DoNothingVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            System.out.printf("preVisitDirectory: %s%n", dir);
            System.out.printf("   lastModifiedTime: %s%n", attrs.lastModifiedTime());
            System.out.printf("   size: %d%n%n", attrs.size());
            return super.preVisitDirectory(dir, attrs);
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.printf("visitFile: %s%n%n", file);
            System.out.printf("   lastModifiedTime: %s%n", attrs.lastModifiedTime());
            System.out.printf("   size: %d%n%n", attrs.size());
            return super.visitFile(file, attrs);
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            System.out.printf("visitFileFailed: %s %s%n%n", file, exc);
            return super.visitFileFailed(file, exc);
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            System.out.printf("postVisitDirectory: %s %s%n%n", dir, exc);
            return super.postVisitDirectory(dir, exc);
        }
    }
}
