package learn.dsai.ch03sorting;

import java.util.Comparator;

public class ArrayInOb<E> {
    private final E[] a;
    private int nElems;

    @SuppressWarnings("unchecked")
    public ArrayInOb(int max) {
        a = (E[]) new Object[max];
        nElems = 0;
    }

    public void insert(E element) {
        a[nElems++] = element;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.println(a[i]);
        }
    }

    public void insertionSort(Comparator<E> comp) {
        for (int m = 1; m < nElems; m++) {
            E current = a[m];
            int i = m;
            while (i > 0 && comp.compare(current, a[i - 1]) < 0) {
                a[i] = a[i - 1];
                i--;
            }
            a[i] = current;
        }
    }
}
