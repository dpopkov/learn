package learn.javaio2e.fileviewer;

import learn.javaio2e.ch03in.StreamCopier;
import learn.javaio2e.fileviewer.filters.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Reads a series of filenames from the command line.
 * The file's data is read and printed on System.out. A command line switch determines how the data is printed.<br>
 * -a   text format (Latin-1)<br>
 * -d   decimal dump<br>
 * -h   hex dump<br>
 * -s   short dump<br>
 * -i   integer dump<br>
 * -l   long dump<br>
 * -f   float dump<br>
 * -x   double dump<br>
 * -little   little endian<br>
 */
public class FileDumper3 {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java FileDumper3 [-ahdsilfx] [-little] file1 file2...");
            return;
        }
        boolean bigEndian = true;
        DumpMode mode = DumpMode.ASC;
        int firstFile;
        for (firstFile = 0; firstFile < args.length; firstFile++) {
            String argument = args[firstFile];
            if (!argument.startsWith("-")) {
                break;
            } else if (argument.equals("-little")) {
                bigEndian = false;
            } else {
                mode = DumpMode.from(argument.substring(1));
            }
        }
        FileDumper3 dumper = new FileDumper3(mode, bigEndian);
        dumper.dumpFiles(args, firstFile, System.out);
    }

    private final DumpMode mode;
    private final boolean bigEndian;

    public FileDumper3(DumpMode mode, boolean bigEndian) {
        this.mode = mode;
        this.bigEndian = bigEndian;
    }

    public void dumpFiles(String[] paths, int start, PrintStream out) {
        for (int i = start; i < paths.length; i++) {
            Path path = Paths.get(paths[i]);
            try (InputStream in = new BufferedInputStream(Files.newInputStream(path))) {
                dump(in, out);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (i < paths.length - 1) {
                printHorizontalLine();
            }
        }
    }

    public void dump(InputStream in, OutputStream out) throws IOException {
        if (bigEndian) {
            if (mode == DumpMode.HEX) {
                in = new HexFilter(in);
            } else if (mode == DumpMode.DEC) {
                in = new DecimalFilter(in);
            } else if (mode == DumpMode.SHORT) {
                in = new ShortFilter(new DataInputStream(in));
            } else if (mode == DumpMode.INT) {
                in = new IntFilter(new DataInputStream(in));
            } else if (mode == DumpMode.LONG) {
                in = new LongFilter(new DataInputStream(in));
            } else {
                throw new UnsupportedOperationException("This mode is not implemented yet: " + mode);
            }
        } else {
            throw new UnsupportedOperationException("Little Endian is not implemented yet");
        }
        StreamCopier.copy(in, out);
    }

    private static void printHorizontalLine() {
        System.out.println(System.lineSeparator()
                + "----------------------------------------------------" + System.lineSeparator());
    }
}
