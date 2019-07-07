package learn.dsajg6e.ch06stacks.exer;

import learn.dsajg6e.ch06stacks.Stack;

public class C0620 {
    /** Moves elements from source below elements in dest. */
    <E> void pushBelow(Stack<E> source, Stack<E> dest, Stack<E> tmp) {
        int lenDest = dest.size();
        int lenSource = source.size();
        transferAll(dest, tmp);
        transferAll(source, tmp);
        transfer(tmp, dest, lenSource);
        transfer(tmp, dest, lenDest);
    }

    private <E> void transferAll(Stack<E> source, Stack<E> target) {
        while (!source.isEmpty()) {
            target.push(source.pop());
        }
    }

    private <E> void transfer(Stack<E> source, Stack<E> target, int count) {
        for (int i = 0; i < count; i++) {
            target.push(source.pop());
        }
    }
}
