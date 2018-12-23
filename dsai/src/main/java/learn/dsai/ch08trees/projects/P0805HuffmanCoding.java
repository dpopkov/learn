package learn.dsai.ch08trees.projects;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class P0805HuffmanCoding {

    public static void main(String[] args) throws IOException {
        String message = acceptMessage(args);
        HuffmanTree tree = new HuffmanTree(message);
        String encoded = tree.encode(message);
        System.out.println("encoded = " + encoded);
        System.out.println("decoded = " + tree.decode(encoded));
    }

    private static String acceptMessage(String[] args) throws IOException {
        String message = null;
        if (args.length == 0) {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter message: ");
            message = in.nextLine();
            in.close();
        } else if (args.length == 1) {
            message = args[0];
        } else if ("--file".equals(args[0])) {
            Path p = Paths.get(args[1]);
            message = new String(Files.readAllBytes(p));
        } else {
            System.out.println("Invalid arguments");
            System.exit(1);
        }
        return message;
    }
}
