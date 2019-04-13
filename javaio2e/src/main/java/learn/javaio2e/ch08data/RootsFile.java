package learn.javaio2e.ch08data;

import java.io.*;

public class RootsFile {
    public static void main(String[] args) throws IOException {
        try (DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream("roots.dat")))) {
            for (int i = 0; i <= 1000; i++) {
                out.writeDouble(Math.sqrt(i));
            }
        }
    }
}
