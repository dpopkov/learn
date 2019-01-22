package learn.dsai.ch10tree234.projects;

import learn.dsai.ch10tree234.Node;
import learn.dsai.ch10tree234.Tree234;

public class P1001MinValue extends Tree234 {
    /**
     * Gets the minimum value in the tree.
     * @return minimum value
     */
    public long minValue() {
        Node current = root;
        Node next = current.getNode(0);
        while (next != null) {
            current = next;
            next = current.getNode(0);
        }
        return current.getItem(0).getData();
    }
}
