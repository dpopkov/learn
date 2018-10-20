package learn.ijpds.tools;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Contains methods for text files processing.
 */
public class Text {
    /**
     * Reads content of a text file as one string in UTF-8 charset.
     * @param path path to file
     * @return content of file
     */
    public static String readFile(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
    }
}
