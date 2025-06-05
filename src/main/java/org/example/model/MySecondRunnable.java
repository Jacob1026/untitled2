package org.example.model;

public class MySecondRunnable implements Runnable{
        private  String taskName;

        public MySecondRunnable(String taskName){
            this.taskName =   taskName;
            System.out.println("建立執行續" + taskName);
        }

        @Override
        public void  run() {
            System.out.println("任務" + taskName + "正在運行");
            try {
                for (int i = 0; i < 3; i++) {

                    System.out.println("任務" + taskName + "倒數:" + i);
                    Thread.sleep(700);
                }
            } catch (InterruptedException e) {
                System.out.println("任務" + taskName + "哀呀!中斷了");
            }
            System.out.println("任務" + taskName + "運行結束");
        }
}
