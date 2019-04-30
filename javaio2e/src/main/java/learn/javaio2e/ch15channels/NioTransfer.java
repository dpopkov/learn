package learn.javaio2e.ch15channels;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * Demonstrates using transferTo() to copy one file to another.
 */
public class NioTransfer {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage: java NioTransfer source destination");
            return;
        }
        try (FileInputStream inFile = new FileInputStream(args[0]);
             FileOutputStream outFile = new FileOutputStream(args[1]);
             FileChannel inChannel = inFile.getChannel();
             FileChannel outChannel = outFile.getChannel()) {
            inChannel.transferTo(0, inChannel.size(), outChannel);
        }
    }
}
