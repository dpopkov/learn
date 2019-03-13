package learn.jionio.ch02file;

import java.io.File;

public class PartitionSpace {
    public static void main(String[] args) {
        File[] roots = File.listRoots();
        for (File root : roots) {
            System.out.println("Partition: " + root);
            System.out.printf("root.getFreeSpace()   = %14d%n", root.getFreeSpace());
            System.out.printf("root.getUsableSpace() = %14d%n", root.getUsableSpace());
            System.out.printf("root.getTotalSpace()  = %14d%n", root.getTotalSpace());
            System.out.println("***");
        }
    }
}
