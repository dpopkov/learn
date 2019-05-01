package learn.javaio2e.ch15channels;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Demonstrates locking a file before copying data into it.
 */
public class LockingCopier {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage: java LockingCopier input-file output-file");
            return;
        }
        try (FileInputStream inFile = new FileInputStream(args[0]);
             FileOutputStream outFile = new FileOutputStream(args[1]);
             FileChannel inChannel = inFile.getChannel();
             FileChannel outChannel = outFile.getChannel()) {
            FileLock outLock = outChannel.lock();
            FileLock inLock = inChannel.lock(0, inChannel.size(), true);
            inChannel.transferTo(0, inChannel.size(), outChannel);
            outLock.release();
            inLock.release();
        }
    }
}
