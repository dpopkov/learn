package learn.javaio2e.ch17files;

import java.io.File;

public class RootLister {
    public static void main(String[] args) {
        File[] roots = File.listRoots();
        if (roots == null) {
            System.out.println("Set of roots could not be determined.");
        } else if (roots.length == 0) {
            System.out.println("There are no file system roots.");
        } else {
            for (File root : roots) {
                System.out.println(root);
            }
        }
    }
}
