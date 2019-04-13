package learn.javaio2e.ch08data;

import java.io.*;

public class File1000 {
    public static void main(String[] args) {
        try (DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream("1000.data")))) {
            for (int i = 1; i <= 1000; i++) {
                out.writeInt(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
