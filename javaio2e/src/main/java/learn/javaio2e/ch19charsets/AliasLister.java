package learn.javaio2e.ch19charsets;

import java.nio.charset.Charset;
import java.util.SortedMap;

/**
 * List different names for character sets.
 */
public class AliasLister {
    public static void main(String[] args) {
        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        for (Charset charset : charsets.values()) {
            System.out.print(charset.displayName());
            if (charset.isRegistered()) {
                System.out.print(" (registered): ");
            } else {
                System.out.print(" (unregistered): ");
            }
            System.out.print(charset.name());
            for (String alias : charset.aliases()) {
                System.out.print(", ");
                System.out.print(alias);
            }
            System.out.println();
        }
    }
}
