package java8.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Counter implements Runnable {

    private static final Integer MAX_T =2;

    private Lock lock = new Lock();

    private static int count = 0;

    public int inc() throws InterruptedException {
        lock.lock();
        int newCount = ++count;
        lock.unlock();
        return newCount;
    }

    @Override
    public void run() {
        try {
            System.out.println(inc());
        } catch (InterruptedException e) {
        }
    }

    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
        Runnable w1 = new Counter();
        Runnable w2 = new Counter();
        Runnable w3 = new Counter();
        pool.execute(w1);
        pool.execute(w2);
        pool.execute(w3);

    }
}