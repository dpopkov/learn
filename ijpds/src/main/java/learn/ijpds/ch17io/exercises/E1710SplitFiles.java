package learn.ijpds.ch17io.exercises;

import java.io.*;

public class E1710SplitFiles {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Usage: java " + E1710SplitFiles.class.getName() + " sourceFile numberOfPieces");
            System.exit(1);
        }
        String sourcePath = args[0];
        int numberOfPieces = -1;
        try {
            numberOfPieces = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Enter number of pieces as natural number.");
            System.exit(2);
        }
        splitFile(sourcePath, numberOfPieces);
    }

    public static void splitFile(String sourcePath, int numberOfPieces) throws IOException {
        final File sourceFile = new File(sourcePath);
        if (!sourceFile.exists()) {
            System.out.println("File does not exist: " + sourceFile.getCanonicalPath() );
            return;
        }
        final int blockSize = 4 * 1024;
        final int numBlocks = (int) Math.ceil((double)sourceFile.length() / blockSize);
        final int blocksInPiece = (int) (Math.ceil((double) numBlocks / numberOfPieces));
        final byte[] buffer = new byte[blockSize];
        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourceFile))) {
            for (int piece = 1; piece <= numberOfPieces; piece++) {
                String piecePath = String.format("%s.%03d", sourcePath, piece);
                try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(piecePath))) {
                    int numRead;
                    for (int block = 0; block < blocksInPiece; block++) {
                        numRead = input.read(buffer);
                        if (numRead != -1) {
                            out.write(buffer, 0, numRead);
                        }
                    }
                }
                System.out.println("Piece: " + piecePath);
            }
        }
    }
}
