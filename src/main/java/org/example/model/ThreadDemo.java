package org.example.model;

public class ThreadDemo {
    public static void main(String[] args) {
        MyFirstThred thred1 =new MyFirstThred("A");
        MyFirstThred thred2 =new MyFirstThred("B");
        //呼叫start() 不是run()
        thred1.start();
        thred2.start();
        System.out.println("主執行緒運行結束");
    }
}
