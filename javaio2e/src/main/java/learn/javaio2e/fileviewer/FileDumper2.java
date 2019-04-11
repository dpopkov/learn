package learn.javaio2e.fileviewer;

import learn.javaio2e.ch03in.StreamCopier;

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
 */
public class FileDumper2 {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java FileDumper2 [-ahd] file1 file2...");
            return;
        }
        int firstArg = 0;
        DumpMode mode = DumpMode.ASC;
        if (args[0].startsWith("-")) {
            firstArg = 1;
            mode = DumpMode.from(args[0]);
        }
        FileDumper2 dumper = new FileDumper2(mode);
        for (int i = firstArg; i < args.length; i++) {
            Path path = Paths.get(args[i]);
            try (InputStream in = new BufferedInputStream(Files.newInputStream(path))) {
                dumper.dump(in, System.out);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (i < args.length - 1) {
                System.out.println(System.lineSeparator()
                        + "----------------------------------------------------" + System.lineSeparator());
            }
        }
    }

    private final DumpMode mode;

    public FileDumper2(DumpMode mode) {
        this.mode = mode;
    }

    public void dump(InputStream in, OutputStream out) throws IOException {
        if (mode == DumpMode.HEX) {
            in = new HexFilter(in);
        } else if (mode == DumpMode.DEC) {
            in = new DecimalFilter(in);
        }
        StreamCopier.copy(in, out);
    }
}
