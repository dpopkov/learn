package learn.dsai.ch07advsort;

public class QuickSort3App {
    public static void main(String[] args) {
        int maxSize = 16;
        ArrayQ3SortTb arr = new ArrayQ3SortTb(maxSize);
        while (arr.isNotFull()) {
            arr.insert((long) (Math.random() * 100));
        }
        arr.display();
        arr.sort();
        arr.display();
    }
}
