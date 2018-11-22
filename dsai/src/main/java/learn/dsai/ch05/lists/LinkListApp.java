package learn.dsai.ch05.lists;

public class LinkListApp {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.insertFirst(22, 2.99);
        list.insertFirst(44, 4.99);
        list.insertFirst(66, 6.99);
        list.insertFirst(88, 8.99);
        list.display();

        Link link = list.find(44);
        if (link != null) {
            System.out.println("Found link with key " + link.iData);
        } else {
            System.out.println("Can't find link");
        }

        link = list.delete(66);
        if (link != null) {
            System.out.println("Deleted link with key " + link.iData);
        } else {
            System.out.println("Can't delete link");
        }
        list.display();

        while (!list.isEmpty()) {
            link = list.deleteFirst();
            System.out.println("Deleted " + link);
        }
        list.display();
    }
}
