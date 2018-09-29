/* 2-25. Implementing the callback mechanism using anonymous classes. */
package learn.jlf2e.ch02inner;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Convert2Lambda")
public class CallableDemo {
    private final List<Callable> callables = new ArrayList<>();

    private void register(Callable c) {
        callables.add(c);
    }

    private void callback() {
        for (Callable c : callables) {
            c.call();
        }
    }

    public static void main(String[] args) {
        CallableDemo demo = new CallableDemo();
        demo.register(new Callable() {
            @Override
            public void call() {
                System.out.println("Called #1");
            }
        });
        demo.register(new Callable() {
            @Override
            public void call() {
                System.out.println("Called #2");
            }
        });
        demo.register(new Callable() {
            @Override
            public void call() {
                System.out.println("Called #3");
            }
        });
        demo.callback();
    }
}
