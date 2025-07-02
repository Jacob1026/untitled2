package org.example.model.練習;

public class ThreadEasy0630 {
    public static void main(String[] args) {
        Runnable printEven = () -> {
            for (int i = 2; i < 20; i += 2) {
                System.out.println("偶數" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };
        Runnable printOdd = () -> {
            for (int i = 1; i < 20; i += 2) {
                System.out.println("基數" + i);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Thread thread1 = new Thread(printEven);
        Thread thread2 = new Thread(printOdd );
        System.out.println("執行開始----------");
        thread1.start();
        thread2.start();
    }
}
