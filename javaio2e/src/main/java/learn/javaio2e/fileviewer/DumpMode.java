package learn.javaio2e.fileviewer;

enum DumpMode {
    ASC, DEC, HEX;

    public static DumpMode from(String param) {
        DumpMode mode;
        switch (param) {
            case "-h":
                mode = DumpMode.HEX;
                break;
            case "-d":
                mode = DumpMode.DEC;
                break;
            case "-a":
            default:
                mode = DumpMode.ASC;
                break;
        }
        return mode;
    }
}
