package learn.dsai.ch07advsort;

public class QuickSortApp {
    public static void main(String[] args) {
        int maxSize = 16;
        ArrayQSort arr = new ArrayQSort(maxSize);
        while (arr.isNotFull()) {
            arr.insert((long) (Math.random() * 100));
        }
        arr.display();
        arr.sort();
        arr.display();
    }
}
