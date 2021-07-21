package pers.wk.test.java8;

import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

public class Lock {

    public static void main(String[] args) throws InterruptedException, IOException {
        ReentrantLock lock = new ReentrantLock();

        lock.lock();
        lock.unlock();

        Thread t = new Thread(()->{
            lock.lock();
        });

        t.start();

        System.in.read();
    }
}
