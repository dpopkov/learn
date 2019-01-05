package learn.dsai.ch08trees2;

public class BSTreeApp {
    public static void main(String[] args) {
        BSTree<Integer> tree = new BSTree<>();
        tree.insert(50, 25, 75);
        Integer n = tree.find(25);
        if (n != null) {
            System.out.println("Found the node with key 25");
        } else {
            System.out.println("Could not find node with key 25");
        }
    }
}
