package learn.jionio.ch12fs;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserDefinedFileAttributeView;

/**
 * Associating a Description with a File.
 */
public class UDAVDemo {
    private static final String ATTRIBUTE_NAME = "file.description";

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage: UDAVDemo path w | l | r | d");
            return;
        }
        Path path = Paths.get(args[0]);
        UserDefinedFileAttributeView attrView = Files.getFileAttributeView(path, UserDefinedFileAttributeView.class);
        switch (args[1].charAt(0)) {
            case 'W': case 'w':
                attrView.write(ATTRIBUTE_NAME, Charset.defaultCharset().encode("sample"));
                break;
            case 'L': case 'l':
                for (String name : attrView.list()) {
                    System.out.println(name);
                }
                break;
            case 'R': case 'r':
                int size = attrView.size(ATTRIBUTE_NAME);
                ByteBuffer buf = ByteBuffer.allocateDirect(size);
                attrView.read(ATTRIBUTE_NAME, buf);
                buf.flip();
                System.out.println(Charset.defaultCharset().decode(buf));
                break;
            case 'D': case 'd':
                attrView.delete(ATTRIBUTE_NAME);
                break;
        }
    }
}
