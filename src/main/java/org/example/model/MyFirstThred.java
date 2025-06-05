package org.example.model;

public class MyFirstThred extends Thread{
    private  String treadName;

    public  MyFirstThred(String treadName){
        this.treadName =   treadName;
        System.out.println("建立執行續" + treadName);
    }

    @Override
    public void  run() {
        System.out.println("執行緒" + treadName + "正在運行");
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println("執行緒" + treadName + "倒數:" + i);
                Thread.sleep(500);
            }

        } catch (InterruptedException e) {
            System.out.println("執行緒" + treadName + "哀呀!中斷了");
        }
        System.out.println("執行緒" + treadName + "運行結束");
    }

}
