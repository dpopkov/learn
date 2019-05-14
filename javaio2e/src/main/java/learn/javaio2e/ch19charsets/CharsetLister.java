package learn.javaio2e.ch19charsets;

import java.nio.charset.Charset;
import java.util.SortedMap;

/**
 * List available character sets.
 */
public class CharsetLister {
    public static void main(String[] args) {
        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        charsets.keySet().forEach(System.out::println);
    }
}
