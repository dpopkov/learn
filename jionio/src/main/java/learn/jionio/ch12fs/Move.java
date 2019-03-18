package learn.jionio.ch12fs;

import java.io.IOException;
import java.nio.file.*;

public class Move {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java Move source target");
            return;
        }
        Path source = Paths.get(args[0]);
        Path target = Paths.get(args[1]);
        try {
            Files.move(source, target);
        } catch (FileAlreadyExistsException e) {
            System.err.printf("%s : file already exists%n", target);
        } catch (DirectoryNotEmptyException e) {
            System.err.printf("%s : directory is not empty", target);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
