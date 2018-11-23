package learn.dsai.ch05.doubleend;

public class FirstLastApp {
    public static void main(String[] args) {
        FirstLastList list = new FirstLastList();
        list.insertFirst(22);
        list.insertFirst(44);
        list.insertFirst(66);
        list.insertLast(11);
        list.insertLast(33);
        list.insertLast(55);
        System.out.println(list);

        list.deleteFirst();
        list.deleteFirst();
        System.out.println(list);
    }
}
