package learn.javaio2e.ch14buffers;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.security.SecureRandom;

/**
 * Maps the entire file to be erased into memory. It then writes zeros into the file, then ones,
 * then random data produced by a java.util.SecureRandom object. After each run, the buffer
 * is forced to make sure the data is actually written to the disk.
 *
 * <b>This code does NOT WORK properly!</b>
 * Exception in thread "main" java.nio.file.FileSystemException: files.io\roots.dat:
 * Процесс не может получить доступ к файлу, так как этот файл занят другим процессом.
 */
public class SecureDelete {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java SecureDelete filename");
            return;
        }
        File file = new File(args[0]);
        if (file.exists()) {
            SecureRandom random = new SecureRandom();
            try (RandomAccessFile raf = new RandomAccessFile(file, "rw");
                 FileChannel channel = raf.getChannel()) {
                MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, raf.length());
                putAndForce(buffer, 0);
                buffer.rewind();
                putAndForce(buffer, 0xFF);
                buffer.rewind();
                byte[] data = new byte[1];
                while (buffer.hasRemaining()) {
                    random.nextBytes(data);
                    buffer.put(data[0]);
                }
                buffer.force();
            }
            pause(1000L);
            Files.delete(file.toPath());    // java.nio.file.FileSystemException
           /* boolean deleted = file.delete();
            System.out.println(file + (deleted ? " was successfully deleted" : " was not deleted"));*/
        } else {
            System.out.println(file + " does not exist");
        }
    }

    private static void putAndForce(MappedByteBuffer buffer, int value) {
        final byte b = (byte) value;
        while (buffer.hasRemaining()) {
            buffer.put(b);
        }
        buffer.force();
    }

    @SuppressWarnings("SameParameterValue")
    private static void pause(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
