package learn.dsai.ch03sorting;

public class BubbleSortApp {
    public static void main(String[] args) {
        ArrayBub arr = new ArrayBub(10);
        arr.insert(99);
        arr.insert(77);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(0);
        arr.insert(66);
        arr.insert(33);
        arr.display();

        arr.bubbleSort();
        arr.display();
    }
}
