package learn.dsajg6e.ch06stacks;

/**
 * Computes the winner of the Josephus problem using a circular queue.
 */
public class JosephusProblem {
    static <E> E computeWinner(CircularQueue<E> queue, int k) {
        if (queue.isEmpty()) {
            return null;
        }
        while (queue.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                queue.rotate();
            }
            E e = queue.dequeue();
            System.out.println("      " + e + " is out");
        }
        return queue.dequeue();
    }

    static <E> CircularQueue<E> buildQueue(E[] array) {
        CircularQueue<E> queue = new LinkedCircularQueue<>();
        for (E element : array) {
            queue.enqueue(element);
        }
        return queue;
    }

    public static void main(String[] args) {
        String[] a1 = {"Alice", "Bob", "Cindy", "Doug", "Ed", "Fred"};
        String[] a2 = {"Gene", "Hope", "Irene", "Jack", "Kim", "Lance"};
        String[] a3 = {"Mike", "Roberto"};
        System.out.println("First winner is " + computeWinner(buildQueue(a1), 3));
        System.out.println("Second winner is " + computeWinner(buildQueue(a2), 10));
        System.out.println("Third winner is " + computeWinner(buildQueue(a3), 7));
    }
}
