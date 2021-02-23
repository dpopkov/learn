package learn.core2.ch10sec.loaders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class loader loads encrypted with simple 'caesar' cypher class files.
 */
public class CryptoClassLoader extends BaseClassLoader {
    private static final String ENCRYPTED_FILE_EXTENSION = ".caesar";

    private final int key;

    /**
     * Constructs a crypto class loader.
     *
     * @param key the decryption key
     */
    public CryptoClassLoader(int key) {
        this.key = key;
    }

    /**
     * Loads and decrypt the class file bytes.
     *
     * @param className the class name
     * @return an array with the class file bytes
     */
    protected byte[] loadClassBytes(String className) throws IOException {
        String classPath = className.replace('.', '/') + ENCRYPTED_FILE_EXTENSION;
        byte[] bytes = Files.readAllBytes(Paths.get(classPath));
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] - key);
        }
        return bytes;
    }
}
