package learn.ijpds.ch20collections;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("Oklahoma");
        queue.offer("Indiana");
        queue.offer("Georgia");
        queue.offer("Texas");
        while (queue.size() > 0) {
            System.out.print(queue.poll() + " ");
        }
    }
}
