package learn.jionio.ch12fs;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

public class Copy {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage: java Copy source target");
            return;
        }
        Path source = Paths.get(args[0]);
        Path target = Paths.get(args[1]);
        if (!Files.exists(source)) {
            System.err.printf("%s source path doesn't exist%n", source);
            return;
        }
        if (!Files.isDirectory(source)) {
            if (Files.isDirectory(target)) {
                target = target.resolve(source.getFileName());
            }
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            return;
        }
        if (Files.exists(target) && !Files.isDirectory(target)) {
            System.err.printf("target %s is not a directory%n", target);
            return;
        }
        var options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        var copier = new CopyVisitor(source, target);
        Files.walkFileTree(source, options, Integer.MAX_VALUE, copier);
    }

    private static class CopyVisitor extends SimpleFileVisitor<Path> {
        private final StandardCopyOption copyOption = StandardCopyOption.REPLACE_EXISTING;

        private final Path fromPath;
        private final Path toPath;

        CopyVisitor(Path source, Path target) {
            fromPath = source;
            toPath = target;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            System.out.println("\npreVisitDirectory");
            System.out.println("dir = " + dir);
            System.out.println("fromPath = " + fromPath);
            System.out.println("toPath = " + toPath);
            System.out.println("fromPath.relativize(dir) = " + fromPath.relativize(dir));
            System.out.println("toPath.resolve(fromPath.relativize(dir)) = "
                    + toPath.resolve(fromPath.relativize(dir)));
            Path targetPath = toPath.resolve(fromPath.relativize(dir));
            if (!Files.exists(targetPath)) {
                Files.createDirectory(targetPath);
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.println("\nvisitFile");
            System.out.println("file = " + file);
            System.out.println("fromPath = " + fromPath);
            System.out.println("toPath = " + toPath);
            System.out.println("fromPath.relativize(file) = " + fromPath.relativize(file));
            System.out.println("toPath.resolve(fromPath.relativize(file)) = "
                    + toPath.resolve(fromPath.relativize(file)));
            Files.copy(file, toPath.resolve(fromPath.relativize(file)), copyOption);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) {
            if (exc != null) {
                exc.printStackTrace();
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
