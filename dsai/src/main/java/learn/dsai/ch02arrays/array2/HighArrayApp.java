package learn.dsai.ch02arrays.array2;

public class HighArrayApp {
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

        int key = 35;
        if (arr.find(key)) {
            System.out.println("Found " + key);
        } else {
            System.out.println("Can't find " + key);
        }

        arr.delete(0);
        arr.delete(55);
        arr.delete(99);
        arr.display();
    }
}
