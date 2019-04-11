package learn.javaio2e.fileviewer;

import learn.javaio2e.ch03in.StreamCopier;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumMap;

/**
 * Reads a series of filenames from the command line.
 * The file's data is read and printed on System.out. A command line switch determines how the data is printed.<br>
 * -a   text format (Latin-1)<br>
 * -d   decimal dump<br>
 * -h   hex dump<br>
 */
public class FileDumper {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java FileDumper [-ahd] file1 file2...");
            return;
        }
        int firstArg = 0;
        DumpMode mode = DumpMode.ASC;
        if (args[0].startsWith("-")) {
            firstArg = 1;
            mode = DumpMode.from(args[0]);
        }
        FileDumper dumper = new FileDumper(mode);
        for (int i = firstArg; i < args.length; i++) {
            Path path = Paths.get(args[i]);
            try {
                dumper.dump(path, System.out);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (i < args.length - 1) {
                System.out.println(System.lineSeparator()
                        + "----------------------------------------------------" + System.lineSeparator());
            }
        }
    }

    interface PathStreamConsumer {
        void accept(Path path, PrintStream printStream) throws IOException;
    }

    private final EnumMap<DumpMode, PathStreamConsumer> dumpActions = new EnumMap<>(DumpMode.class);
    {
        dumpActions.put(DumpMode.ASC, this::dumpAscii);
        dumpActions.put(DumpMode.DEC, this::dumpDecimal);
        dumpActions.put(DumpMode.HEX, this::dumpHex);
    }

    private DumpMode mode;

    public FileDumper() {
        this(DumpMode.ASC);
    }

    public FileDumper(DumpMode mode) {
        this.mode = mode;
    }

    public void dump(Path path, PrintStream out) throws IOException {
        PathStreamConsumer action = dumpActions.get(mode);
        action.accept(path, out);
    }

    void dumpAscii(Path path, OutputStream out) throws IOException {
        try (InputStream in = new BufferedInputStream(Files.newInputStream(path))) {
            StreamCopier.copy(in, out);
        }
    }

    void dumpDecimal(Path path, PrintStream out) throws IOException {
        byte[] buffer = new byte[16];
        Flag reading = new Flag(true);
        try (InputStream in = new BufferedInputStream(Files.newInputStream(path))) {
            while (reading.isOn()) {
                int bytesRead = fill(buffer, in, reading);
                for (int i = 0; i < bytesRead; i++) {
                    int dec = buffer[i];
                    dec = (dec < 0) ? 256 + dec : dec;
                    out.printf("%03d ", dec);
                }
                out.println();
            }
        }
    }

    void dumpHex(Path path, PrintStream out) throws IOException {
        byte[] buffer = new byte[24];
        Flag reading = new Flag(true);
        try (InputStream in = new BufferedInputStream(Files.newInputStream(path))) {
            while (reading.isOn()) {
                int bytesRead = fill(buffer, in, reading);
                for (int i = 0; i < bytesRead; i++) {
                    int hex = buffer[i];
                    hex = (hex < 0) ? 256 + hex : hex;
                    if (hex >= 16) {
                        out.print(Integer.toHexString(hex) + " ");
                    } else {
                        out.print("0" + Integer.toHexString(hex) + " ");
                    }
                }
                out.println();
            }
        }
    }

    private int fill(byte[] buffer, InputStream from, Flag flag) throws IOException {
        int bytesRead = 0;
        while (bytesRead < buffer.length) {
            int r = from.read(buffer, bytesRead, buffer.length - bytesRead);
            if (r == -1) {
                flag.off();
                break;
            }
            bytesRead += r;
        }
        return bytesRead;
    }

    private static class Flag {
        private boolean value;

        public Flag(boolean value) {
            this.value = value;
        }

        void off() {
            value = false;
        }

        boolean isOn() {
            return value;
        }
    }
}
