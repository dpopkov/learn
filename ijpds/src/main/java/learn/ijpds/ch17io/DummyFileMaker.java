package learn.ijpds.ch17io;

import java.io.*;
import java.util.Arrays;

public class DummyFileMaker {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Usage: java " + DummyFileMaker.class.getName() + " filename size(nnnK, nnnM)");
            System.exit(1);
        }
        File file = new File(args[0]);
        String sizeArg = args[1];
        int numKilobytes = convertSize(sizeArg);
        if (file.exists()) {
            System.out.println("File " + args[0] + " already exists.");
            System.exit(2);
        }
        byte[] block = new byte[1024];
        Arrays.fill(block, (byte)65);
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file))) {
            for (int i = 0; i < numKilobytes; i++) {
                out.write(block);
            }
        }
    }

    private static int convertSize(String sizeArg) {
        int numKilobytes;
        if (sizeArg.endsWith("M")) {
            int numMb = Integer.parseInt(sizeArg.substring(0, sizeArg.length() - 1));
            numKilobytes = numMb * 1024;
        } else if (sizeArg.endsWith("K")) {
            numKilobytes = Integer.parseInt(sizeArg.substring(0, sizeArg.length() - 1));
        } else {
            numKilobytes = Integer.parseInt(sizeArg);
        }
        return numKilobytes;
    }
}
