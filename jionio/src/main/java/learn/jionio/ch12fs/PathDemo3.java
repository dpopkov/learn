package learn.jionio.ch12fs;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo3 {
    public static void main(String[] args) {
        Path path1 = Paths.get("reports", ".", "2015", "jan");
        System.out.println(path1);
        System.out.println(path1.normalize());
        path1 = Paths.get("reports", "2015", "..", "jan");
        System.out.println(path1.normalize());
        System.out.println();
        path1 = Paths.get("reports", "2015", "jan");
        System.out.println(path1);
        System.out.println(path1.relativize(Paths.get("reports", "2016", "mar")));
        try {
            Path root = FileSystems.getDefault().getRootDirectories().iterator().next();
            if (root != null) {
                System.out.printf("Root: %s%n", root.toString());
                Path p = Paths.get(root.toString(), "reports", "2016", "mar");
                System.out.printf("Path: %s%n", p);
                System.out.println(path1.relativize(p));
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        System.out.println();
        path1 = Paths.get("reports", "2015");
        System.out.println(path1);
        System.out.println(path1.resolve("apr"));
        System.out.println();
        Path path2 = Paths.get("reports", "2015", "jan");
        System.out.println(path2);
        System.out.println(path2.getParent());
        System.out.println(path2.resolveSibling(Paths.get("mar")));
        System.out.println(path2.resolve(Paths.get("mar")));
    }
}
