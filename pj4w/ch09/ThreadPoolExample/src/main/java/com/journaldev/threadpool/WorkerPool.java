package com.journaldev.threadpool;

import java.util.concurrent.*;

public class WorkerPool {
    public static void main(String[] args) throws InterruptedException {
        RejectedExecutionHandler rejectedHandler = new RejectedExecutionHandlerImpl();

        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2, 4, 10,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), threadFactory, rejectedHandler);

        MyMonitorThread monitor = new MyMonitorThread(executorPool, 3);
        Thread monitorThread = new Thread(monitor);
        monitorThread.start();

        for (int i = 1; i <= 10; i++) {
            executorPool.execute(new WorkerThread("cmd" + i));
        }

        Thread.sleep(30_000);
        executorPool.shutdown();

        Thread.sleep(5_000);
        monitor.shutdown();
    }
}
