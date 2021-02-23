package learn.core2.ch10sec.loaders;

import java.io.IOException;

/**
 * This abstract class loader must be extended.
 * Method loadClassBytes must be implemented.
 */
public abstract class BaseClassLoader extends ClassLoader {

    public Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] classBytes = loadClassBytes(name);
            Class<?> clazz = defineClass(name, classBytes, 0, classBytes.length);
            if (clazz == null) {
                throw new ClassNotFoundException(name);
            }
            return clazz;
        } catch (IOException e) {
            throw new ClassNotFoundException(name);
        }
    }

    /**
     * Loads the class file bytes.
     *
     * @param className the class name
     * @return an array with the class file bytes
     */
    protected abstract byte[] loadClassBytes(String className) throws IOException;
}
