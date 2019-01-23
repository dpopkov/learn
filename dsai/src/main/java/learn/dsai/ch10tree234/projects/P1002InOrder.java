package learn.dsai.ch10tree234.projects;

import learn.dsai.ch10tree234.DataItem;
import learn.dsai.ch10tree234.Node;
import learn.dsai.ch10tree234.Tree234;

import java.util.function.Consumer;
import java.util.function.LongConsumer;

public class P1002InOrder extends Tree234 {
    public String toStringInOrder() {
        StringBuilder builder = new StringBuilder();
        inOrder(root, di -> builder.append(di.toString()));
        return builder.toString();
    }

    public void inOrder(LongConsumer consumer) {
        inOrder(root, di -> consumer.accept(di.getData()));
    }

    private void inOrder(Node node, Consumer<DataItem> consumer) {
        int len = node.getNumItems();
        int i;
        Node child;
        for (i = 0; i < len; i++) {
            child = node.getNode(i);
            if (child != null) {
                inOrder(child, consumer);
            }
            consumer.accept(node.getItem(i));
        }
        child = node.getNode(i);
        if (child != null) {
            inOrder(child, consumer);
        }
    }
}
