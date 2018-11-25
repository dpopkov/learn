package learn.dsai.ch05.iterators;

import learn.dsai.ch05.doubly.DoublyLinkedList;

public class ListIteratorDeleteApp {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        ListIterator it1 = list.getIterator();

        it1.insertAfter(21);
        it1.insertAfter(40);
        it1.insertAfter(30);
        it1.insertAfter(7);
        it1.insertAfter(45);
        list.displayForward();

        it1.reset();
        boolean lastDone = false;
        while (!lastDone) {
            lastDone = it1.atEnd();
            long data = it1.getCurrent().data;
            if (data % 3 == 0) {
                it1.deleteCurrent();
            } else {
                it1.nextLink();
            }
        }
        list.displayForward();
    }

}
