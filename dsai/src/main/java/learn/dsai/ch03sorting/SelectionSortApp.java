package learn.dsai.ch03sorting;

public class SelectionSortApp {
    public static void main(String[] args) {
        ArraySel arr = new ArraySel(10);
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

        arr.selectionSort();
        arr.display();
    }
}
