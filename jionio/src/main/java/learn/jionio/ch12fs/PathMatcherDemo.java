package learn.jionio.ch12fs;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;

/**
 * Demonstrating Path-Matching.
 * syntax: glob | regex
 * Example of arguments: "regex:([^\s]+(\.(?i)(png|jpg))$)" figure1.jpg
 */
public class PathMatcherDemo {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java PathMatcherDemo syntax:pattern path");
            return;
        }
        FileSystem fsDefault = FileSystems.getDefault();
        PathMatcher matcher = fsDefault.getPathMatcher(args[0]);
        Path path = fsDefault.getPath(args[1]);
        String result = matcher.matches(path) ? "%s matches pattern" : "%s doesn't match pattern";
        System.out.printf(result, path);
    }
}
