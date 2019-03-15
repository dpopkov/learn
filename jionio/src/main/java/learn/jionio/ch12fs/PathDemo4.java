package learn.jionio.ch12fs;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo4 {
    public static void main(String[] args) throws IOException {
        Path p1 = Paths.get("a", "b", "c");
        Path p2 = Paths.get("a", "b", "c", "d");
        System.out.printf("p1: %s%n", p1);
        System.out.printf("p2: %s%n", p2);
        System.out.printf("p1.equals(p2): %b%n", p1.equals(p2));
        System.out.printf("p1.equals(p2.subpath(0, 3)): %b%n", p1.equals(p2.subpath(0, 3)));
        System.out.println("p1.compareTo(p2) = " + p1.compareTo(p2));
        System.out.println("p1.startsWith(\"x\") = " + p1.startsWith("x"));
        System.out.println("p1.startsWith(Paths.get(\"a\")) = " + p1.startsWith(Paths.get("a")));
        System.out.println("p2.endsWith(\"d\") = " + p2.endsWith("d"));
        System.out.println("p2.endsWith(Paths.get(\"c\", \"d\")) = " + p2.endsWith(Paths.get("c", "d")));
        System.out.println("p2.toUri() = " + p2.toUri());
        Path p3 = Paths.get(".");
        System.out.println("p3.toString() = " + p3.toString());
        System.out.println("p3.toRealPath() = " + p3.toRealPath());
    }
}
