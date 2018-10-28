package learn.ijpds.ch17io.exercises;

import java.io.*;

public class E1712CombineFiles {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Usage: java " + E1712CombineFiles.class.getName() +
                    " source_file1 source_file2 ... source_fileN" );
            System.exit(1);
        }
        combineFiles(args);
    }

    public static void combineFiles(String[] paths) throws IOException {
        String destinationPath = inferDestination(paths[0]);
        File file = new File(destinationPath);
        if (file.exists()) {
            throw new IOException("Destination file exists: " + destinationPath);
        }
        byte[] buffer = new byte[4 * 1024];
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file))) {
            for (String path : paths) {
                try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(path))) {
                    int numBytes;
                    while ((numBytes = input.read(buffer)) != -1) {
                        out.write(buffer, 0, numBytes);
                    }
                }
            }
        }
    }

    private static String inferDestination(String path) {
        int suffixPos = path.lastIndexOf(".");
        String numberPart = path.substring(suffixPos + 1);
        try {
            Integer.parseInt(numberPart);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Path does not contain starting number: " + path);
        }
        return path.substring(0, suffixPos);
    }
}
