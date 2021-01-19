package com.syj;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Mutil implements Runnable {
    synchronized void method() {
        for (int i = 0; i < 10000; ++i) {
            System.out.println(i);
//            try {
//                sleep(20);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    @Override
    public void run() {

        this.method();
    }

    public static void main(String[] args) {
        Thread a = new Thread(new Mutil());
        Thread b = new Thread(new Mutil());
        a.start();
        b.start();
        ReentrantLock lock = new ReentrantLock();
        Executors.newCachedThreadPool();
    }
}
