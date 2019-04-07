package learn.javaio2e.ch02out;

/**
 * Writes the printable ASCII characters (32 to 126) on the console.
 */
public class AsciiChart {
    public static void main(String[] args) {
        char linefeed = '\n';
        char tab = '\t';
        for (int i = 32; i < 127; i++) {
            System.out.write(i);
            System.out.write(i % 8 == 7 ? linefeed : tab);
        }
        System.out.write(linefeed);
    }
}
