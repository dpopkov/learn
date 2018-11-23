package learn.dsai.ch05.adt.sorted;

public class SortedListApp {
    public static void main(String[] args) {
        SortedList list = new SortedList();
        list.insert(20);
        list.insert(40);
        list.display();
        list.insert(10);
        list.insert(30);
        list.insert(50);
        list.display();
        list.remove();
        list.display();
    }
}
