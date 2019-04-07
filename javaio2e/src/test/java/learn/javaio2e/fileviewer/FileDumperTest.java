package learn.javaio2e.fileviewer;

import com.google.common.jimfs.Configuration;
import com.google.common.jimfs.Jimfs;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class FileDumperTest {
    private static final String NL = System.lineSeparator();

    @Test
    public void testDumpAscii() throws IOException {
        Path file = createFile("test string");
        OutputStream out = new ByteArrayOutputStream();
        FileDumper dumper = new FileDumper();
        dumper.dumpAscii(file, out);
        assertThat(out.toString(), is("test string"));
    }

    @Test
    public void testDumpDecimal() throws IOException {
        Path file = createFile(new byte[]{1, 22, 127});
        OutputStream out = new ByteArrayOutputStream();
        FileDumper dumper = new FileDumper();
        dumper.dumpDecimal(file, new PrintStream(out));
        assertThat(out.toString(), is("001 022 127 " + NL));
    }

    @Test
    public void testDumpHex() throws IOException {
        Path file = createFile(new byte[]{1, 0x16, 0x7F});
        OutputStream out = new ByteArrayOutputStream();
        FileDumper dumper = new FileDumper();
        dumper.dumpHex(file, new PrintStream(out));
        assertThat(out.toString(), is("01 16 7f " + NL));
    }

    private Path createFile(String content) throws IOException {
        Path file = createTestDir().resolve("testFile");
        Files.writeString(file, content);
        return file;
    }

    private Path createFile(byte[] data) throws IOException {
        Path file = createTestDir().resolve("testFile");
        Files.write(file, data);
        return file;
    }

    private Path createTestDir() throws IOException {
        Path testDir = Jimfs.newFileSystem(Configuration.unix()).getPath("testDir");
        Files.createDirectory(testDir);
        return testDir;
    }
}