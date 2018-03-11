package com.journaldev.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadPool {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Needs 2 parameters: numberOfThreads and numberOfWorkers");
            return;
        }
        int numThreads = Integer.parseInt(args[0]);
        int numWorkers = Integer.parseInt(args[1]);
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        for (int i = 1; i <= numWorkers; i++) {
            Runnable worker = new WorkerThread("" + i);
            executorService.execute(worker);
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            // empty loop body
        }
        System.out.println("Finished all threads.");
    }
}
