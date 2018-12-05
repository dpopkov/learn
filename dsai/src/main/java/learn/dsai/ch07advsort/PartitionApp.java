package learn.dsai.ch07advsort;

public class PartitionApp {
    public static void main(String[] args) {
        final int maxSize = 16;
        ArrayPar arr = new ArrayPar(maxSize);
        for (int j = 0; j < maxSize; j++) {
            long n = (long) (Math.random() * 200);
            arr.insert(n);
        }
        arr.display();
        long pivot = 99;
        System.out.println("pivot = " + pivot);
        int partIdx = arr.partitionIt(0, arr.getSize() - 1, pivot);
        System.out.println("Partition is at index " + partIdx);
        arr.display();
    }
}
