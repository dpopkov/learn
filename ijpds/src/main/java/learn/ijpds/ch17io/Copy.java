/* 17.4 */
package learn.ijpds.ch17io;

import learn.csia.utils.CliAppArgs;

import java.io.*;

public class Copy {
    /**
     * Main method.
     * @param args args[0] source file, args[1] target file
     */
    public static void main(String[] args) throws IOException {
        CliAppArgs cli = new CliAppArgs(args, "Source file", "Target file");
        String source = cli.nextString();
        String target = cli.nextString();
        File sourceFile = new File(source);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + source + " does not exist.");
            System.exit(1);
        }
        File targetFile = new File(target);
        if (targetFile.exists()) {
            System.out.println("Target file " + target + " already exists.");
            System.exit(2);
        }
        copyFile(sourceFile, targetFile);
    }

    public static void copyFile(File sourceFile, File targetFile) throws IOException {
        try (
                BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourceFile));
                BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(targetFile))
        ) {
            int r, numberOfBytesCopied = 0;
            while ((r = input.read()) != -1) {
                output.write(r);
                numberOfBytesCopied++;
            }
            System.out.println(numberOfBytesCopied + " bytes copied");
        }
    }

    public static void copyFileWithoutBuffered(File sourceFile, File targetFile) throws IOException {
        try (
                FileInputStream input = new FileInputStream(sourceFile);
                FileOutputStream output = new FileOutputStream(targetFile)
        ) {
            int r, numberOfBytesCopied = 0;
            while ((r = input.read()) != -1) {
                output.write(r);
                numberOfBytesCopied++;
            }
            System.out.println(numberOfBytesCopied + " bytes copied");
        }
    }
}
