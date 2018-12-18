package learn.dsai.ch08trees;

public class TreeLongApp {
    public static void main(String[] args) {
        TreeLong tree = new TreeLong();
        tree.insert(50);
        tree.insert(25);
        tree.insert(75);
        NodeLong found = tree.find(25);
        if (found != null) {
            System.out.println("Found the node with key 25");
        } else {
            System.out.println("could not find node with key 25");
        }
    }
}
