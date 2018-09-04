package learn.csia.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class NumberUtils {
    /**
     * Gets maximum value for specified whole type.
     * @param wrapperTypeName name of wrapper class of whole number type (Byte, Short, Integer, or Long)
     * @return maximum value
     * @throws ReflectiveOperationException
     */
    public static long getMaxValueFor(String wrapperTypeName) throws ReflectiveOperationException {
        Class cl = Class.forName("java.lang." + wrapperTypeName);
        Constructor constructor = cl.getConstructor(String.class);
        Object obj = constructor.newInstance("1");
        Field f = cl.getDeclaredField("MAX_VALUE");
        return f.getLong(obj);
    }
}
