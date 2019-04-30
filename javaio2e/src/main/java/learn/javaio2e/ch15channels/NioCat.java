package learn.javaio2e.ch15channels;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Concatenates several files and demonstrates gathering channels.
 */
public class NioCat {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.err.println("Usage: java NioCat infile1 infile2 ... outfile");
            return;
        }
        final int numInFiles = args.length - 1;
        ByteBuffer[] buffers = new ByteBuffer[numInFiles];
        for (int i = 0; i < numInFiles; i++) {
            RandomAccessFile raf = new RandomAccessFile(args[i], "r");
            FileChannel channel = raf.getChannel();
            buffers[i] = channel.map(FileChannel.MapMode.READ_ONLY, 0, raf.length());
        }
        FileOutputStream outFile = new FileOutputStream(args[numInFiles]);
        FileChannel out = outFile.getChannel();
        out.write(buffers);
        out.close();
    }
}
