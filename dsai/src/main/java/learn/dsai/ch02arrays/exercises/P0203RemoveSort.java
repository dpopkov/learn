package learn.dsai.ch02arrays.exercises;

import learn.dsai.ch02arrays.array2.HighArray;

public class P0203RemoveSort {
    public static void main(String[] args) {
        HighArray arr = new HighArray(10);
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(0);
        arr.insert(66);
        arr.insert(33);
        arr.display();

        HighArray sorted = new HighArray(10);
        while (arr.getSize() > 0) {
            sorted.insert(arr.removeMax());
        }
        sorted.display();
    }
}
