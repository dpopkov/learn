package learn.javaio2e.fileviewer;

import java.util.Map;

enum DumpMode {
    ASC, DEC, HEX, SHORT, INT, LONG, FLOAT, DOUBLE;

    private final static Map<String, DumpMode> map = Map.of(
            "a", ASC,
            "d", DEC,
            "h", HEX,
            "s", SHORT,
            "i", INT,
            "l", LONG,
            "f", FLOAT,
            "x", DOUBLE
    );

    public static DumpMode from(String shortName) {
        return map.get(shortName);
    }
}
