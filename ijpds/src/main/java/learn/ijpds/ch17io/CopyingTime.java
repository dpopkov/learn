package learn.ijpds.ch17io;

import java.io.File;
import java.io.IOException;

/**
 * Measures time of copying.
 */
public class CopyingTime {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java " + CopyingTime.class.getName() + " source-file");
            System.exit(1);
        }
        String source = args[0];
        String target = source + ".1";
        File sourceFile = new File(source);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + source + " does not exist.");
            System.exit(1);
        }
        long started, ms;
        File targetFile = new File(target);
        started = System.currentTimeMillis();
        Copy.copyFile(sourceFile, targetFile);
        ms = System.currentTimeMillis() - started;
        System.out.println("1: " + ms + " milliseconds");

        File targetFile2 = new File(source + ".2");
        started = System.currentTimeMillis();
        CopyWithBlocks.copyFile(sourceFile, targetFile2);
        ms = System.currentTimeMillis() - started;
        System.out.println("2: " + ms + " milliseconds");

        File targetFile3 = new File(source + ".3");
        started = System.currentTimeMillis();
        Copy.copyFileWithoutBuffered(sourceFile, targetFile3);
        ms = System.currentTimeMillis() - started;
        System.out.println("3: " + ms + " milliseconds");

        /*
        Result of tests on 10mb file:
        10485760 bytes copied
        1: 326 milliseconds     (Buffered streams)
        10485760 bytes copied
        2: 26 milliseconds      (Buffered streams with byte array as buffer)
        10485760 bytes copied
        3: 42797 milliseconds   (raw FileInput/FileOutputStream-s)
         */
    }
}
