package org.example.model;

public class ThreadDemo2 {
    public static void main(String[] args) {
        MySecondRunnable task1 = new MySecondRunnable("下載資料");
        MySecondRunnable task2 = new MySecondRunnable("處理圖片");

        Thread thread1 =new Thread(task1);
        Thread thread2 =new Thread(task2);
        thread1.start();
        thread2.start();
    }
}
