package learn.core2.ch10sec.loaders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class loader loads class files without any decryption or decoding.
 */
public class SimpleClassLoader  extends BaseClassLoader {
    /**
     * Loads the class file bytes.
     *
     * @param className the class name
     * @return an array with the class file bytes
     */
    protected byte[] loadClassBytes(String className) throws IOException {
        String classPath = className.replace('.', '/');
        if (!classPath.endsWith(".class")) {
            classPath += ".class";
        }
        return Files.readAllBytes(Paths.get(classPath));
    }
}
