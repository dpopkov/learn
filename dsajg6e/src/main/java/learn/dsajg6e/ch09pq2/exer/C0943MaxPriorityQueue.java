package learn.dsajg6e.ch09pq2.exer;

import learn.dsajg6e.ch06stacks.LinkedStack;
import learn.dsajg6e.ch06stacks.Stack;
import learn.dsajg6e.ch09pq2.HeapPriorityQueue;
import learn.dsajg6e.ch09pq2.PriorityQueue;

/**
 * C-9.43
 * Implementation of max priority queue that uses min priority queue.
 */
public class C0943MaxPriorityQueue<K extends Comparable<K>> {
    private final PriorityQueue<K, Void> minPriorityQueue = new HeapPriorityQueue<>();
    private final Stack<K> stack = new LinkedStack<>();

    public void insert(K key) {
        minPriorityQueue.insert(key, null);
    }

    public K max() {
        if (isEmpty()) {
            return null;
        }
        ensureStackIsLoaded();
        return stack.top();
    }

    private void ensureStackIsLoaded() {
        if (stack.isEmpty()) {
            fillStack();
        } else if (minPriorityQueue.size() > 0) {
            insertToStack();
        }
    }

    private void insertToStack() {
        Stack<K> temp = null;
        while (!minPriorityQueue.isEmpty()) {
            K key = minPriorityQueue.removeMin().getKey();
            if (key.compareTo(stack.top()) >= 0) {
                stack.push(key);
            } else {
                if (temp == null) {
                    temp = new LinkedStack<>();
                }
                while (!stack.isEmpty() && key.compareTo(stack.top()) < 0) {
                    temp.push(stack.pop());
                }
                stack.push(key);
                while (!temp.isEmpty()) {
                    stack.push(temp.pop());
                }
            }
        }
    }

    private void fillStack() {
        while (!minPriorityQueue.isEmpty()) {
            stack.push(minPriorityQueue.removeMin().getKey());
        }
    }

    public K removeMax() {
        if (isEmpty()) {
            return null;
        }
        ensureStackIsLoaded();
        return stack.pop();
    }

    public boolean isEmpty() {
        return minPriorityQueue.isEmpty() && stack.isEmpty();
    }
}
