package learn.dsai.ch08trees2.projects;

import learn.dsai.ch08trees2.huffman.HuffmanTree;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/*
Program implements Huffman coding and decoding. It does the following:
1. Accepts a text message, possibly of more than one line.
2. Creates a Huffman tree for this message.
3. Creates a code table.
4. Encodes the message info binary.
5. Decodes the message from binary back to text.
 */
public class P0805Huffman {
    public static void main(String[] args) throws IOException {
        String message;
        if (args.length == 1) {
            message = args[0];
        } else if (args.length == 2 && "--file".equals(args[0])) {
            message = readFile(args[1]);
        } else {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter message: ");
            message = in.nextLine();
        }
        HuffmanTree tree = new HuffmanTree(message);
        String encoded = tree.encode(message);
        System.out.println("encoded = " + encoded);
        int encodedLen = encoded.length();
        String decoded = tree.decode(encoded);
        System.out.println("decoded = " + decoded);
        int decodedLen = decoded.length() * 8;
        System.out.println("Encoded length = " + encodedLen);
        System.out.println("Decoded length = " + decodedLen);
        System.out.printf("%.1f%%%n", ((double) encodedLen / decodedLen) * 100);
    }

    private static String readFile(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            throw new IllegalArgumentException("File does not exist: " + path);
        }
        char[] buffer = new char[1024 * 4];
        StringBuilder builder = new StringBuilder();
        try (InputStreamReader isr = new InputStreamReader(
                new BufferedInputStream(new FileInputStream(file)), StandardCharsets.UTF_8)){
            int n;
            while ((n = isr.read(buffer)) != -1) {
                builder.append(buffer, 0, n);
            }
        }
        return builder.toString();
    }
}
