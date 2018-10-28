package learn.ijpds.ch17io;

import learn.csia.utils.CliAppArgs;

import java.io.*;

public class CopyWithBlocks {
    public static final int DEFAULT_BLOCK_SIZE = 1024 * 4;

    /**
     * Main method.
     * @param args args[0] source file, args[1] target file
     */
    public static void main(String[] args) throws IOException {
        CliAppArgs cli = new CliAppArgs(args, "Source file", "Target file");
        copyFile(getSourceFile(cli.nextString()), getTargetFile(cli.nextString()));
    }

    public static void copyFile(File sourceFile, File targetFile) throws IOException {
        copyFile(sourceFile, targetFile, DEFAULT_BLOCK_SIZE);
    }

    public static void copyFile(File sourceFile, File targetFile, int bufferBlockSize) throws IOException {
        try (
                BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourceFile));
                BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(targetFile))
        ) {
            byte[] block = new byte[bufferBlockSize];
            int r, numberOfBytesCopied = 0;
            while ((r = input.read(block)) != -1) {
                output.write(block, 0, r);
                numberOfBytesCopied += r;
            }
            System.out.println(numberOfBytesCopied + " bytes copied");
        }
    }

    private static File getSourceFile(String source) {
        File sourceFile = new File(source);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + source + " does not exist.");
            System.exit(1);
        }
        return sourceFile;
    }

    private static File getTargetFile(String target) {
        File targetFile = new File(target);
        if (targetFile.exists()) {
            System.out.println("Target file " + target + " already exists.");
            System.exit(2);
        }
        return targetFile;
    }
}
