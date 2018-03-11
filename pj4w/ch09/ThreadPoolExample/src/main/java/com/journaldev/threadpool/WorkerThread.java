package com.journaldev.threadpool;

public class WorkerThread implements Runnable {
    private String command;

    public WorkerThread(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Command = " + command);
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End.");
    }

    @Override
    public String toString() {
        return command;
    }

    private void processCommand() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
