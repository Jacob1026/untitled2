package org.example.model;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public synchronized static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Runnable task = () ->{
            for (int i = 0; i <=3 ; i++) {
                System.out.println(Thread.currentThread().getName()+"執行任務:"+i);
            }
        };
        pool.execute(task);
        pool.execute(task);
        pool.execute(task);
        pool.execute(task);
        pool.shutdown();
    }
}
