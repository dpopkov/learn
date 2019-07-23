package learn.dsajg6e.ch07list.proj;

import learn.dsajg6e.tools.Input;
import learn.dsajg6e.tools.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntConsumer;

public class P0758AddToArrayList {
    private final int dataSize;
    private List<Integer> list;

    public P0758AddToArrayList(int dataSize) {
        this.dataSize = dataSize;
    }

    public static void main(String[] args) {
        int dataSize = inputDataSize(args);
        P0758AddToArrayList runner = new P0758AddToArrayList(dataSize);
        runner.runTest("Adding at the front", runner::addFront);
        runner.runTest("Adding at the middle", runner::addMiddle);
        runner.runTest("Adding at the back", runner::addBack);
    }

    private static int inputDataSize(String[] args) {
        if (args.length == 1) {
            return Integer.parseInt(args[0]);
        } else {
            return Input.nextInt("Enter size of data: ");
        }
    }

    private void addFront(int value) {
        list.add(0, value);
    }

    private void addMiddle(int value) {
        list.add(list.size() / 2, value);
    }

    private void addBack(int value) {
        list.add(list.size(), value);
    }

    private void runTest(String title, IntConsumer addMethod) {
        list = new ArrayList<>();
        StopWatch sw = new StopWatch();
        sw.start();
        for (int i = 0; i < dataSize; i++) {
            addMethod.accept(i);
        }
        sw.stop();
        System.out.printf("%25s. Elapsed: %d%n", title, sw.getElapsed());
    }
}

/*
Results:
--------

Enter size of data: 65536
      Adding at the front. Elapsed: 219
     Adding at the middle. Elapsed: 107
       Adding at the back. Elapsed: 4

Enter size of data: 131072
      Adding at the front. Elapsed: 1043
     Adding at the middle. Elapsed: 433
       Adding at the back. Elapsed: 7

Enter size of data: 262144
      Adding at the front. Elapsed: 4558
     Adding at the middle. Elapsed: 2083
       Adding at the back. Elapsed: 11
 */