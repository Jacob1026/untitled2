package org.example.model.練習;

public class ThreadEasy0701 {
    public static void main(String[] args) {
        Runnable printA =()->{
            for (int i = 1; i <=5 ; i++) {
                System.out.println("threadA:"+i);
            }try {
                Thread.sleep(50);
            }catch (InterruptedException e){
                System.out.println(e);
            }
        };
        Runnable printB =()->{
            for (int i = 1; i <=5 ; i++) {
                System.out.println("threadB:"+i);
            }try {
                Thread.sleep(50);
            }catch (InterruptedException e){
                System.out.println(e);
            }
        };

        Thread threadA =new Thread(printA);
        Thread threadB =new Thread(printB);
       threadA.start();
       threadB.start();
    }
}

