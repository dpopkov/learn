package learn.dsai.ch07advsort;

public class ShellSortApp {
    public static void main(String[] args) {
        final int maxSize = 10;
        ArraySh arr = new ArraySh(maxSize);
        for (int i = 0; i < maxSize; i++) {
            long n = (long) (Math.random() * 100);
            arr.insert(n);
        }
        arr.display();
        arr.sort();
        arr.display();
    }
}
