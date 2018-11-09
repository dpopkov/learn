package learn.dsai.ch02arrays.array3;

public class OrdArrayApp {
    public static void main(String[] args) {
        int maxSize = 100;
        OrdArray arr = new OrdArray(maxSize);

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

        int key = 55;
        if (arr.find(key) < 0) {
            System.out.println("Can't find " + key);
        } else {
            System.out.println("Found " + key);
        }

        arr.delete(0);
        arr.delete(55);
        arr.delete(99);
        arr.display();
    }
}
