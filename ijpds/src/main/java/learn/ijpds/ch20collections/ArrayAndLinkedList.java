/* 20.4 */
package learn.ijpds.ch20collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ArrayAndLinkedList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(0, 10);
        list.add(3, 30);
        System.out.println("A list of integers in the array list:");
        System.out.println(list);

        LinkedList<Object> linked = new LinkedList<>(list);
        linked.add(1, "red");
        linked.removeLast();
        linked.addFirst("green");
        System.out.println("Display the linked list forward:");
        ListIterator<Object> it = linked.listIterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        System.out.println("Display the linked list backward:");
        it = linked.listIterator(linked.size());
        while (it.hasPrevious()) {
            System.out.print(it.previous() + " ");
        }
    }
}
