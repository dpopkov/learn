package com.journaldev.threadpool;

import java.util.concurrent.ThreadPoolExecutor;

public class MyMonitorThread implements Runnable {
    private ThreadPoolExecutor executor;
    private int seconds;
    private boolean run = true;

    public MyMonitorThread(ThreadPoolExecutor executor, int delayInSeconds) {
        this.executor = executor;
        this.seconds = delayInSeconds;
    }

    public void shutdown() {
        run = false;
    }

    @Override
    public void run() {
        while (run) {
            System.out.println(
                    String.format("[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
                            executor.getPoolSize(),
                            executor.getCorePoolSize(),
                            executor.getActiveCount(),
                            executor.getCompletedTaskCount(),
                            executor.getTaskCount(),
                            executor.isShutdown(),
                            executor.isTerminated()
                    )
            );
            try {
                Thread.sleep(seconds * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
