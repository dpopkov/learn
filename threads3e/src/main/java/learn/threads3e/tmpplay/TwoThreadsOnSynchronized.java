package learn.threads3e.tmpplay;

import java.util.stream.IntStream;
import java.util.stream.Stream;

interface CharConsumer {
    void addLower(char ch);
    void addUpper(char ch);
}

public class TwoThreadsOnSynchronized implements CharConsumer {
    private char[] buffer;
    private int nChars;

    private TwoThreadsOnSynchronized() {
        buffer = new char[10];
        fill(buffer, '-');
    }

    private void fill(char[] buffer, char ch) {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = ch;
        }
    }

    public synchronized String getBuffer() {
        return new String(buffer);
    }

    @Override
    public String toString() {
        return new String(buffer);
    }

    public synchronized void addLower(char ch) {
        char lower = Character.toLowerCase(ch);
        buffer[nChars++] = lower;
        System.out.println("Added lower: " + lower);
    }

    public synchronized void addUpper(char ch) {
        char upper = Character.toUpperCase(ch);
        buffer[nChars++] = upper;
        System.out.println("Added upper: " + upper);
    }

    public static void main(String[] args) throws InterruptedException {
        TwoThreadsOnSynchronized consumer = new TwoThreadsOnSynchronized();
        LowerSupplier lowerSupplier = new LowerSupplier(consumer, 5);
        UpperSupplier upperSupplier = new UpperSupplier(consumer, 5);
        Thread t1 = new Thread(lowerSupplier);
        Thread t2 = new Thread(upperSupplier);
        t1.start();
        t2.start();
        Thread.sleep(1100);
        System.out.println("Synchronized getBuffer: " + consumer.getBuffer());

        t1.join();
        t2.join();
        System.out.println("Buffer: " + consumer);
    }

    private static abstract class CharSupplier implements Runnable {
        protected CharConsumer consumer;
        protected int limit;

        public CharSupplier(CharConsumer consumer, int limit) {
            this.consumer = consumer;
            this.limit = limit;
        }
    }

    private static class LowerSupplier extends CharSupplier {
        public LowerSupplier(CharConsumer consumer, int limit) {
            super(consumer, limit);
        }

        @Override
        public void run() {
            for (int i = 0; i < limit; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                consumer.addLower((char) ('a' + i));
            }
        }
    }

    private static class UpperSupplier extends CharSupplier {
        public UpperSupplier(CharConsumer consumer, int limit) {
            super(consumer, limit);
        }

        @Override
        public void run() {
            for (int i = 0; i < limit; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                consumer.addUpper((char) ('A' + i));
            }
        }
    }
}
