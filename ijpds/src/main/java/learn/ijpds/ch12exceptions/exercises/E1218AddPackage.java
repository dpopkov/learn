package learn.ijpds.ch12exceptions.exercises;

import learn.csia.utils.CliAppArgs;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Add package statement. Suppose you have Java source files under the directories chapter1, chapter2, . . . ,
 * chapter34. Write a program to insert the
 * statement package chapterN; as the first line for each Java source file under
 * the directory chapterN. Suppose chapter1, chapter2, . . . , chapter34
 * are under the root directory srcRootDirectory. The root directory and
 * chapterN directory may contain other folders and files.
 */
public class E1218AddPackage {
    private static final FileFilter FILE_FILTER = path -> path.getName().endsWith(".java");
    private static final FileFilter DIR_FILTER = File::isDirectory;

    public static void main(String[] args) {
        CliAppArgs in = new CliAppArgs(args, "Enter source directory");
        String sourceDir =  in.nextString();
        File dir = new File(sourceDir);
        if (!dir.exists()) {
            System.out.println("Source directory does not exist.");
            return;
        }
        File[] packageDirs = dir.listFiles(DIR_FILTER);
        if (packageDirs != null) {
            try {
                for (File packageDir : packageDirs) {
                    processPackageDirectory(packageDir);
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void processPackageDirectory(File dir) throws FileNotFoundException {
        File[] javaFiles = dir.listFiles(FILE_FILTER);
        if (javaFiles == null || javaFiles.length == 0) {
            System.out.println("No java files found in " + dir.getPath());
            return;
        }
        for (File f : javaFiles) {
            insertPackage(f);
        }
    }

    private static void insertPackage(File file) throws FileNotFoundException {
        String packageName = file.getParentFile().getName();
        List<String> lines = new ArrayList<>();
        lines.add("package " + packageName + ";");
        lines.add("");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        }
        try (PrintWriter writer = new PrintWriter(file)) {
            for (String line : lines) {
                writer.println(line);
            }
        }
    }
}
